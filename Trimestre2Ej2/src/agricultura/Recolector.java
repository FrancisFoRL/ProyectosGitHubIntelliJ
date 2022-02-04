package agricultura;

import java.util.Scanner;

/**
 * Clase Recolector que hereda atributos y funciones de Trabajor Agricula y se añaden mas variables de recoleccion de informacion
 * de Recolector.
 */

public class Recolector extends Trabajador_Agricola{

    //Atributos de instancia
    /**
     * Atributo booleano que guarda si el trabajador es eventual o no.
     */
    private boolean eventual;

    /**
     * Atributo de tipo double que guarda cuantos kilos a recogido el trabajador.
     */
    private double kilosRecogidos;

    /**
     * Atributo de tipo double que guarda el precio del Kilo.
     */
    private double precioKilo;

    //Atributos de clase
    /**
     * Atributo de clase que guarda el numero de trabajadores totales creados.
     */
    private static int numTrabajadores;

    //Constructor
    public Recolector(String nom, int dni2, double sueldo, boolean eventual, double kilosRecogidos, double precioKilo) {
        super(nom, dni2, sueldo);
        this.eventual = eventual;
        this.kilosRecogidos = kilosRecogidos;
        this.precioKilo = precioKilo;
        numTrabajadores++;
    }

    //Getters
    public static int getNumTrabajadoresRecolector() {
        return numTrabajadores;
    }

    //Funciones

    /**
     * Funcion de la clase padre que se va a sobreescribir para que en el caso de que el trabajor sea eventual se le aplique un
     * calculo y en el caso de que no se le aplique otro.
     * @return El salario del trabajador eventual o el del no eventual.
     */
    @Override
    public double salario() {
        if(!eventual){
            return super.salario() + (kilosRecogidos * precioKilo) + 100;
        }else{
            return super.salario() + (kilosRecogidos * precioKilo);
        }
    }

    /**
     * Se le añade a la funcion toString padre mas atributos que mostrar.
     */
    @Override
    public String toString() {
        return super.toString() + " || Sueldo= " + salario() + " || Eventual: " + eventual + " || Kilos Recogidos: " + kilosRecogidos + " || Precio Kilo: " + precioKilo;
    }
}
