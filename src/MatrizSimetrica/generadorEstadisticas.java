package MatrizSimetrica;

import GeneradoresGrafos.AleatoriaConProbabilidad;
import GeneradoresGrafos.Generadora;
import GeneradoresGrafos.PorcentajeDeAdyacencia;

public class generadorEstadisticas {
	
	public static void main (String[] args) {
		
		Generadora aleatorioProba = new AleatoriaConProbabilidad(10, 40);
		aleatorioProba.generar();
		
		Generadora porcentajeAdyacencia = new PorcentajeDeAdyacencia(15, 60);
		porcentajeAdyacencia.generar();
		
//		GrafoNDNP grafoNDNP = new GrafoNDNP(aleatorioProba.getMatrizSimetrica());
//		grafoNDNP.coloreoMatula(1);
//		grafoNDNP.imprimirNodoColor();
//		System.out.println("");
//		RegularConGrado g4= new RegularConGrado(10, 5);
//		g4.generar();
//		g4.imprimir();
	}

}
