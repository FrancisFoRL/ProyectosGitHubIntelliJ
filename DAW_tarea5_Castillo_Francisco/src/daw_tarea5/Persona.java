package daw_tarea5;

import librerias.Fecha;

public class Persona implements Estadisticas{
    private String dni, nombre, apellido1, apellido2;
    private int indentificador;
    private Fecha fechaNacimiento;

    @Override
    public int diaporMes(int mes) {
        return 0;//Se añadiran calculos
    }
}//Fin Persona
