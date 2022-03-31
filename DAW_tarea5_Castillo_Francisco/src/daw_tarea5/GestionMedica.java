package daw_tarea5;

import libreria.PeticionDatos;

//todo Hacer funcion de busqueda de DNI y otra que compruebe que los DNI no esten repetidos
public class GestionMedica {
    private Centro[] centrosMedicos = new Centro[10];

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

    private Persona crearPersona(){
        String dni = PeticionDatos.pedirNIF_NIE();
        String nombre = PeticionDatos.pedirCadena("Nombre: ");
        String apellido1 = PeticionDatos.pedirCadena("1er apellido: ");
        String apellido2 = PeticionDatos.pedirCadena("2o apellido: ");
        String genero = Persona.validarGenero(PeticionDatos.pedirCadena("Genero: "));
        Medico medico = new Medico(dni, nombre, apellido1, apellido2,);
        return
    }
}
