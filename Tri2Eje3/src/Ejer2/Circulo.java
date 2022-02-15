package Ejer2;

public class Circulo extends Figura2D{
    private double radio;
    private final double PI = 3.14;

    public Circulo(String figura, String color, int borde, double radio) {
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
        return PI * Math.pow(radio,2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * PI * radio;
    }
}
