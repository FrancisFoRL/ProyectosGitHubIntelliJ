package Ejer2;

public class Cubo extends Figura3D{
    private double lado;

    public Cubo(String figura, String color, int borde, double lado) {
        super(figura, color, borde);
        this.lado = lado;
    }

    @Override
    public double calcularVolumen() {
        return Math.pow(lado,3);
    }

    @Override
    public double calcularArea() {
        return 6 * Math.pow(lado,2);
    }
}
