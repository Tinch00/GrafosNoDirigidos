package GeneradoresGrafos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import MatrizSimetrica.Arista;
import MatrizSimetrica.MatrizSimetrica;

public abstract class Generadora {
	protected MatrizSimetrica matriz;
	
	
	public Generadora(int cantNodos){
		matriz  = new MatrizSimetrica(cantNodos);
	}
	
	public abstract void generar();
	
	//Calcular GradoMax  y GradoMin.
	//Calcular Aristas.
	
	public int getCantNodos() {
		return this.getMatrizSimetrica().getCantNodos();
	}
	
	public MatrizSimetrica getMatrizSimetrica() {
		return this.matriz;
	}
	
	
	public void imprimir(){
		
		System.out.print(" ");
		for (int C = 0; C < this.matriz.getCantNodos(); C++) {
			System.out.print(" " + C);
		}
		
		for(int F = 0; F < this.matriz.getCantNodos(); F++) {
			System.out.println();
			System.out.print(F + " ");
			for (int C = 0; C < this.matriz.getCantNodos(); C++) {
				
				
				if (this.matriz.getArista(F, C)=='1') {
					System.out.printf("%s ",this.matriz.getArista(F, C));
				}
				else if (F == C) {
					System.out.printf("- ");
				}else {
					System.out.printf("0 ");
				}					
			}
		}
	}
	
	public void escribirGrafoEnArchivo(int cantNodos, int cantAristas, double ady, int gradoMax, int gradoMin, ArrayList<Arista> listaArista, String fo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(fo));

		salida.println(cantNodos + " " + cantAristas + " " + ady + " " + gradoMax + " " + gradoMin);
		
		for (Arista arista : listaArista) {
			salida.println(arista);
		}

		salida.close();
	}
	
	//como generar un grafo de red de mundo Pequenio. para el 7 de Mica.

}
