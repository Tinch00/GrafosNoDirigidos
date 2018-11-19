package MatrizSimetrica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import AlgoritmosColoreo.GrafoNDNP;
import GeneradoresGrafos.AleatoriaConProbabilidad;
import GeneradoresGrafos.AleatorioPorcentajeDeAdy;
import GeneradoresGrafos.Generadora;

public class Estadisticas {
	
	public static void main (String[] args) {
		
		int nodos=600;
		int adyacencia=40;
		
//		GeneroGrafo1
		Generadora aleatorioProba = new AleatoriaConProbabilidad(nodos, adyacencia);
		aleatorioProba.generar();

		GrafoNDNP grafo = new GrafoNDNP(aleatorioProba.getMatrizSimetrica());		
//		10000corridasGrafo1 secuen
		grafo.coloreoAleatorio(100);
		guardarEstadistica(grafo.getVectorEstadistica(), "SecAlea-AleatorioProba"+nodos+adyacencia);
		
//		10000corridasGrafo1 WP
		grafo.coloreoWelshPowell(100);
		guardarEstadistica(grafo.getVectorEstadistica(), "WP-AleatorioProba"+nodos+adyacencia);
		
//		10000corridasGrafo1 MAtu
		grafo.coloreoMatula(100);
		guardarEstadistica(grafo.getVectorEstadistica(), "MAtula-AleatorioProba"+nodos+adyacencia);
				
//		GeneroGrafo2
		Generadora porcentajeAdyacencia = new AleatorioPorcentajeDeAdy(nodos, adyacencia);
		porcentajeAdyacencia.generar();
		
		GrafoNDNP grafo2 = new GrafoNDNP(aleatorioProba.getMatrizSimetrica());
//		10000corridasGrafo1 secuen
		grafo2.coloreoAleatorio(100);
		guardarEstadistica(grafo.getVectorEstadistica(), "SecAlea-PorcAdy"+nodos+adyacencia);
		
//		10000corridasGrafo1 WP
		grafo2.coloreoWelshPowell(100);
		guardarEstadistica(grafo.getVectorEstadistica(), "WP-PorcAdy"+nodos+adyacencia);
		
//		10000corridasGrafo1 MAtu
		grafo2.coloreoMatula(100);
		guardarEstadistica(grafo.getVectorEstadistica(), "Matula-PorcAdy"+nodos+adyacencia);
	}
	
	public static void guardarEstadistica(int[] vector, String fo) {
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(fo));
			for(int i=0;i<vector.length;i++) {
				salida.printf(i + ",");
			}
			salida.println();
			for(int i=0;i<vector.length;i++) {
				salida.printf(vector[i] + ",");
			}
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
