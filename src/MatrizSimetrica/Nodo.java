package MatrizSimetrica;

public class Nodo implements Comparable {
	
	private int valorNodo;
	private int grado;
	
	public Nodo(int nodo) {
		this.valorNodo = nodo;
		this.grado = 0;
	}
	
	public int getValorNodo() {
		return this.valorNodo;
	}
	
	public void setValorNodo(int valorNodo) {
		this.valorNodo = valorNodo;
	}
	
	public void setGrado(int grado) {
		this.grado = grado;
	}
	
	public int getGrado() {
		return this.grado;
	}

	@Override
	public int compareTo(Object o) {
		Nodo nodo2 = (Nodo)o;
		return nodo2.getGrado() - this.getGrado();
	}

}
