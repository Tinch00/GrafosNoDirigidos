package MatrizSimetrica;

public class Arista {
	
	private int nodoInicio; 
	private int nodoFin;
	
	public Arista(int nodoInicio, int nodoFin){
		this.nodoInicio = nodoInicio;
		this.nodoFin = nodoFin;
	}
	
	public int getNodoInicio(){
		return this.nodoInicio;
	}
	
	public int getNodoFin(){
		return this.nodoFin;
	}

}
