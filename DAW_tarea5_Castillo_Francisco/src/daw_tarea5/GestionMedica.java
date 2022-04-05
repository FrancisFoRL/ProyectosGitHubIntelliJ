package daw_tarea5;

import libreria.PeticionDatos;
import librerias.Fecha;

import java.time.Year;

//todo Hacer funcion de busqueda de DNI y otra que compruebe que los DNI no esten repetidos
public class GestionMedica {
    private Centro[] centrosMedicos;
    private final int TAMANIO = 5;
    private final int year = Year.now().getValue();

    public GestionMedica(int tamanio) {
        centrosMedicos = new Centro[tamanio];
    }

    public Centro[] getCentrosMedicos() {
        return centrosMedicos;
    }

    public static void main(String[] args) {
        //todo añadir bucle que añada dos hospitales y dos clinicas a el array principal
        //todo añadir funcio que añada y elimine hospitales
        String dni;
        int numPers;
        Persona persona;
        GestionMedica gestion = new GestionMedica(5);
        int opcion, peticion;
        for (int x = 0; x < 4; x+=2) {
            gestion.getCentrosMedicos()[x] = new Hospital("VIA", "VIA", 5, 5, 5);
            gestion.getCentrosMedicos()[x + 1] = new Clinica("CLI", "CLI", 4);

        }
        do {
            System.out.println("0. Salir aplicacion");
            System.out.println("1. Gestion Hospital");
            System.out.println("2. Gestion Clinica");
            System.out.println("3. Gestion Personal");
            System.out.println("4. Gestion Paciente");
            System.out.println("5. Sacar estadisticas Centros Medicos");
            System.out.println("6. Sacar estadisticas Personal");


            switch (opcion = PeticionDatos.pedirEnteroRango(0, 6, 3, "Dame una opcion: ")) {


                case 1: {

                }

                case 2: {

                }
                case 3: {
                    do {
                        System.out.println("1. Crear nuevo trabajdor");
                        System.out.println("2. Modificar datos de un trabajador");
                        System.out.println("3. Volver al menu principal");

                        switch (opcion = PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion: ")) {
                            case 1: {
                                dni = PeticionDatos.pedirNIF_NIE();
                                if (Persona.existePers(gestion.getCentrosMedicos(), dni, 1) == null) {
                                    System.out.println("¿El nuevo trabajador sera Medico(1) o Administrativo(2)?");
                                    persona = crearPersona(PeticionDatos.pedirEnteroRango(1, 2, 3, "Dame un opcion: "), dni);
                                } else {
                                    if (Persona.existePers(gestion.getCentrosMedicos(), dni, 1) instanceof Medico) {
                                        numPers = 1;
                                    } else {
                                        numPers = 2;
                                    }
                                    persona = Persona.existePers(gestion.getCentrosMedicos(), dni, numPers);
                                    System.out.println("La persona con DNI "+persona.getDni() + " existe: ");
                                    System.out.println(persona);//todo cambiar String persona para mostrarlo bien
                                }
                                //todo al crear uno nuevo mostrar este menu o asignar directamente en la creacion?
                                //todo comprobar que el array no este lleno de trajadores, crear funcion que aumente
                                System.out.println("1. Asignar a hospital/clinica");
                                System.out.println("2. Modificar datos del medico");
                                System.out.println("3. Despedir");

                                switch (opcion = PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion: ")) {
                                    case 1: {
                                        mostrarHosCli(gestion.getCentrosMedicos());
                                        peticion = PeticionDatos.pedirEnteroRango(1, Centro.contCentros, 3, "Dame una opcion: ");
                                        ((Medico) persona).lugar = peticion-1;
                                        gestion.getCentrosMedicos()[peticion - 1].addTrabajador(persona);
                                        break;
                                    }
                                    case 2: {
                                        persona = crearPersona(3, dni);
                                    }
                                    case 3: {
                                        gestion.getCentrosMedicos()[((Medico) persona).lugar].removeTrabajador(persona.getDni());
                                    }
                                }
                            }
                            case 2: {
                                //todo comprobar persona porque pone no inicializado
                                //persona = crearPersona(numPers,dni);
                            }

                        }
                    } while (opcion != 3);
                }
                case 4: {

                }
                case 5: {

                }
                case 6: {

                }
            }
        } while (opcion != 0);
    }

    private static void mostrarHosCli(Centro[] centro) {
        for (int x = 1; x <= Centro.contCentros; x++) {
            System.out.println(x + ".- ID " + centro[x-1].getIdentificador() + " " + centro[x-1].getNombreCentro());
        }
    }


    private static Centro crearCentro(int tipo) {
        String nombre, direccion;
        int limiteConsultas, plantas, habitacionesPorPlanta;

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
                mes = PeticionDatos.pedirEntero("Mes de nacimiento: ");
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
                mes = PeticionDatos.pedirEntero("Mes de nacimiento: ");
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

    /**
     * Funcion que comprueba los DNI de un array de tipo Persona. Comprueba que el Dni pasado por parametro no este usado ya en el array.
     * @param num 0=Persona, 1=Medico, 2=Administrativo.
     * @param dni Dni que se comprobara que no este en el array.
     * @return devuelve true si el DNI no se encuentra en le array y false si ya esta usado por otra persona.
     */

    //todo funcion que busca el dni.
    //todo comprobar funcion comprobar Dni, por a nivel de consultas y hospitales
    //todo añadir comprobar dni de los objetos guardados en ficheros
    /*
    private static boolean comprobarDNI(Centro centrosMedicos,String dni, int num) {
        if (num == 0) {
            for (Centro centro : centrosMedicos) {
                if (centro instanceof Hospital) {
                    for (int i = 0; i < ((Hospital) centro).getHabitaciones().length; i++) {
                        for (int j = 0; j < ((Hospital) centro).getHabitaciones()[i].length; j++) {
                            if (((Hospital) centro).getHabitaciones()[i][j] == null) ;
                            else if (((Hospital) centro).getHabitaciones()[i][j].getDni().equals(dni)) return false;
                        }
                    }
                    for (int i = 0; i < centro.getConsultas().length; i++) {
                        if (centro.getConsultas()[i] == null) ;
                        else if (centro.getConsultas()[i].getDni().equals(dni)) return false;
                    }
                } else if (centro instanceof Clinica) {
                    for (int i = 0; i < centro.getConsultas().length; i++) {
                        if (centro.getConsultas()[i] == null) ;
                        else if (centro.getConsultas()[i].getDni().equals(dni)) return false;
                    }
                }
            }
        } else {
            for (Centro centro : centrosMedicos) {
                if (centro instanceof Hospital) {
                    for (int i = 0; i < centro.getTrabajadores().length; i++) {
                        if (centro.getTrabajadores()[i] == null) ;
                        else {
                            if (centro.getTrabajadores()[i] instanceof Medico && num == 1) {
                                if (centro.getTrabajadores()[i].getDni().equals(dni)) return false;
                            } else if (centro.getTrabajadores()[i] instanceof Administrativo && num == 2) {
                                if (centro.getTrabajadores()[i].getDni().equals(dni)) return false;
                            }
                        }
                    }
                } else if (centro instanceof Clinica) {
                    for (int i = 0; i < centro.getTrabajadores().length; i++) {
                        if (centro.getTrabajadores()[i] == null) ;
                        else {
                            if (centro.getTrabajadores()[i] instanceof Medico && num == 1) {
                                if (centro.getTrabajadores()[i].getDni().equals(dni)) return false;
                            } else if (centro.getTrabajadores()[i] instanceof Administrativo && num == 2) {
                                if (centro.getTrabajadores()[i].getDni().equals(dni)) return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
     */
}
