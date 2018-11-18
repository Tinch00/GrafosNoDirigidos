package AlgoritmosColoreo;

import java.util.ArrayList;
import java.util.Collections;

import MatrizSimetrica.MatrizSimetrica;

public class GrafoNDNP{
	
	//Listas:
	private ArrayList <Integer> nodoColor;
	private ArrayList <Integer> listaNodos;
	private ArrayList <Integer> nodoGrado;
	private MatrizSimetrica matriz;
	
	//Estadisticas:
	private int colorMaximo;
	private int gradoMaximo;
	private int gradoMinimo;
	
	public GrafoNDNP(MatrizSimetrica matriz) {
		this.matriz = matriz;
		this.nodoColor = new ArrayList<Integer>();
		this.listaNodos = new ArrayList<Integer>();
		this.nodoGrado = new ArrayList<Integer>();
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
		
		//Inicializo listaNodos
		for (int nodo = 0; nodo < matriz.getCantNodos();nodo++ ) {
			this.listaNodos.add(nodo);
		}
		
		//Calculo de Grado.
		for (int indiceNodo = 0; indiceNodo < this.matriz.getCantNodos(); indiceNodo++) {
			int grado = 0;
			for (int C = 0; C < this.matriz.getCantNodos(); C++) {
				if (indiceNodo != C) {
					if (this.matriz.getNodo(indiceNodo, C) == '1'){
						grado++;
					}
				}
			}
			if (grado > gradoMaximo)
				gradoMaximo = grado;
			if (grado < gradoMinimo)
				gradoMinimo = grado;
			
			this.nodoGrado.add(indiceNodo,grado);
		}
		//Al ser integers, no hace falta el comparator.
		Collections.sort(this.nodoGrado,Collections.reverseOrder());
		//Para matula: Collections.sort(arraylist, Collections.reverseOrder());
		
		
		for (int i = 0; i < this.nodoGrado.size(); i++) {
			int valorNodo = this.nodoGrado.get(i);
			if (valorNodo == gradoMaximo) {
				indiceMayorGrado = i+1;
			}
				
			if (valorNodo > gradoMinimo) {
				indiceMenorGrado = i;
			}
		}
		
		for (int i = 0; i < cantidadCorridas; i++) {
			Collections.shuffle(this.nodoGrado.subList(indiceMayorGrado, indiceMenorGrado));
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
					if(this.matriz.getNodo(nodo, C) == '1' && this.nodoColor.get(nodo) == this.nodoColor.get(C)) {
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
	

}
