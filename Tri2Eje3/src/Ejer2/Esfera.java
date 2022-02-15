package Ejer2;

public class Esfera extends Figura3D{
    private double radio;
    private final double PI = 3.14;

    public Esfera(String figura, String color, int borde, double radio) {
        super(figura, color, borde);
        this.radio = radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public double getPI() {
        return PI;
    }

    @Override
    public double calcularArea() {
        return 4 * PI * Math.pow(radio,2);
    }

    @Override
    public double calcularVolumen() {
        return (4 * PI * Math.pow(radio,3))/3;
    }
}
