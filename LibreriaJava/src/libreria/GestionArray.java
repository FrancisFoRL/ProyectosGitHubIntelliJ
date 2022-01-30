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

    public static void mostrarVectorCadena(String[] vector) {
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

    /**
     * Busqueda Secuencial
     */
    public static int buscar_secuencial(float[] v, float ele) {
        int i, pos = -1;
        boolean encontrado = false;
        for (i = 0; i < v.length && !encontrado; i++)
            if (v[i] == ele) {
                encontrado = true;
                pos = i;
            }
        return pos;
    }

    public static int buscar_secuencial(int[] v, int ele) {
        int i, pos = -1;
        boolean encontrado = false;
        for (i = 0; i < v.length && !encontrado; i++)
            if (v[i] == ele) {
                encontrado = true;
                pos = i;
            }
        return pos;
    }

    public static int buscar_secuencial(String[] cadenas, String cad) {
        int i, pos = -1;
        boolean encontrado = false;
        for (i = 0; i < cadenas.length && !encontrado; i++) {
            if (cadenas[i].equals(cad)) {
                encontrado = true;
                pos = i;

            }
        }
        return pos;
    }

    /**
     * Busqueda Binaria
     */
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

    public static int b_binaria_asc(String[] v, String ele) {
        int izquierda = 0, derecha = v.length - 1, posicion, mitad;
        mitad = (izquierda + derecha) / 2;
        while (!v[mitad].equals(ele) && izquierda <= derecha) {
            if (ele.compareTo(v[mitad]) > 0)
                izquierda = mitad + 1;
            else
                derecha = mitad - 1;
            mitad = (izquierda + derecha) / 2;
        }
        if (v[mitad].equals(ele))
            posicion = mitad;
        else
            posicion = -1;
        return posicion;
    }

    /**
     * Metodo burbuja
     */
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
                }
    }

    public static void muestra(int v[]) {
        System.out.println("\n El vector de enteros es:\n");
        for (int f = 0; f < v.length; f++)
            System.out.print(v[f] + " ");
    }

    public static void aleatorio(int v[]) {
        for (int f = 0; f < v.length; f++)
            v[f] = (int) Math.round(Math.random() * 1000);
    }

    public static void burbuja_asc(String[] v) {
        int i, j;
        String temp;
        int num_ele = v.length;
        for (i = 1; i < num_ele; i++)
            for (j = 0; j < num_ele - i; j++)
                if (v[j].compareTo(v[j + 1]) > 0) {
                    temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
    }

    /**
     * Metodo Shell
     */
    public static void shell_asc(int v[]) {
        int d, i, ele;
        boolean ordenado;
        int num_ele = v.length;
        d = num_ele / 2;
        while (d >= 1) {
            ordenado = false;
            while (!ordenado) {
                ordenado = true;
                for (i = 0; i < num_ele - d; i++)
                    if (v[i] > v[i + d]) {
                        ele = v[i];
                        v[i] = v[i + d];
                        v[i + d] = ele;
                        ordenado = false;
                    }
            }
            d = d / 2;
        }
    }

    public static void shell_asc(String[] v) {
        int d, i;
        String ele;
        boolean ordenado;
        int num_ele = v.length;
        d = num_ele / 2;
        while (d >= 1) {
            ordenado = false;
            while (!ordenado) {
                ordenado = true;
                for (i = 0; i < num_ele - d; i++)
                    if (v[i].compareTo(v[i + d]) > 0) {
                        ele = v[i];
                        v[i] = v[i + d];
                        v[i + d] = ele;
                        ordenado = false;
                    }
            }
            d = d / 2;
        }
    }

    /**
     * Metodo Quicksort
     */
    public static void quicksort_asc(int v[]) {
        quicksort_asc(v, 0, v.length - 1);
    }

    private static void quicksort_asc(int v[], int izq, int der) {
        int pivote = v[izq];
        int i = izq;
        int j = der;
        int aux;
        while (i < j) {
            while (v[i] <= pivote && i < j)
                i++;
            while (v[j] > pivote)
                j--;
            if (i < j) {
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        v[izq] = v[j];
        v[j] = pivote;
        if (izq < j - 1)
            quicksort_asc(v, izq, j - 1);
        if (j + 1 < der)
            quicksort_asc(v, j + 1, der);
    }

    public static void quicksort_asc(String[] v) {
        quicksort_asc(v, 0, v.length - 1);
    }

    private static void quicksort_asc(String[] v, int izq, int der) {
        String pivote = v[izq];
        int i = izq;
        int j = der;
        String aux;
        while (i < j) {
            while (v[i].compareTo(pivote) == 0 && i < j)
                i++;
            while (v[j].compareTo(pivote) > 0)
                j--;
            if (i < j) {
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        v[izq] = v[j];
        v[j] = pivote;
        if (izq < j - 1)
            quicksort_asc(v, izq, j - 1);
        if (j + 1 < der)
            quicksort_asc(v, j + 1, der);
    }

}
