package Ejer2;

import libreria.PeticionDatos;

import javax.management.MBeanRegistration;
import java.util.Scanner;

public class PruebaFigura {

    private static String nomFigura;
    private static String colorFigura;
    private static int numBorde;
    private static double numLadoRadio, lado1, lado2, base, altura;

    public static void main(String[] args) {
        int cont = 0;
        Cuadrado cuadrado = new Cuadrado("Cuadrado", "Verde", 2, 5);
        Circulo circulo = new Circulo("Circulo", "Rosa", 1, 4);
        Triangulo triangulo = new Triangulo("Triangulo", " Marron", 2, 5, 5, 5, 3);
        Cubo cubo = new Cubo("Cubo", "Naranja", 2, 1);
        Esfera esfera = new Esfera("Esfera", "Rojo", 2, 2.5);

        System.out.println("Figura: " + cuadrado.getFigura() + "\nColor: " + cuadrado.getColor() + "\nLonguitud lados: " + cuadrado.getLados());
        System.out.println("Area: " + cuadrado.calcularArea() + "\nPerimetro: " + cuadrado.calcularPerimetro() + "\nDiagonal: " + cuadrado.calcularDiagonal());

        System.out.println("\nFigura: " + esfera.getFigura() + "\nColor: " + esfera.getColor() + "\nLonguitud radio: " + esfera.getRadio());
        System.out.println("Area: " + esfera.calcularArea() + "\nVolumen: " + cuadrado.calcularPerimetro() + "\n");

        Figura[] array = {cuadrado, circulo, triangulo, cubo, esfera};

        for (Figura elemento : array) {
            System.out.println("Area de " + elemento.getFigura() + ": " + areaFigura(elemento));
        }

        Figura[] array2 = new Figura[3];

        do {
            array2[cont] = crearFigura();
            System.out.println(array2[cont]);
            cont++;
        } while (cont != 2);
    }

    public static double areaFigura(Figura area) {
        return area.calcularArea();
    }

    public static Figura crearFigura() {
        int opcion;
        System.out.println("\n¿De que tipo sera el objeto?");
        System.out.println("1.Cuadrado");
        System.out.println("2.Circulo");
        System.out.println("3.Triangulo");
        System.out.println("4.Esfera");
        System.out.println("5.Cubo");
        opcion = PeticionDatos.pedirEnteroRango(1,5,3,"\nDame una opcion(1-5): ");

        switch (opcion) {
            case 1:
                nomFigura = PeticionDatos.pedirCadena("\nNombre figura: ");
                colorFigura = PeticionDatos.pedirCadena("Color figura: ");
                numBorde = PeticionDatos.pedirEntero("Grosor borde: ");
                numLadoRadio = PeticionDatos.pedirDecimal("Longuitud lado: ");
                return new Cuadrado(nomFigura, colorFigura, numBorde, numLadoRadio);
            case 2:
                nomFigura = PeticionDatos.pedirCadena("\nNombre figura: ");
                colorFigura = PeticionDatos.pedirCadena("Color figura: ");
                numBorde = PeticionDatos.pedirEntero("Grosor borde: ");
                numLadoRadio = PeticionDatos.pedirDecimal("Longuitud radio: ");
                return new Circulo(nomFigura, colorFigura, numBorde, numLadoRadio);
            case 3:
                nomFigura = PeticionDatos.pedirCadena("\nNombre figura: ");
                colorFigura = PeticionDatos.pedirCadena("Color figura: ");
                numBorde = PeticionDatos.pedirEntero("Grosor borde: ");
                lado1 = PeticionDatos.pedirDecimal("Longuitud lado 1: ");
                lado2 = PeticionDatos.pedirDecimal("Longuitud lado 2: ");
                base = PeticionDatos.pedirDecimal("Longuitud base: ");
                altura = PeticionDatos.pedirDecimal("Altura : ");
                return new Triangulo(nomFigura, colorFigura, numBorde, lado1, lado2, base, altura);
            case 4:
                nomFigura = PeticionDatos.pedirCadena("\nNombre figura: ");
                colorFigura = PeticionDatos.pedirCadena("Color figura: ");
                numBorde = PeticionDatos.pedirEntero("Grosor borde: ");
                numLadoRadio = PeticionDatos.pedirDecimal("Longuitud lado: ");
                return new Cubo(nomFigura, colorFigura, numBorde, numLadoRadio);

            case 5:
                nomFigura = PeticionDatos.pedirCadena("\nNombre figura: ");
                colorFigura = PeticionDatos.pedirCadena("Color figura: ");
                numBorde = PeticionDatos.pedirEntero("Grosor borde: ");
                numLadoRadio = PeticionDatos.pedirDecimal("Longuitud radio: ");
                return new Esfera(nomFigura, colorFigura, numBorde, numLadoRadio);
        }
        return null;
    }


}
