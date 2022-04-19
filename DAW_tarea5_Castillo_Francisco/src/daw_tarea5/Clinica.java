package daw_tarea5;

/**
 * Clase de Clinica que contiene lo necesario para gestiona una Clinica.
 * @author Francisco Castillo
 * @see Centro
 * @version 19/04/2022
 */
public class Clinica extends Centro {

    //Constructor
    public Clinica(String nombreCentro, String direccionCentro, int limiteConsultas) {
        super(nombreCentro, direccionCentro, limiteConsultas);
    }

    //Funciones

    /**
     * Funcion booleana que añade un paciente a un consulta si es posible, en el caso de que no sea posible,
     * se devolvera un false.
     * @param enf Objeto de tipo paciente que se añadira a una consulta.
     * @param consulta numero de consulta a la que se quiere añadir el paciente.
     * @return devuelve false si el numero de consulta pasado por parametro esta ocupado, si no, devolvera
     * true.
     */
    public boolean addPaciente(Paciente enf, int consulta) {
        if (getConsultas()[consulta - 1] != null) {
            return false;
        } else {
            getConsultas()[consulta - 1] = enf;
            enf.consulta = consulta - 1;
        }
        return true;
    }

    /**
     * Funcion booleana que elimina al paciente de la clinica. Si el paciente esta asignado a algun lugar de la clinica, su
     * posicion se quedara nula y el objeto de esta persona se añadira al array de delPaciente y se devolvera true. En caso
     * de que no este asignado se devolvera false, ya que no habra nada que eliminar.
     * @param enf Objeto de tipo Paciente que se quiere eliminar.
     * @return devolvera true si el paciente se elimino correctamente, si no, se devolvera un false.
     */
    public boolean removePaciente(Paciente enf) {
        if (enf.consulta == -1) ;
        else if (getConsultas()[enf.consulta].getDni().equals(enf.getDni())) {
            getConsultas()[enf.consulta] = null;
            enf.lugar = -1;
            enf.consulta = -1;
            arrayRemovePaciente(enf);
            return true;
        }
        return false;
    }

    /**
     * Funcion que busca una posicion vacia para guarda el objeto pasado por parametro. Si ya existe en el
     * array, se sobreescribira.
     * @param enf Objeto de tipo Paciente que se guardara.
     */
    private void arrayRemovePaciente(Paciente enf) {
        delPaciente = aumentarArray(delPaciente);
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

    /**
     * Funcion implementada de la interfaz Estadisticas. Esta funcion busca los dias de visita medica en un mes y devuelve el numero de dias que se hizo una visita medica
     * en dicho mes.
     * @param mes atributo de tipo entero que contiene el mes en el que se buscaran los dias de visitas medicas.
     * @return devuelve el numero de dias que se visito en el mes pasado por parametros.
     * @see Estadisticas
     */
    @Override
    public int diaporMes(int mes) {
        int cont = 0;
        for (int x = 0; x < getConsultas().length; x++) {
            if (getConsultas()[x] == null) ;
            else {
                if (getConsultas()[x].diaporMes(mes) > 0) {
                    cont++;
                }
            }
        }
        return cont;
    }

    /**
     * Funcion implementada de la interfaz Estadisticas. Esta funcion muestra la informacion de una Clinica.
     * @see Persona
     */
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
