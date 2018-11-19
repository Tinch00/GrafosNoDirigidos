package GeneradoresGrafos;

import java.io.IOException;

public class RegularPorcentajeDeAdy extends Generadora {
	
	private double adyacencia;
		
		public RegularPorcentajeDeAdy (int cantNodos, int ady) {
			super(cantNodos);
			this.adyacencia = ady;
		}
		//
		@Override
		public void generar() {
			int grado = (int) ((this.adyacencia/100) * (this.matriz.getCantNodos()-1));
			int gradoMaximo = 0;
			int gradoMinimo = this.matriz.getCantNodos() - 1;
			
			
			if((this.matriz.getCantNodos() %2 == 1 && grado %2 ==1) || grado >= this.matriz.getCantNodos() || this.matriz.getCantNodos() == 1 || grado <=0) {
				//System.out.println("ERROR: No se puede generar un grafo de " + this.matriz.getCantNodos() + "nodos y grado " + grado);
				return;
			}
				
			for(int F = 0; F < this.matriz.getCantNodos(); F++) {
				for(int C = 1; C <=grado/2; C++) {
					this.matriz.setArista(F, (F+C) % this.matriz.getCantNodos());
				}
				if(F < (this.matriz.getCantNodos()/2) && grado%2 == 1)
					this.matriz.setArista(F, F + (this.matriz.getCantNodos()/2));
			}
			
			for (int indiceNodo = 0; indiceNodo < this.matriz.getCantNodos(); indiceNodo++) {
				int gradoNodo = 0;
				for (int C = 0; C < this.matriz.getCantNodos(); C++) {
					if (indiceNodo != C) {
						if (this.matriz.getArista(indiceNodo, C) == '1'){
							gradoNodo++;
						}
					}
				}
				if (gradoNodo > gradoMaximo)
					gradoMaximo = gradoNodo;
				if (gradoNodo < gradoMinimo)
					gradoMinimo = gradoNodo;
			}
			
			try {
				int cantAristas = this.matriz.getCantAristas();
				int totalAristas = this.matriz.getTotalAristas();
				double ady =((double)cantAristas/totalAristas)*100;
				escribirGrafoEnArchivo(this.matriz.getCantNodos(), 
									   this.matriz.getCantAristas(),
									   ady,
									   gradoMaximo,
									   gradoMinimo,
									   this.matriz.getListaAristas(),
									   "bin/ArchivosEntrada/RegularConPorcentajeAdy"  + this.matriz.getCantNodos() + (this.adyacencia) + ".in");
			} catch (IOException e) {
				System.out.println("No se pudo guardar el archivo");
				e.printStackTrace();
			}
			
		}


}
