package AlgoritmosColoreo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import MatrizSimetrica.MatrizSimetrica;
import MatrizSimetrica.Nodo;

public class GrafoNDNP{
	
	//Listas:
	private ArrayList <Integer> nodoColor;
	private ArrayList <Nodo> listaNodos;
	private int[] vectorEstadistica; 
	
	private MatrizSimetrica matriz;
	
	//Estadisticas:
	private int colorMaximo;
	private int gradoMaximo;
	private int gradoMinimo;
	
	@SuppressWarnings("resource")
	public GrafoNDNP(String archivoGrafoEntrada) {
		
		Scanner sc;
		try {
			this.listaNodos = new ArrayList<Nodo>();
			this.nodoColor = new ArrayList<Integer>();
			
			//Tiraba error al leer el Double
			sc = new Scanner(new File(archivoGrafoEntrada)).useLocale(Locale.US);
			
			int cantNodos = sc.nextInt();
			int cantAristas = sc.nextInt();
			double porcAdyacencia = sc.nextDouble();
			this.gradoMaximo = sc.nextInt();
			this.gradoMinimo = sc.nextInt();
			
			this.matriz = new MatrizSimetrica(cantNodos);
			
			//Creo los nodos.
			for (int nodo = 0; nodo < matriz.getCantNodos(); nodo++) {
				this.listaNodos.add(new Nodo(nodo));
			}

			//Armo Matriz con Aristas
			for (int i = 0; i < cantAristas; i++) {
				this.matriz.setArista(sc.nextInt(), sc.nextInt());
			}
			
			//Seteo Grado Por Arista
			for (int indiceNodo = 0; indiceNodo < this.matriz.getCantNodos(); indiceNodo++) {
				int grado = 0;
				for (int C = 0; C < this.matriz.getCantNodos(); C++) {
					if (indiceNodo != C) {
						if (this.matriz.getArista(indiceNodo, C) == '1'){
							grado++;
						}
					}
				}				
				this.listaNodos.get(indiceNodo).setGrado(grado);
			}
			
			//agrego una entrada por cada vector para guardar los colores.
			for (int i = 0; i < this.matriz.getCantNodos();i++) {
				this.nodoColor.add(i,0);
			}
			
			this.vectorEstadistica = new int[this.matriz.getCantNodos()];
	
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		}
	
	public void coloreoAleatorio(int cantidadCorridas) {
		inicializarVectorEstadistica();

		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		
		for (int i = 0; i < cantidadCorridas; i++) {
			//Ordena de forma aleatoria los nodos y colorea.
			Collections.shuffle(this.listaNodos);
			
			this.colorear();
			this.vectorEstadistica[this.colorMaximo]++;
			
			if(i % 200 == 0) {
				System.out.println("Secuencial: Corrida:" + i);
				Date date = new Date();
				System.out.print(" - hora: " + dateFormat.format(date));
			}
		}
		
//		try {
	//		escribirGrafoColoreado("coloreo.out");
	//	} catch (IOException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
	}
	
	public void coloreoWelshPowell(int cantidadCorridas) {
		int indiceMayorGrado = 0;
		int indiceMenorGrado = this.matriz.getCantNodos() - 1;
		inicializarVectorEstadistica();
		
		Collections.sort(this.listaNodos,new Comparator<Nodo>(){
			@Override
			public int compare(Nodo nodo1, Nodo nodo2) {
				return nodo2.getGrado() - nodo1.getGrado();
			};
		});

		for (int i = 0; i < this.listaNodos.size(); i++) {
			//Chimi para saber desde donde y hasta donde hacer shuffle
			int gradoNodo = this.listaNodos.get(i).getGrado();
			if (gradoNodo == this.gradoMaximo) {
				indiceMayorGrado = i+1;
			}
				
			if (gradoNodo > this.gradoMinimo) {
				indiceMenorGrado = i;
			}
		}
		
		for (int i = 0; i < cantidadCorridas; i++) {
			//Descarta los nodos de grado mayor y menor y hace un shuffle de los del medio.
			Collections.shuffle(this.listaNodos.subList(indiceMayorGrado, indiceMenorGrado));
			
			this.colorear();			
			this.vectorEstadistica[this.colorMaximo]++;
			if(i % 200 == 0)
				System.out.println("WP: Corrida:" + i);
		}
		
//		try {
//			escribirGrafoColoreado("coloreo.out");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void coloreoMatula(int cantidadCorridas) {
		int indiceMayorGrado = 0;
		int indiceMenorGrado = this.matriz.getCantNodos() - 1;
		inicializarVectorEstadistica();
		
		Collections.sort(this.listaNodos,new Comparator<Nodo>(){
			@Override
			public int compare(Nodo nodo1, Nodo nodo2) {
				return nodo1.getGrado() - nodo2.getGrado();
			};
		});		
		
		for (int i = 0; i < this.listaNodos.size(); i++) {
			//Chimi para saber desde donde y hasta donde hacer shuffle
			int gradoNodo = this.listaNodos.get(i).getGrado();
			if (gradoNodo == this.gradoMinimo) {
				indiceMenorGrado = i+1;
			}
			
			if (gradoNodo < this.gradoMaximo) {
				indiceMayorGrado = i;
			}
				
		}
		
		for (int i = 0; i < cantidadCorridas; i++) {
			//Descarta los nodos de grado mayor y menor y hace un shuffle de los del medio.
			Collections.shuffle(this.listaNodos.subList(indiceMenorGrado,indiceMayorGrado));
			
			this.colorear();
			this.vectorEstadistica[this.colorMaximo]++;
			
			if(i % 500 == 0)
				System.out.println("Matula: Corrida:" + i);
		}
	//		try {
	//		escribirGrafoColoreado("coloreo.out");
	//	} catch (IOException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
	}
	
	
	// Funcion colorear que se utiliza para todas las tecnicas de coloreo.
	private void colorear() {
		this.colorMaximo = 1;
		int color  = 1;
		//Inicializo vector en cada pasada Nodo Color
		for (int i = 0; i < this.matriz.getCantNodos();i++) {
			this.nodoColor.set(i,0);
		}
		
		for (int indiceNodo = 0; indiceNodo < this.listaNodos.size(); indiceNodo++) {
			Nodo nodo = this.listaNodos.get(indiceNodo);
			color = 1;
			this.nodoColor.set(nodo.getValorNodo(), color);
			
			if (indiceNodo == 0) {
				//Primer nodo color 1;
				this.nodoColor.set(nodo.getValorNodo(),color);
				continue;
			}
			
			for (int C = 0; C < this.matriz.getCantNodos();C++) {		
				if (nodo.getValorNodo() != C) {	
					if(this.matriz.getArista(nodo.getValorNodo(), C) == '1' && this.nodoColor.get(nodo.getValorNodo()) == this.nodoColor.get(C)) {
						color++;
						if (color > this.colorMaximo) {
							this.colorMaximo = color;
						}
						this.nodoColor.set(nodo.getValorNodo(),color);
						//Si cambio el color, vuelve a recorrer preguntando
						//si ya tiene algun otro nodo de ese color.
						C = -1;
					}
				}
			}
		}
	}
	
	public void imprimirNodoColor(){
		System.out.println();
		System.out.print("Secuencia de coloreo: ");
		for (int i = 0; i < this.listaNodos.size(); i++) {
			System.out.print(this.listaNodos.get(i).getValorNodo() + " - ");
	}
		System.out.println();
		for (int i = 0; i < this.nodoColor.size(); i++) {
			System.out.println("nodo: " + i + " - Color: " + this.nodoColor.get(i) );
	}
		System.out.println("Maximo Colores: " + this.colorMaximo);
		
	}
	
	
	public void escribirGrafoColoreado(String fo) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter(fo));
		double ady = this.matriz.getCantAristas()/this.matriz.getTotalAristas();

		salida.println(this.matriz.getCantNodos() + " " + 
					   this.colorMaximo + " " + 
					   this.matriz.getCantAristas() + " " + 
					   ady + " " + 
					   this.gradoMaximo + " " + 
					   this.gradoMinimo);
		
		salida.println("Nodo - Color");
		for (int i = 0; i < this.nodoColor.size(); i++) {
			salida.println(i + " - " + this.nodoColor.get(i) );
		}
		
		salida.close();
	}
	
	private void inicializarVectorEstadistica() {
		for (int i=0; i < this.vectorEstadistica.length; i++) {
			this.vectorEstadistica[i]=0;
		}
	}
	
	public int[] getVectorEstadistica() {
		return this.vectorEstadistica;
	}
	
	

}
