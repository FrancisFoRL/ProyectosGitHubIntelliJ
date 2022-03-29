package daw_tarea5;

import librerias.Fecha;

import java.time.Year;

public class Medico extends Persona{
    private Fecha[] diasTrabajados;
    private String especialidad;
    private final int year = Year.now().getValue();

    //Funciones
    public boolean addDiasTrabajados(Fecha trabajo){
        if(!trabajo.comprobarFechaValida(year-50)){
            return false;
        }
        for(int x=0; x < diasTrabajados.length;x++){
            if(diasTrabajados[x] == null){
                diasTrabajados[x] = trabajo;
            }
        }
        return true;
    }

    private boolean comprobarEspecialidad(String especialidad){
        return especialidad.equalsIgnoreCase("Traumatologia") || especialidad.equalsIgnoreCase("Dermatologia") || especialidad.equalsIgnoreCase("Oftalmologia") ||
                especialidad.equalsIgnoreCase("Alergologia") || especialidad.equalsIgnoreCase("Geriatria") || especialidad.equalsIgnoreCase("Psiquiatria");
    }

    @Override
    public int diaporMes(int mes) {
        return 0;
    }

    @Override
    public void mostrarEstado() {

    }
}//Fin Medico
