package agricultura;

public class Recolector extends Trabajador_Agricola{
    private boolean eventual;
    private double kilosRecogidos;
    private double precioKilo;
    private static int numTrabajadores;

    public Recolector(String nom, int dni2, double sueldo, boolean eventual, double kilosRecogidos, double precioKilo) {
        super(nom, dni2, sueldo);
        this.eventual = eventual;
        this.kilosRecogidos = kilosRecogidos;
        this.precioKilo = precioKilo;
        numTrabajadores++;
    }



    public static int getNumTrabajadoresRecolector() {
        return numTrabajadores;
    }

    @Override
    public double salario() {
        if(!eventual){
            return super.salario() + (kilosRecogidos * precioKilo) + 100;
        }else{
            return super.salario() + (kilosRecogidos * precioKilo);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " || Sueldo= " + salario() + " || Eventual: " + eventual + " || Kilos Recogidos: " + kilosRecogidos + " || Precio Kilo: " + precioKilo;
    }
}
