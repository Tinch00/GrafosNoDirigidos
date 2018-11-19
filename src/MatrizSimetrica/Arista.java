package MatrizSimetrica;

public class Arista {
	
	private int nodoInicio; 
	private int nodoFin;
	private int valor;
	
	public Arista(int nodoInicio, int nodoFin){
		this.nodoInicio = nodoInicio;
		this.nodoFin = nodoFin;
		int valor = 0;
		
	}
	
	public void setValor(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}
	
	public int getNodoInicio(){
		return this.nodoInicio;
	}
	
	public int getNodoFin(){
		return this.nodoFin;
	}
	
	@Override
	public String toString() {
		return nodoInicio + " " + nodoFin;
	}

}
