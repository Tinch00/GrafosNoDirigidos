package MatrizSimetrica;

import java.util.ArrayList;

public class MatrizSimetrica {
	
	// Solo para grafos NO dirigidos.
	
	private char[] vectorMatriz;
	private int cantNodos;
	private int totalAristas;
	private ArrayList<Arista> listaArista;
	
	public MatrizSimetrica(int cantNodos) {
		vectorMatriz = new char[(cantNodos*cantNodos-1)/2];
		this.listaArista = new ArrayList<Arista>();
		this.totalAristas = (cantNodos*cantNodos-1)/2;
		this.cantNodos = cantNodos;
	}
	
	public char getArista(int F, int C) {
		if (F == C)
			return '-';
		
		//Para mostrar la parte de abajo, Intercambio F con C.
		//Sin usar variable auxiliar (Gracias google).
		if(F > C) {
			F = F + C;
			C = F - C;
			F = F - C;
		}
		
		return vectorMatriz[F*this.cantNodos + C - ((int)(Math.pow(F, 2)+ 3*F + 2)/2)];
	}
	
	public void setArista(int F, int C) {
		if (F==C)
			return;
		if(F > C) {
			F = F + C;
			C = F - C;
			F = F - C;
		}
		vectorMatriz[(F*this.cantNodos)+C-((int)(Math.pow(F, 2)+3*F+2)/2)] = '1';
		this.listaArista.add(new Arista(F,C));
	}
	
	public int getCantNodos(){
		return this.cantNodos;
	}

	public int getCantAristas() {
		return this.listaArista.size();
	}
	
	public int getTotalAristas() {
		return this.totalAristas;
	}
	
	public ArrayList <Arista> getListaAristas() {
		return this.listaArista;
	}
}
