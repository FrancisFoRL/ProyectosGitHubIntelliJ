package federacion;

import libreria.PeticionDatos;

import java.time.Year;
import java.util.Random;

public class EquipoBaloncesto extends Equipo implements Estadisticas{

    //TODO comprobar array ESTATICO
    private static JugadorBaloncesto[] jugadorBaloncesto;
    protected int anotacionTotal;
    private int year = Year.now().getValue();

    public EquipoBaloncesto(String nombreEquipo) {
        super(nombreEquipo);
        jugadorBaloncesto = new JugadorBaloncesto[18];
        this.anotacionTotal = 0;
    }


    /**
     * Funcion de tipo JugadorBaloncesto que crear el objeto y lo rellena aleatoriamente o por teclado segun lo que se pase por el parametro.
     * Despues de rellenar toda la informacion del objeto, este se devolvera.
     * @param aleatorio Si el valor es true se creara un JugadorBaloncesto aleatorio usando la clase Faker sino se creara a partir de teclado
     * @return Objeto de tipo JugadorBaloncesto con todos los datos necesarios
     */
    public JugadorBaloncesto crearJugador(boolean aleatorio){
        Random num = new Random();
        int dorsal;
        JugadorBaloncesto jugadorBaloncesto = new JugadorBaloncesto();
        if(!aleatorio){
            jugadorBaloncesto.setNombre(PeticionDatos.pedirCadena("Nombre del jugador: "));
            jugadorBaloncesto.setApellido1(PeticionDatos.pedirCadena("1ª apellido del jugador: "));
            jugadorBaloncesto.setApellido2(PeticionDatos.pedirCadena("2º apellido del jugador: "));
            do {
                dorsal = PeticionDatos.pedirEnteroRango(1, 24, 3, "Dorsal del jugador: ");
            }while (!comprobarDorsal(dorsal));
            jugadorBaloncesto.setDorsal(dorsal);
            jugadorBaloncesto.setPuesto(PeticionDatos.pedirCadena("Puesto Jugador: "));
            //TODO generar fecha aleatoria en Faker
            //jugadorBaloncesto.setFechaNacimiento(); //TODO Revisar fecha de nacimiento, primero se comprueba que con Fecha se valido y despues que la edad este en el rango
            jugadorBaloncesto.setPartidosJugados(PeticionDatos.pedirEntero("Partidos jugados: "));
            jugadorBaloncesto.setMinutosJugados(PeticionDatos.pedirEntero("Minutos jugados: "));
            jugadorBaloncesto.setPartidosGanados(PeticionDatos.pedirEntero("Partidos ganados: "));
            jugadorBaloncesto.setPartidosPerdidos(PeticionDatos.pedirEntero("Partidos perdidos: "));
            jugadorBaloncesto.setAnotacion(PeticionDatos.pedirEntero("Puntos anotados: "));
        }else{
            //TODO Cambiar a aleatorio
            jugadorBaloncesto.setNombre(Faker.nombres());
            jugadorBaloncesto.setApellido1(Faker.apellidos());
            jugadorBaloncesto.setApellido2(Faker.apellidos());
            do {
                dorsal = num.nextInt(4,24);
            }while (!comprobarDorsal(dorsal));
            jugadorBaloncesto.setFechaNacimiento(Faker.fechaAleatoria(year-65,year-8));
            jugadorBaloncesto.setPuesto(Faker.puestoBaloncesto());
            jugadorBaloncesto.setDorsal(dorsal);
            jugadorBaloncesto.setPartidosJugados(num.nextInt(0,40));
            jugadorBaloncesto.setMinutosJugados(num.nextInt(0,1600));
            jugadorBaloncesto.setPartidosGanados(num.nextInt(0,5));
            jugadorBaloncesto.setPartidosPerdidos(jugadorBaloncesto.partidosJugados-jugadorBaloncesto.partidosGanados);
            jugadorBaloncesto.setAnotacion(num.nextInt(0,250));
            //TODO preguntar a David
            System.out.println(partidosJugados+" + "+partidosGanados);
            System.out.println(jugadorBaloncesto.partidosJugados+" + "+jugadorBaloncesto.getPartidosGanados());
        }
        this.jugadorBaloncesto[0] = jugadorBaloncesto;
        return jugadorBaloncesto;
    }
    private static void asignaArray(JugadorBaloncesto jugador){
        jugadorBaloncesto[0]=jugador;
    }

    //TODO JugadorBaloncesto con todos lo parametros necesarios para crear el objeto
    //TODO Necesario crear constructor con parametros
    public JugadorBaloncesto crearJugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal, int minutosJugados, int partidosJugados, int partidosGanados, int partidosPerdidos, int anotaciones){
        JugadorBaloncesto jugadorBaloncesto = new JugadorBaloncesto(nombre, apellido1, apellido2,puesto, fechaNacimiento, dorsal, minutosJugados, partidosJugados,  partidosGanados, partidosPerdidos, anotaciones);
        return jugadorBaloncesto;
    }



    private static boolean comprobarDorsal(int dorsal) {
        if(JugadorBaloncesto.totalJugadores == 1){
            return true;
        }else {
            for (int array = 0; array < JugadorBaloncesto.totalJugadores - 1; array++) {
                if (jugadorBaloncesto[array].getDorsal() == dorsal) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void setNombreEquipo(String nombreEquipo) {
        super.setNombreEquipo(nombreEquipo);
    }

    @Override
    public double porcentajeVictorias() {
        return (partidosGanados / partidosJugados)*100;
    }


    //TODO Comprobar valoracion
    @Override
    public double valoracion() {


        //TODO añadir punto extra por cada 20 puntos
        /*
        if (getAnotacionTotal() > 20){
            int cociente = getAnotacionTotal() / 20;
            anotacionTotal+=cociente;
        }
        */

        return anotacionTotal;
    }


    public int getAnotacionTotal() {
        return anotacionTotal;
    }

    public void setAnotacionTotal(int anotacionTotal) {
        this.anotacionTotal = anotacionTotal;
    }

    @Override
    public String toString() {
        return "EquipoBaloncesto{" +
                "anotacionTotal=" + anotacionTotal +
                ", year=" + year +
                '}'+jugadorBaloncesto[0];
    }
}
