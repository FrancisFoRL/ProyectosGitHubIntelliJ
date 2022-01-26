package paquete1;

import java.util.Random;

public class Faker {
    private static final String[] NOMBRES = {"Juan", "Fran", "David", "Alba", "Natalia", "Maria"};
    private static final String[] PROVINCIAS = {"Almeria", "Malaga", "Granada", "Sevilla", "Huelva", "Cadiz", "Cordoba"};
    private static final String[] APELLIDOS = {"Castillo", "Muñoz", "Rodriguez", "Brull", "Garcia", "Ortiz"};

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