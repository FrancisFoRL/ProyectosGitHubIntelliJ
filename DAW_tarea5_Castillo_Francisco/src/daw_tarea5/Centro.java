package daw_tarea5;

import java.io.*;
import java.util.Arrays;

/**
 * Clase abstrata Centro que contiene toda la informacion necesaria que hace falta para crear una nueva Centro.
 * @author Francisco Castillo
 * @version 19/04/2022
 */
public abstract class Centro implements Estadisticas, Serializable {

    /**
     * Atributos que contendran los datos principales de un Centro.
     */
    private String nombreCentro, direccionCentro;

    /**
     * identificador: Atributo que guarda el ID propio del Centro.
     * Atributos que llevan la cuenta de Medicos y Administrativos creados.
     */
    private int identificador, contMedicos, contAdministrativos;

    /**
     * Atributo que indica en numero de consultas que tendra un centro.
     */
    protected int limiteConsultas;

    /**
     * Atributos que lleva la cuenta de los ID que se asignan a los Centros.
     */
    protected static int contID;

    /**
     * Atributos que lleva la cuenta de los Centros creados.
     */
    protected static int contCentros;

    /**
     * Array donde se guardaran los paciente de consultas
     */
    private Paciente[] consultas;

    /**
     * Array donde se guardaran los trabajadores
     */
    private Persona[] trabajadores;

    /**
     * Array donde se guardaran los trabajadores eliminados
     */
    protected static Persona[] delTrabajadores = new Persona[5];

    /**
     * Array donde se guardaran los pacientes eliminados
     */
    protected static Persona[] delPaciente = new Persona[5];

    //Constructores
    public Centro(String nombreCentro, String direccionCentro, int limiteConsultas) {
        this.nombreCentro = nombreCentro;
        this.direccionCentro = direccionCentro;
        this.consultas = new Paciente[limiteConsultas];
        this.limiteConsultas = limiteConsultas;
        this.trabajadores = new Persona[5];
        identificador = contID++;
        contCentros++;
    }

    //Getters y Setters
    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getDireccionCentro() {
        return direccionCentro;
    }

    public void setDireccionCentro(String direccionCentro) {
        this.direccionCentro = direccionCentro;
    }

    public Paciente[] getConsultas() {
        return consultas;
    }

    public Persona[] getTrabajadores() {
        return trabajadores;
    }

    public int getIdentificador() {
        return identificador;
    }

    //Funciones

    /**
     * Funcion que comprueba si la cadena nombreCentro pasada por parametro no sea igual a ningun nombre de los
     * objetos que se encuentran dentro del array.
     * @param nombreCentro cadena que contiene el nombre del Centro.
     * @param centros array donde se comprobaran los nombres
     * @return devuelve true si el nombre no existe dentro del array, si no, devolvera false.
     */
    protected static boolean validarNombre(String nombreCentro, Centro[] centros){
        for(int x = 0; x < centros.length; x++){
            if(centros[x] == null);
            else if(centros[x].nombreCentro.equalsIgnoreCase(nombreCentro)){
                return false;
            }
        }
        return true;
    }

    /**
     * Funcion que comprueba si la cadena nombreCentro pasada por parametro no sea igual a ningun nombre de los
     * objetos que se encuentran dentro del array.
     * @param nombreDireccion cadena que contiene el nombre de la Direccion.
     * @param centros array donde se comprobaran los nombres
     * @return devuelve true si el nombre no existe dentro del array, si no, devolvera false.
     */
    public static boolean validarDireccion(String nombreDireccion, Centro[] centros){
        for(int x = 0; x < centros.length; x++){
            if(centros[x] == null);
            else if(centros[x].nombreCentro.equalsIgnoreCase(nombreDireccion)){
                return false;
            }
        }
        return true;
    }

    /**
     * Funcion que añade un trabajador al array de trabajadores.
     * @param trabajador objeto de tipo persona que se añadira al array.
     */
    public void addTrabajador(Persona trabajador) {
        trabajadores = aumentarArray(trabajadores);
        for (int x = 0; x < trabajadores.length; x++) {
            if (trabajadores[x] == null) {
                trabajadores[x] = trabajador;
                if (trabajador instanceof Medico) {
                    contMedicos++;
                    trabajador.posArray = x;
                } else if (trabajador instanceof Administrativo) {
                    contAdministrativos++;
                    trabajador.posArray = x;
                }
                break;
            }
        }
    }

    /**
     * Funcion booleana que elimina al trabajdor del array de trabajadores. Si el trabajador esta asignado a algun lugar, su
     * posicion se quedara nula y el objeto de esta persona se añadira al array de delTrabajador y se devolvera true. En caso
     * de que no este asignado se devolvera false, ya que no habra nada que eliminar.
     * @param trabajador Objeto de tipo Persona que se quiere eliminar.
     * @return devolvera true si el trabajador se elimino correctamente, si no, se devolvera un false.
     */
    public boolean removeTrabajador(Persona trabajador) {
        if (trabajador.lugar == -1 && trabajador.posArray == -1) ;
        else if (trabajadores[trabajador.posArray].getDni().equals(trabajador.getDni())) {
            trabajadores[trabajador.posArray] = null;
            trabajador.lugar = -1;
            trabajador.posArray = -1;
            if (trabajador instanceof Medico) {
                contMedicos--;
            } else if (trabajador instanceof Administrativo) {
                contAdministrativos--;
            }
            delTrabajadores = aumentarArray(delTrabajadores);
            for (int x = 0; x < delTrabajadores.length; x++) {
                if (delTrabajadores[x] == null) {
                    delTrabajadores[x] = trabajador;
                    break;
                } else if (delTrabajadores[x].getDni().equalsIgnoreCase(trabajador.getDni())) {
                    delTrabajadores[x] = null;
                    delTrabajadores[x] = trabajador;
                    break;
                }
            }
            return true;
        }
        return false;
    }


    /**
     * Funcion que analiza si el array esta lleno y en el caso de que este lleno, aumenta el espacio del array.
     */
    protected Persona[] aumentarArray(Persona[] array) {
        if (!Arrays.asList(array).contains(null)) {//Arrays.asList nos permite buscar en el array el valor que deseemos, en este caso un null
            Persona[] aux = new Persona[array.length];
            for (int x = 0; x < aux.length; x++) {
                aux[x] = array[x];
            }
            array = new Persona[aux.length * 2];
            for (int x = 0; x < aux.length; x++) {
                array[x] = aux[x];
            }
        }
        return array;
    }
}//Fin de Centro
