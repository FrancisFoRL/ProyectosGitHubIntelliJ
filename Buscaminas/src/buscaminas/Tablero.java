package buscaminas;

import java.util.Arrays;
import java.util.Random;

public class Tablero {
    private int filas;
    private int columnas;
    private int minas, min, max;
    private int[][] tablero;

    public Tablero() {
        filas = 10;
        columnas = 10;
        minas = 10;
        tablero = new int[filas][columnas];
        asignarPosiciones();
        comprobarPosiciones();
    }

    private void asignarPosiciones() {
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

    private void comprobarPosiciones() {
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
            }
        }
    }
}
