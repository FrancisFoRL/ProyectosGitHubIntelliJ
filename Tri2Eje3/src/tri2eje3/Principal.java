package tri2eje3;

public class Principal {
    public static void main(String[] args) {

        Dado dado = new Dado();
        int num = dado.lanzar();
        System.out.println(num);

        Moneda moneda = new Moneda();

        if(moneda.lanzar() == 1){
            System.out.println("Cara");
        }else{
            System.out.println("Cruz");
        }
    }
}
