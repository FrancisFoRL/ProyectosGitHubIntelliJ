package daw_tarea5;

import librerias.Fecha;

import java.util.Arrays;

public class Paciente extends Persona {
    private Fecha[] visitasMedicas;
    //Atributos que indican donde esta el paciente;
    protected int planta=-1, habitacion=-1, consulta=-1;

    public Paciente(String dni, String nombre, String apellido1, String apellido2, String genero, Fecha fechaNacimiento) {
        super(dni, nombre, apellido1, apellido2, genero, fechaNacimiento);
        this.visitasMedicas = new Fecha[5];
    }

    //Getters y Setters
    public Fecha[] getVisitasMedicas() {
        return visitasMedicas;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public int getConsulta() {
        return consulta;
    }

    public void setConsulta(int consulta) {
        this.consulta = consulta;
    }

    //Funciones
    //todo comprobar que la fecha no sea antes de que la paciente naciera y que la fecha no sea mayor a la actual
    public boolean addVisita(Fecha visita) {
        if (!visita.comprobarFechaValida(getFechaNacimiento(),0)) {
            return false;
        } else {
            for (int x = 0; x < visitasMedicas.length; x++) {
                if (visitasMedicas[x] == null) {
                    break;
                } else if (visita.getDia() == visitasMedicas[x].getDia() && visita.getMes() == visitasMedicas[x].getMes() && visita.getAnio() == visitasMedicas[x].getAnio()) {
                    return false;
                }
            }
        }
        aumentarArray();
        for (int x = 0; x < visitasMedicas.length; x++) {
            if (visitasMedicas[x] == null){
                visitasMedicas[x] = visita;
                break;
            }
        }
        return true;
    }
    //Todo Crear funcion para agrandar array visitasMedicas.

    private String ultimaVisita() {
        Fecha fecha = new Fecha(0,0,0);
        for (Fecha visitasMedica : visitasMedicas) {
            if (visitasMedica == null);
            else if (visitasMedica.getAnio() > fecha.getAnio()) {
                fecha.setFechaCompleta(visitasMedica.getDia(), visitasMedica.getMes(), visitasMedica.getAnio());
            } else if (visitasMedica.getAnio() == fecha.getAnio()) {
                if (visitasMedica.getMes() > fecha.getMes()) {
                    fecha.setFechaCompleta(visitasMedica.getDia(), visitasMedica.getMes(), visitasMedica.getAnio());
                } else if (visitasMedica.getMes() == fecha.getMes()) {
                    if (visitasMedica.getDia() > fecha.getDia())
                        fecha.setFechaCompleta(visitasMedica.getDia(), visitasMedica.getMes(), visitasMedica.getAnio());
                }
            }
        }
        return fecha.toString();
    }
//todo en caso de que no aumente seria devolver el array
    private void aumentarArray() {
        if (!Arrays.asList(visitasMedicas).contains(null)){
            Fecha[] aux = new Fecha[visitasMedicas.length];
            for(int x=0; x< aux.length;x++){
                aux[x] = visitasMedicas[x];
            }
            visitasMedicas = new Fecha[aux.length * 2];
            for(int x=0; x< aux.length;x++){
                visitasMedicas[x] = aux[x];
            }
        }
    }

    public static boolean validarFechaNacimiento(Fecha fNacimiento) {
        return fNacimiento.getAnio() >= YEAR - 120 && fNacimiento.getAnio() <= YEAR;
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
