package federacion;

import libreria.PeticionDatos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Federacion{

    public static void main(String[] args) {
        int opcion;
        int nuevoEquipo = 9;
        Equipo[] equipos = new Equipo[12];
        EquipoBaloncesto equipob = new EquipoBaloncesto(Faker.nombreEquipo());
        equipos[0] = equipob;
        añadirJugadorBalocesto(equipob);
        EquipoBaloncesto equipob1 = new EquipoBaloncesto(Faker.nombreEquipo());
        equipos[1] = equipob1;
        añadirJugadorBalocesto(equipob1);
        EquipoBaloncesto equipob2 = new EquipoBaloncesto(Faker.nombreEquipo());
        EquipoFutbol equipof = new EquipoFutbol(Faker.nombreEquipo());
        EquipoFutbol equipof1 = new EquipoFutbol(Faker.nombreEquipo());
        EquipoFutbol equipof2 = new EquipoFutbol(Faker.nombreEquipo());
        EquipoBalonmano equipoba = new EquipoBalonmano(Faker.nombreEquipo());
        EquipoBalonmano equipoba1 = new EquipoBalonmano(Faker.nombreEquipo());
        EquipoBalonmano equipoba2 = new EquipoBalonmano(Faker.nombreEquipo());



        /*
        equipos[2] = equipob2;
        añadirJugadorBalocesto(equipob2);
        equipos[3] = equipof;
        añadirJugadorFutbol(equipof);
        equipos[4] = equipof1;
        añadirJugadorFutbol(equipof1);
        equipos[5] = equipof2;
        añadirJugadorFutbol(equipof2);
        equipos[6] = equipoba;
        añadirJugadorBalonmano(equipoba);
        equipos[7] = equipoba1;
        añadirJugadorBalonmano(equipoba1);
        equipos[8] = equipoba2;
        añadirJugadorBalonmano(equipoba2);
         */
        //Todo comprobar porque se incian todas la posiciones y las pone a null
        System.out.println(equipob);
        System.out.println(equipob1);


        do{

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
                System.out.println("\n¿De que tipo sera el equipo a añadir?");
                System.out.println("1. Equipo de Baloncesto");
                System.out.println("2. Equipo Futbol");
                System.out.println("3. Equipo Balonmano");

                switch (PeticionDatos.pedirEnteroRango(1,3,3,"Dame un opcion: ")){
                    case 1:
                        //TODO Arreglar espacios en peticion de datos
                        EquipoBaloncesto equipob3 = new EquipoBaloncesto(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                        equipos[nuevoEquipo] = equipob3;
                        nuevoEquipo++;
                        break;
                    case 2:
                        EquipoFutbol equipof3 = new EquipoFutbol(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                        equipos[nuevoEquipo] = equipof3;
                        nuevoEquipo++;
                        break;
                    case 3:
                        EquipoBalonmano equipoba3 = new EquipoBalonmano(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                        equipos[nuevoEquipo] = equipoba3;
                        nuevoEquipo++;
                        break;
                }
                break;
            case 2:
                /*
                if(EquipoBaloncesto..length < 18){
                    equipob.crearJugador(false);
                    System.out.println(equipob);
                }else{
                    System.out.println("No se pueden añadir mas jugadores a este equipo");
                }

                 */

                break;
            case 3:

                mostrarEquipos(equipos);
                shell_ascInt(equipob.getJugadorBaloncesto());
                System.out.println(equipob);
                break;
            case 4:
                System.out.println("\n¿De que tipo de equipos se pasaran a fichero?");
                System.out.println("1. Equipo de Baloncesto");
                System.out.println("2. Equipo Futbol");
                System.out.println("3. Equipo Balonmano");
                switch (PeticionDatos.pedirEnteroRango(1,3,3,"Dame un opcion: ")){
                    case 1:
                        /*
                        FileOutputStream ficheroBaloncesto = new FileOutputStream("EquipoBaloncesto.txt");
                        ObjectOutputStream tuberia = new ObjectOutputStream(ficheroBaloncesto);
                         */
                        for (int x = 0 ; x<equipos.length;x++){
                            if (equipos[x] instanceof EquipoBaloncesto) {
                                EquipoBaloncesto auxba = (EquipoBaloncesto) equipos[x];
                                /*
                                try {
                                    tuberia.writeObject(auxba);
                                }catch(FileNotFoundException e) {
                                    System.out.println("Fichero no encontrado");
                                }catch (IOException e) {
                                    System.out.println("Hubo una excepcion");
                                }finally {
                                    try {
                                        ficheroBaloncesto.close();
                                    }catch (IOException e){
                                        System.out.println("Hubo una excepcion");
                                    }

                                }
                                */
                            }

                        }
                }


                break;
            case 5:
                break;
            case 6:
                break;
        }
        }while (opcion!=7);
    }

    private static void añadirJugadorBalocesto(EquipoBaloncesto jugadores){
        for(int i=1; i <= 5;i++){
            jugadores.nuevoJugadorArray(jugadores.crearJugador(true));
        }
    }

    private static void añadirJugadorFutbol(EquipoFutbol jugadores){
        for(int i=1; i <= 11;i++){
            jugadores.crearJugador(true);
        }
    }

    private static void añadirJugadorBalonmano(EquipoBalonmano jugadores){
        for(int i=1; i <= 7;i++){
            jugadores.crearJugador(true);
        }
    }

    private static void mostrarEquipos(Equipo[] equipos){
        int cont=0;
        System.out.println("---------Equipos actuales---------");
        while(equipos[cont]!=null){
            System.out.println((cont+1)+".-"+equipos[cont]);
            cont++;
        }
    }


    public static void shell_ascInt(Jugador v[]) {
        int d, i, ele;
        boolean ordenado;
        int cont = 0;
        while(v[cont]!=null)
        {
            cont++;
        }
        int num_ele = cont;
        d = num_ele / 2;
        while (d >= 1) {
            ordenado = false;
            while (!ordenado) {
                ordenado = true;
                for (i = 0; i < num_ele - d; i++)
                    if (v[i].getDorsal() > v[i + d].getDorsal()) {
                        ele = v[i].getDorsal();
                        v[i].setDorsal(v[i + d].getDorsal());
                        v[i + d].setDorsal(ele);
                        ordenado = false;
                    }
            }
            d = d / 2;
        }
    }

    public static void shell_ascString(Jugador[] v) {
        int d, i;
        String ele;
        boolean ordenado;
        int cont=0;
        while(v[cont]!=null)
        {
            cont++;
        }
        int num_ele = cont;
        d = num_ele / 2;
        while (d >= 1) {
            ordenado = false;
            while (!ordenado) {
                ordenado = true;
                for (i = 0; i < num_ele - d; i++)
                    if (v[i].getApellido1().compareTo(v[i + d].getApellido1()) > 0) {
                        ele = v[i].getApellido1();
                        v[i] = v[i + d];
                        v[i + d].setApellido1(ele);
                        ordenado = false;
                    }
            }
            d = d / 2;
        }
    }



}


