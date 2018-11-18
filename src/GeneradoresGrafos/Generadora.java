package GeneradoresGrafos;

import MatrizSimetrica.MatrizSimetrica;

public abstract class Generadora {
	protected MatrizSimetrica matriz;
	private int cantNodos;
	
	
	public Generadora(int cantNodos){
		matriz  = new MatrizSimetrica(cantNodos);
		this.cantNodos = cantNodos;
	}
	
	public abstract void generar();
	
	//Calcular GradoMax  y GradoMin.
	//Calcular Aristas.
	
	public int getCantNodos() {
		return this.cantNodos;
	}
	
	public MatrizSimetrica getMatrizSimetrica() {
		return this.matriz;
	}
	
	
	public void imprimir(){
//		String ESPACIOS = " ";
//		if (this.matriz.getCantNodos()<)
//			ESPACIOS = "  ";
//		else
//			ESPACIOS = " ";
		
		System.out.print(" ");
		for (int C = 0; C < this.matriz.getCantNodos(); C++) {
			System.out.print(" " + C);
		}
		
		for(int F = 0; F < this.matriz.getCantNodos(); F++) {
			System.out.println();
			System.out.print(F + " ");
			for (int C = 0; C < this.matriz.getCantNodos(); C++) {
				
				
				if (this.matriz.getNodo(F, C)=='1') {
					System.out.printf("%s ",this.matriz.getNodo(F, C));
				}
				else if (F == C) {
					System.out.printf("- ");
				}else {
					System.out.printf("0 ");
				}					
			}
		}
	}
	
	//como generar un grafo de red de mundo Pequenio. para el 7 de Mica.

}
