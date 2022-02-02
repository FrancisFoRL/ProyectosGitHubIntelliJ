package agricultura;

public class Recolector_Aceituna extends Recolector{
    private static int numTrabajadoresAceituna;

    public Recolector_Aceituna(String nom, int dni2, double sueldo, boolean eventual, double kilosRecogidos, double precioKilo) {
        super(nom, dni2, sueldo, eventual, kilosRecogidos, precioKilo);
        numTrabajadoresAceituna++;
    }

    public static int getNumTrabajadoresAceituna() {
        return numTrabajadoresAceituna;
    }

    @Override
    public double salario() {
        return super.salario() + 150;
    }
}
