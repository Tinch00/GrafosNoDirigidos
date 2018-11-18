package MatrizSimetrica;

public class MatrizSimetrica {
	
	// Solo para grafos NO dirigidos.
	
	private Nodo[] vectorMatriz;
	private int cantNodos;
	
	public MatrizSimetrica(int cantNodos) {
		vectorMatriz = new Nodo[(cantNodos*cantNodos-1)/2];
		this.cantNodos = cantNodos;
		for (int i = 0; i < this.vectorMatriz.length; i++ ) {
			vectorMatriz[i] = new Nodo('0');
		}
	}
	
	public char getNodo(int F, int C) {
		if (F == C)
			return '-';
		
		//Para mostrar la parte de abajo, Intercambio F con C.
		//Sin usar variable auxiliar (Gracias google).
		if(F > C) {
			F = F + C;
			C = F - C;
			F = F - C;
		}
		
		return vectorMatriz[F*this.cantNodos + C - ((int)(Math.pow(F, 2)+ 3*F + 2)/2)].getValorNodo();
	}
	
	public void setNodo(int F, int C) {
		if (F==C)
			return;
		if(F > C) {
			F = F + C;
			C = F - C;
			F = F - C;
		}
		
		int calculo = (F*this.cantNodos)+C-((int)(Math.pow(F, 2)+3*F+2)/2);
		vectorMatriz[(F*this.cantNodos)+C-((int)(Math.pow(F, 2)+3*F+2)/2)].setValorNodo('1');
	}
	
	public int getCantNodos(){
		return this.cantNodos;
	}
	
}
