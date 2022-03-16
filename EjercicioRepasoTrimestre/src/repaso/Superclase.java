package repaso;

public class Superclase {
    String atributo1;
    private int atributo2;
    protected double atributo3;//Puedo modificar en el hijo, pero a nivel de instancia
    // de un objeto es como si el atributo fuera privado.

    public Superclase() {
        this.atributo1 = "Atributo de prueba";
        this.atributo2 = 5;
        this.atributo3 = 1.3;
    }

    public Superclase(String atributo1) {
        this.atributo1 = atributo1;
        this.atributo2 = 0;
        this.atributo3 = 0;
    }

    public int getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(int atributo2) {
        this.atributo2 = atributo2;
    }

    private boolean setParametros(String cadena1, int num1, double num2){
        if(num1 > 0 && num2 > 0){
            atributo1 = cadena1;
            atributo2 = num1;
            atributo3 = num2;
            return true;
        }
        return false;
    }
}
