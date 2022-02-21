package federacion;

public class EquipoBaloncesto extends Equipo{

    private JugadorBaloncesto[] jugadorBaloncesto;
    private int anotacionTotal;

    public EquipoBaloncesto(JugadorBaloncesto[] jugadorBaloncesto, int anotacionTotal) {
        this.jugadorBaloncesto = new JugadorBaloncesto[18];
        this.anotacionTotal = 0;
    }

    private JugadorBaloncesto crearJugador(boolean aleatorio){

        JugadorBaloncesto jugadorBaloncesto = new JugadorBaloncesto();
        return jugadorBaloncesto;
    }
}
