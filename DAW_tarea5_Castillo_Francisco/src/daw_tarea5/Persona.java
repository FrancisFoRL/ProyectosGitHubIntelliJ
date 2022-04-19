package daw_tarea5;

import librerias.Fecha;

import java.io.*;
import java.time.Year;

/**
 * Clase abstrata Persona que contiene toda la informacion necesaria que hace falta para crear una nueva Persona.
 * @author Francisco Castillo
 * @version 19/04/2022
 */
public abstract class Persona implements Estadisticas, Serializable {

    /**
     * Atributos que contendran los datos principales de una persona.
     */
    private String dni, nombre, apellido1, apellido2, genero;

    /**
     * Atributos que lleva la cuenta de los ID que se asignan a las personas.
     */
    protected static int contID;

    /**
     * Atributo que guarda el ID propio de la persona.
     */
    private int identificador;

    /**
     * Atributo que guarda la fecha de nacimiento de la persona.
     */
    private Fecha fechaNacimiento;

    /**
     * Atributo que devuelve el año actual del sistema.
     */
    protected static final int YEAR = Year.now().getValue();

    /**
     * Atributo que guarda en que lugar (Hospital o Clinica) se encuentra la persona.
     */
    protected int lugar = -1;

    /**
     * Atributo que guarda en que lugar del array se encuentra la persona.
     */
    protected int posArray = -1;

    //Constructores

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

    /**
     * Funcion de tipo Persona que busca un persona en los varios arrays de los centros que se le pasen. Esta funcion es valida tanto para Pacientes como para Personal, ya que con el
     * tipoPers indicamos que tipo de persona estamos buscando. Tambien se comprueba en los arrays de los Pacientes y Personal dados de baja si existe una persona con el Dni igual que
     * el pasado por parametro.
     * @param centro Array de tipo Centro que contiene varios centros, como pueden Hospitales o Clinicas.
     * @param dni cadena que contiene el Dni que se está buscando.
     * @param tipoPers indica que tipo de Persona se está buscando, si es 0 será un Paciente y si es 1 será Personal.
     * @return se devuelve un objeto de tipo Persona si el Dni se encuentra, si no es el caso, se devolvera un null.
     */
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

    /**
     * Funcion que comprueba si la cadena género pasada por parametro es igual que las que son validas.
     * @param genero cadena que contiene de que genero es la persona.
     * @return devuelve true si el parametro pasado es igual que uno de los valores validos, si no, devolvera false.
     */
    public static boolean validarGenero(String genero) {
        return genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino") || genero.equalsIgnoreCase("Sin definir");
    }

    //ToString
    @Override
    public String toString() {
        return "ID: "+ identificador+ " || DNI: " + dni + " || Nombre: " + nombre + " || Apellidos: " + apellido1 + " " + apellido2 + " || Fecha de nacimiento: "+fechaNacimiento;
    }
}//Fin Persona
