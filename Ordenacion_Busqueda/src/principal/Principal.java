package principal;

import libreria.GestionArray;
import paquete1.Faker;

/**
 * La clase Principal se usara para hacer pruebas de el metodo de busqueda y de los diferentes metodos de ordenacion, como son
 * el de burbuja, el Shell y el quicksort. Se vera que tiempo de ejecucion tiene cada uno, con ello vemos cual es el mas eficiente
 * de los tres.
 *
 * @author Francisco Castillo Brull
 * @version 30/01/2022
 */

public class Principal {
    public static void main(String[] args) {
        //Atributos

        String[] array = new String[100]; //Array principal de tipo String donde se guardaran los nombres.
        /*
         * Arrays de tipo String que sera copias del array principal.
         */
        String[] copiaBurbuja = new String[100];
        String[] copiaShell = new String[100];
        String[] copiaQuicksort = new String[100];
        long inicio, fin, tiempo; //Atributos que nos valdra para el tiempo de ejecucion de un algoritmo.
        int posicion;//Atributo que guarda la posicion del nombre que se busca.

        rellenarArray(array);

        /*
         * Para el caso del calculo del tiempo se usa nanoTime, ya que la ejecuciones solo llegan a mostrarse en
         * nanosegundos. Antes de llamar cada funcion se inicia y cuando esta termina, vuelve a repetir nanotime.
         * Con esto recibimos dos valores que restamos y conseguimos el tiempo que tardo en ejecutar el algoritmo.
         */
        inicio = System.nanoTime();
        posicion = GestionArray.buscar_secuencial(array, "Antonio");
        fin = System.nanoTime();
        tiempo = fin - inicio;

        System.out.println("---------Metodo de Busqueda---------");
        System.out.println("El nombre Antonio esta en la posicion " + posicion);
        System.out.println("Tiempo de ejecucion metodo tradicional: " + tiempo + " nanosegundos\n");

        System.out.println("---------Metodos de Ordenacion---------");

        //Metodo Burbuja
        copiaBurbuja = array;
        inicio = System.nanoTime();
        GestionArray.burbuja_asc(copiaBurbuja);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Tiempo de ejecucion metodo burbuja: " + tiempo + " nanosegundos");

        //Metodo Shell
        copiaShell = array;
        inicio = System.nanoTime();
        GestionArray.shell_asc(copiaShell);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Tiempo de ejecucion metodo shell: " + tiempo + " nanosegundos");

        //Metodo quicksort
        copiaQuicksort = array;
        inicio = System.nanoTime();
        GestionArray.shell_asc(copiaQuicksort);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Tiempo de ejecucion metodo quicksort: " + tiempo + " nanosegundos");

    }

    /**
     * Funcior rellenarArray que rellena todas la posiciones de un array con nombres aleatorios que
     * recibe de la libreria Faker.
     *
     * @param personas
     * @see Faker
     */

    private static void rellenarArray(String[] personas) {
        for (int x = 0; x < personas.length; x++) {
            personas[x] = Faker.nombres();
        }
    }
}

