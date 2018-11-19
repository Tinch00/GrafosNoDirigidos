package AlgoritmosColoreo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import MatrizSimetrica.MatrizSimetrica;
import MatrizSimetrica.Nodo;

public class GrafoNDNP{
	
	//Listas:
	private ArrayList <Integer> nodoColor;
	private ArrayList <Integer> listaNodos;
	private ArrayList <Nodo> nodoGrado;
	private MatrizSimetrica matriz;
	
	//Estadisticas:
	private int colorMaximo;
	private int gradoMaximo;
	private int gradoMinimo;
	
	public GrafoNDNP(MatrizSimetrica matriz) {
		this.matriz = matriz;
		this.nodoColor = new ArrayList<Integer>();
		this.listaNodos = new ArrayList<Integer>();
		this.nodoGrado = new ArrayList<Nodo>();
	}
	
	public void coloreoAleatorio(int cantidadCorridas) {
		for (int nodo = 0; nodo < matriz.getCantNodos();nodo++ ) {
			this.listaNodos.add(nodo);
		}
		
		for (int i = 0; i < cantidadCorridas; i++) {
			//Ordena de forma aleatoria los nodos y colorea.
			Collections.shuffle(this.listaNodos);
			this.colorear();
		}
	}
	
	public void coloreoWelshPowell(int cantidadCorridas) {
		this.gradoMaximo = 0;
		this.gradoMinimo = this.matriz.getCantNodos() - 1;
		int indiceMayorGrado = 0;
		int indiceMenorGrado = this.matriz.getCantNodos() - 1;
		
		//Inicializo gradoNodo
		for (int nodo = 0; nodo < matriz.getCantNodos();nodo++ ) {
			this.nodoGrado.add(new Nodo(nodo));
		}
		
		//Calculo de Grado.
		for (int indiceNodo = 0; indiceNodo < this.matriz.getCantNodos(); indiceNodo++) {
			int grado = 0;
			for (int C = 0; C < this.matriz.getCantNodos(); C++) {
				if (indiceNodo != C) {
					if (this.matriz.getArista(indiceNodo, C) == '1'){
						grado++;
					}
				}
			}
			if (grado > gradoMaximo)
				gradoMaximo = grado;
			if (grado < gradoMinimo)
				gradoMinimo = grado;
			
			this.nodoGrado.get(indiceNodo).setGrado(grado);
		}
		
		Collections.sort(this.nodoGrado,new Comparator<Nodo>(){
			@Override
			public int compare(Nodo nodo1, Nodo nodo2) {
				return nodo2.getGrado() - nodo1.getGrado();
			};
		});

		for (int i = 0; i < this.nodoGrado.size(); i++) {
			//Chimi para saber desde donde y hasta donde hacer shuffle
			int gradoNodo = this.nodoGrado.get(i).getGrado();
			if (gradoNodo == gradoMaximo) {
				indiceMayorGrado = i+1;
			}
				
			if (gradoNodo > gradoMinimo) {
				indiceMenorGrado = i;
			}
		}
		
		for (int i = 0; i < cantidadCorridas; i++) {
			//Descarta los nodos de grado mayor y menor y hace un shuffle de los del medio.
			Collections.shuffle(this.nodoGrado.subList(indiceMayorGrado, indiceMenorGrado));
			//Guarda en "listaNodos" el orden a ordenar los nodos.
			for (int j = 0; j < this.nodoGrado.size(); j++) {
				this.listaNodos.add(j, this.nodoGrado.get(j).getValorNodo());
			}
			this.colorear();
		}
	}
	
	public void coloreoMatula(int cantidadCorridas) {
		this.gradoMaximo = 0;
		this.gradoMinimo = this.matriz.getCantNodos() - 1;
		int indiceMayorGrado = 0;
		int indiceMenorGrado = this.matriz.getCantNodos() - 1;
		
		//Inicializo gradoNodo
		for (int nodo = 0; nodo < matriz.getCantNodos();nodo++ ) {
			this.nodoGrado.add(new Nodo(nodo));
		}
		
		//Calculo de Grado.
		for (int indiceNodo = 0; indiceNodo < this.matriz.getCantNodos(); indiceNodo++) {
			int grado = 0;
			for (int C = 0; C < this.matriz.getCantNodos(); C++) {
				if (indiceNodo != C) {
					if (this.matriz.getArista(indiceNodo, C) == '1'){
						grado++;
					}
				}
			}
			if (grado > gradoMaximo)
				gradoMaximo = grado;
			if (grado < gradoMinimo)
				gradoMinimo = grado;
			
			this.nodoGrado.get(indiceNodo).setGrado(grado);
		}
		
		Collections.sort(this.nodoGrado,new Comparator<Nodo>(){
			@Override
			public int compare(Nodo nodo1, Nodo nodo2) {
				return nodo1.getGrado() - nodo2.getGrado();
			};
		});		
		
		for (int i = 0; i < this.nodoGrado.size(); i++) {
			//Chimi para saber desde donde y hasta donde hacer shuffle
			int gradoNodo = this.nodoGrado.get(i).getGrado();
			if (gradoNodo == gradoMinimo) {
				indiceMenorGrado = i+1;
			}
			
			if (gradoNodo < gradoMaximo) {
				indiceMayorGrado = i;
			}
				
		}
		
		for (int i = 0; i < cantidadCorridas; i++) {
			//Descarta los nodos de grado mayor y menor y hace un shuffle de los del medio.
			Collections.shuffle(this.nodoGrado.subList(indiceMenorGrado,indiceMayorGrado));
			//Guarda en "listaNodos" el orden a ordenar los nodos.
			for (int j = 0; j < this.nodoGrado.size(); j++) {
				this.listaNodos.add(j, this.nodoGrado.get(j).getValorNodo());
			}
			this.colorear();
		}
	}
	
	
	// Funcion colorear que se utiliza para todas las tecnicas de coloreo.
	private void colorear() {

		int color  = 1;
		//Inicializo vector Nodo Color
		for (int i = 0; i < this.matriz.getCantNodos();i++) {
			this.nodoColor.add(i,0);
		}
		
		for (int indiceNodo = 0; indiceNodo < this.listaNodos.size(); indiceNodo++) {
			int nodo = this.listaNodos.get(indiceNodo);
			color = 1;
			this.nodoColor.set(nodo, color);
			
			if (indiceNodo == 0) {
				//Primer nodo color 1;
				this.nodoColor.set(nodo,color);
				continue;
			}
			
			for (int C = 0; C < this.matriz.getCantNodos();C++) {		
				if (nodo != C) {	
					if(this.matriz.getArista(nodo, C) == '1' && this.nodoColor.get(nodo) == this.nodoColor.get(C)) {
						color++;
						if (color > this.colorMaximo) {
							this.colorMaximo = color;
						}
						this.nodoColor.set(nodo,color);
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
			System.out.print(this.listaNodos.get(i) + " - ");
	}
		System.out.println();
		for (int i = 0; i < this.nodoColor.size(); i++) {
			System.out.println("nodo: " + i + " - Color: " + this.nodoColor.get(i) );
	}
		System.out.println("Maximo Colores: " + this.colorMaximo);
		
	}
	
	
	public void escribirGrafoColoreado(String fo) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter(fo));

		salida.println(this.matriz.getCantNodos() + " " + 
					   this.colorMaximo + " " + 
					   this.matriz.getCantAristas() + " " + 
					   (this.matriz.getCantAristas()/this.matriz.getTotalAristas()) + " " + 
					   this.gradoMaximo + " " + 
					   this.gradoMinimo);
		
		salida.println("Nodo - Color");
		for (int i = 0; i < this.nodoColor.size(); i++) {
			salida.println(i + " - " + this.nodoColor.get(i) );
		}
		
		salida.close();
	}
	
	

}
