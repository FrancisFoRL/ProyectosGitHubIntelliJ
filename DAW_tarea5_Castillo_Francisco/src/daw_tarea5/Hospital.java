package daw_tarea5;

import librerias.Fecha;

public class Hospital extends Centro{
    private int plantas, habitacionesPorPlanta;
    private Paciente[][] habitaciones;

    //Constructor
    public Hospital(String nombreCentro, String direccionCentro, int limiteConsultas, int plantas, int habitacionesPorPlanta) {
        super(nombreCentro, direccionCentro, limiteConsultas);
        habitaciones = new Paciente[plantas][habitacionesPorPlanta];
    }

    //Getters y Setters
    public Paciente[][] getHabitaciones() {
        return habitaciones;
    }

    //Funciones
    @Override
    public int diaporMes(int mes) {
        int cont = 0;
        for (Fecha visitasMedica : ) {
            if (visitasMedica == null) {
                break;
            } else {
                if (visitasMedica.getMes() == mes) {
                    cont++;
                }
            }
        }
        return cont;
    }

    @Override
    public void mostrarEstado() {

    }
}//Fin Hospital
