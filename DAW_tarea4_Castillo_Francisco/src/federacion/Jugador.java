package federacion;

public abstract class Jugador {
    private String nombre, apellido1, apellido2, puesto;
    private Fecha fechaNacimiento;
    private int dorsal, minutosJugados, partidosJugados, partidosGanados, partidosPerdidos;

    abstract boolean validarPuesto(String puesto);

    abstract boolean validarDorsal(int dorsal);

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getPuesto() {
        return puesto;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getDorsal() {
        return dorsal;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    @Override
    public String toString() {
        return "Jugador " + nombre + " " + apellido1 + " " + apellido2 + " (Dorsal " + dorsal + ")";
    }
}
