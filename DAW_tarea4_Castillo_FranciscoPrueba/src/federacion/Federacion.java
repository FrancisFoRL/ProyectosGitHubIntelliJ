package federacion;

import libreria.PeticionDatos;

import java.io.*;

/**
 * Clase Federancion, esta es la clase principal del programa que contiene el Main. Aqui mostraremos el
 * menu y se podran elegir entre varias opciones que hacer. Se crear 3 array de cada tipo de deporte por defecto y
 * se le añaden de forma aleatoria los jugadores minimos necesarios. Esto deja al usuario con la posibilidad de añadir
 * 1 solo equipo de cada especialidad y poder añadir jugadores a los arrays ya creados.
 */
public class Federacion implements Serializable {

    //Main
    public static void main(String[] args) throws IOException {
        //Atributos
        int opcion, posicion;

        /*
         * Se crea un array de tipo Equipo, que es donde se guardaran el resto de equipos
         */
        Equipo[] equipos = new Equipo[12];

        /*
         * Se crear 3 array de cada especialidad y se rellenan de forma aleatoria con el minimo de
         * jugadores necesarios
         */
        for (int i = 0; i < 9; i += 3) {
            equipos[i] = new EquipoBaloncesto(asignarNombre(equipos));
            añadirJugador(equipos[i], 5, 0);
            equipos[i + 1] = new EquipoFutbol(asignarNombre(equipos));
            añadirJugador(equipos[i + 1], 11, 0);
            equipos[i + 2] = new EquipoBalonmano(asignarNombre(equipos));
            añadirJugador(equipos[i + 2], 7, 0);
        }
        /*
         * Se muestra un menu y se elige la accion que se quiere llevar acabo
         */
        do {
            System.out.println("\n---------Federacion de Equipos---------");
            System.out.println("1. Añadir nuevo equipo");
            System.out.println("2. Añadir nuevo jugador");
            System.out.println("3. Ordenar jugadores de un Equipo");
            System.out.println("4. Pasar Equipo a fichero");
            System.out.println("5. Estadisticas de los jugadores de un equipo");
            System.out.println("6. Estadisticas de equipos de una especialidad");
            System.out.println("7. Salir\n");

            opcion = PeticionDatos.pedirEnteroRango(1, 7, 3, "Dame un opcion(1-7): ");
            System.out.println();

            switch (opcion) {
                case 1 -> {
                    posicion = buscarPosicion(equipos);
                    if (posicion >= 0) {
                        System.out.println("¿De que tipo sera el equipo a añadir?");
                        System.out.println("1. Equipo de Baloncesto");
                        System.out.println("2. Equipo Futbol");
                        System.out.println("3. Equipo Balonmano");
                        System.out.println();
                        nuevoEquipo(equipos, posicion);
                    } else {
                        System.out.println("Ya no se pueden crear mas equipos");
                    }
                }
                case 2 -> {
                    mostrarSoloEquipos(equipos);
                    añadirJugador(equipos[PeticionDatos.pedirEnteroRango(1, Equipo.totalEquipos, 3, "Numero del equipo a elegir (1-" + Equipo.totalEquipos + "): ") - 1],
                            1, PeticionDatos.pedirEnteroRango(0, 1, 3, "¿Quieres añadir los datos del jugador de forma aleatoria(0) o de forma manual(1)?"));
                }
                case 3 -> {
                    System.out.println("1. Ordenar todos los equipos");
                    System.out.println("2. Ordenar un solo equipo\n");
                    switch (PeticionDatos.pedirEnteroRango(1, 2, 3, "Dame una opcion: ")) {
                        case 1 -> {
                            opcion = PeticionDatos.pedirEnteroRango(0, 1, 3, "Ordenar por dorsal(0) / Ordenar por 1er apellido(1): ");
                            for (int x = 0; x < Equipo.totalEquipos; x++) {
                                ordenarEquipo(equipos[x], opcion);
                            }
                        }
                        case 2 -> {
                            mostrarSoloEquipos(equipos);
                            ordenarEquipo(equipos[PeticionDatos.pedirEnteroRango(1, Equipo.totalEquipos, 3, "Numero del equipo a elegir (1-" + Equipo.totalEquipos + "): ") - 1],
                                    PeticionDatos.pedirEnteroRango(0, 1, 3, "Ordenar por dorsal(0) / Ordenar por 1er apellido(1): "));
                        }
                    }
                }
                case 4 -> {
                    System.out.println("¿De que tipo de equipos se pasaran a fichero?");
                    System.out.println("1. Equipo de Baloncesto");
                    System.out.println("2. Equipo Futbol");
                    System.out.println("3. Equipo Balonmano");
                    pasarFichero(equipos);
                }
                case 5 -> {
                    mostrarSoloEquipos(equipos);
                    mostrarEstadisticasJug(equipos);
                }
                case 6 -> {
                    System.out.println("¿De que tipo de equipos se mostraran la estadisticas?");
                    System.out.println("1. Equipo de Baloncesto");
                    System.out.println("2. Equipo Futbol");
                    System.out.println("3. Equipo Balonmano");
                    mostrarEstadisticas(equipos);
                }
            }
        } while (opcion != 7);
    }

    /**
     * Funcion que crea un nuevo equipo de la especialidad que se desee. Este controla que no se supere el maximo de numero de
     * equipos de cada especialidad.
     *
     * @param equipos  array de todos los equipos creados hasta ahora
     * @param posicion valor entero donde ira el nuevo equipo en el array principal
     */
    private static void nuevoEquipo(Equipo[] equipos, int posicion) {
        int opcion;
        switch (PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame un opcion: ")) {
            case 1 -> {
                if (EquipoBaloncesto.totalEquipos == 4) {
                    System.out.println("Ya no se pueden crear mas equipos de Baloncesto");
                } else {
                    equipos[posicion] = new EquipoBaloncesto(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                    opcion = PeticionDatos.pedirEnteroRango(0, 1, 3, "¿Desea añadir los jugadores de forma aleatoria(0) o manual(1)?: ");
                    if (opcion == 0) {
                        añadirJugador(equipos[posicion], PeticionDatos.pedirEnteroRango(1, ((EquipoBaloncesto)equipos[posicion]).getJugadorBaloncesto().length, 3, "¿Cuantos jugadores desea añadir?: "), 0);
                    } else {
                        añadirJugador(equipos[posicion], 5, 1);
                    }
                }
            }
            case 2 -> {
                if (EquipoFutbol.totalEquipos == 4) {
                    System.out.println("Ya no se pueden crear mas equipos de Futbol");
                } else {
                    equipos[posicion] = new EquipoFutbol(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                    opcion = PeticionDatos.pedirEnteroRango(0, 1, 3, "¿Desea añadir los jugadores de forma aleatoria(0) o manual(1)?: ");
                    if (opcion == 0) {
                        añadirJugador(equipos[posicion], PeticionDatos.pedirEnteroRango(1, ((EquipoFutbol)equipos[posicion]).getJugadorFutbol().length, 3, "¿Cuantos jugadores desea añadir?: "), 0);
                    } else {
                        añadirJugador(equipos[posicion], 11, 1);
                    }
                }

            }
            case 3 -> {
                if (EquipoBalonmano.totalEquipos == 4) {
                    System.out.println("Ya no se pueden crear mas equipos de Balonmano");
                } else {
                    equipos[posicion] = new EquipoBalonmano(PeticionDatos.pedirCadena("\nNombre del equipo: "));
                    opcion = PeticionDatos.pedirEnteroRango(0, 1, 3, "¿Desea añadir los jugadores de forma aleatoria(0) o manual(1)?: ");
                    if (opcion == 0) {
                        añadirJugador(equipos[posicion], PeticionDatos.pedirEnteroRango(1, ((EquipoBalonmano)equipos[posicion]).getJugadorBalonmano().length, 3, "¿Cuantos jugadores desea añadir?: "), 0);
                    } else {
                        añadirJugador(equipos[posicion], 7, 1);
                    }
                }
            }
        }
    }

    private static void añadirJugador(Equipo jugadores, int num, int aleatorio){
        boolean ale;
        if(aleatorio == 0){
            ale = true;
        }else{
            ale = false;
        }
        if(jugadores instanceof EquipoBaloncesto){
            if (((EquipoBaloncesto)jugadores).arrayLleno()) {
                System.out.println("No se pueden añadir mas jugadores");
            } else {
                for (int i = 0; i < num; i++) {
                    ((EquipoBaloncesto)jugadores).nuevoJugadorArray(((EquipoBaloncesto)jugadores).crearJugador(ale));
                }
            }
        }else if(jugadores instanceof EquipoFutbol){
            if (((EquipoFutbol)jugadores).arrayLleno()) {
                System.out.println("No se pueden añadir mas jugadores");
            } else {
                for (int i = 0; i < num; i++) {
                    ((EquipoFutbol) jugadores).nuevoJugadorArray(((EquipoFutbol) jugadores).crearJugador(ale));
                }
            }
        }else if(jugadores instanceof EquipoBalonmano){
            if (((EquipoBalonmano)jugadores).arrayLleno()) {
                System.out.println("No se pueden añadir mas jugadores");
            } else {
                for (int i = 0; i < num; i++) {
                    ((EquipoBalonmano)jugadores).nuevoJugadorArray(((EquipoBalonmano)jugadores).crearJugador(ale));
                }
            }
        }
    }

    /**
     * Funcion que asigna nombres a los equipos y comprueba que no esten repetidos
     *
     * @param equipos array que contiene los nombres de todos los equipos
     * @return devuelve el nombre del equipo
     */
    private static String asignarNombre(Equipo[] equipos) {
        String nombre;
        boolean comprobar;
        do {
            nombre = Faker.nombreEquipo();
            comprobar = true;
            for (Equipo equipo : equipos) {
                if (equipo != null) {
                    if (equipo.nombreEquipo.equals(nombre)) {
                        comprobar = false;
                        break;
                    }
                }
            }
        } while (!comprobar);
        return nombre;
    }

    /**
     * Funcion que muestra las estadisticas de los jugadores de un equipo
     *
     * @param equipos array que contiene la informacion de los jugadores de los equipos
     */
    private static void mostrarEstadisticasJug(Equipo[] equipos) {
        int opcion = PeticionDatos.pedirEnteroRango(1, 3, 3, "\nDame una opcion(1/" + Equipo.totalEquipos + "): ") - 1;
        if (equipos[opcion] instanceof EquipoBaloncesto) {
            System.out.println("\n---------" + equipos[opcion].nombreEquipo + "---------");
            ((EquipoBaloncesto) equipos[opcion]).mostrarValoracionJug();
        } else if (equipos[opcion] instanceof EquipoFutbol) {
            System.out.println("\n---------" + equipos[opcion].nombreEquipo + "---------");
            ((EquipoFutbol) equipos[opcion]).mostrarValoracionJug();
        } else if (equipos[opcion] instanceof EquipoBalonmano) {
            System.out.println("\n---------" + equipos[opcion].nombreEquipo + "---------");
            ((EquipoBalonmano) equipos[opcion]).mostrarValoracionJug();
        }
    }

    /**
     * Funcion que muestra las estadisticas de un equipo
     *
     * @param equipos array que contiene la informacion de los equipos
     */
    private static void mostrarEstadisticas(Equipo[] equipos) {
        switch (PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame un opcion: ")) {
            case 1:
                for (int x = 0; x < Equipo.totalEquipos; x++) {
                    if (equipos[x] instanceof EquipoBaloncesto) {
                        System.out.println("\nEstadisticas " + equipos[x].nombreEquipo + ": " + (equipos[x]).valoracion());
                    }
                }
                break;

            case 2:
                for (int x = 0; x < Equipo.totalEquipos; x++) {
                    if (equipos[x] instanceof EquipoFutbol) {
                        System.out.println("\nEstadisticas " + equipos[x].nombreEquipo + ": " + (equipos[x]).valoracion());
                    }
                }
                break;

            case 3:
                for (int x = 0; x < Equipo.totalEquipos; x++) {
                    if (equipos[x] instanceof EquipoBalonmano) {
                        System.out.println("\nEstadisticas " + equipos[x].nombreEquipo + ": " + (equipos[x]).valoracion());
                    }
                }
                break;
        }
    }

    /**
     * Funcion que ordena los array dependiendo del tipo que sea. Se pasa si se quiere que el array se ordene por
     * el dorsal o por el primer apellido.
     *
     * @param equipo nos da la informacion del equipo a ordenar
     * @param num    valor que no indica si se quiere ordenar por dorsal(0) o por apellido(0)
     */
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

    /**
     * Funcion que muestra el equipo con sus jugadores.
     *
     * @param equipos array que contiene la informacion de los nombres de los equipos
     */
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

    /**
     * Funcion que muestra los nombres de los equipos por pantalla
     *
     * @param equipos array que contiene la informacion de los nombres de los equipos
     */
    private static void mostrarSoloEquipos(Equipo[] equipos) {
        for (int x = 0; x < equipos.length; x++) {
            if (equipos[x] != null) {
                System.out.println("Equipo " + (x + 1) + ": " + equipos[x].nombreEquipo);
            } else {
                break;
            }
        }
    }

    /**
     * Funcion que busca un hueco en el array, si no hay ninguno devolvera que no hay disponible ninguna posicion.
     *
     * @param equipos Array donde se busca si hay un hueco libre.
     * @return devuelve la posicion el array donde hay hueco y si no hay devuelve un -1
     */
    private static int buscarPosicion(Equipo[] equipos) {
        for (int x = 0; x < equipos.length; x++) {
            if (equipos[x] == null) {
                return x;
            }
        }
        return -1;
    }

    /**
     * Funcion que pasa a fichero externo los equipos de una especialidad. Anteriormente todas la clases que se van a pasar a fichero
     * tiene que tener como interfaz Serializable, ya que asi luego nos permitira pasar el objeto a bytes.
     *
     * @param equipos array que contiene la informacion de los equipos
     * @throws IOException esta declaracion nos vale para arrojar cualquier excepcion que nos arroje la funcion
     */
    private static void pasarFichero(Equipo[] equipos) throws IOException {
        switch (PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion(1/3): ")) {
            case 1 -> {
                FileOutputStream ficherob = new FileOutputStream("EquipoBaloncesto.txt");
                DataOutputStream oss = new DataOutputStream(ficherob);
                for(Equipo equipo : equipos){
                    if(equipo instanceof EquipoBaloncesto){
                        ordenarEquipo(equipo, 1);
                        oss.writeChars("-----"+equipo.getNombreEquipo()+"-----");
                        oss.writeChars(((EquipoBaloncesto) equipo).mostrarJugadoresString());
                        oss.writeChars("\n");
                        oss.writeChars("\n");
                    }
                }
                oss.close();
            }
            case 2 -> {
                FileOutputStream ficherof = new FileOutputStream("EquipoFutbol.txt");
                DataOutputStream oss = new DataOutputStream(ficherof);
                for(Equipo equipo : equipos){
                    if(equipo instanceof EquipoFutbol){
                        ordenarEquipo(equipo, 1);
                        oss.writeChars("-----"+equipo.getNombreEquipo()+"-----");
                        oss.writeChars(((EquipoFutbol) equipo).mostrarJugadoresString());
                        oss.writeChars("\n");
                        oss.writeChars("\n");
                    }
                }
                oss.close();
            }
            case 3 -> {
                FileOutputStream ficheroba = new FileOutputStream("EquipoBalonmano.txt");
                DataOutputStream oss = new DataOutputStream(ficheroba);
                for(Equipo equipo : equipos){
                    if(equipo instanceof EquipoBalonmano){
                        ordenarEquipo(equipo, 1);
                        oss.writeChars("-----"+equipo.getNombreEquipo()+"-----");
                        oss.writeChars(((EquipoBalonmano) equipo).mostrarJugadoresString());
                        oss.writeChars("\n");
                        oss.writeChars("\n");
                    }
                }
                oss.close();
            }
        }
    }

    //Metodos de ordenacion

    /*
     * Ordenacion por dorsal
     */
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

    /*
     * Ordenacion por apellido
     */
    public static void shell_ascString(Jugador[] v) {
        int d, i, cont = 0;
        boolean ordenado;
        Jugador aux;
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


