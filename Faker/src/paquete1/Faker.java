package paquete1;

import java.util.Random;

public class Faker {
    /**
     * Array privada y estatica que almacena varios nombres.
     */
    private static final String[] NOMBRES = {"Alan", "Jacinto", "Martinez", "Alicia", "Jesús", "Mirta", "Andrea", "Josefina", "Mónica", "Andrés", "Juan",
            "Nicolás", "Antonia", "Juana", "Noé", "Antonio", "Juárez", "Noelia", "Azul", "Julia", "Paula", "Bartolomé", "Julián", "Patricio", "Belén", "Juliana",
            "Renzo", "Celeste", "Julio", "Rodrigo", "Edgardo", "Leandro", "Rodríguez", "Felicia", "Luis", "Romina", "Florencia", "Luisa", "Rosario", "Gaspar", "Marcelo"};
    /**
     * Array privada y estatica que almacena varias provincias.
     */
    private static final String[] PROVINCIAS = {"Almeria", "Malaga", "Granada", "Sevilla", "Huelva", "Cadiz", "Cordoba"};
    /**
     * Array privada y estatica que almacena varios apellidos.
     */
    private static final String[] APELLIDOS = {"Castillo", "Muñoz", "Rodriguez", "Brull", "Garcia", "Ortiz"};

    /**
     * Funcion que no recibe nada y que devuelve un nombre aleatorio del array de nombres.
     *
     * @return devuelve un String con un nombre.
     */
    public static String nombres() {
        Random r1 = new Random();
        String nombre;
        int num = r1.nextInt(NOMBRES.length);
        return nombre = NOMBRES[num];
    }

    /**
     * Funcion que no recibe nada y que devuelve una provincia aleatoria del array de provincias.
     *
     * @return devuelve un String con un nombre de una provincia.
     */
    public static String provincias() {
        Random r1 = new Random();
        String provincia;
        int num = r1.nextInt(PROVINCIAS.length);
        return provincia = PROVINCIAS[num];
    }

    /**
     * Funcion que no recibe nada y que devuelve un apellido aleatorio del array de apellidos.
     *
     * @return devuelve un String con un provincia.
     */
    public static String apellidos() {
        Random r1 = new Random();
        String apellido;
        int num = r1.nextInt(APELLIDOS.length);
        return apellido = APELLIDOS[num];
    }
}