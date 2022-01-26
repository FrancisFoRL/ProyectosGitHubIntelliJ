package game;

import libreria.GestionArray;

/**
 * Esta clase contiene principalmente todas las funciones que ayudan a gestionar el juego de Hundir la Flota.
 * Contiene objetos, ya que al haber dos jugadores, cada vez que se cree uno, se le creara sus arrays correspondientes y
 * los barcos que tendra en su poder.
 *
 * @author Francisco Castillo Brull
 * @version 25/01/2022
 */

public class Gestion {

    //Atributos
    /**
     * EL atributo fila privado estatico y final, el cual lleva el numero de filas que se usara en un array. Este sera estatico ya que sera
     * igual para todos y nos no interesa que este sea cambiado.
     */
    private static final int fila = 5;
    /**
     * EL atributo columna, privado, estatico y final, el cual lleva el numero de columnas que se usara en un array. Este sera estatico ya que sera
     *      * igual para todos y nos no interesa que este sea cambiado.
     */
    private static final int columna = 5;
    /**
     * El atributo barcos, que se usara para asignar una cantidad de barcos a un jugador.
     */
    private int barcos;
    /**
     * Matriz tableroGestion que gestionara el juego de Hundir la Flota.
     */
    private int[][] tableroGestion;
    /**
     * Matriz tableroVista que se muestra por pantalla y con la que interactuara el jugador.
     */
    private String[][] tableroVista;

    //Constructor

    /**
     * Constructor sin parametros que inicia varios atributos:
     * -barcos: se iniciara la cantidad de barcos a 2 por jugador.
     * -tableroGestion: se iniciara todas sus posiciones a 0.
     * -tableroVista: se iniciara todas sus posiciones a el valor X.
     */

    public Gestion() {
        barcos = 2;
        tableroGestion = GestionArray.CrearInicializarMatrizEnteros(fila, columna, 0);
        tableroVista = rellenarArrayString(fila, columna);
    }

    public int getBarcos() {
        return barcos;
    }

    public int[][] getTableroGestion() {
        return tableroGestion;
    }

    public String[][] getTableroVista() {
        return tableroVista;
    }

    /**
     * Funcion que muestra la funcion que se ve por pantalla. Aqui se controla la forma en la que se va a ver, para que asi no se vea de una forma
     * desordena y que sea algo legible para el usuario.
     *
     * @param matriz El parametro matriz que se recibe es la matriz que se mostrara por pantalla.
     * @return No se devolvera nada, solo se imprime por pantalla.
     */
    public void mostrarArray(String[][] matriz) {
        System.out.println("---------Tablero---------\n");
        System.out.print("  C O L U M N A S");
        for (int x = 0; x < matriz.length; x++) {
            System.out.println();
            for (int y = 0; y < matriz[x].length; y++) {
                if (x == 0 && y == 0) {
                    System.out.print("F " + matriz[x][y] + "     ");
                } else if (x == 1 && y == 0) {
                    System.out.print("I " + matriz[x][y] + "     ");
                } else if (x == 2 && y == 0) {
                    System.out.print("L " + matriz[x][y] + "     ");
                } else if (x == 3 && y == 0) {
                    System.out.print("A " + matriz[x][y] + "     ");
                } else if (x == 4 && y == 0) {
                    System.out.print("S " + matriz[x][y] + "     ");
                } else if (x == 0 && y >= 10) {
                    System.out.print("  " + matriz[x][y] + "    ");
                } else if (x >= 10 && y >= 1) {
                    System.out.print("  " + matriz[x][y] + "     ");
                } else if (x >= 10) {
                    System.out.print("  " + matriz[x][y] + "    ");
                } else {
                    System.out.print("  " + matriz[x][y] + "     ");
                }
            }
        }
        System.out.println("\n");
    }


    /**
     * Funcion que rellena el array a mostrar por pantalla. Este se rellena de forma que se vean las coordenadas
     * y sea mas entendible para el usuario. Lo demas se rellena con una X.
     *
     * @param filas    El parametro filas definira la cantidad de filas que habra en la matriz.
     * @param columnas El parametro columnas definira la cantidad de filas que habra en la matriz.
     * @return
     */
    private static String[][] rellenarArrayString(int filas, int columnas) {
        String[][] array = new String[filas][columnas];
        int superior = 1, inferior = 1;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if (x == 0 && y == 0) {
                    array[x][y] = "-";
                } else if (x == 0) {
                    array[x][y] = String.valueOf(superior);
                    superior++;
                } else if (y == 0) {
                    array[x][y] = String.valueOf(inferior);
                    inferior++;
                } else {
                    array[x][y] = "X";
                }
            }
        }
        return array;
    }

    /**
     * Funcion que controla la posicion indicada por el jugador. Esta mostrara si la posicion proporcionada es Agua o ha tocado un
     * Barco. En el caso de que el barco ya se haya tocado dos veces, saldra un mensaje de que este ha sido hundido y se le restara ese
     * barco al jugador.
     *
     * @param tabGestion El parametro tabGestion es el array sobre el que se va a comprobar las coordenadas.
     * @param tabVista   El parametro tabVista es el que se cambiara segun lo que se haya encontrado.
     * @param filas      EL parametro filas es la fila que indico el jugador.
     * @param columnas   EL parametro filas es la columna que indico el jugador.
     */
    public void comprobarPosicion(int[][] tabGestion, String[][] tabVista, int filas, int columnas) {
        if (tabGestion[filas][columnas] != 1 && tabGestion[filas][columnas] != 2) {
            System.out.println("\nAgua!");
            tabVista[filas][columnas] = "A";

        } else if (tabGestion[filas][columnas] == 1 || tabGestion[filas][columnas] == 2) {
            System.out.println("\nBarco Tocado!");
            tabVista[filas][columnas] = "T";

            if (filas < fila && columnas < columna && tabVista[filas - 1][columnas].equals("T") && tabGestion[filas - 1][columnas] == tabGestion[filas][columnas]) {
                System.out.println("Barco Hundido!");
                barcos--;

            } else if (filas < fila && columnas < columna && tabVista[filas][columnas - 1].equals("T") && tabGestion[filas][columnas - 1] == tabGestion[filas][columnas]) {
                System.out.println("Barco Hundido!");
                barcos--;

            }else if (filas < fila && columnas < columna && tabVista[filas][columnas + 1].equals("T") && tabGestion[filas][columnas + 1] == tabGestion[filas][columnas]) {
                System.out.println("Barco Hundido!");
                barcos--;

            } else if (filas+1 != fila) {
                 if (filas < fila && columnas < columna && tabVista[filas + 1][columnas].equals("T") && tabGestion[filas + 1][columnas] == tabGestion[filas][columnas]) {
                     System.out.println("Barco Hundido!");
                     barcos--;
                 }
            }
        }
    }
}

