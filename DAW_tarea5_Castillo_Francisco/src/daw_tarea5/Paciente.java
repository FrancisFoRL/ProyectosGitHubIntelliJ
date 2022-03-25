package daw_tarea5;

import librerias.Fecha;

public class Paciente extends Persona {
    private Fecha[] visitasMedicas;

    public Paciente() {
        visitasMedicas = new Fecha[5];
    }

    //Getters y Setters
    public Fecha[] getVisitasMedicas() {
        return visitasMedicas;
    }

    //Funciones
    public boolean addVisita(Fecha visita){

    }

    private String ultimaVisita() {
        for (int x = 0; x < visitasMedicas.length; x++) {
            if (x + 1 == visitasMedicas.length || visitasMedicas[x + 1] == null) {
                return visitasMedicas[x].toString();
            }
        }
        return null;
    }

    @Override
    public int diaporMes(int mes) {
        int cont = 0;
        for (Fecha visitasMedica : visitasMedicas) {
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
        System.out.println("Dni Paciente: " + getDni() + " || Nombre: " + getNombre() + " || Apellidos: " + getApellido1() + " " + getApellido2() +
                " || Ultima visita medica: " + ultimaVisita());
    }


}//Fin Paciente
