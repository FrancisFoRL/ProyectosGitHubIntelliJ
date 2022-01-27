package libreria;

import java.util.Objects;

public class GestionArray {

    /*
     Función que crea un array unidimensional según el parámetro e inicializarlo según el otro
     parámetro.
     In: int filas será un valor mayor de cero que indicará de cuantas filas será el array; int valor indica
     que valor ha de tener cada una de las posiciones del array
     Out: Devuelve el array unidimensional de enteros inicializado o null si hay algun problema.
    */
    public static int[] CrearInicializarVectorEnteros(int filas, int valor) {
        if (filas <= 0) {
            System.out.println("Filas no es valido");
            return null;
        }

        int[] array = new int[filas];
        for (int x = 0; x < array.length; x++) {
            array[x] = valor;
        }
        return array;
    }

    /*
     Función que crea un array unidimensional según el parámetro e inicializarlo según el otro
     parámetro.
     In: int filas será un valor mayor de cero que indicará de cuantas filas será el array; double valor
     indica que valor ha de tener cada una de las posiciones del array
     Out: Devuelve el array unidimensional de decimales inicializado o null si hay algun problema.
    */
    public static double[] CrearInicializarVectorDecimal(int filas, double valor) {
        if (filas <= 0) {
            System.out.println("Filas no es valido");
            return null;
        }

        double[] array = new double[filas];
        for (int x = 0; x < array.length; x++) {
            array[x] = valor;
        }
        return array;
    }

    /*
     Función que crea un array bidimensional según los parámetro e inicializarlo según el otro
     parámetro.
     In: int filas será un valor mayor de cero que indicará de cuantas filas será el array; int columnas será
     un valor mayor de cero que indicará de cuantas columnas será el array; int valor indica que valor ha
     de tener cada una de las posiciones del array
     Out: Devuelve el array bidimensional de enteros inicializado o null si hay algun problema.
    */
    public static int[][] CrearInicializarMatrizEnteros(int filas, int columnas, int valor) {
        if (filas <= 0) {
            System.out.println("Filas no es valido");
            return null;
        }

        if (columnas <= 0) {
            System.out.println("Columnas no es valido");
            return null;
        }

        int[][] array = new int[filas][columnas];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                array[x][y] = valor;
            }
        }
        return array;
    }

    /*
     Función que crea un array unidimensional según el parámetro e inicializarlo según el otro
     parámetro.
     In: int filas será un valor mayor de cero que indicará de cuantas filas será el array; int columnas será
     un valor mayor de cero que indicará de cuantas columnas será el array; double valor indica que
     valor ha de tener cada una de las posiciones del array
     Out: Devuelve el array bidimensional de decimales inicializado o null si hay algun problema.
    */
    public static double[][] CrearInicializarMatrizDecimal(int filas, int columnas, double valor) {
        if (filas <= 0) {
            System.out.println("Filas no es valido");
            return null;
        }

        if (columnas <= 0) {
            System.out.println("Columnas no es valido");
            return null;
        }

        double[][] array = new double[filas][columnas];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                array[x][y] = valor;
            }
        }
        return array;
    }

    /*
     Función que muestra por pantalla los valores de un array unidimensional de enteros.
     In: int [] vector es el array a mostrar
     Out: No devuelve nada.
    */
    public static void mostrarVectorEnteros(int[] vector) {
        System.out.println("---------Mostrar vector---------");
        for (int x = 0; x < vector.length; x++) {
            System.out.println("Valor fila " + x + ": " + vector[x]);
        }
    }

    /*
     Función que muestra por pantalla los valores de un array unidimensional de decimales.
     In: int [] vector es el array a mostrar
     Out: No devuelve nada.
    */
    public static void mostrarVectorDecimal(double[] vector) {
        System.out.println("---------Mostrar vector---------");
        for (int x = 0; x < vector.length; x++) {
            System.out.println("Valor fila " + x + ": " + vector[x]);
        }
    }

    /*
     Función que muestra por pantalla los valores de un array bidimensional de enteros.
     In: int [] matriz es el array a mostrar
     Out: No devuelve nada.
    */
    public static void mostrarMatrizEnteros(int[][] matriz) {
        System.out.println("---------Mostrar vector---------");
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                System.out.println("Valor fila " + x + " / columna " + y + ": " + matriz[x][y]);
            }
        }
    }

    /*
     Función que muestra por pantalla los valores de un array bidimensional de decimales.
     In: int [] matriz es el array a mostrar
     Out: No devuelve nada.
    */
    public static void mostrarMatrizEnteros(double[][] matriz) {
        System.out.println("---------Mostrar vector---------");
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                System.out.println("Valor fila " + x + " / columna " + y + ": " + matriz[x][y]);
            }
        }
    }

    public static void burbuja_asc(int v[]) {
        int i, j;
        int temp;
        int num_ele = v.length;
        for (i = 1; i < num_ele; i++)
            for (j = 0; j < num_ele - i; j++)
                if (v[j] > v[j + 1]) {
                    temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                } /* fin if */
    } /* fin burbuja_asc */

    public static int buscar_secuencial(String[] texto, String ele) {
        int i, pos = -1;
        boolean encontrado = false;
        /* !encontrado es igual que encontrado == false */
        for (i = 0; i < texto.length && !encontrado; i++)
            if (Objects.equals(texto[i], ele)) {
                // se ha encontrado el elemento ele en el vector
                encontrado = true;
                pos = i;
            }
        return pos;
    } /* fin buscar_secuencial */

    public static int b_binaria_asc(float v[], float ele) {
        int izquierda = 0, derecha = v.length - 1, posicion, mitad;
        mitad = (izquierda + derecha) / 2;

        while (v[mitad] != ele && izquierda <= derecha) {
            if (ele > v[mitad])
                izquierda = mitad + 1;
            else
                derecha = mitad - 1;
            mitad = (izquierda + derecha) / 2;
        }
        if (v[mitad] == ele)
            posicion = mitad;
        else
            posicion = -1;
        return posicion;
    }
}
