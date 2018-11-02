package MatrizSimetrica;

import GeneradoresGrafos.AleatoriaConProbabilidad;
import GeneradoresGrafos.Generadora;
import GeneradoresGrafos.PorcentajeDeAdyacencia;

public class MainColoreoGrafos {
	
	public static void main (String[] args) {
		//int cantNodos = 5;
		//MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		AleatoriaConProbabilidad grafo = new AleatoriaConProbabilidad(10, 10);
		grafo.generar();
		grafo.imprimir();

		PorcentajeDeAdyacencia grafo2 = new PorcentajeDeAdyacencia(10, 10);
		grafo2.generar();
		grafo2.imprimir();
		
		
			
//		System.out.println("0 1 2 3 4");
//		for(int F = 0; F < cantNodos; F++) {
//			for (int C = 0; C < cantNodos; C++) {			
//				System.out.printf("%s ",grafo.matriz.getNodo(F, C));
//			}
//			System.out.println(F);
//		}

		
	}

}
