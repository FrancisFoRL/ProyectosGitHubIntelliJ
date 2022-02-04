package agricultura;

/**
 * Clase Recolector que hereda atributos y funciones de Recolector y se añaden mas variables de recoleccion de informacion
 * de Recolector_Aceituna.
 */
public class Recolector_Aceituna extends Recolector {
    //Atributos de clase
    /**
     * Atributo de clase que guarda el numero de trabajadores totales creados.
     */
    private static int numTrabajadoresAceituna;

    //Construtores
    public Recolector_Aceituna(String nom, int dni2, double sueldo, boolean eventual, double kilosRecogidos, double precioKilo) {
        super(nom, dni2, sueldo, eventual, kilosRecogidos, precioKilo);
        numTrabajadoresAceituna++;
    }

    //Getters
    public static int getNumTrabajadoresAceituna() {
        return numTrabajadoresAceituna;
    }

    //Funciones

    /**
     * Se llama a la funcion salario de la clase padre Recolector y se hara lo que hace salario mas una suma de 150.
     *
     * @return salario del trabajador Recolector Aceituna
     */
    @Override
    public double salario() {
        return super.salario() + 150;
    }

}
