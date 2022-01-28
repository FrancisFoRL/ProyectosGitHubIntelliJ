package paquete1;

import java.util.Random;

public class Faker {
    private static final String[] NOMBRES = {"Alan", "Jacinto", "Martinez", "Alicia", "Jesús", "Mirta", "Andrea", "Josefina", "Mónica", "Andrés", "Juan",
            "Nicolás", "Antonia", "Juana", "Noé" , "Antonio", "Juárez", "Noelia", "Azul", "Julia", "Paula" ,"Bartolomé", "Julián", "Patricio", "Belén", "Juliana",
            "Renzo", "Celeste", "Julio", "Rodrigo", "Edgardo", "Leandro", "Rodríguez", "Felicia", "Luis", "Romina", "Florencia", "Luisa", "Rosario", "Gaspar", "Marcelo"};
    private static final String[] PROVINCIAS = {"Almeria", "Malaga", "Granada", "Sevilla", "Huelva", "Cadiz", "Cordoba"};
    private static final String[] APELLIDOS = {"Castillo", "Muñoz", "Rodriguez", "Brull", "Garcia", "Ortiz"};
//hola
    public static String nombres() {
        Random r1 = new Random();
        String nombre;
        int num = r1.nextInt(NOMBRES.length);
        return nombre = NOMBRES[num];
    }

    public static String provincias() {
        Random r1 = new Random();
        String provincia;
        int num = r1.nextInt(PROVINCIAS.length);
        return provincia = PROVINCIAS[num];
    }

    public static String apellidos() {
        Random r1 = new Random();
        String apellido;
        int num = r1.nextInt(APELLIDOS.length);
        return apellido = APELLIDOS[num];
    }
}