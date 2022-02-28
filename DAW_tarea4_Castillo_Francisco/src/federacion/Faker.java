package federacion;

import java.util.Random;

/**
 * Clase faker que se usa para que devuelva valores de forma aletoria de los Arrays que tiene integrados.
 * @author Francisco Castillo
 * @version 28/01/2022
 */
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
     * Array privada y estatica que almacena varios puestos de baloncesto.
     */
    private static final String[] PUESTO_BALONCESTO = {"Pivot", "Alero", "Base"};

    /**
     * Array privada y estatica que almacena varios puestos de futbol.
     */
    private static final String[] PUESTO_FUTBOL = {"Delantero", "Mediocentro", "Defensa"};

    /**
     * Array privada y estatica que almacena varios puestos de balonmano.
     */
    private static final String[] PUESTO_BALONMANO = {"Pivot", "Central", "Defensa"};

    /**
     * Array privada y estatica que almacena varios nombre de equipo.
     */
    private static final String[] NOMBRE_EQUIPO = {"Troyanos","Real Boludos","Gandules Club","Messidores","Mochos Fútbol Club","Penaldos","Atletas de Mentiras FC","Todo Terreno", "Los jaja"};

    /**
     * Funcion que no recibe nada y que devuelve un nombre aleatorio del array de nombres.
     *
     * @return devuelve un String con un nombre.
     */
    public static String nombres() {
        Random r1 = new Random();
        int num = r1.nextInt(NOMBRES.length);
        return NOMBRES[num];
    }

    /**
     * Funcion que no recibe nada y que devuelve un apellido aleatorio del array de apellidos.
     * @return devuelve un String con un provincia.
     */
    public static String apellidos() {
        Random r1 = new Random();
        int num = r1.nextInt(APELLIDOS.length);
        return APELLIDOS[num];
    }

    /**
     * Funcion que no recibe nada y que devuelve un puesto de baloncesto aleatorio del array de PUESTO_BALONCESTO.
     * @return devuelve un String con una posicion de baloncesto.
     */
    public static String puestoBaloncesto() {
        Random r1 = new Random();
        int num = r1.nextInt(PUESTO_BALONCESTO.length);
        return PUESTO_BALONCESTO[num];
    }

    /**
     * Funcion que no recibe nada y que devuelve un puesto de futbol aleatorio del array de PUESTO_FUTBOL.
     * @return devuelve un String con una posicion de futbol.
     */
    public static String puestoFutbol() {
        Random r1 = new Random();
        int num = r1.nextInt(PUESTO_FUTBOL.length);
        return PUESTO_FUTBOL[num];
    }

    /**
     * Funcion que no recibe nada y que devuelve un puesto de baloncesto aleatorio del array de PUESTO_BALONMANO.
     * @return devuelve un String con una posicion de balonmano.
     */
    public static String puestoBalonmano() {
        Random r1 = new Random();
        int num = r1.nextInt(PUESTO_BALONMANO.length);
        return PUESTO_BALONMANO[num];
    }

    /**
     * Funcion que no recibe nada y que devuelve un nombre de equipo aleatorio del array de NOMBRE_EQUIPO.
     * @return devuelve un String con una nombre de equipo.
     */
    public static String nombreEquipo() {
        Random r1 = new Random();
        int num = r1.nextInt(NOMBRE_EQUIPO.length);
        return NOMBRE_EQUIPO[num];
    }

    /**
     * Funcion que genera de forma aletoria un fecha entre el rango de años pasados por paramentro.
     * @param rango1 entero que sera un año
     * @param rango2 rango1 entero que sera un año
     * @return devuelve una fecha completa
     */
    public static Fecha fechaAleatoria(int rango1, int rango2){
        Random r = new Random();
        Fecha fecha = new Fecha();
        int dia, anio = 0;
        if (rango1<rango2){
            anio = r.nextInt(rango1,rango2);
        }else if(rango1>rango2){
            anio = r.nextInt(rango2,rango1);
        }
        int mes = r.nextInt(1,12);
        do{
            dia = r.nextInt(1,31);
        }while(!fecha.comprobarDia(dia,mes,anio));
        fecha.setFechaCompleta(dia,mes,anio);
        return fecha;
    }
}