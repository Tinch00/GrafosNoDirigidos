package MatrizSimetrica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import AlgoritmosColoreo.GrafoNDNP;
import GeneradoresGrafos.AleatoriaConProbabilidad;
import GeneradoresGrafos.AleatorioPorcentajeDeAdy;
import GeneradoresGrafos.Generadora;
import GeneradoresGrafos.RegularPorcentajeDeAdy;

public class Estadisticas {
	
	public static void main (String[] args) {
		
		int nodos=600;
		int adyacencia=40;
		int cantCorridas = 10000;
		
//////////GeneroGrafo1////////////////
//		Generadora aleatorioProba = new AleatoriaConProbabilidad(nodos, adyacencia);
//		aleatorioProba.generar();
//
//		GrafoNDNP grafo = new GrafoNDNP("bin/ArchivosEntrada/AleatorioConProbabilidad"+nodos+adyacencia+".0"+".in");
////		10000corridasGrafo1 secuencial
//		grafo.coloreoAleatorio(cantCorridas);
//		guardarEstadistica(grafo.getVectorEstadistica(), "SecAlea-AleatorioProba"+nodos+adyacencia);
//		
////		GrafoNDNP grafo2 = new GrafoNDNP("bin/ArchivosEntrada/AleatorioConProbabilidad"+nodos+adyacencia+".0"+".in");
//////		10000corridasGrafo1 WP
////		grafo2.coloreoWelshPowell(cantCorridas);
////		guardarEstadistica(grafo2.getVectorEstadistica(), "WP-AleatorioProba"+nodos+adyacencia);
////		
////		GrafoNDNP grafo3 = new GrafoNDNP("bin/ArchivosEntrada/AleatorioConProbabilidad"+nodos+adyacencia+".0"+".in");
//////		10000corridasGrafo1 MAtu
////		grafo3.coloreoMatula(cantCorridas);
////		guardarEstadistica(grafo3.getVectorEstadistica(), "Matula-AleatorioProba"+nodos+adyacencia);
				
//////GeneroGrafo2///////////////////
		Generadora porcentajeAdyacencia = new RegularPorcentajeDeAdy(nodos, adyacencia);
		porcentajeAdyacencia.generar();
		
		GrafoNDNP grafo4 = new GrafoNDNP("bin/ArchivosEntrada/RegularConPorcentajeAdy"+nodos+adyacencia+".0"+".in");
//		10000corridasGrafo1 secuen
		grafo4.coloreoAleatorio(cantCorridas);
		guardarEstadistica(grafo4.getVectorEstadistica(), "SecAlea-PorcAdy"+nodos+adyacencia);
		
		GrafoNDNP grafo5 = new GrafoNDNP("bin/ArchivosEntrada/RegularConPorcentajeAdy"+nodos+adyacencia+".0"+".in");
//		10000corridasGrafo1 WP
		grafo5.coloreoWelshPowell(cantCorridas);
		guardarEstadistica(grafo5.getVectorEstadistica(), "WP-PorcAdy"+nodos+adyacencia);
		
		GrafoNDNP grafo6 = new GrafoNDNP("bin/ArchivosEntrada/RegularConPorcentajeAdy"+nodos+adyacencia+".0"+".in");
//		10000corridasGrafo1 MAtu
		grafo6.coloreoMatula(cantCorridas);
		guardarEstadistica(grafo6.getVectorEstadistica(), "Matula-PorcAdy"+nodos+adyacencia);
	}
	
	public static void guardarEstadistica(int[] vector, String fo) {
		try {
			PrintWriter salida = new PrintWriter(new FileWriter("bin/vectoresGraficos/" + fo + ".out"));
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
