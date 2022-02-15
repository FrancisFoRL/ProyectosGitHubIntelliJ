package Interfaces;

import libreria.PeticionDatos;

public class ProbarInterface {
    public static void main(String[] args) {
        int opcion;
        String cadena;
        System.out.println("------Coche1------");
        Coche coche1 = new Coche();
        infoCoche(coche1);
        System.out.println("\n------Coche2------");
        Coche coche2 = new Coche();
        infoCoche(coche2);
        System.out.println("\n------Robot1------");
        Robot robot1 = new Robot();
        infoRobot(robot1);
        System.out.println("\n------Robot2------");
        Robot robot2 = new Robot();
        infoRobot(robot2);

        Movimiento[] array = {coche1, coche2, robot1, robot2};

        do {
            System.out.println("\nObjetos del array:");
            System.out.println("1.Coche1");
            System.out.println("2.Coche2");
            System.out.println("3.Robot1");
            System.out.println("4.Robot2");
            System.out.println("5.Salir");
            opcion = PeticionDatos.pedirEnteroRango(1, 5, 3, "\nDame una opcion(1-5): ");

            switch (opcion) {
                case 1 -> modificarArray(array[0]);
                case 2 -> modificarArray(array[1]);
                case 3 -> modificarArray(array[2]);
                case 4 -> modificarArray(array[3]);
            }
        }while (opcion!=5);
        System.out.println("\nFin del Programa");
    }

    public static void modificarArray (Movimiento array){
        String cadena;
        do {
            cadena = PeticionDatos.pedirCadena("¿Desea Acelerar o Frenar?: ");
            cadena = cadena.toUpperCase();
            if (cadena.equals("ACELERAR")) {
                avanzarMasRapido(array, PeticionDatos.pedirEntero("¿Cuanto desea acelerar?: "));
                System.out.println(array);
                break;
            } else if (cadena.equals("FRENAR")) {
                MasDespacio(array, PeticionDatos.pedirEntero("¿Cuanto desea frenar?: "));
                System.out.println(array);
                break;
            }
        } while (true);
    }

    public static void infoCoche(Coche coche){
        do{
            if(!coche.setVelocidad(PeticionDatos.pedirEntero("Pasos del robot: "))){
                System.out.println("Velocidad no valida");
            }else{
                break;
            }
        }while (true);
    }

    public static void infoRobot(Robot robot){
        do{
                if(!robot.setPasos(PeticionDatos.pedirEntero("Pasos del robot: "))){
                System.out.println("Pasos no validos");
            }else{
                break;
            }
        }while (true);
    }

    private static void avanzarMasRapido(Movimiento objeto, int movimiento) {
        objeto.acelerar(movimiento);
    }

    private static void MasDespacio(Movimiento objeto, int movimiento) {
        objeto.frenar(movimiento);
    }
}
