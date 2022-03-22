package daw_tarea5;

import librerias.Fecha;

public class Centro implements Estadisticas{
    private String nombreCentro, direccionCentro;
    private int identificador, limiteConsultas, contMedicos, contAdministrativos;
    private Paciente[] consultas;
    private Persona[] trabajadores;



    //Funciones

    @Override
    public int diaporMes(int mes) {
        return 0;//Se añadiran calculos
    }//Fin diaPorMes
}//Fin de Centro
