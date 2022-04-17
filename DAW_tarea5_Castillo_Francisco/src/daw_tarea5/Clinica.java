package daw_tarea5;

public class Clinica extends Centro {

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
                System.out.print("Consulta " + (x + 1) + " tiene un paciente ||");
                getConsultas()[x].mostrarEstado();
            }
        }
    }
}
