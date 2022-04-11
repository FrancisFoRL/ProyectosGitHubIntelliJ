package daw_tarea5;

import librerias.Fecha;

import java.io.*;

public class Hospital extends Centro {
    protected int plantas, habitacionesPorPlanta;
    private Paciente[][] habitaciones;

    //Constructor
    public Hospital(String nombreCentro, String direccionCentro, int limiteConsultas, int plantas, int habitacionesPorPlanta) {
        super(nombreCentro, direccionCentro, limiteConsultas);
        habitaciones = new Paciente[plantas][habitacionesPorPlanta];
        this.plantas = plantas;
        this.habitacionesPorPlanta = habitacionesPorPlanta;
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
            enf.consulta = consulta - 1;
        }
        return true;
    }

    public boolean addPaciente(Paciente enf, int planta, int habitacion) {
        if (habitaciones[planta - 1][habitacion - 1] != null) {
            return false;
        } else {
            habitaciones[planta - 1][habitacion - 1] = enf;
            enf.planta = planta - 1;
            enf.habitacion = habitacion - 1;
        }
        return true;
    }

    //todo añadir que al eliminar lo guarde en un fichero
    public boolean removePaciente(Paciente enf) throws IOException, ClassNotFoundException {
        if (enf.planta == -1 && enf.habitacion == -1) ;
        else if (habitaciones[enf.planta][enf.habitacion].getDni().equals(enf.getDni())) {
            habitaciones[enf.planta][enf.habitacion] = null;
            enf.planta = -1;
            enf.habitacion = -1;
            arrayRemovePaciente(enf);
            return true;
        }
        if (enf.consulta == -1) ;
        else if (getConsultas()[enf.consulta].getDni().equals(enf.getDni())) {
            getConsultas()[enf.consulta] = null;
            enf.consulta = -1;
            arrayRemovePaciente(enf);
            return true;
        }
        return false;
    }

    private static void arrayRemovePaciente(Paciente enf) throws IOException, ClassNotFoundException {
        File fichero = new File("pacientes.dat");
        if(fichero.exists()){
            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream("pacientes.dat"));
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("pacientes.dat"));
            Paciente[] aux = (Paciente[]) leerFichero.readObject();
            for(int x = 0; x < aux.length; x++){
                if(aux[x] == null){
                    aux[x] = enf;
                    break;
                }else if(aux[x].getDni().equalsIgnoreCase(enf.getDni())){
                    aux[x] = enf;
                    break;
                }
            }
            escribiendoFichero.writeObject(aux);
            escribiendoFichero.close();
        }else{
            Paciente[] aux = new Paciente[50];
            for(int x = 0; x < aux.length; x++){
                if(aux[x] == null){
                    aux[x] = enf;
                    break;
                }
            }
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("pacientes.dat"));
            escribiendoFichero.writeObject(aux);
            escribiendoFichero.close();
        }
    }

    @Override
    public int diaporMes(int mes) {
        int cont = 0;
        for (int x = 0; x < habitaciones.length; x++) {
            for (int y = 0; y < habitaciones[x].length; y++) {
                if (habitaciones[x][y] == null) ;
                else {
                    for (int i = 0; i < habitaciones[x][y].getVisitasMedicas().length; i++) {
                        if (habitaciones[x][y].getVisitasMedicas()[i] == null) ;
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
                    if (getConsultas()[x].getVisitasMedicas()[y] == null) ;
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
                        + getConsultas()[x].getNombre() + " || Apellidos: " + getConsultas()[x].getApellido1() + " " + getConsultas()[x].getApellido2());
            }
        }
        System.out.println("---------Plantas Hospital---------");
        for (int x = 0; x < habitaciones.length; x++) {
            for (int y = 0; y < habitaciones[x].length; y++) {
                if (habitaciones[x][y] == null) ;
                else {
                    System.out.println("Planta " + (x + 1) + " / Habitacion " + (y + 1) + " || DNI: " + habitaciones[x][y].getDni() + "|| Nombre: "
                            + habitaciones[x][y].getNombre() + " || Apellidos: " + habitaciones[x][y].getApellido1() + " " + habitaciones[x][y].getApellido2());
                }
            }
        }

    }
}//Fin Hospital
