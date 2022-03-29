package buscaminas;

import java.util.Arrays;
import java.util.Random;

public class Tablero {
    private int filas;
    private int columnas;
    private int minas, min, max;
    private int[][] tablero;

    public Tablero(){
    }

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        tablero = new int[filas][columnas];
        colocarMinas();
        colocarPista();
    }

    private void colocarMinas() {
        Random ale = new Random();
        int contMinas = 0, fila, columna;
        do {
            fila = ale.nextInt(0, filas);
            columna = ale.nextInt(0, columnas);
            if (tablero[fila][columna] != 9) {
                tablero[fila][columna] = 9;
                contMinas++;
            }
        } while (contMinas != minas);
    }

    private void colocarPista(){
        for(int x = 0; x < filas; x++){
            for(int y = 0; y < columnas; y++){
                if(tablero[x][y] != 9){
                    tablero[x][y]=rellena(x,y);
                }
            }
        }
    }

    public int rellena(int filas, int columnas){
        int cont = 0;
        for(int x = max(0, filas); x<=min(filas+1, this.filas-1); x++){
            for(int y = max(0, columnas - 1); y<=min(columnas+1, this.columnas-1); y++){
                if(x==filas && y==columnas)continue;
                if(tablero[x][y]==9)cont++;
            }
        }
        return cont;
    }

    private int min(int a, int b){
        return Math.min(a, b);
    }

    private int max(int a, int b){
        return Math.max(a, b);
    }

    public void pintarTablero(){
        System.out.println("Tablero");
        for(int x=0; x<filas; x++){
            for(int y=0; y<columnas; y++){
                if(tablero[x][y]!=9){
                    System.out.print("  "+tablero[x][y]+"\t");
                }else {
                    System.out.print("  "+tablero[x][y]+"\t");
                }
            }
            System.out.println();
        }
        System.out.println("Fin tablero");
    }
}
