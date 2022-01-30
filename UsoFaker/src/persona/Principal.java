package persona;

import libreria.GestionArray;
import paquete1.Faker;

/**
 * Clase donde se crea un objeto persona y se rellena y pinta por pantalla lo que se guardo en el array
 * de personas.
 *
 * @author Francisco Castillo
 * @version 25/01/2022
 */
public class Principal {

    public static void main(String[] args) {
        Persona[] personas = new Persona[20];
        rellenarPersona(personas);
        pintarPersona(personas);
    }

    /**
     * Funcion que muestra por pantalla el contenido del array de tipo Persona que se pasa por parametro.
     *
     * @param personas Array de tipo Persona que se usara para mostrar por pantalla.
     */
    private static void pintarPersona(Persona[] personas) {
        for (int x = 0; x < personas.length; x++) {
            System.out.println("Datos de persona " + (x + 1) + ": " + personas[x]);
        }
    }

    /**
     * Funcion que rellena el array de tipo Persona que se pasa por parametros.
     *
     * @param personas Array de tipo Persona que se usara para para rellenarlo.
     */
    private static void rellenarPersona(Persona[] personas) {
        for (int x = 0; x < personas.length; x++) {
            personas[x] = new Persona();
            personas[x].setNombre(Faker.nombres());
            personas[x].setApellido(Faker.apellidos());
            personas[x].setApellido2(Faker.apellidos());
            personas[x].setProvincia(Faker.provincias());
        }
    }
}
