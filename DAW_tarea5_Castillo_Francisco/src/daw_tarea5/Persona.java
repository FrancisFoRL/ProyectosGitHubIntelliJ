package daw_tarea5;

import librerias.Fecha;

import java.time.Year;

public abstract class Persona implements Estadisticas {
    private String dni, nombre, apellido1, apellido2, genero;
    private int indentificador;
    private Fecha fechaNacimiento;
    private final int year = Year.now().getValue();

    public Persona(){
        //todo Comprobar si en el futuro hace falta definir valores a los atributos de constructor.
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIndentificador() {
        return indentificador;
    }

    public void setIndentificador(int indentificador) {
        this.indentificador = indentificador;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean validarFechaNacimiento(Fecha fNacimiento){
        return fNacimiento.getAnio() < year - 120;
    }

    public boolean validarGenero(String genero){
        return genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino") || genero.equalsIgnoreCase("Sin definir");
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                '}';
    }
}//Fin Persona
