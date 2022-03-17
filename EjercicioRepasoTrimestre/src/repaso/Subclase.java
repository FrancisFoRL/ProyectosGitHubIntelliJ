package repaso;

import java.util.Arrays;

public class Subclase extends Superclase{
    private String[] atributoSub1;
    private static int atributoSub2;
    int atributoSub3;

    public Subclase(){
        atributoSub1 = new String[15];
        atributoSub2 = 0;
        atributoSub3 = 0;
    }

    public String[] getAtributoSub1() {
        return atributoSub1;
    }

    public void setAtributoSub1(String[] atributoSub1) {
        this.atributoSub1 = atributoSub1;
    }

    public static int getAtributoSub2() {
        return atributoSub2;
    }

    public static void setAtributoSub2(int atributoSub2) {
        Subclase.atributoSub2 = atributoSub2;
    }

    private void actualizarParametros(String atributo1, int atributo2, double atributo3, int atributoSub3){
        this.atributo1 = atributo1;
        setAtributo2(atributo2);
        this.atributo3 = atributo3;
        this.atributoSub3 = atributoSub3;
    }
}
