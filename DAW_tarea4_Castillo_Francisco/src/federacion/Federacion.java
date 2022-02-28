package federacion;

import libreria.PeticionDatos;

import java.io.*;
import java.util.ArrayList;

public class Federacion {

    public static void main(String[] args) throws IOException {
        int opcion, posicion, num;
        Equipo[] equipos = new Equipo[12];
        //Todo Funcion que compruebe que el nombre no esta repetido
        equipos[0] = new EquipoBaloncesto(Faker.nombreEquipo());
        añadirJugadorBalocesto((EquipoBaloncesto) equipos[0], 5, true);
        equipos[1] = new EquipoBaloncesto(Faker.nombreEquipo());
        añadirJugadorBalocesto((EquipoBaloncesto) equipos[1], 5, true);
        equipos[2] = new EquipoBaloncesto(Faker.nombreEquipo());
        añadirJugadorBalocesto((EquipoBaloncesto) equipos[2], 5, true);
        equipos[3] = new EquipoFutbol(Faker.nombreEquipo());
        añadirJugadorFutbol((EquipoFutbol) equipos[3], 11, true);
        equipos[4] = new EquipoFutbol(Faker.nombreEquipo());
        añadirJugadorFutbol((EquipoFutbol) equipos[4], 11, true);
        equipos[5] = new EquipoFutbol(Faker.nombreEquipo());
        añadirJugadorFutbol((EquipoFutbol) equipos[5], 11, true);
        equipos[6] = new EquipoBalonmano(Faker.nombreEquipo());
        añadirJugadorBalonmano((EquipoBalonmano) equipos[6], 7, true);
        equipos[7] = new EquipoBalonmano(Faker.nombreEquipo());
        añadirJugadorBalonmano((EquipoBalonmano) equipos[7], 7, true);
        equipos[8] = new EquipoBalonmano(Faker.nombreEquipo());
        añadirJugadorBalonmano((EquipoBalonmano) equipos[8], 7, true);


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
                                if (EquipoBaloncesto.totalEquipos == 4) {
                                    System.out.println("Ya no se pueden crear mas equipos de Baloncesto");
                                } else {
                                    equipos[posicion] = new EquipoBaloncesto(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                                }
                                opcion = PeticionDatos.pedirEnteroRango(0, 1, 3, "¿Desea añadir los jugadores de forma aleatoria(0) o manual(1)?: ");
                                if (opcion == 0) {
                                    añadirJugadorBalocesto((EquipoBaloncesto) equipos[posicion], 5, true);
                                } else {
                                    añadirJugadorBalocesto((EquipoBaloncesto) equipos[posicion], PeticionDatos.pedirEnteroRango(1, 18, 3, "¿Cuantos jugadores desea añadir?: "), false);
                                }
                                break;
                            case 2:
                                if (EquipoFutbol.totalEquipos == 4) {
                                    System.out.println("Ya no se pueden crear mas equipos de Futbol");
                                } else {
                                    equipos[posicion] = new EquipoFutbol(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                                }
                                opcion = PeticionDatos.pedirEnteroRango(0, 1, 3, "¿Desea añadir los jugadores de forma aleatoria(0) o manual(1)?: ");
                                if (opcion == 0) {
                                    añadirJugadorFutbol((EquipoFutbol) equipos[posicion], 11, true);
                                } else {
                                    añadirJugadorFutbol((EquipoFutbol) equipos[posicion], PeticionDatos.pedirEnteroRango(1, 24, 3, "¿Cuantos jugadores desea añadir?: "), false);
                                }
                                break;
                            case 3:
                                if (EquipoBalonmano.totalEquipos == 4) {
                                    System.out.println("Ya no se pueden crear mas equipos de Balonmano");
                                } else {
                                    equipos[posicion] = new EquipoBalonmano(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                                    break;
                                }
                                opcion = PeticionDatos.pedirEnteroRango(0, 1, 3, "¿Desea añadir los jugadores de forma aleatoria(0) o manual(1)?: ");
                                if (opcion == 0) {
                                    añadirJugadorBalonmano((EquipoBalonmano) equipos[posicion], 7, true);
                                } else {
                                    añadirJugadorBalonmano((EquipoBalonmano) equipos[posicion], PeticionDatos.pedirEnteroRango(1, 14, 3, "¿Cuantos jugadores desea añadir?: "), false);
                                }
                        }
                    } else {
                        System.out.println("Ya no se pueden crear mas equipos");
                    }
                    break;
                case 2:
                    mostrarEquipos(equipos);
                    añadirJugador(equipos[PeticionDatos.pedirEnteroRango(1, Equipo.totalEquipos, 3, "Numero del equipo a elegir (1-" + Equipo.totalEquipos + "): ") - 1]
                            , PeticionDatos.pedirEnteroRango(0, 1, 3, "¿Quieres añadir los datos del jugador de forma aleatoria(0) o de forma manual(1)?"));
                    break;
                case 3:
                    System.out.println("\n1. Ordenar todos los equipos");
                    System.out.println("2. Ordenar un solo equipo");
                    switch (PeticionDatos.pedirEnteroRango(1, 2, 3, "Dame una opcion: ")) {
                        case 1:
                            opcion = PeticionDatos.pedirEnteroRango(0, 1, 3, "Ordenar por dorsal(0) / Ordenar por 1er apellido(1): ");
                            for (int x = 0; x < Equipo.totalEquipos; x++) {
                                ordenarEquipo(equipos[x], opcion);
                            }
                            break;
                        case 2:
                            mostrarEquipos(equipos);
                            ordenarEquipo(equipos[PeticionDatos.pedirEnteroRango(1, Equipo.totalEquipos, 3, "Numero del equipo a elegir (1-" + Equipo.totalEquipos + "): ") - 1],
                                    PeticionDatos.pedirEnteroRango(0, 1, 3, "Ordenar por dorsal(0) / Ordenar por 1er apellido(1): "));
                            break;
                    }
                    break;
                case 4:
                    System.out.println("\n¿De que tipo de equipos se pasaran a fichero?");
                    System.out.println("1. Equipo de Baloncesto");
                    System.out.println("2. Equipo Futbol");
                    System.out.println("3. Equipo Balonmano");
                    pasarFichero(equipos, PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion(1/3): "));


                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (opcion != 7);
    }

    private static void añadirJugadorBalocesto(EquipoBaloncesto jugadores, int num, boolean aletorio) {
        if (jugadores.arrayLleno()) {
            System.out.println("No se pueden añadir mas jugadores");
        } else {
            for (int i = 0; i < num; i++) {
                jugadores.nuevoJugadorArray(jugadores.crearJugador(aletorio));
            }
        }

    }

    private static void añadirJugadorFutbol(EquipoFutbol jugadores, int num, boolean aletorio) {
        if (jugadores.arrayLleno()) {
            System.out.println("No se pueden añadir mas jugadores");
        } else {
            for (int i = 0; i < num; i++) {
                jugadores.nuevoJugadorArray(jugadores.crearJugador(aletorio));
            }
        }
    }

    private static void añadirJugadorBalonmano(EquipoBalonmano jugadores, int num, boolean aletorio) {
        if (jugadores.arrayLleno()) {
            System.out.println("No se pueden añadir mas jugadores");
        } else {
            for (int i = 0; i < num; i++) {
                jugadores.nuevoJugadorArray(jugadores.crearJugador(aletorio));
            }
        }
    }

    private static void añadirJugador(Equipo equipo, int num) {
        if (num == 0) {
            if (equipo instanceof EquipoBaloncesto) {
                añadirJugadorBalocesto((EquipoBaloncesto) equipo, 1, true);
            } else if (equipo instanceof EquipoFutbol) {
                añadirJugadorFutbol((EquipoFutbol) equipo, 1, true);
            } else if (equipo instanceof EquipoBalonmano) {
                añadirJugadorBalonmano((EquipoBalonmano) equipo, 1, true);
            }
        } else if (num == 1) {
            if (equipo instanceof EquipoBaloncesto) {
                añadirJugadorBalocesto((EquipoBaloncesto) equipo, 1, false);
            } else if (equipo instanceof EquipoFutbol) {
                añadirJugadorFutbol((EquipoFutbol) equipo, 1, false);
            } else if (equipo instanceof EquipoBalonmano) {
                añadirJugadorBalonmano((EquipoBalonmano) equipo, 1, false);
            }
        }

    }

    private static void ordenarEquipo(Equipo equipo, int num) {
        if (num == 0) {
            if (equipo instanceof EquipoBaloncesto) {
                shell_ascInt(((EquipoBaloncesto) equipo).getJugadorBaloncesto());
            } else if (equipo instanceof EquipoFutbol) {
                shell_ascInt(((EquipoFutbol) equipo).getJugadorFutbol());
            } else if (equipo instanceof EquipoBalonmano) {
                shell_ascInt(((EquipoBalonmano) equipo).getJugadorBalonmano());
            }
        } else if (num == 1) {
            if (equipo instanceof EquipoBaloncesto) {
                shell_ascString(((EquipoBaloncesto) equipo).getJugadorBaloncesto());
            } else if (equipo instanceof EquipoFutbol) {
                shell_ascString(((EquipoFutbol) equipo).getJugadorFutbol());
            } else if (equipo instanceof EquipoBalonmano) {
                shell_ascString(((EquipoBalonmano) equipo).getJugadorBalonmano());
            }
        }
    }

    private static void mostrarEquipos(Equipo[] equipos) {
        for (int x = 0; x < equipos.length; x++) {
            if (equipos[x] != null) {
                System.out.println("Equipo " + (x + 1));
                System.out.println(equipos[x]);
            } else {
                break;
            }
        }
    }

    private static int buscarPosicion(Equipo[] equipos) {
        for (int x = 0; x < equipos.length; x++) {
            if (equipos[x] == null) {
                return x;
            }
        }
        System.out.println("No hay posiciones disponibles");
        return -1;
    }

    private static void pasarFichero(Equipo[] equipos, int num) throws IOException {

        switch (num){
            case 1:
                ArrayList<EquipoBaloncesto> array = new ArrayList<EquipoBaloncesto>();
                for(int x = 0; x < Equipo.totalEquipos; x++)
                    if(equipos[x] instanceof EquipoBaloncesto){
                        array.add((EquipoBaloncesto) equipos[x]);
                    }
                try {
                    ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("EquipoBaloncesto.txt"));
                    oss.writeObject(array);
                    oss.close();
                }catch (FileNotFoundException e) {
                    System.out.println("El fichero no existe");
                } catch (Exception e){
                    System.out.println(e.getMessage()+ "Hola");
                }
                break;
        }
    }

    public static void shell_ascInt(Jugador[] v) {
        int d, i;
        boolean ordenado;
        Jugador aux;
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
                        aux = v[i];
                        v[i] = v[i + d];
                        v[i + d] = aux;
                        ordenado = false;
                    }
            }
            d = d / 2;
        }
    }

    public static void shell_ascString(Jugador[] v) {
        int d, i;
        boolean ordenado;
        Jugador aux;
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
                        aux = v[i];
                        v[i] = v[i + d];
                        v[i + d] = aux;
                        ordenado = false;
                    }
            }
            d = d / 2;
        }
    }


}


