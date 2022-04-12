package daw_tarea5;

import libreria.PeticionDatos;
import librerias.Fecha;

import java.io.*;
import java.time.Year;
import java.util.Arrays;

//todo Hacer funcion de busqueda de DNI y otra que compruebe que los DNI no esten repetidos
public class GestionMedica implements Serializable {
    private Centro[] centrosMedicos;
    private final int TAMANIO = 5;
    private final int year = Year.now().getValue();

    public GestionMedica(int tamanio) {
        centrosMedicos = new Centro[tamanio];
    }

    public Centro[] getCentrosMedicos() {
        return centrosMedicos;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //todo añadir bucle que añada dos hospitales y dos clinicas a el array principal
        //todo añadir funcion que añada y elimine hospitales
        //todo hace metodo con ordenacion a la hora de mostrar pacientes de un hospital, habra que crear un array auxiliar
        String dni;
        int numPers;
        Persona persona;
        File fichero = new File("objetos.dat");
        GestionMedica gestion;
        int[] array;
        int opcion, peticion, z;
        boolean control = fichero.exists();

        if (control) {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream("objetos.dat"));
            ObjectInputStream arrayescribir = new ObjectInputStream(new FileInputStream("AtributosStatic.dat"));
            gestion = (GestionMedica) lectura.readObject();
            array = (int[]) arrayescribir.readObject();
            Persona.contID = array[0];
            Centro.contID = array[1];
            Centro.contCentros = array[2];
            lectura.close();
            arrayescribir.close();
        } else {
            gestion = new GestionMedica(5);
            for (int x = 0; x < 4; x += 2) {
                gestion.getCentrosMedicos()[x] = new Hospital("Hola", "VIA", 5, 5, 5);
                gestion.getCentrosMedicos()[x + 1] = new Clinica("CLI", "CLI", 4);
            }
        }

        /*
        if (control) {
            if (PeticionDatos.pedirEnteroRango(1, 2, 3, "¿Quiere cargar el estado anterior del programa? Si(1)/No(2)") == 1) {
                ObjectInputStream escribir = new ObjectInputStream(new FileInputStream("objetos.dat"));
                gestion = (GestionMedica) escribir.readObject();
                escribir.close();
            }
            else
                control = false;
        }
        if (!control)
        {
            gestion = new GestionMedica(5);
            for (int x = 0; x < 4; x += 2) {
                gestion.getCentrosMedicos()[x] = new Hospital("Hola", "VIA", 5, 5, 5);
                gestion.getCentrosMedicos()[x + 1] = new Clinica("CLI", "CLI", 4);
            }
        }

         */

        do {
            System.out.println("0. Salir aplicacion");
            System.out.println("1. Gestion Hospital");
            System.out.println("2. Gestion Clinica");
            System.out.println("3. Gestion Personal");
            System.out.println("4. Gestion Paciente");
            System.out.println("5. Sacar estadisticas Centros Medicos");
            System.out.println("6. Sacar estadisticas Personal");

            switch (opcion = PeticionDatos.pedirEnteroRango(0, 6, 3, "Dame una opcion: ")) {

                case 1 -> {
                    System.out.println("1. Mostrar Hospitales existente");
                    System.out.println("2. Crear nuevo Hospital");
                    System.out.println("3. Eliminar Hospital");
                    System.out.println("4. Volver al menu principal");

                    switch (opcion = PeticionDatos.pedirEnteroRango(1, 4, 3, "Dame una opcion: ")) {
                        case 1 -> {
                            z = PeticionDatos.pedirEnteroRango(1, mostrarHosCli(gestion.centrosMedicos, 1), 3, "Dame una opcion: ");

                            System.out.println("1. Mostrar informacion del Hospital seleccionado");
                            System.out.println("2. Modificar datos del hospital seleccionado");
                            System.out.println("3. Volver al menu principal");

                            switch (peticion = PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion: ")) {
                                case 1 -> {
                                    gestion.getCentrosMedicos()[z - 1].mostrarEstado();
                                }
                                case 2 -> {
                                    editarCentro(gestion.getCentrosMedicos()[z - 1]);
                                }
                            }
                        }
                        case 2 -> {
                            nuevoCentro(crearCentro(0), gestion.getCentrosMedicos());
                        }
                        case 3 -> {
                            //todo hacer la eliminacion del hospital, si hay personas no se puede eliminar, si esta vacio se podra eliminar
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
                            z = PeticionDatos.pedirEnteroRango(1, mostrarHosCli(gestion.centrosMedicos, 2), 3, "Dame una opcion: ");

                            System.out.println("1. Mostrar informacion de la Clinica seleccionado");
                            System.out.println("2. Modificar datos de la Clinica seleccionado");
                            System.out.println("3. Volver al menu principal");

                            switch (PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion: ")) {
                                case 1 -> {
                                    gestion.getCentrosMedicos()[z - 1].mostrarEstado();
                                }
                                case 2 -> {
                                    editarCentro(gestion.getCentrosMedicos()[z - 1]);
                                }
                            }
                        }
                        case 2 -> {
                            nuevoCentro(crearCentro(1), gestion.getCentrosMedicos());
                        }
                        case 3 -> {
                            //todo hacer la eliminacion del hospital, si hay personas no se puede eliminar, si esta vacio se podra eliminar
                        }
                    }
                }
                case 3 -> {
                    System.out.println("1. Crear nuevo trabajador");
                    System.out.println("2. Modificar datos de un trabajador");
                    System.out.println("3. Volver al menu principal");

                    switch (opcion = PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion: ")) {
                        case 1 -> {
                            dni = PeticionDatos.pedirNIF_NIE();
                            if (Persona.existePers(gestion.getCentrosMedicos(), dni, 1) == null) {
                                System.out.println("¿El nuevo trabajador sera Medico(1) o Administrativo(2)?");
                                persona = crearPersona(PeticionDatos.pedirEnteroRango(1, 2, 3, "Dame un opcion: "), dni);
                                añadirPersona(gestion.getCentrosMedicos(), persona, 1);
                            } else {
                                if (Persona.existePers(gestion.getCentrosMedicos(), dni, 1) instanceof Medico) {
                                    numPers = 1;
                                } else {
                                    numPers = 2;
                                }
                                persona = Persona.existePers(gestion.getCentrosMedicos(), dni, numPers);
                                //todo comprobar que el array no este lleno de trajadores, crear funcion que aumente
                                System.out.println("La persona con DNI " + persona.getDni() + " existe: ");
                                System.out.println(persona);//todo cambiar String persona para mostrarlo bien
                                System.out.println("1. Asignar a hospital/clinica");
                                System.out.println("2. Modificar datos del medico");
                                System.out.println("3. Despedir");
                                System.out.println("4. Añadir dia trabajado");
                                System.out.println("5. Volver al menu principal");


                                switch (PeticionDatos.pedirEnteroRango(1, 5, 3, "Dame una opcion: ")) {
                                    case 1 -> {
                                        añadirPersona(gestion.getCentrosMedicos(), persona, 1);
                                    }
                                    case 2 -> {
                                        if (Persona.existePers(gestion.getCentrosMedicos(), dni, 1) instanceof Medico) {
                                            numPers = 1;
                                        } else {
                                            numPers = 2;
                                        }
                                        editarPersona(persona, numPers);
                                    }
                                    case 3 -> {
                                        if (gestion.getCentrosMedicos()[persona.lugar].removeTrabajador(persona)) {
                                            System.out.println("Se despidio al trabajador");
                                        } else {
                                            System.out.println("El trabajador no esta asingnado a ningun sitio");
                                        }

                                    }
                                    case 4 -> {
                                        añadirDia(persona);
                                    }
                                }
                            }
                        }
                        case 2 -> {
                            dni = PeticionDatos.pedirNIF_NIE();

                            if (Persona.existePers(gestion.getCentrosMedicos(), dni, 1) == null) {
                                System.out.println("El DNI que se ha especificado no corresponde a ninguna persona");
                            } else if (Persona.existePers(gestion.getCentrosMedicos(), dni, 1) instanceof Medico) {
                                editarPersona(Persona.existePers(gestion.getCentrosMedicos(), dni, 1), 1);
                            } else if (Persona.existePers(gestion.getCentrosMedicos(), dni, 1) instanceof Administrativo) {
                                editarPersona(Persona.existePers(gestion.getCentrosMedicos(), dni, 1), 2);
                            }
                        }
                    }
                }
                case 4 -> {
                    System.out.println("1. Crear nuevo paciente");
                    System.out.println("2. Modificar datos de un paciente");
                    System.out.println("3. Volver al menu principal");

                    switch (opcion = PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion: ")) {
                        case 1 -> {
                            dni = PeticionDatos.pedirNIF_NIE();
                            if (Persona.existePers(gestion.getCentrosMedicos(), dni, 0) == null) {
                                persona = crearPersona(0, dni);
                                añadirPersona(gestion.getCentrosMedicos(), persona, 0);
                            } else {
                                persona = Persona.existePers(gestion.getCentrosMedicos(), dni, 0);
                                System.out.println("La persona con DNI " + persona.getDni() + " existe: ");
                                System.out.println(persona);//todo cambiar String persona para mostrarlo bien
                                System.out.println("1. Asignar a hospital/clinica");
                                System.out.println("2. Modificar datos del paciente");
                                System.out.println("3. Dar alta");
                                System.out.println("4. Añadir visita medica");//todo añadir lo necesario para añadir visita medica

                                switch (PeticionDatos.pedirEnteroRango(1, 4, 3, "Dame una opcion: ")) {
                                    case 1 -> {
                                        añadirPersona(gestion.getCentrosMedicos(), persona, 0);
                                    }
                                    case 2 -> {
                                        editarPersona(persona, 0);
                                    }
                                    case 3 -> {
                                        if (gestion.getCentrosMedicos()[persona.lugar] instanceof Hospital) {
                                            if (((Hospital) gestion.getCentrosMedicos()[persona.lugar]).removePaciente((Paciente) persona)) {
                                                System.out.println("Se le dio de alta al paciente");
                                            } else {
                                                System.out.println("El paciente no esta asingnado a ningun sitio");
                                            }
                                        } else if (gestion.getCentrosMedicos()[persona.lugar] instanceof Clinica) {
                                            if (((Clinica) gestion.getCentrosMedicos()[persona.lugar]).removePaciente((Paciente) persona)) {
                                                System.out.println("Se le dio de alta al paciente");
                                            } else {
                                                System.out.println("El paciente no esta asingnado a ningun sitio");
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
                            dni = PeticionDatos.pedirNIF_NIE();
                            if (Persona.existePers(gestion.getCentrosMedicos(), dni, 1) == null) {
                                System.out.println("El paciente no existe");
                            } else {
                                editarPersona(Persona.existePers(gestion.getCentrosMedicos(), dni, 0), 0);
                            }

                            //todo hacer algo para saber posicion en la que esta guardada el medico o administrativa
                            //persona = Persona.existePers(gestion.getCentrosMedicos(), dni, numPers);
                            //persona = crearPersona(numPers,dni);
                        }
                    }
                }
                case 5 -> {

                }
                case 6 -> {

                }
            }
        } while (opcion != 0);
        if (PeticionDatos.pedirEnteroRango(1, 2, 3, "¿Desea guardar la informacion creada?Si(1)/No(2): ") == 1) {
            int[] guardar = {Persona.contID, Centro.contID, Centro.contCentros};
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("objetos.dat"));
            ObjectOutputStream atributos = new ObjectOutputStream(new FileOutputStream("AtributosStatic.dat"));
            escribiendoFichero.writeObject(gestion);
            atributos.writeObject(guardar);
            escribiendoFichero.close();
            atributos.close();
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

    private static int mostrarHosCli(Centro[] centro, int mostrar) {
        int cont = 0;
        for (int x = 1; x <= Centro.contCentros; x++) {
            if (mostrar == 1 && centro[x - 1] instanceof Hospital) {
                System.out.println(cont + 1 + ".- ID " + centro[x - 1].getIdentificador() + " Hospital " + centro[x - 1].getNombreCentro());
                cont++;
            } else if (mostrar == 2 && centro[x - 1] instanceof Clinica) {
                System.out.println(cont + 1 + ".- ID " + centro[x - 1].getIdentificador() + " Clinica " + centro[x - 1].getNombreCentro());
                cont++;
            } else if (mostrar == 3) {
                if (centro[x - 1] instanceof Hospital) {
                    System.out.println(x + ".- ID " + centro[x - 1].getIdentificador() + " Hospital " + centro[x - 1].getNombreCentro());
                    cont++;
                } else if (centro[x - 1] instanceof Clinica) {
                    System.out.println(x + ".- ID " + centro[x - 1].getIdentificador() + " Clinica " + centro[x - 1].getNombreCentro());
                    cont++;
                }
            }
        }
        return cont;
    }

    private static void nuevoCentro(Centro centro, Centro[] gestion) {
        gestion = aumentarArray(gestion);
        for (int x = 0; x < gestion.length; x++) {
            if (gestion[x] == null) {
                gestion[x] = centro;
                break;
            }
        }
    }

    private static Centro[] aumentarArray(Centro[] centro) {
        if (!Arrays.asList(centro).contains(null)) {//Arrays.asList nos permite buscar en el array el valor que deseemos, en este caso un null
            Centro[] aux = new Centro[centro.length];
            for (int x = 0; x < aux.length; x++) {
                aux[x] = centro[x];
            }
            centro = new Centro[aux.length * 2];
            for (int x = 0; x < aux.length; x++) {
                centro[x] = aux[x];
            }
        }
        return centro;
    }

    private static Centro crearCentro(int tipo) {
        String nombre, direccion;
        int limiteConsultas, plantas, habitacionesPorPlanta;
        //todo comprobar que el nombre no esta repetido
        nombre = PeticionDatos.pedirCadena("Nombre del centro:");
        direccion = PeticionDatos.pedirCadena("Direccion del centro: ");//todo cambiar para permitir numeros
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
                posicion = PeticionDatos.pedirCadena("Especialidad de medico: ");
            } while (!Medico.comprobarEspecialidad(posicion));
        } else if (numTipo == 2) {
            do {
                posicion = PeticionDatos.pedirCadena("Especialidad de medico: ");
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
                posicion = PeticionDatos.pedirCadena("Especialidad de medico: ");
            } while (!Medico.comprobarEspecialidad(posicion));
            ((Medico) persona).setEspecialidad(posicion);
        } else if (numTipo == 2) {
            do {
                posicion = PeticionDatos.pedirCadena("Especialidad de medico: ");
            } while (!Administrativo.comprobarEspecialidad(posicion));
            ((Administrativo) persona).setArea(posicion);
        }
    }

    private static void añadirPersona(Centro[] centro, Persona persona, int numTipo) {
        int x, planta, habitacion;
        boolean ocupado;
        System.out.println("\n¿A que hospital o clinica se asignara la persona?");
        x = PeticionDatos.pedirEnteroRango(1, mostrarHosCli(centro, 3), 3, "Dame una opcion: ") - 1;
        if (numTipo == 0) {
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

}
