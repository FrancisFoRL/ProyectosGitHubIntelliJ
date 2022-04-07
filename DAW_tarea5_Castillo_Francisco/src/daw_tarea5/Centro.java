package daw_tarea5;

import java.io.Serializable;

public abstract class Centro implements Estadisticas, Serializable {
    private String nombreCentro, direccionCentro;
    private int identificador, contMedicos, contAdministrativos;
    protected int limiteConsultas;
    protected static int contID; //todo contmedicos es el numero maximo de medicos o el numero de medicos creados?
    protected static int contCentros;
    private Paciente[] consultas;
    private Persona[] trabajadores;

    public Centro(String nombreCentro, String direccionCentro, int limiteConsultas) {
        this.nombreCentro = nombreCentro;
        this.direccionCentro = direccionCentro;
        this.consultas = new Paciente[limiteConsultas];//todo limiteconsultas el numero de consultas que tendra?
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
    //todo si contMedico es para el numero de medicos, hacer funcion booleana que devuelva falta si todos los puestos ya estan ocupados
    public void addTrabajador(Persona trabajador) {
        for (int x = 0; x < trabajadores.length; x++) {
            if (trabajadores[x] == null) {
                trabajadores[x] = trabajador;
                if (trabajador instanceof Medico) {
                    contMedicos++;
                } else if (trabajador instanceof Administrativo) {
                    contAdministrativos++;
                }
                break;
            }
        }
    }

    //todo Crear removeEmpleado para eliminarlo de array
    public void removeTrabajador(String dni) {
        for (int x = 0; x < trabajadores.length; x++) {
            if (trabajadores[x].getDni().equals(dni)) {
                //todo añadir lo de guardar en el fichero antes de eliminar
                trabajadores[x] = null;
                if (trabajadores[x] instanceof Medico) {
                    contMedicos--;
                } else if (trabajadores[x] instanceof Administrativo) {
                    contAdministrativos--;
                }
            }
        }
    }

    public static Centro existeCentro(Centro[] centros, String nombre){
        for(int x = 0; x < centros.length; x++){
            if(centros[x] == null);
            else if(centros[x].getNombreCentro().equalsIgnoreCase(nombre)){
                return centros[x];
            }
        }
        return null;
    }


}//Fin de Centro
