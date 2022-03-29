package daw_tarea5;

import librerias.Fecha;

import java.time.Year;

public class Paciente extends Persona {
    private Fecha[] visitasMedicas;
    private final int year = Year.now().getValue();

    public Paciente() {
        visitasMedicas = new Fecha[5];
    }

    //Getters y Setters
    public Fecha[] getVisitasMedicas() {
        return visitasMedicas;
    }

    //Funciones
    public boolean addVisita(Fecha visita){
        if(!visita.comprobarFechaValida(year-50)){
            return false;
        }else{
            for(int x=0; x < visitasMedicas.length; x++){
                if(visitasMedicas[x] == null){
                    break;
                }else if (visita.getDia() == visitasMedicas[x].getDia() && visita.getMes() == visitasMedicas[x].getMes() && visita.getAnio() == visitasMedicas[x].getAnio()){
                    return false;
                }
            }
        }




        for(int x=0; x < visitasMedicas.length;x++){
            if(visitasMedicas[x] == null){
                visitasMedicas[x] = visita;
            }
        }
        return true;
    }
    //Todo Crear funcion para agrandar array visitasMedicas.

    private String ultimaVisita() {
        for (int x = 0; x < visitasMedicas.length; x++) {
            if (x + 1 == visitasMedicas.length || visitasMedicas[x + 1] == null) {
                return visitasMedicas[x].toString();
            }
        }
        return null;
    }

    private void aumentarArray(){
        for(int x=0; x< visitasMedicas.length;x++){

        }
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
