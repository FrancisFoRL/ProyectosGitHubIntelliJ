package libreria;

public class GestionArray {
    public GestionArray() {
    }

    public static int[] CrearInicializarVectorEnteros(int filas, int valor) {
        if (filas <= 0) {
            System.out.println("Filas no es valido");
            return null;
        } else {
            int[] array = new int[filas];

            for(int x = 0; x < array.length; ++x) {
                array[x] = valor;
            }

            return array;
        }
    }

    public static double[] CrearInicializarVectorDecimal(int filas, double valor) {
        if (filas <= 0) {
            System.out.println("Filas no es valido");
            return null;
        } else {
            double[] array = new double[filas];

            for(int x = 0; x < array.length; ++x) {
                array[x] = valor;
            }

            return array;
        }
    }

    public static int[][] CrearInicializarMatrizEnteros(int filas, int columnas, int valor) {
        if (filas <= 0) {
            System.out.println("Filas no es valido");
            return null;
        } else if (columnas <= 0) {
            System.out.println("Columnas no es valido");
            return null;
        } else {
            int[][] array = new int[filas][columnas];

            for(int x = 0; x < array.length; ++x) {
                for(int y = 0; y < array[x].length; ++y) {
                    array[x][y] = valor;
                }
            }

            return array;
        }
    }

    public static double[][] CrearInicializarMatrizDecimal(int filas, int columnas, double valor) {
        if (filas <= 0) {
            System.out.println("Filas no es valido");
            return null;
        } else if (columnas <= 0) {
            System.out.println("Columnas no es valido");
            return null;
        } else {
            double[][] array = new double[filas][columnas];

            for(int x = 0; x < array.length; ++x) {
                for(int y = 0; y < array[x].length; ++y) {
                    array[x][y] = valor;
                }
            }

            return array;
        }
    }

    public static void mostrarVectorEnteros(int[] vector) {
        System.out.println("---------Mostrar vector---------");

        for(int x = 0; x < vector.length; ++x) {
            System.out.println("Valor fila " + x + ": " + vector[x]);
        }

    }

    public static void mostrarVectorCadena(String[] vector) {
        System.out.println("---------Mostrar vector---------");

        for(int x = 0; x < vector.length; ++x) {
            System.out.println("Valor fila " + x + ": " + vector[x]);
        }

    }

    public static void mostrarVectorDecimal(double[] vector) {
        System.out.println("---------Mostrar vector---------");

        for(int x = 0; x < vector.length; ++x) {
            System.out.println("Valor fila " + x + ": " + vector[x]);
        }

    }

    public static void mostrarMatrizEnteros(int[][] matriz) {
        System.out.println("---------Mostrar vector---------");

        for(int x = 0; x < matriz.length; ++x) {
            for(int y = 0; y < matriz[x].length; ++y) {
                System.out.println("Valor fila " + x + " / columna " + y + ": " + matriz[x][y]);
            }
        }

    }

    public static void mostrarMatrizEnteros(double[][] matriz) {
        System.out.println("---------Mostrar vector---------");

        for(int x = 0; x < matriz.length; ++x) {
            for(int y = 0; y < matriz[x].length; ++y) {
                System.out.println("Valor fila " + x + " / columna " + y + ": " + matriz[x][y]);
            }
        }

    }

    public static int buscar_secuencial(float[] v, float ele) {
        int pos = -1;
        boolean encontrado = false;

        for(int i = 0; i < v.length && !encontrado; ++i) {
            if (v[i] == ele) {
                encontrado = true;
                pos = i;
            }
        }

        return pos;
    }

    public static int buscar_secuencial(int[] v, int ele) {
        int pos = -1;
        boolean encontrado = false;

        for(int i = 0; i < v.length && !encontrado; ++i) {
            if (v[i] == ele) {
                encontrado = true;
                pos = i;
            }
        }

        return pos;
    }

    public static int buscar_secuencial(String[] cadenas, String cad) {
        int pos = -1;
        boolean encontrado = false;

        for(int i = 0; i < cadenas.length && !encontrado; ++i) {
            if (cadenas[i].equals(cad)) {
                encontrado = true;
                pos = i;
            }
        }

        return pos;
    }

    public static int b_binaria_asc(float[] v, float ele) {
        int izquierda = 0;
        int derecha = v.length - 1;

        int mitad;
        for(mitad = (izquierda + derecha) / 2; v[mitad] != ele && izquierda <= derecha; mitad = (izquierda + derecha) / 2) {
            if (ele > v[mitad]) {
                izquierda = mitad + 1;
            } else {
                derecha = mitad - 1;
            }
        }

        int posicion;
        if (v[mitad] == ele) {
            posicion = mitad;
        } else {
            posicion = -1;
        }

        return posicion;
    }

    public static int b_binaria_asc(String[] v, String ele) {
        int izquierda = 0;
        int derecha = v.length - 1;

        int mitad;
        for(mitad = (izquierda + derecha) / 2; !v[mitad].equals(ele) && izquierda <= derecha; mitad = (izquierda + derecha) / 2) {
            if (ele.compareTo(v[mitad]) > 0) {
                izquierda = mitad + 1;
            } else {
                derecha = mitad - 1;
            }
        }

        int posicion;
        if (v[mitad].equals(ele)) {
            posicion = mitad;
        } else {
            posicion = -1;
        }

        return posicion;
    }

    public static void burbuja_asc(int[] v) {
        int num_ele = v.length;

        for(int i = 1; i < num_ele; ++i) {
            for(int j = 0; j < num_ele - i; ++j) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }

    }

    public static void muestra(int[] v) {
        System.out.println("\n El vector de enteros es:\n");

        for(int f = 0; f < v.length; ++f) {
            System.out.print(v[f] + " ");
        }

    }

    public static void aleatorio(int[] v) {
        for(int f = 0; f < v.length; ++f) {
            v[f] = (int)Math.round(Math.random() * 1000.0D);
        }

    }

    public static void burbuja_asc(String[] v) {
        int num_ele = v.length;

        for(int i = 1; i < num_ele; ++i) {
            for(int j = 0; j < num_ele - i; ++j) {
                if (v[j].compareTo(v[j + 1]) > 0) {
                    String temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }

    }

    public static void shell_asc(int[] v) {
        int num_ele = v.length;

        for(int d = num_ele / 2; d >= 1; d /= 2) {
            boolean ordenado = false;

            while(!ordenado) {
                ordenado = true;

                for(int i = 0; i < num_ele - d; ++i) {
                    if (v[i] > v[i + d]) {
                        int ele = v[i];
                        v[i] = v[i + d];
                        v[i + d] = ele;
                        ordenado = false;
                    }
                }
            }
        }

    }

    public static void shell_asc(String[] v) {
        int num_ele = v.length;

        for(int d = num_ele / 2; d >= 1; d /= 2) {
            boolean ordenado = false;

            while(!ordenado) {
                ordenado = true;

                for(int i = 0; i < num_ele - d; ++i) {
                    if (v[i].compareTo(v[i + d]) > 0) {
                        String ele = v[i];
                        v[i] = v[i + d];
                        v[i + d] = ele;
                        ordenado = false;
                    }
                }
            }
        }

    }

    public static void quicksort_asc(int[] v) {
        quicksort_asc((int[])v, 0, v.length - 1);
    }

    private static void quicksort_asc(int[] v, int izq, int der) {
        int pivote = v[izq];
        int i = izq;
        int j = der;

        while(i < j) {
            while(v[i] <= pivote && i < j) {
                ++i;
            }

            while(v[j] > pivote) {
                --j;
            }

            if (i < j) {
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }

        v[izq] = v[j];
        v[j] = pivote;
        if (izq < j - 1) {
            quicksort_asc(v, izq, j - 1);
        }

        if (j + 1 < der) {
            quicksort_asc(v, j + 1, der);
        }

    }

    public static void quicksort_asc(String[] v) {
        quicksort_asc((String[])v, 0, v.length - 1);
    }

    private static void quicksort_asc(String[] v, int izq, int der) {
        String pivote = v[izq];
        int i = izq;
        int j = der;

        while(i < j) {
            while(v[i].compareTo(pivote) == 0 && i < j) {
                ++i;
            }

            while(v[j].compareTo(pivote) > 0) {
                --j;
            }

            if (i < j) {
                String aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }

        v[izq] = v[j];
        v[j] = pivote;
        if (izq < j - 1) {
            quicksort_asc(v, izq, j - 1);
        }

        if (j + 1 < der) {
            quicksort_asc(v, j + 1, der);
        }

    }
}

