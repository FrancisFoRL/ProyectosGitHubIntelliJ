package federacion;

import java.util.Random;

public class Faker {
    /**
     * Array privada y estatica que almacena varios nombres.
     */
    private static final String[] NOMBRES = {"Alan", "Jacinto", "Martinez", "Alicia", "Jesús", "Mirta", "Andrea", "Josefina", "Mónica", "Andrés", "Juan",
            "Nicolás", "Antonia", "Juana", "Noé", "Antonio", "Juárez", "Noelia", "Azul", "Julia", "Paula", "Bartolomé", "Julián", "Patricio", "Belén", "Juliana",
            "Renzo", "Celeste", "Julio", "Rodrigo", "Edgardo", "Leandro", "Rodríguez", "Felicia", "Luis", "Romina", "Florencia", "Luisa", "Rosario", "Gaspar", "Marcelo"};
    /**
     * Array privada y estatica que almacena varios apellidos.
     */
    private static final String[] APELLIDOS = {"Castillo", "Muñoz", "Rodriguez", "Brull", "Garcia", "Ortiz"};

    /**
     * Funcion que no recibe nada y que devuelve un nombre aleatorio del array de nombres.
     *
     * @return devuelve un String con un nombre.
     */

    private static final String[] PUESTO_BALONCESTO = {"Pivot", "Alero", "Base"};
    private static final String[] PUESTO_FUTBOL = {"Delantero", "Mediocentro", "Defensa"};
    private static final String[] PUESTO_BALONMANO = {"Pivot", "Central", "Defensa"};
    private static final String[] NOMBRE_EQUIPO = {"Troyanos","Real Boludos","Manes Club","Messidores","Mochos Fútbol Club","Penaldos","Atletas de Mentiras FC","Todo Terreno"};
    public static String nombres() {
        Random r1 = new Random();
        String nombre;
        int num = r1.nextInt(NOMBRES.length);
        return nombre = NOMBRES[num];
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

    public static String puestoBaloncesto() {
        Random r1 = new Random();
        String puesto;
        int num = r1.nextInt(PUESTO_BALONCESTO.length);
        return puesto = PUESTO_BALONCESTO[num];
    }

    public static String puestoFutbol() {
        Random r1 = new Random();
        String puesto;
        int num = r1.nextInt(PUESTO_FUTBOL.length);
        return puesto = PUESTO_FUTBOL[num];
    }

    public static String puestoBalonmano() {
        Random r1 = new Random();
        String puesto;
        int num = r1.nextInt(PUESTO_BALONMANO.length);
        return puesto = PUESTO_BALONMANO[num];
    }

    public static String nombreEquipo() {
        Random r1 = new Random();
        String nombre;
        int num = r1.nextInt(NOMBRE_EQUIPO.length);
        return nombre = NOMBRE_EQUIPO[num];
    }

    public static Fecha fechaAleatoria(int rango1, int rango2){
        Random r = new Random();
        Fecha fecha = new Fecha();
        int dia;
        int anio = r.nextInt(rango1,rango2);
        int mes = r.nextInt(1,12);
        do{
            dia = r.nextInt(1,31);
        }while(!fecha.comprobarDia(dia,mes,anio));
        fecha.setFechaCompleta(dia,mes,anio);
        return fecha;
    }
}