package Ejer2;

public abstract class Figura {
    private String figura;
    private String color;
    private int borde;

    public Figura(String figura, String color, int borde){
        this.figura = figura;
        this.color = color;
        this.borde = borde;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBorde(int borde) {
        this.borde = borde;
    }

    public String getColor() {
        return color;
    }

    public double getBorde() {
        return borde;
    }

    public String getFigura() {
        return figura;
    }

    public int calcularArea() {
        return borde;
    }
}
