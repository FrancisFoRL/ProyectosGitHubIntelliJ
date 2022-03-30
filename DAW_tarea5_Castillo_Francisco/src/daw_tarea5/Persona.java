package daw_tarea5;

import librerias.Fecha;

import java.time.Year;
import java.util.Arrays;

public abstract class Persona implements Estadisticas {
    private String dni, nombre, apellido1, apellido2, genero;
    private static int identificador;
    private Fecha fechaNacimiento;
    private final int year = Year.now().getValue();

    //Constructores
    public Persona(){
        identificador++;
    }

    public Persona(String dni, String nombre, String apellido1, String apellido2, String genero, Fecha fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        identificador++;
    }

    //Getters y Setters
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

    public int getIdentificador() {
        return identificador;
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

    /**
     * Funcion que comprueba los DNI de un array de tipo Persona. Comprueba que el Dni pasado por parametro no este usado ya en el array.
     * @param persona Array donde se comprobaran los array ya asignados.
     * @param dni Dni que se comprobara que no este en el array.
     * @return devuelve true si el DNI no se encuentra en le array y false si ya esta usado por otra persona.
     */
    //todo comprobar funcion comprobar Dni, por tema de cosultas y hospitales
    public boolean comprobarDNI(Persona[] persona, String dni){
        for (Persona persona1 : persona) {
            if(persona1 == null){
                break;
            }else if (persona1.getDni().equals(dni)) {
                return false;
            }
        }
        return false;
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
