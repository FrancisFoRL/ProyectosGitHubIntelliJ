package federacion;

import java.time.Year;

/**
 * Clase abstrata Jugador que contiene toda la informacion necesaria que hace falta para crear un
 * nuevo jugador.
 * @author Francisco Castillo
 * @version 28/01/2022
 */
public abstract class Jugador implements Estadisticas {
    //Atributos
    /**
     * Los atributos que son protected, se han elegido asi para que en las subclases sean
     * visibles y puedan usarse.
     */
    protected String nombre, apellido1, apellido2, puesto;
    protected Fecha fechaNacimiento;
    protected int dorsal, minutosJugados, partidosJugados, partidosGanados, partidosPerdidos;
    private int year = Year.now().getValue();// Atributo que importa Year, este nos da la fecha actual del sistema.

    //Constructores
    public Jugador() {
        this.minutosJugados = 0;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
    }

    public Jugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.puesto = puesto;
        this.fechaNacimiento = fechaNacimiento;
        this.dorsal = dorsal;
        this.minutosJugados = 0;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
    }

    //Setters y Getters
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

    public void setFechaNacimiento(Fecha fechaNacimiento){
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

    //Funciones
    abstract boolean validarPuesto(String puesto);

    abstract boolean validarDorsal(int dorsal);

    //toString
    @Override
    public String toString() {
        return "- " + nombre + " " + apellido1 + " " + apellido2 +
                " ( Puesto: " + puesto + " || Fecha de Nacimiento: " + fechaNacimiento +
                " || Dorsal: " + dorsal + " )";
    }
}
