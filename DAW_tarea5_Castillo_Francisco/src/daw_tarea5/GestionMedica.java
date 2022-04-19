package daw_tarea5;

import libreria.PeticionDatos;
import librerias.Faker;
import librerias.Fecha;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class GestionMedica implements Serializable {
    //Hacer una version cambiando los objetos, en vez de hacerlo pasando el array, creando un fichero para cada persona.
    private Centro[] centrosMedicos;
    private static final LocalDate DIAHOY = LocalDate.now();

    public GestionMedica(int tamanio) {
        centrosMedicos = new Centro[tamanio];
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String dni;
        int numPers;
        Persona persona;
        GestionMedica gestion = cargarFicheros();
        int opcion, peticion, z;

        do {
            System.out.println("\n0. Salir aplicacion");
            System.out.println("1. Gestion Hospital");
            System.out.println("2. Gestion Clinica");
            System.out.println("3. Gestion Personal");
            System.out.println("4. Gestion Paciente");
            System.out.println("5. Sacar estadisticas Centros Medicos");
            System.out.println("6. Sacar estadisticas Personas");

            switch (opcion = PeticionDatos.pedirEnteroRango(0, 6, 3, "Dame una opcion: ")) {

                case 1 -> {
                    System.out.println("1. Mostrar Hospitales existentes");
                    System.out.println("2. Crear nuevo Hospital");
                    System.out.println("3. Eliminar Hospital");
                    System.out.println("4. Volver al menu principal");

                    switch (opcion = PeticionDatos.pedirEnteroRango(1, 4, 3, "Dame una opcion: ")) {
                        case 1 -> {
                            z = encontrarCentro(gestion.centrosMedicos, 0);

                            System.out.println("1. Mostrar informacion del Hospital seleccionado");
                            System.out.println("2. Modificar datos del hospital seleccionado");
                            System.out.println("3. Volver al menu principal");

                            switch (PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion: ")) {
                                case 1 -> {
                                    gestion.centrosMedicos[z].mostrarEstado();
                                }
                                case 2 -> {
                                    editarCentro(gestion.centrosMedicos[z]);
                                }
                            }
                        }
                        case 2 -> {
                            nuevoCentro(crearCentro(0), gestion);
                        }
                        case 3 -> {
                            if (delCentro(gestion, 1)) {
                                System.out.println("Hospital eliminado");
                            } else {
                                System.out.println("El hospital no se puede eliminar porque contiene a personas");
                            }
                        }
                    }

                }

                case 2 -> {
                    System.out.println("1. Mostrar Clinicas existentes");
                    System.out.println("2. Crear nueva Clinica");
                    System.out.println("3. Eliminar Clinica");
                    System.out.println("4. Volver al menu principal");

                    switch (opcion = PeticionDatos.pedirEnteroRango(1, 4, 3, "Dame una opcion: ")) {
                        case 1 -> {
                            z = encontrarCentro(gestion.centrosMedicos, 1);

                            System.out.println("1. Mostrar informacion de la Clinica seleccionado");
                            System.out.println("2. Modificar datos de la Clinica seleccionado");
                            System.out.println("3. Volver al menu principal");

                            switch (PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion: ")) {
                                case 1 -> {
                                    gestion.centrosMedicos[z].mostrarEstado();
                                }
                                case 2 -> {
                                    editarCentro(gestion.centrosMedicos[z]);
                                }
                            }
                        }
                        case 2 -> {
                            nuevoCentro(crearCentro(1), gestion);
                        }
                        case 3 -> {
                            if (delCentro(gestion, 2)) {
                                System.out.println("Clinica eliminada");
                            } else {
                                System.out.println("La clinica no se puede eliminar porque contiene a personas");
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("1. Crear nuevo trabajador");
                    System.out.println("2. Mostrar trabajadores");
                    System.out.println("3. Modificar datos de un trabajador");
                    System.out.println("4. Volver al menu principal");

                    switch (opcion = PeticionDatos.pedirEnteroRango(1, 4, 3, "Dame una opcion: ")) {
                        case 1 -> {
                            dni = PeticionDatos.pedirNIF_NIE();
                            if (Persona.existePers(gestion.centrosMedicos, dni, 1) == null) {
                                System.out.println("¿El nuevo trabajador sera Medico(1) o Administrativo(2)?");
                                persona = crearPersona(PeticionDatos.pedirEnteroRango(1, 2, 3, "Dame un opcion: "), dni);
                                añadirPersona(gestion.centrosMedicos, persona, 1);
                            } else {
                                persona = Persona.existePers(gestion.centrosMedicos, dni, 1);
                                System.out.println("La persona con DNI " + persona.getDni() + " existe: ");
                                System.out.println(persona);
                                System.out.println("1. Asignar a hospital/clinica");
                                System.out.println("2. Modificar datos del trabajador");
                                System.out.println("3. Despedir");
                                System.out.println("4. Añadir dia trabajado");
                                System.out.println("5. Volver al menu principal");


                                switch (PeticionDatos.pedirEnteroRango(1, 5, 3, "Dame una opcion: ")) {
                                    case 1 -> {
                                        añadirPersona(gestion.centrosMedicos, persona, 1);
                                    }
                                    case 2 -> {
                                        if (Persona.existePers(gestion.centrosMedicos, dni, 1) instanceof Medico) {
                                            numPers = 1;
                                        } else {
                                            numPers = 2;
                                        }
                                        editarPersona(persona, numPers);
                                    }
                                    case 3 -> {
                                        if (persona.lugar == -1) {
                                            System.out.println("El trabajador no esta asingnado a ningun sitio");
                                        } else if (gestion.centrosMedicos[persona.lugar].removeTrabajador(persona)) {
                                            System.out.println("Se despidio al trabajador");
                                        }
                                    }
                                    case 4 -> {
                                        añadirDia(persona);
                                    }
                                }
                            }
                        }
                        case 2 -> {
                            mostrarPersonas(1, gestion.centrosMedicos);
                        }
                        case 3 -> {
                            dni = PeticionDatos.pedirNIF_NIE();
                            if (Persona.existePers(gestion.centrosMedicos, dni, 1) == null) {
                                System.out.println("El DNI que se ha especificado no corresponde a ninguna persona");
                            } else if (Persona.existePers(gestion.centrosMedicos, dni, 1) instanceof Medico) {
                                editarPersona(Persona.existePers(gestion.centrosMedicos, dni, 1), 1);
                            } else if (Persona.existePers(gestion.centrosMedicos, dni, 1) instanceof Administrativo) {
                                editarPersona(Persona.existePers(gestion.centrosMedicos, dni, 1), 2);
                            }
                        }
                    }
                }
                case 4 -> {
                    System.out.println("1. Crear nuevo paciente");
                    System.out.println("2. Mostrar pacientes");
                    System.out.println("3. Modificar datos de un paciente");
                    System.out.println("4. Volver al menu principal");

                    switch (opcion = PeticionDatos.pedirEnteroRango(1, 4, 3, "Dame una opcion: ")) {
                        case 1 -> {
                            dni = PeticionDatos.pedirNIF_NIE();
                            if (Persona.existePers(gestion.centrosMedicos, dni, 0) == null) {
                                persona = crearPersona(0, dni);
                                añadirPersona(gestion.centrosMedicos, persona, 0);
                            } else {
                                persona = Persona.existePers(gestion.centrosMedicos, dni, 0);
                                System.out.println("La persona con DNI " + persona.getDni() + " existe: ");
                                System.out.println(persona);
                                System.out.println("1. Asignar a hospital/clinica");
                                System.out.println("2. Modificar datos del paciente");
                                System.out.println("3. Dar alta");
                                System.out.println("4. Añadir visita medica");
                                System.out.println("5. Volver al menu principal");

                                switch (PeticionDatos.pedirEnteroRango(1, 5, 3, "Dame una opcion: ")) {
                                    case 1 -> {
                                        añadirPersona(gestion.centrosMedicos, persona, 0);
                                    }
                                    case 2 -> {
                                        editarPersona(persona, 0);
                                    }
                                    case 3 -> {
                                        if (persona.lugar == -1) {
                                            System.out.println("El paciente no esta asingnado a ningun sitio");
                                        } else {
                                            if (gestion.centrosMedicos[persona.lugar] instanceof Hospital) {
                                                if (((Hospital) gestion.centrosMedicos[persona.lugar]).removePaciente((Paciente) persona)) {
                                                    System.out.println("Se le dio de alta al paciente");
                                                }
                                            } else if (gestion.centrosMedicos[persona.lugar] instanceof Clinica) {
                                                if (((Clinica) gestion.centrosMedicos[persona.lugar]).removePaciente((Paciente) persona)) {
                                                    System.out.println("Se le dio de alta al paciente");
                                                }
                                            }
                                        }
                                    }
                                    case 4 -> {
                                        añadirDia(persona);
                                    }
                                }
                            }
                        }
                        case 2 -> {
                            mostrarPersonas(0, gestion.centrosMedicos);
                        }
                        case 3 -> {
                            dni = PeticionDatos.pedirNIF_NIE();
                            if (Persona.existePers(gestion.centrosMedicos, dni, 1) == null) {
                                System.out.println("El paciente no existe");
                            } else {
                                editarPersona(Persona.existePers(gestion.centrosMedicos, dni, 0), 0);
                            }
                        }
                    }
                }
                case 5 -> {
                    int mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Dame un mes del año (1/12): ");
                    peticion = encontrarCentro(gestion.centrosMedicos, 2);
                    mostrarEstadisticaPac(mes, gestion.centrosMedicos[peticion]);
                }
                case 6 -> {
                    mostrarEstadistica(PeticionDatos.pedirEnteroRango(1, 12, 3, "Dame un mes del año (1/12): "),
                            gestion.centrosMedicos[encontrarCentro(gestion.centrosMedicos, 2)],
                            PeticionDatos.pedirEnteroRango(1, 3, 3, "¿La estadisticas a mostrar seran de un medico(1), de un administrador(2) o de un Paciente(3)?: "));

                }
            }
        } while (opcion != 0);
        if (PeticionDatos.pedirEnteroRango(1, 2, 3, "¿Desea guardar la informacion creada?Si(1)/No(2): ") == 1) {
            pasarFichero(gestion);
        }
        System.out.print("Fin del Programa");
    }

    private static void pasarFichero(GestionMedica gestion) throws IOException {
        int[] guardar = {Persona.contID, Centro.contID, Centro.contCentros};
        ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("objetos.dat"));
        ObjectOutputStream atributos = new ObjectOutputStream(new FileOutputStream("AtributosStatic.dat"));
        ObjectOutputStream trabajadores = new ObjectOutputStream(new FileOutputStream("trabajadores.dat"));
        ObjectOutputStream pacientes = new ObjectOutputStream(new FileOutputStream("pacientes.dat"));
        escribiendoFichero.writeObject(gestion);
        atributos.writeObject(guardar);
        trabajadores.writeObject(Centro.delTrabajadores);
        pacientes.writeObject(Centro.delPaciente);
        escribiendoFichero.close();
        atributos.close();
        trabajadores.close();
    }

    private static void mostrarPersonas(int tipo, Centro[] centros) {
        Persona[] personas = new Persona[5];
        int cont = 0;
        if (tipo == 0) {
            for (Centro centro : centros) {
                if (centro == null) ;
                else {
                    for (int y = 0; y < centro.getConsultas().length; y++) {
                        personas = aumentarArray(personas);
                        if (centro.getConsultas()[y] == null);
                        else {
                            personas[cont] = centro.getConsultas()[y];
                            cont++;
                        }
                    }
                }
                if (centro instanceof Hospital) {
                    for (int y = 0; y < ((Hospital) centro).getHabitaciones().length; y++) {
                        for (int i = 0; i < ((Hospital) centro).getHabitaciones()[y].length; i++) {
                            personas = aumentarArray(personas);
                            if (((Hospital) centro).getHabitaciones()[y][i] == null) ;
                            else {
                                personas[cont] = ((Hospital) centro).getHabitaciones()[y][i];
                                cont++;
                            }
                        }
                    }
                }
            }
            for (int x = 0; x < Centro.delPaciente.length; x++) {
                personas = aumentarArray(personas);
                if (Centro.delPaciente[x] == null) ;
                else {
                    personas[cont] = Centro.delPaciente[x];
                    cont++;
                }
            }
        } else {
            for (Centro centro : centros) {
                if (centro == null) ;
                else {
                    for (int x = 0; x < centro.getTrabajadores().length; x++) {
                        personas = aumentarArray(personas);
                        if (centro.getTrabajadores()[x] == null) ;
                        else {
                            personas[cont] = centro.getTrabajadores()[x];
                            cont++;
                        }
                    }
                }
            }
            for (int x = 0; x < Centro.delTrabajadores.length; x++) {
                personas = aumentarArray(personas);
                if (Centro.delTrabajadores[x] == null) ;
                else {
                    personas[cont] = Centro.delTrabajadores[x];
                    cont++;
                }
            }
        }

        shell_ascPersona(personas);
        for (Persona persona : personas) {
            if (persona == null) ;
            else {
                System.out.print(persona);
                if (persona.lugar > -1) {
                    System.out.print(" || Lugar: " + centros[persona.lugar].getNombreCentro());
                } else {
                    System.out.print(" || Lugar: Sin asignar");
                }
                if (persona instanceof Paciente && persona.lugar > -1) {
                    if (((Paciente) persona).consulta > -1) {
                        System.out.print(" || Consulta " + (((Paciente) persona).consulta + 1));
                    } else if (((Paciente) persona).planta > -1) {
                        System.out.print(" || Planta " + (((Paciente) persona).planta + 1) + " Habitacion " + (((Paciente) persona).habitacion + 1));
                    }
                }
                System.out.println();
            }
        }
    }

    private static void mostrarEstadisticaPac(int mes, Centro centro) {
        Persona[] personas = new Paciente[5];
        int cont = 0;
        for (int x = 0; x < centro.getConsultas().length; x++) {
            if (!Arrays.asList(personas).contains(null)) {
                Persona[] aux = new Persona[personas.length];
                for (int y = 0; y < aux.length; y++) {
                    aux[y] = personas[y];
                }
                personas = new Persona[aux.length * 2];
                for (int y = 0; y < aux.length; y++) {
                    personas[y] = aux[y];
                }
            }
            if (centro.getConsultas()[x] == null) ;
            else if (centro.getConsultas()[x].diaporMes(mes) > 0) {
                personas[cont] = centro.getConsultas()[x];
                cont++;
            }
        }
        if (centro instanceof Hospital) {
            for (int x = 0; x < ((Hospital) centro).getHabitaciones().length; x++) {
                for (int y = 0; y < ((Hospital) centro).getHabitaciones()[x].length; y++) {
                    if (((Hospital) centro).getHabitaciones()[x][y] == null) ;
                    else if (((Hospital) centro).getHabitaciones()[x][y].diaporMes(mes) > 0) {
                        personas[cont] = ((Hospital) centro).getHabitaciones()[x][y];
                        cont++;
                    }
                }
            }
        }
        shell_ascPersona(personas);
        for (int x = 0; x < personas.length; x++) {
            if (personas[x] == null) ;
            else {
                personas[x].mostrarEstado();
            }
        }
    }

    private static void mostrarEstadistica(int mes, Centro centro, int tipo) {
        int opcion;
        Persona[] personas = new Persona[5];
        int cont = 0;
        if(tipo == 1 || tipo == 2) {
            for (int x = 0; x < centro.getTrabajadores().length; x++) {
                if (!Arrays.asList(personas).contains(null)) {
                    Persona[] aux = new Persona[personas.length];
                    for (int y = 0; y < aux.length; y++) {
                        aux[y] = personas[y];
                    }
                    personas = new Persona[aux.length * 2];
                    for (int y = 0; y < aux.length; y++) {
                        personas[y] = aux[y];
                    }
                }
                if (centro.getTrabajadores()[x] == null) ;
                else if (tipo == 1 && centro.getTrabajadores()[x] instanceof Medico && centro.getTrabajadores()[x].diaporMes(mes) > 0) {
                        personas[cont] = centro.getTrabajadores()[x];
                        cont++;

                } else if (tipo == 2 && centro.getTrabajadores()[x] instanceof Administrativo && centro.getTrabajadores()[x].diaporMes(mes) > 0) {
                    personas[cont] = centro.getTrabajadores()[x];
                    cont++;
                }
            }
        }else {
            for (int x = 0; x < centro.getConsultas().length; x++) {
                if (!Arrays.asList(personas).contains(null)) {
                    Persona[] aux = new Persona[personas.length];
                    for (int y = 0; y < aux.length; y++) {
                        aux[y] = personas[y];
                    }
                    personas = new Persona[aux.length * 2];
                    for (int y = 0; y < aux.length; y++) {
                        personas[y] = aux[y];
                    }
                }
                if(centro.getConsultas()[x] == null);
                else if(centro.getConsultas()[x].diaporMes(mes) > 0){
                    personas[cont] = centro.getConsultas()[x];
                    cont++;
                }
            }
            if(centro instanceof Hospital){
                for(int x = 0; x < ((Hospital) centro).getHabitaciones().length; x++){
                    for(int y = 0; y < ((Hospital) centro).getHabitaciones()[x].length; y++){
                        if(((Hospital) centro).getHabitaciones()[x][y] == null);
                        else if(((Hospital) centro).getHabitaciones()[x][y].diaporMes(mes) > 0){
                            personas[cont] = centro.getConsultas()[x];
                            cont++;
                        }
                    }
                }
            }
        }
        if (cont == 1) {
            personas[cont - 1].mostrarEstado();
        } else {
            shell_ascPersona(personas);
            cont = 0;
            for (int x = 0; x < personas.length; x++) {
                if (personas[x] == null) ;
                else {
                    System.out.println((x + 1) + "-." + personas[x].getNombre() + " " + personas[x].getApellido1() + " " + personas[x].getApellido2());
                    cont++;
                }
            }
            if (cont == 0) {
                System.out.println("No hay nada creado");
            } else {
                opcion = PeticionDatos.pedirEnteroRango(1, cont, 3, "Dame una opcion: ");
                personas[opcion - 1].mostrarEstado();
            }
        }
    }

    private static void añadirDia(Persona persona) {
        Fecha fecha = new Fecha();
        int anio, mes, dia;
        if (persona instanceof Medico) {
            do {
                anio = PeticionDatos.pedirEntero("Año: ");
                mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Mes: ");
                dia = PeticionDatos.pedirEnteroRango(1, Fecha.rangoDia(mes, anio), 3, "Dia: ");
                fecha.setFechaCompleta(dia, mes, anio);
            } while (!((Medico) persona).addDiasTrabajados(fecha));
        } else if (persona instanceof Administrativo) {
            do {
                anio = PeticionDatos.pedirEntero("Año: ");
                mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Mes: ");
                dia = PeticionDatos.pedirEnteroRango(1, Fecha.rangoDia(mes, anio), 3, "Dia: ");
                fecha.setFechaCompleta(dia, mes, anio);
            } while (!((Administrativo) persona).addDiasTrabajados(fecha));
        } else if (persona instanceof Paciente) {
            do {
                anio = PeticionDatos.pedirEntero("Año: ");
                mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Mes: ");
                dia = PeticionDatos.pedirEnteroRango(1, Fecha.rangoDia(mes, anio), 3, "Dia: ");
                fecha.setFechaCompleta(dia, mes, anio);
            } while (!((Paciente) persona).addVisita(fecha));
        }
    }


    private static int encontrarCentro(Centro[] centros, int tipo) {
        Centro[] aux = new Centro[centros.length];
        int cont = 0, elegir;
        for (Centro centro : centros) {
            if (centro == null) {
            } else if (centro instanceof Hospital && tipo == 0) {
                aux[cont] = centro;
                cont++;
            } else if (centro instanceof Clinica && tipo == 1) {
                aux[cont] = centro;
                cont++;
            } else if (tipo == 2) {
                aux[cont] = centro;
                cont++;
            }
        }
        shell_ascCentros(aux);
        for (int x = 0; x < aux.length; x++) {
            if (aux[x] == null) ;
            else {
                System.out.println((x + 1) + ".- ID " + aux[x].getIdentificador() + " " + aux[x].getNombreCentro());
            }
        }
        elegir = PeticionDatos.pedirEnteroRango(1, cont, 3, "Dame una opcion: ");
        for (int x = 0; x < centros.length; x++) {
            if (centros[x] == null) ;
            else if (centros[x].getNombreCentro().equalsIgnoreCase(aux[elegir - 1].getNombreCentro())) {
                cont = x;
            }
        }
        return cont;
    }

    private static void nuevoCentro(Centro centro, GestionMedica gestion) {
        aumentarArray(gestion);
        for (int x = 0; x < gestion.centrosMedicos.length; x++) {
            if (gestion.centrosMedicos[x] == null) {
                gestion.centrosMedicos[x] = centro;
                break;
            }
        }
    }

    private static boolean delCentro(GestionMedica gestion, int tipo) {
        int x;
        System.out.println("¿Que hospital desea eliminar?");
        if (tipo == 1) {
            x = encontrarCentro(gestion.centrosMedicos, 0);
        } else {
            x = encontrarCentro(gestion.centrosMedicos, 1);
        }

        if (gestion.centrosMedicos[x] instanceof Hospital) {
            for (int j = 0; j < ((Hospital) gestion.centrosMedicos[x]).getHabitaciones().length; j++) {
                for (int y = 0; y < ((Hospital) gestion.centrosMedicos[x]).getHabitaciones()[j].length; y++) {
                    if (((Hospital) gestion.centrosMedicos[x]).getHabitaciones()[j][y] == null) ;
                    else {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < gestion.centrosMedicos[x].getConsultas().length; i++) {
            if (gestion.centrosMedicos[x].getConsultas()[i] == null) ;
            else {
                return false;
            }
        }

        for (int y = 0; y < gestion.centrosMedicos[x].getTrabajadores().length; y++) {
            if (gestion.centrosMedicos[x].getTrabajadores()[y] == null) ;
            else {
                return false;
            }
        }
        gestion.centrosMedicos[x] = null;
        return true;
    }

    private static void aumentarArray(GestionMedica gestionMedica) {
        if (!Arrays.asList(gestionMedica.centrosMedicos).contains(null)) {//Arrays.asList nos permite buscar en el array el valor que deseemos, en este caso un null
            Centro[] aux = new Centro[gestionMedica.centrosMedicos.length];
            for (int x = 0; x < aux.length; x++) {
                aux[x] = gestionMedica.centrosMedicos[x];
            }
            gestionMedica.centrosMedicos = new Centro[aux.length * 2];
            for (int x = 0; x < aux.length; x++) {
                gestionMedica.centrosMedicos[x] = aux[x];
            }
        }
    }

    private static Persona[] aumentarArray(Persona[] array) {
        if (!Arrays.asList(array).contains(null)) {//Arrays.asList nos permite buscar en el array el valor que deseemos, en este caso un null
            Persona[] aux = new Persona[array.length];
            for (int x = 0; x < aux.length; x++) {
                aux[x] = array[x];
            }
            array = new Persona[aux.length * 2];
            for (int x = 0; x < aux.length; x++) {
                array[x] = aux[x];
            }
        }
        return array;
    }


    private static Centro crearCentro(int tipo) {
        String nombre, direccion;
        int limiteConsultas, plantas, habitacionesPorPlanta;
        //todo comprobar que el nombre no esta repetido
        nombre = PeticionDatos.pedirCadena("Nombre del centro:");
        direccion = PeticionDatos.pedirCadenaLimite(true, true, 100, "Direccion del centro: ");//todo cambiar para permitir numeros
        limiteConsultas = PeticionDatos.pedirEntero("Numero de consultas: ");
        if (tipo == 0) {
            plantas = PeticionDatos.pedirEntero("Numero de plantas del centro: ");
            habitacionesPorPlanta = PeticionDatos.pedirEntero("Numero de habitaciones por planta: ");
            return new Hospital(nombre, direccion, limiteConsultas, plantas, habitacionesPorPlanta);
        } else if (tipo == 1) {
            return new Clinica(nombre, direccion, limiteConsultas);
        }
        return null;
    }

    private static void editarCentro(Centro centro) {
        //todo comprobar que el nombre no esta repetido
        centro.setNombreCentro(PeticionDatos.pedirCadena("Nombre del centro:"));
        centro.setDireccionCentro(PeticionDatos.pedirCadena("Direccion del centro: "));//todo cambiar para permitir numeros
    }

    /**
     * @param numTipo 0=Persona, 1=Medico, 2=Administrativo
     * @return devuelve un objeto con la informacion necesaria de tipo Persona
     */

    private static Persona crearPersona(int numTipo, String dni) {
        String nombre, apellido1, apellido2, genero, posicion = "";
        int dia, mes, anio;
        Fecha fecha = new Fecha();
        nombre = PeticionDatos.pedirCadena("Nombre: ");
        apellido1 = PeticionDatos.pedirCadena("1er apellido: ");
        apellido2 = PeticionDatos.pedirCadena("2o apellido: ");
        do {
            genero = PeticionDatos.pedirCadena("Genero (Masculino/Femenino/Sin Definir): ");
            if (!Medico.validarGenero(genero)) {
                System.out.println("Genero no valido");
            }
        } while (!Persona.validarGenero(genero));
        if (numTipo == 0) {
            do {
                anio = PeticionDatos.pedirEntero("Año de nacimiento: ");
                mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Mes de nacimiento: ");
                dia = PeticionDatos.pedirEnteroRango(1, Fecha.rangoDia(mes, anio), 3, "Dia de nacimiento: ");
                fecha.setFechaCompleta(dia, mes, anio);
            } while (!Paciente.validarFechaNacimiento(fecha));
        } else if (numTipo == 1) {
            do {
                anio = PeticionDatos.pedirEntero("Año de nacimiento: ");
                mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Mes de nacimiento: ");
                dia = PeticionDatos.pedirEnteroRango(1, Fecha.rangoDia(mes, anio), 3, "Dia de nacimiento: ");
                fecha.setFechaCompleta(dia, mes, anio);
            } while (!Medico.validarFechaNacimiento(fecha));
        } else if (numTipo == 2) {
            do {
                anio = PeticionDatos.pedirEntero("Año de nacimiento: ");
                mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Mes de nacimiento: ");
                dia = PeticionDatos.pedirEnteroRango(1, Fecha.rangoDia(mes, anio), 3, "Dia de nacimiento: ");
                fecha.setFechaCompleta(dia, mes, anio);
            } while (!Administrativo.validarFechaNacimiento(fecha));
        }

        if (numTipo == 1) {
            do {
                posicion = PeticionDatos.pedirCadena("Especialidad del medico: ");
            } while (!Medico.comprobarEspecialidad(posicion));
        } else if (numTipo == 2) {
            do {
                posicion = PeticionDatos.pedirCadena("Especialidad del administrativo: ");
            } while (!Administrativo.comprobarEspecialidad(posicion));
        }

        if (numTipo == 0) {
            return new Paciente(dni, nombre, apellido1, apellido2, genero, fecha);
        } else if (numTipo == 1) {
            return new Medico(dni, nombre, apellido1, apellido2, genero, fecha, posicion);
        } else if (numTipo == 2) {
            return new Administrativo(dni, nombre, apellido1, apellido2, genero, fecha, posicion);
        }
        return null;
    }

    //todo en caso de que el campo se deje vacio el valor se quedara como el antiguo
    private static void editarPersona(Persona persona, int numTipo) {
        String genero, posicion;
        int dia, mes, anio;
        Fecha fecha = new Fecha();
        persona.setNombre(PeticionDatos.pedirCadena("Nombre[" + persona.getNombre() + "]: "));
        persona.setApellido1(PeticionDatos.pedirCadena("1e apellido[" + persona.getApellido1() + "]: "));
        persona.setApellido2(PeticionDatos.pedirCadena("2o apellido[" + persona.getApellido2() + "]: "));
        do {
            genero = PeticionDatos.pedirCadena("Genero " + persona.getGenero() + "(Masculino/Femenino/Sin Definir): ");
            if (!Medico.validarGenero(genero)) {
                System.out.println("Genero no valido");
            }
        } while (!Persona.validarGenero(genero));

        if (numTipo == 0) {
            do {
                anio = PeticionDatos.pedirEntero("Año de nacimiento: ");
                mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Mes de nacimiento: ");
                dia = PeticionDatos.pedirEnteroRango(1, Fecha.rangoDia(mes, anio), 3, "Dia de nacimiento: ");
                fecha.setFechaCompleta(dia, mes, anio);
            } while (!Paciente.validarFechaNacimiento(fecha));
        } else if (numTipo == 1) {
            do {
                anio = PeticionDatos.pedirEntero("Año de nacimiento: ");
                mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Mes de nacimiento: ");
                dia = PeticionDatos.pedirEnteroRango(1, Fecha.rangoDia(mes, anio), 3, "Dia de nacimiento: ");
                fecha.setFechaCompleta(dia, mes, anio);
            } while (!Medico.validarFechaNacimiento(fecha));
        } else if (numTipo == 2) {
            do {
                anio = PeticionDatos.pedirEntero("Año de nacimiento: ");
                mes = PeticionDatos.pedirEnteroRango(1, 12, 3, "Mes de nacimiento: ");
                dia = PeticionDatos.pedirEnteroRango(1, Fecha.rangoDia(mes, anio), 3, "Dia de nacimiento: ");
                fecha.setFechaCompleta(dia, mes, anio);
            } while (!Administrativo.validarFechaNacimiento(fecha));
            persona.setFechaNacimiento(fecha);
        }

        if (numTipo == 1) {
            do {
                posicion = PeticionDatos.pedirCadena("Especialidad del medico: ");
            } while (!Medico.comprobarEspecialidad(posicion));
            ((Medico) persona).setEspecialidad(posicion);
        } else if (numTipo == 2) {
            do {
                posicion = PeticionDatos.pedirCadena("Especialidad del administrativo: ");
            } while (!Administrativo.comprobarEspecialidad(posicion));
            ((Administrativo) persona).setArea(posicion);
        }
    }

    private static void añadirPersona(Centro[] centro, Persona persona, int numTipo) {
        int x, planta, habitacion;
        boolean ocupado;
        Fecha fecha = new Fecha();
        fecha.setFechaCompleta(DIAHOY.getDayOfMonth(), DIAHOY.getMonthValue(), DIAHOY.getYear());

        System.out.println("\n¿A que hospital o clinica se asignara la persona?");
        x = encontrarCentro(centro, 2);
        if (numTipo == 0) {
            ((Paciente) persona).addVisita(fecha);
            System.out.println("Los quieres añadir a la consulta(1) o una habitacion en planta(2)");
            if (PeticionDatos.pedirEnteroRango(1, 2, 3, "Dame una opcion: ") == 1) {
                if (persona.lugar > -1) {
                    centro[persona.lugar].getConsultas()[((Paciente) persona).consulta] = null;
                }
                if (centro[x] instanceof Hospital) {
                    do {
                        ocupado = ((Hospital) centro[x]).addPaciente((Paciente) persona, PeticionDatos.pedirEnteroRango(1, centro[x].limiteConsultas, 3, "Dame un numero de consulta(1/" + centro[x].limiteConsultas + "): "));
                        if (!ocupado) {
                            System.out.println("Consulta ocupada");
                        }
                    } while (!ocupado);
                    persona.lugar = x;
                } else {
                    do {
                        ocupado = !((Clinica) centro[x]).addPaciente((Paciente) persona, PeticionDatos.pedirEnteroRango(1, centro[x].limiteConsultas, 3, "Dame un numero de consulta(1/" + centro[x].limiteConsultas + "): "));
                        if (!ocupado) {
                            System.out.println("Consulta ocupada");
                        }
                    } while (!ocupado);
                    persona.lugar = x;
                }
            } else {
                if (persona.lugar > -1) {
                    ((Hospital) centro[persona.lugar]).getHabitaciones()[((Paciente) persona).planta][((Paciente) persona).habitacion] = null;
                }
                do {
                    planta = PeticionDatos.pedirEnteroRango(1, ((Hospital) centro[x]).plantas, 3, "Numero de planta: ");
                    habitacion = PeticionDatos.pedirEnteroRango(1, ((Hospital) centro[x]).habitacionesPorPlanta, 3, "Numero de habitacion: ");
                    ocupado = ((Hospital) centro[x]).addPaciente((Paciente) persona, planta, habitacion);
                    if (!ocupado) {
                        System.out.println("Habitacion ocupada");
                    }
                } while (!ocupado);
                ((Hospital) centro[x]).addPaciente((Paciente) persona, planta, habitacion);
                persona.lugar = x;
            }
        } else {
            if (persona.lugar > -1) {
                centro[persona.lugar].getTrabajadores()[persona.posArray] = null;
            }
            persona.lugar = x;
            centro[x].addTrabajador(persona);
        }
    }

    private static void shell_ascCentros(Centro[] v) {
        int d, i;
        boolean ordenado;
        Centro aux;
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
                    if (v[i].getIdentificador() > v[i + d].getIdentificador()) {
                        aux = v[i];
                        v[i] = v[i + d];
                        v[i + d] = aux;
                        ordenado = false;
                    }
            }
            d = d / 2;
        }
    }


    private static void shell_ascPersona(Persona[] v) {
        int d, i;
        boolean ordenado;
        Persona aux;
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
                    if (v[i].getIdentificador() > v[i + d].getIdentificador()) {
                        aux = v[i];
                        v[i] = v[i + d];
                        v[i + d] = aux;
                        ordenado = false;
                    }
            }
            d = d / 2;
        }
    }

    private static Persona personaAle(int numTipo, Centro[] centros) {
        String nombre, apellido1, apellido2, genero, posicion = "", dni;
        Fecha fecha = new Fecha();
        nombre = Faker.nombres();
        apellido1 = Faker.apellidos();
        apellido2 = Faker.apellidos();
        do {
            genero = Faker.genero();
        } while (!Persona.validarGenero(genero));
        if (numTipo == 1) {
            do {
                fecha = Faker.fechaAleatoria(1900, DIAHOY.getYear());
            } while (!Medico.validarFechaNacimiento(fecha));
        } else if (numTipo == 2) {
            do {
                fecha = Faker.fechaAleatoria(1900, DIAHOY.getYear());
            } while (!Administrativo.validarFechaNacimiento(fecha));
        }

        if (numTipo == 1) {
            do {
                posicion = Faker.especialidadMedico();
            } while (!Medico.comprobarEspecialidad(posicion));
        } else if (numTipo == 2) {
            do {
                posicion = posicion = Faker.especialidadAdministrativo();
            } while (!Administrativo.comprobarEspecialidad(posicion));
        }

        do {
            dni = Faker.DNI();
        } while (Persona.existePers(centros, dni, 1) != null);

        if (numTipo == 1) {
            return new Medico(dni, nombre, apellido1, apellido2, genero, fecha, posicion);
        } else if (numTipo == 2) {
            return new Administrativo(dni, nombre, apellido1, apellido2, genero, fecha, posicion);
        }
        return null;
    }

    private static GestionMedica cargarFicheros() throws IOException, ClassNotFoundException {
        String nombre, direccion;
        boolean comprobar;
        Random r1 = new Random();
        GestionMedica gestion;
        File fichero = new File("objetos.dat");
        int[] array;
        int cont;
        if (fichero.exists()) {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream("objetos.dat"));
            ObjectInputStream arrayescribir = new ObjectInputStream(new FileInputStream("AtributosStatic.dat"));
            ObjectInputStream trabajadores = new ObjectInputStream(new FileInputStream("trabajadores.dat"));
            ObjectInputStream pacientes = new ObjectInputStream(new FileInputStream("pacientes.dat"));
            gestion = (GestionMedica) lectura.readObject();
            array = (int[]) arrayescribir.readObject();
            Centro.delTrabajadores = (Persona[]) trabajadores.readObject();
            Centro.delPaciente = (Persona[]) pacientes.readObject();
            Persona.contID = array[0];
            Centro.contID = array[1];
            Centro.contCentros = array[2];
            lectura.close();
            arrayescribir.close();
            trabajadores.close();
            pacientes.close();
        } else {
            gestion = new GestionMedica(5);
            for (int x = 0; x < 4; x += 2) {
                do {
                    comprobar = true;
                    nombre = Faker.nombreCent();
                    if (!Centro.validarNombre(nombre, gestion.centrosMedicos)) {
                        comprobar = false;
                    }
                } while (!comprobar);
                do {
                    comprobar = true;
                    direccion = Faker.nombreDireccion();
                    if (!Centro.validarDireccion(direccion, gestion.centrosMedicos)) {
                        comprobar = false;
                    }
                } while (!comprobar);
                gestion.centrosMedicos[x] = new Hospital(nombre, direccion, r1.nextInt(3, 7), r1.nextInt(3, 9), r1.nextInt(5, 16));
                cont = 0;
                for (int y = 0; y < 2; y++) {
                    gestion.centrosMedicos[x].addTrabajador(personaAle(1, gestion.centrosMedicos));
                    gestion.centrosMedicos[x].getTrabajadores()[cont].lugar = x;
                    cont++;
                    gestion.centrosMedicos[x].addTrabajador(personaAle(2, gestion.centrosMedicos));
                    gestion.centrosMedicos[x].getTrabajadores()[cont].lugar = x;
                    cont++;
                }
                do {
                    comprobar = true;
                    nombre = Faker.nombreCent();
                    if (!Centro.validarNombre(nombre, gestion.centrosMedicos)) {
                        comprobar = false;
                    }
                } while (!comprobar);
                do {
                    comprobar = true;
                    direccion = Faker.nombreDireccion();
                    if (!Centro.validarDireccion(direccion, gestion.centrosMedicos)) {
                        comprobar = false;
                    }
                } while (!comprobar);
                gestion.centrosMedicos[x + 1] = new Clinica(nombre, direccion, r1.nextInt(3, 7));
                cont = 0;
                for (int y = 0; y < 2; y++) {
                    gestion.centrosMedicos[x + 1].addTrabajador(personaAle(1, gestion.centrosMedicos));
                    gestion.centrosMedicos[x + 1].getTrabajadores()[cont].lugar = x + 1;
                    cont++;
                    gestion.centrosMedicos[x + 1].addTrabajador(personaAle(2, gestion.centrosMedicos));
                    gestion.centrosMedicos[x + 1].getTrabajadores()[cont].lugar = x + 1;
                    cont++;
                }
            }
        }
        return gestion;
    }

}