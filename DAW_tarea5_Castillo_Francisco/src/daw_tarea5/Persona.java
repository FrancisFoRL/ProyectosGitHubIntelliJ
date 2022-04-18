package daw_tarea5;

import librerias.Fecha;

import java.io.*;
import java.time.Year;

public abstract class Persona implements Estadisticas, Serializable {
    private String dni, nombre, apellido1, apellido2, genero;
    protected static int contID;
    private int identificador;
    private Fecha fechaNacimiento;
    protected static final int YEAR = Year.now().getValue();
    protected int lugar = -1;
    protected int posArray = -1;

    //Constructores
    public Persona() {
        identificador = contID++;
    }

    public Persona(String dni, String nombre, String apellido1, String apellido2, String genero, Fecha fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        identificador = contID++;
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

    //todo comprobar que funcione bien
    public static Persona existePers(Centro[] centro, String dni, int tipoPers) {
        if (tipoPers == 0) {
            for (int x = 0; x < Centro.delPaciente.length; x++) {
                if (Centro.delPaciente[x] == null) ;
                else if (Centro.delPaciente[x].getDni().equalsIgnoreCase(dni)) {
                    return Centro.delPaciente[x];
                }
            }

            for (int x = 0; x < centro.length; x++) {
                if (centro[x] == null) ;
                else {
                    if (centro[x] instanceof Hospital) {
                        for (int j = 0; j < ((Hospital) centro[x]).getHabitaciones().length; j++) {
                            for (int y = 0; y < ((Hospital) centro[x]).getHabitaciones()[j].length; y++) {
                                if (((Hospital) centro[x]).getHabitaciones()[j][y] == null) ;
                                else if (((Hospital) centro[x]).getHabitaciones()[j][y].getDni().equalsIgnoreCase(dni)) {
                                    return ((Hospital) centro[x]).getHabitaciones()[j][y];
                                }
                            }
                        }
                    }
                    for (int i = 0; i < centro[x].getConsultas().length; i++) {
                        if (centro[x].getConsultas()[i] == null) ;
                        else if (centro[x].getConsultas()[i].getDni().equalsIgnoreCase(dni)) {
                            return centro[x].getConsultas()[i];
                        }
                    }
                }
            }
        } else if (tipoPers == 1) {
            for (int x = 0; x < Centro.delTrabajadores.length; x++) {
                if (Centro.delTrabajadores[x] == null) ;
                else if (Centro.delTrabajadores[x].getDni().equalsIgnoreCase(dni)) {
                    return Centro.delTrabajadores[x];
                }
            }

            for (int x = 0; x < centro.length; x++) {
                if (centro[x] == null) ;
                else {
                    for (int y = 0; y < centro[x].getTrabajadores().length; y++) {
                        if (centro[x].getTrabajadores()[y] == null) ;
                        else if (centro[x].getTrabajadores()[y].getDni().equalsIgnoreCase(dni)) {
                            return centro[x].getTrabajadores()[y];
                        }
                    }
                }
            }
        }
        return null;
    }


    public static boolean validarGenero(String genero) {
        return genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino") || genero.equalsIgnoreCase("Sin definir");
    }

    @Override
    public String toString() {
        return "ID: "+ identificador+ " || DNI: " + dni + " || Nombre: " + nombre + " || Apellidos: " + apellido1 + " " + apellido2 + " || Fecha de nacimiento: "+fechaNacimiento;
    }
}//Fin Persona
