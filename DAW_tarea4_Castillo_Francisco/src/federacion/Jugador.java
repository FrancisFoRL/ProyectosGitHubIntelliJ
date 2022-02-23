package federacion;

import java.time.Year;

public abstract class Jugador {
    protected String nombre, apellido1, apellido2, puesto;
    protected Fecha fechaNacimiento;
    protected int dorsal, minutosJugados, partidosJugados, partidosGanados, partidosPerdidos;
    private int year = Year.now().getValue();
    public Jugador() {
    }

    public Jugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal, int minutosJugados, int partidosJugados, int partidosGanados, int partidosPerdidos) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.puesto = puesto;
        this.fechaNacimiento = fechaNacimiento;
        this.dorsal = dorsal;
        this.minutosJugados = minutosJugados;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
    }


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
        if ((fechaNacimiento.getAnio() <= year - 8) && (fechaNacimiento.getAnio() >= year - 65)) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            this.fechaNacimiento.setFechaCompleta(1, 1, 1);
        }
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
