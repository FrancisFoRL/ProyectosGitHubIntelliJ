package daw_tarea5;

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
    private boolean removePaciente(Paciente enf) {
        for (int x = 0; x < getConsultas().length; x++) {
            if (getConsultas()[x].getDni().equals(enf.getDni())) {
                //todo hacer para que el paciente se pase fichero antes de eliminar
                getConsultas()[x] = null;
                return true;
            }
        }
        return false;
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
