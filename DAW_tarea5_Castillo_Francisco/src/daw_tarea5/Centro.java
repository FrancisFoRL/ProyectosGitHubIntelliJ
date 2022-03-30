package daw_tarea5;

public abstract class Centro implements Estadisticas{
    private String nombreCentro, direccionCentro;
    private int identificador;
    private int limiteConsultas, contMedicos, contAdministrativos;
    private Paciente[] consultas;
    private Persona[] trabajadores;

    public Centro(String nombreCentro, String direccionCentro, int limiteConsultas) {
        this.nombreCentro = nombreCentro;
        this.direccionCentro = direccionCentro;
        this.limiteConsultas = limiteConsultas;
        this.consultas = new Paciente[5];
        this.trabajadores = new Persona[5];
    }
}//Fin de Centro
