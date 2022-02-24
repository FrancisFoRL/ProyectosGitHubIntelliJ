package federacion;

import libreria.PeticionDatos;

public class Federacion {

    public static void main(String[] args) {
        boolean comprobar;
        int opcion;
        Equipo[] equipos = new Equipo[12];
        EquipoBaloncesto equipob = new EquipoBaloncesto(Faker.nombreEquipo());
        EquipoBaloncesto equipob1 = new EquipoBaloncesto(Faker.nombreEquipo());
        EquipoBaloncesto equipob2 = new EquipoBaloncesto(Faker.nombreEquipo());
        EquipoFutbol equipof = new EquipoFutbol(Faker.nombreEquipo());
        EquipoFutbol equipof1 = new EquipoFutbol(Faker.nombreEquipo());
        EquipoFutbol equipof2 = new EquipoFutbol(Faker.nombreEquipo());
        EquipoBalonmano equipoba = new EquipoBalonmano(Faker.nombreEquipo());
        EquipoBalonmano equipoba1 = new EquipoBalonmano(Faker.nombreEquipo());
        EquipoBalonmano equipoba2 = new EquipoBalonmano(Faker.nombreEquipo());

        do{

        equipos[0] = equipob;
        equipos[1] = equipob1;
        equipos[2] = equipob2;
        equipos[3] = equipof;
        equipos[4] = equipof1;
        equipos[5] = equipof2;
        equipos[6] = equipoba;
        equipos[7] = equipoba1;
        equipos[8] = equipoba2;

        System.out.println("\n1. Añadir nuevo equipo");
        System.out.println("2. Añadir nuevo jugador");
        System.out.println("3. Ordenar jugadores de un Equipo");
        System.out.println("4. Pasar Equipo a fichero");
        System.out.println("5. Estadisticas de los jugadores de un equipo");
        System.out.println("6. Estadisticas de un equipo");
        System.out.println("7. Salir\n");

        opcion = PeticionDatos.pedirEnteroRango(1, 7, 3, "Dame un opcion(1-7): ");

        switch (opcion){
            case 1:
                break;
            case 2:
                equipob.crearJugador(false);
                System.out.println(equipob);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
        }while (opcion!=7);
    }


}


