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

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("0. Salir aplicacion");
            System.out.println("1. Gestion Medica");
            System.out.println("2. Gestion Clinica");
            System.out.println("3. Gestion Personal");
            System.out.println("4. Gestion Paciente");
            System.out.println("5. Sacar estadisticas Centros Medicos");
            System.out.println("6. Sacar estadisticas Personal");


            switch (opcion = PeticionDatos.pedirEnteroRango(0, 6, 3, "Dame una opcion: ")) {
                case 1: {
                    System.out.println("1. Crear nuevo medico");
                    System.out.println("2. Modificar datos de un medico");
                    System.out.println("3. Volver al menu principal");

                    switch (opcion = PeticionDatos.pedirEnteroRango(1, 3, 3, "Dame una opcion: ")) {
                        case 1: {

                        }

                    }
                }
                case 2: {

                }
                case 3: {

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

    private Persona crearPersona(int numTipo) {
        String dni, nombre, apellido1, apellido2, genero, posicion;
        int dia, mes, anio;
        Fecha fecha;
        do {
            dni = PeticionDatos.pedirNIF_NIE();
            if (!comprobarDNI(dni, numTipo)) {
                System.out.println("DNI en uso");
            }
        } while (!comprobarDNI(dni, numTipo));
        nombre = PeticionDatos.pedirCadena("Nombre: ");
        apellido1 = PeticionDatos.pedirCadena("1er apellido: ");
        apellido2 = PeticionDatos.pedirCadena("2o apellido: ");
        do {
            genero = PeticionDatos.pedirCadena("Genero (Masculino/Femenino/Sin Definir): ");
            if (!Persona.validarGenero(genero)) {
                System.out.println("Genero no valido");
            }
        } while (!Persona.validarGenero(genero));
        if (numTipo == 0) {
            //TODO como usar el validar Fecha naciento de Persona?
        }

        //Todo No puedo hacer Persona persona = new Persona();
        return null;
    }

    /**
     * Funcion que comprueba los DNI de un array de tipo Persona. Comprueba que el Dni pasado por parametro no este usado ya en el array.
     *
     * @param num
     * @param dni Dni que se comprobara que no este en el array.
     * @return devuelve true si el DNI no se encuentra en le array y false si ya esta usado por otra persona.
     */
    //todo comprobar funcion comprobar Dni, por tema de cosultas y hospitales
    //todo añadir comprobar dni de los objetos guardados en ficheros
    private boolean comprobarDNI(String dni, int num) {
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
}
