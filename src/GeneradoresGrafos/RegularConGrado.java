package GeneradoresGrafos;

public class RegularConGrado extends Generadora {
	
	private int grado;
	
	 public RegularConGrado(int cantNodos, int grado) {
		super(cantNodos);
		this.grado = grado;
	}

	@Override
	public void generar() { 
		if((this.matriz.getCantNodos() %2 == 1 && this.grado %2 ==1) || this.grado >= this.matriz.getCantNodos() || this.matriz.getCantNodos() == 1 || this.grado <=0) {
			//System.out.println("ERROR: No se puede generar un grafo de " + this.matriz.getCantNodos() + "nodos y grado " + this.grado);
			return;
		}
			
		for(int F = 0; F < this.matriz.getCantNodos(); F++) {
			for(int C = 1; C <= this.grado/2; C++) {
				this.matriz.setArista(F, (F+C) % this.matriz.getCantNodos());
			}
			if(F < (this.matriz.getCantNodos()/2) && this.grado%2 == 1)
				this.matriz.setArista(F, F + (this.matriz.getCantNodos()/2));
		}
	}
}
