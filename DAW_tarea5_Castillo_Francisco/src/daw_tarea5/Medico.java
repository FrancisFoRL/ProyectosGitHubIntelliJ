package daw_tarea5;

import librerias.Fecha;

import java.time.Year;
import java.util.Arrays;
//todo comprobar todos los breaks en if, ya que si se despide un trabajador, este quedaria null y los siguientes no se mostrarian

public class Medico extends Persona{
    //Atributos
    /**
     * Array de tipo Fecha que guardara todos los dias trabajados de un medico.
     */
    private Fecha[] diasTrabajados;

    /**
     * Atributo de tipo cadena que guardara la especialidad de medico.
     */
    private String especialidad;

    /**
     * Atributo constante de tipo entero que almacena el año actual.
     */
    private final int YEAR = Year.now().getValue();

    //Constructor

    public Medico(String dni, String nombre, String apellido1, String apellido2, String genero, Fecha fechaNacimiento, String especialidad) {
        super(dni, nombre, apellido1, apellido2, genero, fechaNacimiento);
        this.diasTrabajados = new Fecha[5];
        this.especialidad = especialidad;
    }


    //Funciones
    /**
     * Funcion que añade los dias trabajados del medico al array diasTrabajados. Este controla que la fecha sea correcta y que no este repetida en el array.
     * Se comprueba si el array no esta lleno, si esta lleno se aumentara con la funcion aumentarArray.
     * @param trabajo atributo de tipo fecha que contendra la fecha nueva a introducir.
     * @return devuelve true si se añadio correctamente la fecha, en el caso de que haya algun fallo, se devolvera un false.
     */
    public boolean addDiasTrabajados(Fecha trabajo){
        if (!trabajo.comprobarFechaValida(YEAR - 50)) {
            return false;
        } else {
            for (int x = 0; x < diasTrabajados.length; x++) {
                if (diasTrabajados[x] == null) {
                    break;
                } else if (trabajo.getDia() == diasTrabajados[x].getDia() && trabajo.getMes() == diasTrabajados[x].getMes() && trabajo.getAnio() == diasTrabajados[x].getAnio()) {
                    return false;
                }
            }
        }
        aumentarArray();
        for (int x = 0; x < diasTrabajados.length; x++) {
            if (diasTrabajados[x] == null) diasTrabajados[x] = trabajo;
        }
        return true;
    }

    /**
     * Funcion que analiza si el array esta lleno y en el caso de que este lleno, aumenta el espacio del array.
     */
    private void aumentarArray() {
        if (!Arrays.asList(diasTrabajados).contains(null)){//Arrays.asList nos permite buscar en el array el valor que deseemos, en este caso un null
            Fecha[] aux = diasTrabajados;
            diasTrabajados = new Fecha[aux.length * 2];
            diasTrabajados = aux;
        }
    }

    /**
     * Funcion booleana que comprueba que parametros pasado sea como los datos que se encuentran en la funcion.
     * @param especialidad datos de tipo cadena que contiene la especialidad del medico.
     * @return devuelve un true si la especialidad es correcta y false si no lo es.
     */
    private boolean comprobarEspecialidad(String especialidad){
        return especialidad.equalsIgnoreCase("Traumatologia") || especialidad.equalsIgnoreCase("Dermatologia") || especialidad.equalsIgnoreCase("Oftalmologia") ||
                especialidad.equalsIgnoreCase("Alergologia") || especialidad.equalsIgnoreCase("Geriatria") || especialidad.equalsIgnoreCase("Psiquiatria");
    }


    /**
     * Funcion que cuenta el numero de dias trabajados por un medico.
     * @return devuelve el numero de dias que ha trabajado el medico.
     */
    private int contDiasTrabajados(){
        int cont=0;
        for(int x = 0; x < diasTrabajados.length;x++){
            if(diasTrabajados[x] == null)break;
            else{
                cont++;
            }
        }
        return cont;
    }

    /**
     * Funcion implementada de la interfaz Estadisticas. Esta funcion busca los dias trabajados en un mes y devuelve el numero de dias que se trabajo
     * en dicho mes.
     * @param mes atributo de tipo entero que contiene el mes en el que se buscaran los dias trabajados.
     * @return devuelve el numero de dias que se trabajo en el mes pasado por parametros.
     * @see Estadisticas
     */
    @Override
    public int diaporMes(int mes) {
        int cont = 0;
        for (Fecha diaTrabajado : diasTrabajados) {
            if (diaTrabajado == null) {
                break;
            } else {
                if (diaTrabajado.getMes() == mes) {
                    cont++;
                }
            }
        }
        return cont;
    }

    /**
     * Funcion implementada de la interfaz Estadisticas. Esta funcion muestra la informacion de un medico.
     */
    @Override
    public void mostrarEstado() {
        System.out.print("Dni Medico: " + getDni() + " || Nombre: " + getNombre() + " || Apellidos: " + getApellido1() + " " + getApellido2() +
                " || Dias Trabajados: "+ contDiasTrabajados());
    }

    /**
     * Funcion heredada de la clase Persona. Con esta funcion se comprueba que la fecha de nacimiento del medico este dentro del rango.
     * @param fNacimiento atributo de tipo Fecha que contiene la fecha de nacimiento.
     * @return devuelve un true si la fecha esta dentro del rango y un false si esta fuera de este.
     * @see Estadisticas
     */
    @Override
    public boolean validarFechaNacimiento(Fecha fNacimiento) {
        return fNacimiento.getAnio() > YEAR - 70 && fNacimiento.getAnio() < YEAR - 20;
    }

}//Fin Medico
