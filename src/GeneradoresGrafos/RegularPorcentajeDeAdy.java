package GeneradoresGrafos;

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
			
		}


}
