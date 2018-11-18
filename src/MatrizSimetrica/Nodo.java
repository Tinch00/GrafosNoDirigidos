package MatrizSimetrica;

public class Nodo {
	
	private char valorNodo;
	private int grado;
	
	public Nodo(char valorNodo) {
		this.valorNodo = valorNodo;
	}
	
	public char getValorNodo() {
		return this.valorNodo;
	}
	
	public void setValorNodo(char valorNodo) {
		this.valorNodo = valorNodo;
	}
	
	public void setGrado(int grado) {
		this.grado = grado;
	}
	
	public int getGrado() {
		return this.grado;
	}

}
