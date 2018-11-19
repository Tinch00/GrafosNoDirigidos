package GeneradoresGrafos;

import java.io.IOException;

public class AleatoriaConProbabilidad extends Generadora {
	
	private double probabilidad;
	
	public AleatoriaConProbabilidad(int cantNodos, int probabilidadPorArista){
		super(cantNodos);
		this.probabilidad = probabilidadPorArista/100.0;
	}
	
	@Override
	public void generar(){
		int gradoMaximo = 0;
		int gradoMinimo = this.matriz.getCantNodos() - 1;
		
		for (int F=0; F < (this.matriz.getCantNodos()); F++){
			for (int C=F+1; C<(this.matriz.getCantNodos()); C++){
				if (Math.random() < probabilidad){
					this.matriz.setArista(F, C);
					
				}			
			}
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
								   "AleatorioConProbabilidad" + this.matriz.getCantNodos() + "-" + (probabilidad*100) + ".in");
		} catch (IOException e) {
			System.out.println("No se pudo guardar el archivo");
			e.printStackTrace();
		}
	}

}
