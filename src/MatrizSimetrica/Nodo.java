package MatrizSimetrica;

public class Nodo {
	
	private int valorNodo;
	private int grado;
	
	public Nodo(int valorNodo) {
		this.valorNodo = valorNodo;
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

}
