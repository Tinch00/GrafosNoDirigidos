package GeneradoresGrafos;

import java.util.ArrayList;

public class NPartito extends Generadora{
	
	private ArrayList <ArrayList <Integer>> listaConjunto;
	private int cantNodos; 
	private int cantConjuntos;
	
	public NPartito(int cantNodos, int cantConjuntos ) {
		super(cantNodos);
		this.cantNodos = cantNodos;
		this.cantConjuntos = cantConjuntos;
		this.listaConjunto = new ArrayList <ArrayList <Integer>>();
	}

	@Override
	public void generar() {
		if (cantConjuntos>=cantNodos)
			return;
		
		for (int i = 0; i < this.cantConjuntos; i++) {
			this.listaConjunto.add(new ArrayList<Integer>());
		}
		
		int indiceConjunto = 0;
		for (int i = 0; i < cantNodos; i++) {
			this.listaConjunto.get(indiceConjunto).add(i);
			if (indiceConjunto == this.cantConjuntos)
				indiceConjunto=0;
			else
				indiceConjunto++;
		}
		
		for (int i = 0; i < this.listaConjunto.size()-1; i++) {
			for (Integer nodo : this.listaConjunto.get(i)) {
				for (int j = 0; j < i; j++) {
					this.matriz.setNodo(nodo,j);
				}
				for (int j = i; j < this.listaConjunto.get(i).size()-1;j++) {
					this.matriz.setNodo(nodo,j);
				}
			}
		}
	}

}
