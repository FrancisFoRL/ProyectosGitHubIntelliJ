package daw_tarea5;

public abstract class Centro implements Estadisticas{
    private String nombreCentro, direccionCentro;
    private int limiteConsultas, identificador;
    protected static int contMedicos, contAdministrativos, contID; //todo contmedicos es el numero maximo de medicos o el numero de medicos creados?
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
                    trabajadores[x].setNombre(trabajador.getNombre());
                    trabajadores[x].setApellido1(trabajador.getApellido1());
                    trabajadores[x].setApellido2(trabajador.getApellido2());
                    trabajadores[x].setDni(trabajador.getDni());
                    trabajadores[x].setFechaNacimiento(trabajador.getFechaNacimiento());
                    trabajadores[x].setGenero(trabajador.getGenero());
                    ((Medico)trabajadores[x]).setEspecialidad(((Medico)trabajador).getEspecialidad());
                    //todo en caso de que contMedico sea para el numero de medicos, añadir incremento de contMedico contMedico++
                    break;
                }
            }
        }else if(trabajador instanceof Administrativo){
            for (int x = 0; x < trabajadores.length; x++) {
                if (trabajadores[x] == null){
                    trabajadores[x].setNombre(trabajador.getNombre());
                    trabajadores[x].setApellido1(trabajador.getApellido1());
                    trabajadores[x].setApellido2(trabajador.getApellido2());
                    trabajadores[x].setDni(trabajador.getDni());
                    trabajadores[x].setFechaNacimiento(trabajador.getFechaNacimiento());
                    trabajadores[x].setGenero(trabajador.getGenero());
                    ((Administrativo)trabajadores[x]).setArea(((Administrativo)trabajador).getArea());
                    //todo en caso de que contAd sea para el numero de medicos, añadir incremento de contAd contAd++
                    break;
                }
            }
        }
    }
    //todo Crear removeEmpleado para eliminarlo de array
}//Fin de Centro
