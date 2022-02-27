package federacion;

import libreria.PeticionDatos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Federacion {

    public static void main(String[] args) {
        int opcion;
        int posicion;
        String nombre;
        Equipo[] equipos = new Equipo[12];
        //Todo Funcion que compruebe que el nombre no esta repetido
        equipos[0] = new EquipoBaloncesto(Faker.nombreEquipo());
        añadirJugadorBalocesto((EquipoBaloncesto) equipos[0],5, true);
        equipos[1] = new EquipoBaloncesto(Faker.nombreEquipo());
        añadirJugadorBalocesto((EquipoBaloncesto) equipos[1],5, true);
        equipos[2] = new EquipoBaloncesto(Faker.nombreEquipo());
        añadirJugadorBalocesto((EquipoBaloncesto) equipos[2],5, true);
        equipos[3] = new EquipoFutbol(Faker.nombreEquipo());
        añadirJugadorFutbol((EquipoFutbol) equipos[3],11, true);
        equipos[4] = new EquipoFutbol(Faker.nombreEquipo());
        añadirJugadorFutbol((EquipoFutbol) equipos[4],11, true);
        equipos[5] = new EquipoFutbol(Faker.nombreEquipo());
        añadirJugadorFutbol((EquipoFutbol) equipos[5],11, true);
        equipos[6] = new EquipoBalonmano(Faker.nombreEquipo());
        añadirJugadorBalonmano((EquipoBalonmano) equipos[6],7, true);
        equipos[7] = new EquipoBalonmano(Faker.nombreEquipo());
        añadirJugadorBalonmano((EquipoBalonmano) equipos[7],7, true);
        equipos[8] = new EquipoBalonmano(Faker.nombreEquipo());
        añadirJugadorBalonmano((EquipoBalonmano) equipos[8],7, true);


        //Todo posible cambio a equipo[x] = new EquipoBaloncesto(Faker.nombreEquipo());

        //Todo comprobar porque se incian todas la posiciones y las pone a null
        System.out.println(equipos[0]);
        System.out.println(equipos[1]);
        System.out.println(equipos[2]);
        System.out.println(equipos[3]);
        System.out.println(equipos[4]);
        System.out.println(equipos[5]);
        System.out.println(equipos[6]);
        System.out.println(equipos[7]);
        System.out.println(equipos[8]);


        do {

            System.out.println("\n1. Añadir nuevo equipo");
            System.out.println("2. Añadir nuevo jugador");
            System.out.println("3. Ordenar jugadores de un Equipo");
            System.out.println("4. Pasar Equipo a fichero");
            System.out.println("5. Estadisticas de los jugadores de un equipo");
            System.out.println("6. Estadisticas de un equipo");
            System.out.println("7. Salir\n");

            opcion = PeticionDatos.pedirEnteroRango(1, 7, 3, "Dame un opcion(1-7): ");

            switch (opcion) {
                case 1:
                    posicion = buscarPosicion(equipos);
                    if (posicion >= 0) {

                        System.out.println("\n¿De que tipo sera el equipo a añadir?");
                        System.out.println("1. Equipo de Baloncesto");
                        System.out.println("2. Equipo Futbol");
                        System.out.println("3. Equipo Balonmano");

                        switch (PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame un opcion: ")) {
                            case 1:
                                if(EquipoBaloncesto.totalEquipos == 4){
                                    System.out.println("Ya no se pueden crear mas equipos de Baloncesto");
                                }else{
                                    equipos[posicion] = new EquipoBaloncesto(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                                }
                                opcion = PeticionDatos.pedirEnteroRango(0,1,3,"¿Desea añadir los jugadores de forma aleatoria(0) o manual(1)?: ");
                                if(opcion == 0){
                                    añadirJugadorBalocesto((EquipoBaloncesto)equipos[posicion],5,true);
                                }else{
                                    añadirJugadorBalocesto((EquipoBaloncesto)equipos[posicion],PeticionDatos.pedirEnteroRango(1,18,3,"¿Cuantos jugadores desea añadir?: "),false);
                                }
                                break;
                            case 2:
                                if(EquipoFutbol.totalEquipos == 4){
                                    System.out.println("Ya no se pueden crear mas equipos de Futbol");
                                }else{
                                    equipos[posicion] = new EquipoFutbol(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                                }
                                opcion = PeticionDatos.pedirEnteroRango(0,1,3,"¿Desea añadir los jugadores de forma aleatoria(0) o manual(1)?: ");
                                if(opcion == 0){
                                    añadirJugadorFutbol((EquipoFutbol) equipos[posicion],11,true);
                                }else{
                                    añadirJugadorFutbol((EquipoFutbol) equipos[posicion],PeticionDatos.pedirEnteroRango(1,24,3,"¿Cuantos jugadores desea añadir?: "),false);
                                }
                                break;
                            case 3:
                                if(EquipoBalonmano.totalEquipos == 4){
                                    System.out.println("Ya no se pueden crear mas equipos de Balonmano");
                                }else{
                                    equipos[posicion] = new EquipoBalonmano(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                                    break;
                                }
                                opcion = PeticionDatos.pedirEnteroRango(0,1,3,"¿Desea añadir los jugadores de forma aleatoria(0) o manual(1)?: ");
                                if(opcion == 0){
                                    añadirJugadorBalonmano((EquipoBalonmano) equipos[posicion],7,true);
                                }else{
                                    añadirJugadorBalonmano((EquipoBalonmano)equipos[posicion],PeticionDatos.pedirEnteroRango(1,14,3,"¿Cuantos jugadores desea añadir?: "),false);
                                }
                        }
                    } else {
                        System.out.println("Ya no se pueden crear mas equipos");
                    }
                    break;
                case 2:
                    mostrarEquipos(equipos);
                    do{
                        nombre=PeticionDatos.pedirCadena("Nombre del equipo a elegir: ");
                    }while(!existeEquipo(equipos,nombre));



                    break;
                /*
                if(EquipoBaloncesto..length < 18){
                    equipob.crearJugador(false);
                    System.out.println(equipob);
                }else{
                    System.out.println("No se pueden añadir mas jugadores a este equipo");
                }

                 */
                case 3:

                    shell_ascInt(((EquipoBaloncesto) equipos[0]).getJugadorBaloncesto());
                    System.out.println(equipos[0]);
                    break;
                case 4:
                    System.out.println("\n¿De que tipo de equipos se pasaran a fichero?");
                    System.out.println("1. Equipo de Baloncesto");
                    System.out.println("2. Equipo Futbol");
                    System.out.println("3. Equipo Balonmano");
                    switch (PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame un opcion: ")) {
                        case 1:
                        /*
                        FileOutputStream ficheroBaloncesto = new FileOutputStream("EquipoBaloncesto.txt");
                        ObjectOutputStream tuberia = new ObjectOutputStream(ficheroBaloncesto);
                         */
                            for (int x = 0; x < equipos.length; x++) {
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
        } while (opcion != 7);
    }

    private static void añadirJugadorBalocesto(EquipoBaloncesto jugadores, int num, boolean aletorio) {
        for (int i = 0; i < num; i++) {
            jugadores.nuevoJugadorArray(jugadores.crearJugador(aletorio));
        }
    }

    private static void añadirJugadorFutbol(EquipoFutbol jugadores, int num, boolean aletorio) {
        for (int i = 0; i < num; i++) {
            jugadores.nuevoJugadorArray(jugadores.crearJugador(aletorio));
        }
    }

    private static void añadirJugadorBalonmano(EquipoBalonmano jugadores, int num, boolean aletorio) {
        for (int i = 0; i < num; i++) {
            jugadores.nuevoJugadorArray(jugadores.crearJugador(aletorio));
        }
    }

    /*
    private static void mostrarEquipos(Equipo[] equipos) {
        int cont = 0;
        System.out.println("---------Equipos actuales---------");
        while (equipos[cont] != null) {
            System.out.println((cont + 1) + ".-" + equipos[cont]);
            cont++;
        }
    }
*/

    public static void shell_ascInt(Jugador[] v) {
        int d, i, ele;
        boolean ordenado;
        int cont = 0;
        while (v[cont] != null) {
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

    private static boolean existeEquipo(Equipo[] equipos, String nombre){
        for (int x = 0; x < equipos.length; x++) {
            if (equipos[x] == null){
                break;
            }else if(equipos[x].getNombreEquipo().equals(nombre)){
                return true;
            }
        }
        System.out.println("El equipo no existe");
        return false;
    }

    private static void mostrarEquipos(Equipo[] equipos){
        for (int x = 0; x < equipos.length; x++) {
            if (equipos[x] != null) {
                System.out.println(equipos[x]);
            } else {
                break;
            }
        }
    }

    private static boolean comprobarNombre(String nombre, Equipo[] equipos){
        int cont = 0;
        while (equipos[cont] != null) {
            cont++;
        }
        for (int x = 0; x < cont; x++) {
            if (equipos[x].getNombreEquipo().equals(nombre)) {
                return false;
            }
        }
        return true;
    }

    private static int buscarPosicion(Equipo[] equipos) {
        for (int x = 0; x < equipos.length; x++) {
            if (equipos[x] == null) {
                return x;
            }
        }
        return -1;
    }

    public static void shell_ascString(Jugador[] v) {
        int d, i;
        String ele;
        boolean ordenado;
        int cont = 0;
        while (v[cont] != null) {
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


