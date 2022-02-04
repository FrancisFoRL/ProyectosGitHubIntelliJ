package agricultura;

/**
 * Clase de prueba para usar la diferentes clase creadas anteriormente en el paquete.
 */
public class PruebaHerencia {
    public static void main(String[] args) {
        Trabajador_Agricola tAgricola = new Trabajador_Agricola("Perico Pérez", 12345678, 985.75);
        Recolector tRecolector = new Recolector("Juan Gonzalez", 12345677, 700.75, false, 100, 2.5);
        Recolector t2Recolector = new Recolector("Álfonso Martínez", 87654321, 700.745, true, 200, 2.0);
        Recolector_Aceituna tRecolectorAceituna = new Recolector_Aceituna("María Fernández", 34522345, 800.0, true, 300.0, 3.0);
        Recolector_Aceituna t2RecolectorAceituna = new Recolector_Aceituna("Luisa García", 84522747, 700.0, false, 300.0, 3.25);

        System.out.println(tAgricola);
        System.out.println(tRecolector);
        System.out.println(t2Recolector);
        System.out.println(tRecolectorAceituna);
        System.out.println(t2RecolectorAceituna);

        System.out.println("\nNumero de Trabajadores Agrícolas: " + Trabajador_Agricola.getNum_trabajadores());
        System.out.println("Numero de Recolectores: " + Recolector.getNumTrabajadoresRecolector());
        System.out.println("Numero de Recolectores Aceituna: " + Recolector_Aceituna.getNumTrabajadoresAceituna());
    }
}
