package daw_tarea5;

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
    public boolean removePaciente(Paciente enf) {
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

        for (int x = 0; x < habitaciones.length; x++) {
            for (int y = 0; y < habitaciones[x].length; y++) {
                if (habitaciones[x][y] == null) ;
                else {
                    if (habitaciones[x][y].diaporMes(mes) > 0) {
                        cont++;
                        habitaciones[x][y].mostrarEstado();
                    }
                }
            }
        }
        for (int x = 0; x < getConsultas().length; x++) {
            if (getConsultas()[x] == null) ;
            else {
                if (getConsultas()[x].diaporMes(mes) > 0) {
                    cont++;
                    getConsultas()[x].mostrarEstado();
                }
            }
        }
        /*
        }else if(tipo > 0){
            for(int x = 0; x < getTrabajadores().length; x++){
                if(tipo == 1 && getTrabajadores()[x] instanceof Medico){
                    if(getTrabajadores()[x].diaporMes(mes) > 0){
                        cont++;
                        System.out.println(cont+".- "+getTrabajadores()[x].getNombre()+" "+getTrabajadores()[x].getApellido1()+" "+getTrabajadores()[x].getApellido2());
                    }
                }else if(tipo == 2 && getTrabajadores()[x] instanceof Administrativo){
                    if(getTrabajadores()[x].diaporMes(mes) > 0){
                        cont++;
                        System.out.println(cont+".- "+getTrabajadores()[x].getNombre()+" "+getTrabajadores()[x].getApellido1()+" "+getTrabajadores()[x].getApellido2());
                    }
                }
            }
        }

         */
        return cont;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("---------Consultas---------");
        for (int x = 0; x < getConsultas().length; x++) {
            if (getConsultas()[x] == null) {
                System.out.println("Consulta " + (x + 1) + " libre");
            } else {
                System.out.print("Consulta " + (x + 1) + " tiene un paciente || ");
                getConsultas()[x].mostrarEstado();
            }
        }
        System.out.println("---------Plantas Hospital---------");
        for (int x = 0; x < habitaciones.length; x++) {
            for (int y = 0; y < habitaciones[x].length; y++) {
                if (habitaciones[x][y] == null) ;
                else {
                    System.out.print("Planta " + (x + 1) + " / Habitacion " + (y + 1) + " || ");
                    habitaciones[x][y].mostrarEstado();
                }
            }
        }

    }
}//Fin Hospital
