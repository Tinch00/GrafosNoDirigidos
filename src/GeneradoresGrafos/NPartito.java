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
		if (this.cantConjuntos>=this.cantNodos)
			return;
		
		for (int i = 0; i < this.cantConjuntos; i++) {
			this.listaConjunto.add(new ArrayList<Integer>());
		}
		
		int indiceConjunto = 0;
		for (int i = 0; i < cantNodos; i++) {
			this.listaConjunto.get(indiceConjunto).add(i);
			if (indiceConjunto == (this.cantConjuntos-1))
				indiceConjunto=0;
			else
				indiceConjunto++;
		}
		
		for (int i = 0; i<this.listaConjunto.size(); i++) {
			for (Integer nodo : this.listaConjunto.get(i)) {
				for (int j = 0; j < i;j++) {
					for (int k = 0; k < this.listaConjunto.get(j).size(); k++) {
						this.matriz.setNodo(nodo, this.listaConjunto.get(i).get(k));
					}						
				}
				for (int j = i+1; j < this.listaConjunto.size()-1;j++) {
					for (int k = 0; k < this.listaConjunto.get(j).size(); k++) {
						this.matriz.setNodo(nodo, this.listaConjunto.get(i).get(k));
					}						
				}	
			}
		}
		
	}

}
