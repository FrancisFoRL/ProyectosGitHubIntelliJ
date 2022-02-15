package Ejer2;

public class Triangulo extends Figura2D{
    private double lado1, lado2, base, altura;

    public Triangulo(String figura, String color, int borde, double lado1, double lado2, double base, double altura) {
        super(figura, color, borde);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.base = base;
        this.altura = altura;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura)/2;
    }

    @Override
    public double calcularPerimetro() {
        String figura= getFigura().toUpperCase();
        if(figura.equals("EQUILATERO")) {
            return 3 * lado1;
        }else if(figura.equals("ISOSCELES")){
            return 2*lado1+base;
        }else{
            return lado1+lado2+base;
        }
    }
}
