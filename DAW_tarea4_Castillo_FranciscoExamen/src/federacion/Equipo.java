package federacion;

/**
 * Clase Equipo que contiene toda la informacion necesaria que hace falta para crear un
 * nuevo equipo.
 * @author Francisco Castillo
 * @version 28/01/2022
 */
public abstract class Equipo implements Estadisticas {
    //Atributos
    /**
     * Los atributos que son protected, se han elegido asi para que en las subclases sean
     * visibles y puedan usarse.
     */
    protected int partidosJugados, partidosGanados, partidosPerdidos;
    protected String nombreEquipo;

    //Atributo de clase
    protected static int totalEquipos;

    //Constructores
    public Equipo(){
        totalEquipos++;
    }

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        partidosJugados = 0;
        partidosGanados = 0;
        partidosPerdidos = 0;
        totalEquipos++;
    }

    //Setters y Getters
    public static int getTotalEquipos() {
        return totalEquipos;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    //Funciones
    @Override
    public double porcentajeVictorias() {
        return 0;
    }

    @Override
    public double valoracion() {
        return 0;
    }

    @Override
    public int posicion() {
        return 0;
    }
}
