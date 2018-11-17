package MatrizSimetrica;

import GeneradoresGrafos.AleatoriaConProbabilidad;
import GeneradoresGrafos.Generadora;
import GeneradoresGrafos.NPartito;
import GeneradoresGrafos.PorcentajeDeAdyacencia;
import GeneradoresGrafos.PorcentajeDeAdyacenciaRegular;
import GeneradoresGrafos.RegularConGrado;

public class MainColoreoGrafos {
	
	public static void main (String[] args) {
		//int cantNodos = 5;
		//MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		AleatoriaConProbabilidad grafo = new AleatoriaConProbabilidad(6, 70);
		grafo.generar();
		grafo.imprimir();
		System.out.println("");
		PorcentajeDeAdyacencia grafo2 = new PorcentajeDeAdyacencia(10, 80);
		grafo2.generar();
		grafo2.imprimir();
		System.out.println("");
		NPartito grafo3 = new NPartito(9,3);
		grafo3.generar();
		grafo3.imprimir();
		System.out.println("");
		RegularConGrado g4= new RegularConGrado(6, 2);
		g4.generar();
		g4.imprimir();
		System.out.println("");
		PorcentajeDeAdyacenciaRegular g5= new PorcentajeDeAdyacenciaRegular(5, 50);
		g5.generar();
		g5.imprimir();
		
			
//		System.out.println("0 1 2 3 4");
//		for(int F = 0; F < cantNodos; F++) {
//			for (int C = 0; C < cantNodos; C++) {			
//				System.out.printf("%s ",grafo.matriz.getNodo(F, C));
//			}
//			System.out.println(F);
//		}

		
	}

}
