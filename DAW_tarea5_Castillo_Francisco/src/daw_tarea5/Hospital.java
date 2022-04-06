package daw_tarea5;

import librerias.Fecha;

public class Hospital extends Centro {
    protected int plantas, habitacionesPorPlanta;
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
    public boolean addPaciente(Paciente enf, int consulta) {
        if (getConsultas()[consulta - 1] != null) {
            return false;
        } else {
            getConsultas()[consulta - 1] = enf;
            /*
            getConsultas()[consulta - 1].setDni(enf.getDni());
            getConsultas()[consulta - 1].setNombre(enf.getNombre());
            getConsultas()[consulta - 1].setApellido1(enf.getApellido1());
            getConsultas()[consulta - 1].setApellido2(enf.getApellido2());
            getConsultas()[consulta - 1].setFechaNacimiento(enf.getFechaNacimiento());
            getConsultas()[consulta - 1].setGenero(enf.getGenero());

             */
        }
        return true;
    }

    public boolean addPaciente(Paciente enf, int planta, int habitacion) {
        if (habitaciones[planta - 1][habitacion - 1] != null) {
            return false;
        } else {
            habitaciones[planta - 1][habitacion - 1].setDni(enf.getDni());
            habitaciones[planta - 1][habitacion - 1].setNombre(enf.getNombre());
            habitaciones[planta - 1][habitacion - 1].setApellido1(enf.getApellido1());
            habitaciones[planta - 1][habitacion - 1].setApellido2(enf.getApellido2());
            habitaciones[planta - 1][habitacion - 1].setFechaNacimiento(enf.getFechaNacimiento());
            habitaciones[planta - 1][habitacion - 1].setGenero(enf.getGenero());
        }
        return true;
    }

    //todo añadir que al eliminar lo guarde en un fichero
    private boolean removePaciente(Paciente enf) {
        for (int x = 0; x < habitaciones.length; x++) {
            for (int y = 0; y < habitaciones[x].length; y++) {
                if (habitaciones[x][y].getDni().equals(enf.getDni())) {
                    //Todo añadir que se guarde en el fichero el paciente eliminado
                    habitaciones[x][y] = null;
                    return true;
                }
            }
        }
        for (int x = 0; x < getConsultas().length; x++) {
                if (getConsultas()[x].getDni().equals(enf.getDni())) {
                    //Todo añadir que se guarde en el fichero el paciente eliminado
                    getConsultas()[x] = null;
                    return true;
                }
        }
        return false;
    }

    @Override
    public int diaporMes(int mes) {
        int cont = 0;
        for (int x = 0; x < habitaciones.length; x++) {
            for (int y = 0; y < habitaciones[x].length; y++) {
                if (habitaciones[x][y] == null) ;
                else {
                    for (int i = 0; i < habitaciones[x][y].getVisitasMedicas().length; i++) {
                        if (habitaciones[x][y].getVisitasMedicas()[i] == null) break;
                        else {
                            if (habitaciones[x][y].getVisitasMedicas()[i].getMes() == mes) {
                                cont++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (int x = 0; x < getConsultas().length; x++) {
            if (getConsultas()[x] == null) ;
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
                System.out.println("Consulta " + (x + 1) + " tiene un paciente // DNI: " + getConsultas()[x].getDni() + "|| Nombre: "
                        + getConsultas()[x].getNombre() + " || Apellidos: " + getConsultas()[x].getApellido1() + " " + getConsultas()[x].getApellido2()) ;
            }
        }
        System.out.println("---------Plantas Hospital---------");
        for (int x = 0; x < habitaciones.length; x++) {
            for (int y = 0; y < habitaciones[x].length; y++) {
                if (habitaciones[x][y] == null) break;
                else {
                    System.out.println("Planta " + (x + 1) + " /Habitacion " + (y + 1) + "|| DNI: " + habitaciones[x][y].getDni() + "|| Nombre: "
                            + habitaciones[x][y].getNombre() + " || Apellidos: " + habitaciones[x][y].getApellido1() + " " + habitaciones[x][y].getApellido2());
                }
            }
        }

    }
}//Fin Hospital
