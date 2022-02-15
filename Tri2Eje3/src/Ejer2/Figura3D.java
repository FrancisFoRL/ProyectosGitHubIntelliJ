package Ejer2;

public abstract class Figura3D extends Figura {

    public Figura3D(String figura, String color, int borde) {
        super(figura, color, borde);
    }

    public abstract double calcularVolumen();
}
