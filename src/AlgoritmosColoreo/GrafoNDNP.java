package AlgoritmosColoreo;

import java.util.ArrayList;
import java.util.Collections;

import MatrizSimetrica.MatrizSimetrica;

public class GrafoNDNP{
	
	private ArrayList <Integer> nodoColor;
	private ArrayList <Integer> listaNodos;
	private MatrizSimetrica matriz;
	
	//Estadisticas:
	private int colorMaximo;
	
	public GrafoNDNP(int cantNodos, MatrizSimetrica matriz) {
		this.matriz = matriz;
		this.nodoColor = new ArrayList<Integer>();
		this.listaNodos = new ArrayList<Integer>();
	}
	
	public void coloreoAleatorio(int cantidadCorridas) {
		
		cantidadCorridas = 1;
		for (int nodo = 0; nodo < matriz.getCantNodos();nodo++ ) {
			this.listaNodos.add(nodo);
		}
		
		for (int i = 0; i < cantidadCorridas; i++) {
			Collections.shuffle(this.listaNodos);
			this.colorear();
		}
	}

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
