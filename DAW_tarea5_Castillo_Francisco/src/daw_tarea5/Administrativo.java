package daw_tarea5;

import librerias.Fecha;

import java.time.Year;
import java.util.Arrays;

/**
 * Clase de Administrativo que contiene lo necesario para gestionar a un Administrativo.
 * @author Francisco Castillo
 * @see Persona
 * @version 19/04/2022
 */
public class Administrativo extends Persona{

    //Atributos
    /**
     * Array de tipo Fecha que guardara todos los dias trabajados de un Administrativo.
     */
    private Fecha[] diasTrabajados;

    /**
     * Atributo de tipo cadena que guardara la especialidad de Administrativo.
     */
    private String area;

    //Constructores
    public Administrativo(String dni, String nombre, String apellido1, String apellido2, String genero, Fecha fechaNacimiento, String area) {
        super(dni, nombre, apellido1, apellido2, genero, fechaNacimiento);
        this.diasTrabajados = new Fecha[5];
        this.area = area;
    }

    //Getters y Setters
    public void setArea(String area) {
        this.area = area;
    }

    //Funcion
    /**
     * Funcion booleana que añade un dia trabajado nuevo del Administrativo. Comprobara que la fecha no sea menor a la fecha de nacimiento del Administrativo. Si es menor a su fecha de
     * nacimiento devolvera un false.
     * @param trabajo parametro de tipo Fecha que contiene la fecha que se quiere añadir.
     * @return devuelve falso si la fecha pasada por parametro no es valida, si es valida se devolvera true y se añadira al array de diasTrabajados.
     */
    public boolean addDiasTrabajados(Fecha trabajo){
        if (!trabajo.comprobarFechaValida(getFechaNacimiento(),18)) {
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
            if (diasTrabajados[x] == null){
                diasTrabajados[x] = trabajo;
                break;
            }
        }
        return true;
    }

    /**
     * Funcion que aumenta el array de diasTrabajados si esta lleno y lo aumenta al doble de la capacidad que puede tener.
     * En el caso de no usar Arrays.asList, lo que se haria sería un bucle que compruebe todas la posiciones, si encuentra un null saldria del bucle y no aumentaria.
     * En el caso de llegar a la ultima posicion y no encontrar ningun nulo ya se aumentaria el array.
     */
    private void aumentarArray() {
        if (!Arrays.asList(diasTrabajados).contains(null)){//Arrays.asList nos permite buscar en el array el valor que deseemos, en este caso un null
            Fecha[] aux = new Fecha[diasTrabajados.length];
            for(int x=0; x< aux.length;x++){
                aux[x] = diasTrabajados[x];
            }
            diasTrabajados = new Fecha[aux.length * 2];
            for(int x=0; x< aux.length;x++){
                diasTrabajados[x] = aux[x];
            }
        }
    }

    /**
     * Funcion booleana que comprueba que parametros pasado sea como los datos que se encuentran en la funcion.
     * @param especialidad datos de tipo cadena que contiene la especialidad del medico.
     * @return devuelve un true si la especialidad es correcta y false si no lo es.
     */
    public static boolean comprobarEspecialidad(String especialidad){
        return especialidad.equalsIgnoreCase("Urgencias") || especialidad.equalsIgnoreCase("Quirofano") || especialidad.equalsIgnoreCase("Administracion");
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
     * Funcion de tipo booleana que comprueba que la fecha de nacimiento este entre rango que se indica.
     * @param fNacimiento atributo de tipo fecha que contiene la fecha a comprobar.
     * @return devuelve false si la fecha esta fuera de rango devolvera false, si no, devolvera true.
     */
    public static boolean validarFechaNacimiento(Fecha fNacimiento) {
        return fNacimiento.getAnio() >= YEAR - 65 && fNacimiento.getAnio() <= YEAR - 18;
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
            } else {
                if (diaTrabajado.getMes() == mes) {
                    cont++;
                }
            }
        }
        return cont;
    }

    /**
     * Funcion implementada de la interfaz Estadisticas. Esta funcion muestra la informacion de un administrativo.
     * @see Persona
     */
    @Override
    public void mostrarEstado() {
        System.out.print("ID: "+getIdentificador()+ "|| DNI Administrativo: " + getDni() + " || Nombre: " + getNombre() + " || Apellidos: " + getApellido1() + " " + getApellido2() +
                " || Dias Trabajados: "+ contDiasTrabajados());
    }

    @Override
    public String toString() {
        return super.toString()+ " || Area: "+area;
    }
}//Fin Administrativo
