package GeneradoresGrafos;

import MatrizSimetrica.Arista;
import MatrizSimetrica.MatrizSimetrica;

public abstract class Generadora {
	protected MatrizSimetrica matriz;
	private int gradoMaximo, gradoMinimo, cantAristas;
	private int cantNodos;
	
	
	public Generadora(int cantNodos){
		matriz  = new MatrizSimetrica(cantNodos);
		this.cantNodos = cantNodos;
	}
	
	public abstract void generar();
	
	//Calcular GradoMax  y GradoMin.
	//Calcular Aristas.
	
	
	public void imprimir(){
		for(int F = 0; F < this.matriz.getCantNodos(); F++) {
			for (int C = 0; C < this.matriz.getCantNodos(); C++) {			
				System.out.printf("%s ",this.matriz.getNodo(F, C));
			}
			System.out.println();
		}
	}
	
	//como generar un grafo de red de mundo Pequeño. para el 7 de Mica.

}
