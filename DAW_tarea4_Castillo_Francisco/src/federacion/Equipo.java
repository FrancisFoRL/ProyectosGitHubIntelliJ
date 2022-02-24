package federacion;

public class Equipo implements Estadisticas {
    protected int partidosJugados, partidosGanados, partidosPerdidos;
    protected String nombreEquipo;

    public Equipo(){
    }

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        partidosJugados = 0;
        partidosGanados = 0;
        partidosPerdidos = 0;
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

    @Override
    public double porcentajeVictorias() {
        return 0;
    }

    @Override
    public double valoracion() {
        return 0;
    }
}
