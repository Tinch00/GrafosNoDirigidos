package GeneradoresGrafos;

import java.util.ArrayList;
import java.util.Collections;

import MatrizSimetrica.Arista;

public class PorcentajeDeAdyacencia extends Generadora {
	
	private int cantAristas;
	private double adyacencia;

	public PorcentajeDeAdyacencia(int cantNodos, int ady) {
		super(cantNodos);
		this.adyacencia = ady/100.0;
		this.cantAristas =(int) (cantNodos * (cantNodos -1)/2*this.adyacencia);
	}

	@Override
	public void generar() {
		ArrayList<Arista> arista = new ArrayList<Arista>();
		
		for (int F=0; F < (this.matriz.getCantNodos()-2); F++){
			for (int C=F+1; C<(this.matriz.getCantNodos()-1); C++){
				arista.add(new Arista(F,C)); 
			}
		}
		
		Collections.shuffle(arista);
		
		for (int i=0; i < this.cantAristas; i++){
			super.matriz.setNodo(arista.get(i).getNodoInicio(), arista.get(i).getNodoFin());
		}
		
	}

}
