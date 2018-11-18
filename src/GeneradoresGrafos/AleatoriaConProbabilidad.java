package GeneradoresGrafos;

public class AleatoriaConProbabilidad extends Generadora {
	
	private double probabilidad;
	
	public AleatoriaConProbabilidad(int cantNodos, int probabilidadPorArista){
		super(cantNodos);
		this.probabilidad = probabilidadPorArista/100.0;
	}
	
	@Override
	public void generar(){
		for (int F=0; F < (this.matriz.getCantNodos()); F++){
			for (int C=F+1; C<(this.matriz.getCantNodos()); C++){
				if (Math.random() < probabilidad){
					this.matriz.setNodo(F, C);
				}			
			}
		}
	}

}
