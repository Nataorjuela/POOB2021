package jewelQuest;

import java.util.Random;

public class JewelQuest{

	private int[][]tablero;
	private boolean isVisible;
	private int puntaje;

	public static void main(String[] args ){
		JewelQuest gui=new JewelQuest();	
	}

	public JewelQuest() {
		tablero=new int[6][8];
		puntaje=0;
		for(int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero[1].length;j++) {
				tablero[i][j]=aleatoria();
			}		 
		}
	}
	
	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public void cambiar(int x1,int y1,int x2,int y2) {

		if (((Math.abs(x2-x1))==1 && (Math.abs(y2-y1))!=1) || (((Math.abs(x2-x1))!=1)&&(Math.abs(y2-y1))==1)){
			int aux=tablero[x1][y1];
			tablero[x1][y1]=tablero[x2][y2];
			tablero[x2][y2]=aux;
		}
		verificarFilas();
		verificarColumnas();
		imprimir();
	}


	private void imprimir() {
		for(int i = 0; i < tablero.length; i++){ 
			for(int j = 0; j < tablero[i].length; j++){ 
				System.out.print(tablero[i][j] + " "); // Imprime elemento 
			} 
			System.out.println(); // Imprime salto de línea 
		} 

	}

	private void verificarColumnas() {
		int actual = 0;
		int cont = 0;
		int fila = 0;
		int colum = 0;
		while (colum < tablero[1].length) {
			actual = 0;
			cont = 0;
			while (fila < tablero.length) {
				if (tablero[fila][colum] == actual) {
					cont+=1;
				}
				else {
					actual = tablero[fila][colum];
					cont = 1;
				}
				if (cont > 2) {
					tablero[fila][colum] = aleatoria();
					tablero[fila-1][colum] = aleatoria();
					tablero[fila-2][colum] = aleatoria();
					puntaje += 30;
				}
				fila+=1;
			}
			colum+=1;
		}

	}

	private void verificarFilas() {
		int actual = 0;
		int cont = 0;
		for(int i=0;i<tablero.length;i++) {
			actual = 0;
			cont = 0;
			for(int j=0;j<tablero[1].length;j++) {
				if (tablero[i][j] == actual) {
					cont+=1;
				}
				else {
					actual = tablero[i][j];
					cont = 1;
				}
				if (cont > 2) {
					tablero[i][j] = aleatoria();
					tablero[i][j-1] = aleatoria();
					tablero[i][j-2] = aleatoria();
					puntaje += 30;
				}
			}

		}



	}

	private int aleatoria(){
		Random r = new Random();
		int valorDado = r.nextInt(3); // Entre 0 y 4.
		return valorDado;
	}



}
