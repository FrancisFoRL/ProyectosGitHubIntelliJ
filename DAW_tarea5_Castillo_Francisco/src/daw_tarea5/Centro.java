package daw_tarea5;

import java.io.Serializable;

public abstract class Centro implements Estadisticas, Serializable{
    private String nombreCentro, direccionCentro;
    private int limiteConsultas, identificador, contMedicos, contAdministrativos;
    protected static int contID; //todo contmedicos es el numero maximo de medicos o el numero de medicos creados?
    private Paciente[] consultas;
    private Persona[] trabajadores;
    public Centro(String nombreCentro, String direccionCentro, int limiteConsultas) {
        this.nombreCentro = nombreCentro;
        this.direccionCentro = direccionCentro;
        this.consultas = new Paciente[limiteConsultas];//todo limiteconsultas el numero de consultas que tendra?
        this.trabajadores = new Persona[5];
        identificador = contID++;
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

    //Funciones
    //todo si contMedico es para el numero de medicos, hacer funcion booleana que devuelva falta si todos los puestos ya estan ocupados
    private void addTrabajador(Persona trabajador){
        if(trabajador instanceof Medico){
            for (int x = 0; x < trabajadores.length; x++) {
                if (trabajadores[x] == null){
                    trabajadores[x] = trabajador;
                    contMedicos++;
                    break;
                }
            }
        }else if(trabajador instanceof Administrativo){
            for (int x = 0; x < trabajadores.length; x++) {
                if (trabajadores[x] == null){
                    trabajadores[x] = trabajador;
                    contAdministrativos++;
                    break;
                }
            }
        }
    }
    //todo Crear removeEmpleado para eliminarlo de array


}//Fin de Centro
