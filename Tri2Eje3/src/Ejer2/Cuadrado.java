package Ejer2;

public class Cuadrado extends Figura2D{
    private double lado;

    public Cuadrado(String figura, String color, int borde, double lado) {
        super(figura, color, borde);
        this.lado = lado;
    }

    public void setLados(int lados) {
        this.lado = lado;
    }

    public double getLados() {
        return lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return Math.pow(lado, 4);
    }

    public double calcularDiagonal(){
        return lado * (Math.sqrt(2));
    }

}
