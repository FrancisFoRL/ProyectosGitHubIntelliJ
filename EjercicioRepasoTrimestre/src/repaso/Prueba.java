package repaso;

public class Prueba {
    public static void main(String[] args){
        int insSubclase = Subclase.getAtributoSub2();
        Subclase insSubclase2 = new Subclase();
        Superclase insSuperClase = new Superclase("Prueba de programa SubClase");

        insSuperClase.setAtributo2(40);
        insSuperClase.atributo3 = 5.3;

        insSubclase2.atributo1 = "Prueba de programa SuperClase";
        insSubclase2.setAtributo2(30);
        insSubclase2.atributo3 = 4.2;

        for(int i = 0; i < insSubclase2.getAtributoSub1().length; i++){
            insSubclase2.getAtributoSub1()[i] = "Ejemplo";
        }
        Subclase.setAtributoSub2(5);
        insSubclase2.atributoSub3 = 10;

        System.out.println(insSubclase);
        System.out.println(insSubclase2);
        System.out.println(insSuperClase);
    }
}
