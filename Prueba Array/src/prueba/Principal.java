package prueba;

import libreria.GestionArray;
import paquete1.Faker;

public class Principal {
    public static void main (String[] args){
        String[] array = new String [100];
        String[] copiaBurbuja = new String[100];
        String[] copiaShell = new String[100];
        String[] copiaQuicksort = new String[100];
        long inicio, fin, tiempo;
        int posicion;

        rellenarArray(array);

        inicio = System.nanoTime();
        posicion = GestionArray.buscar_secuencial(array, "Antonio");
        fin = System.nanoTime();
        tiempo = fin - inicio;

        System.out.println("---------Metodo de Busqueda---------");
        System.out.println("El nombre Antonio esta en la posicion "+posicion);
        System.out.println("Tiempo de ejecucion metodo tradicional: "+tiempo+" nanosegundos\n");

        System.out.println("---------Metodos de Ordenacion---------");
        //Metodo Burbuja
        copiaBurbuja = array;
        inicio = System.nanoTime();
        GestionArray.burbuja_asc(copiaBurbuja);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Tiempo de ejecucion metodo burbuja: "+tiempo+" nanosegundos");

        //Metodo Shell
        copiaShell=array;
        inicio = System.nanoTime();
        GestionArray.shell_asc(copiaShell);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Tiempo de ejecucion metodo shell: "+tiempo+" nanosegundos");

        //Metodo quicksort
        copiaQuicksort=array;
        inicio = System.nanoTime();
        GestionArray.shell_asc(copiaQuicksort);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Tiempo de ejecucion metodo quicksort: "+tiempo+" nanosegundos");







    }

    private static void pintarPersona(String[] personas){
        for(int x=0; x < personas.length;x++){
            System.out.println("Datos de persona "+x+": "+personas[x]);
        }
    }

    private static void rellenarArray(String[] personas){
        for(int x=0; x < personas.length;x++){
            personas[x] = Faker.nombres();
        }
    }
}
