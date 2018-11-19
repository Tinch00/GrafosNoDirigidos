package GeneradoresGrafos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import MatrizSimetrica.Arista;

public class AleatorioPorcentajeDeAdy extends Generadora {
	
	private int cantAristas;
	private double adyacencia;

	public AleatorioPorcentajeDeAdy(int cantNodos, int ady) {
		super(cantNodos);
		this.adyacencia = ady/100.0;
		this.cantAristas =(int) (cantNodos * (cantNodos -1)/2*this.adyacencia);
	}

	@Override
	public void generar() {
		ArrayList<Arista> arista = new ArrayList<Arista>();
		int gradoMaximo = 0;
		int gradoMinimo = this.matriz.getCantNodos() - 1;
		
		for (int F=0; F < (this.matriz.getCantNodos()); F++){
			for (int C=F+1; C<(this.matriz.getCantNodos()); C++){
				arista.add(new Arista(F,C)); 
			}
		}
		Collections.shuffle(arista);
		
		for (int i=0; i < this.cantAristas; i++){
			super.matriz.setArista(arista.get(i).getNodoInicio(), arista.get(i).getNodoFin());
		}
		
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
		}
		
		try {
			escribirGrafoEnArchivo(this.matriz.getCantNodos(), 
								   this.matriz.getCantAristas(),
								   (this.matriz.getCantAristas()/this.matriz.getTotalAristas()),
								   gradoMaximo,
								   gradoMinimo,
								   this.matriz.getListaAristas(),
								   "AleatorioConPorcentajeAdy"  + this.matriz.getCantNodos() + "-" + (this.adyacencia*100) + ".in");
		} catch (IOException e) {
			System.out.println("No se pudo guardar el archivo");
			e.printStackTrace();
		}
		
	}

}
