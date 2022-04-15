package daw_tarea5;

import java.io.*;

public class Clinica extends Centro{

    //Constructor
    public Clinica(String nombreCentro, String direccionCentro, int limiteConsultas) {
        super(nombreCentro, direccionCentro, limiteConsultas);
    }

    //Funciones
    public boolean addPaciente(Paciente enf, int consulta) {
        if (getConsultas()[consulta - 1] != null) {
            return false;
        } else {
            getConsultas()[consulta - 1] = enf;
            enf.consulta = consulta - 1;
        }
        return true;
    }

    //todo añadir que al eliminar lo guarde en un fichero
    public boolean removePaciente(Paciente enf) {
        if (enf.consulta == -1) ;
        else if (getConsultas()[enf.consulta].getDni().equals(enf.getDni())) {
            getConsultas()[enf.consulta] = null;
            enf.consulta = -1;
            arrayRemovePaciente(enf);
            return true;
        }
        return false;
    }

    //todo si da tiempo hacer funcion de aumentar el array que se guarda en fichero
    private void arrayRemovePaciente(Paciente enf) {
        aumentarArray(delPaciente);
        for (int x = 0; x < delPaciente.length; x++) {
            if (delPaciente[x] == null) {
                delPaciente[x] = enf;
                break;
            } else if (delPaciente[x].getDni().equalsIgnoreCase(enf.getDni())) {
                delPaciente[x] = null;
                delPaciente[x] = enf;
                break;
            }
        }
    }

    @Override
    public int diaporMes(int mes) {
        int cont = 0;
        for (int x = 0; x < getConsultas().length; x++) {
            if (getConsultas()[x] == null);
            else {
                for (int y = 0; y < getConsultas()[x].getVisitasMedicas().length; y++) {
                    if (getConsultas()[x].getVisitasMedicas()[y] == null) break;
                    else {
                        if (getConsultas()[x].getVisitasMedicas()[y].getMes() == mes) {
                            cont++;
                            break;
                        }
                    }
                }
            }
        }
        return cont;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("---------Consultas---------");
        for (int x = 0; x < getConsultas().length; x++) {
            if (getConsultas()[x] == null) {
                System.out.println("Consulta " + (x + 1) + " libre");
            } else {
                System.out.println("Consulta " + (x + 1) + " tiene un paciente ( DNI: " + getConsultas()[x].getDni() + "|| Nombre: "
                        + getConsultas()[x].getNombre() + " || Apellidos: " + getConsultas()[x].getApellido1() + " " + getConsultas()[x].getApellido2());
            }
        }
    }
}
