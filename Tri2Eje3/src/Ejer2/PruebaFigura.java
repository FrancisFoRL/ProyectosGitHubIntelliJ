package Ejer2;

import javax.management.MBeanRegistration;
import java.util.Scanner;

public class PruebaFigura {

    public static void main(String[] args){

        Cuadrado cuadrado = new Cuadrado("Cuadrado","Verde",2,5);
        Circulo circulo = new Circulo("Circulo","Rosa",1,4);
        Triangulo triangulo = new Triangulo("Triangulo", " Marron", 2, 5,5,5,3);
        Cubo cubo = new Cubo("Cubo", "Naranja", 2, 1);
        Esfera esfera = new Esfera("Esfera","Rojo",2,2.5);

        System.out.println("Figura: "+cuadrado.getFigura()+"\nColor: "+cuadrado.getColor()+"\nLonguitud lados: "+cuadrado.getLados());
        System.out.println("Area: "+cuadrado.calcularArea()+"\nPerimetro: "+cuadrado.calcularPerimetro()+"\nDiagonal: "+cuadrado.calcularDiagonal());

        System.out.println("\nFigura: "+esfera.getFigura()+"\nColor: "+esfera.getColor()+"\nLonguitud radio: "+esfera.getRadio());
        System.out.println("Area: "+esfera.calcularArea()+"\nVolumen: "+cuadrado.calcularPerimetro()+"\n");

        Figura[] array = {cuadrado, circulo, triangulo, cubo, esfera};

        for(Figura elemento : array){
            System.out.println("Area de "+elemento.getFigura()+": "+areaFigura(elemento));
        }
    }

    public static double areaFigura (Figura area){
        return area.calcularArea();
    }

    public static Figura crearFigura(){
        Esfera esfera = new Esfera("Esfera","Rojo",2,2.5);
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("¿De que tipo sera el objeto?");
        System.out.println("1.Circulo");
        System.out.println("2.Cuadrado");
        System.out.println("3.Triangulo");
        System.out.println("4.Esfera");
        System.out.println("5.Cubo");
        opcion = sc.nextInt();

        switch (opcion){
            case 1:
                break;
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;
        }

        return esfera;
    }


}
