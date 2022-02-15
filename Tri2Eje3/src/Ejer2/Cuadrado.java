package Ejer2;

public class Cuadrado extends Figura2D{
    private int lados;
    public Cuadrado(String figura, String color, int borde, int lados) {
        super(figura, color, borde);
        this.lados = lados;
    }

    public void setLados(int lados) {
        this.lados = lados;
    }

    public int getLados() {
        return lados;
    }

    @Override
    public int calcularArea() {
        return lados * lados;
    }

    @Override
    public double calcularPerimetro(double longuitud) {
        return Math.pow(longuitud, lados);
    }

    public double calcularDiagonal(double longuitud){
        double diagonal= (Math.pow(longuitud,2)+Math.pow(longuitud,2));
        return (Math.sqrt(diagonal));
    }

}
