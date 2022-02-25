package federacion;

import libreria.PeticionDatos;

import java.time.Year;
import java.util.Random;

public class EquipoFutbol extends Equipo implements Estadisticas{
    //TODO comprobar array ESTATICO
    private JugadorFutbol[] jugadorFutbol;
    protected int golesTotal;
    private int year = Year.now().getValue();
    protected static int totalEquipos;

    public EquipoFutbol(String nombreEquipo) {
        super(nombreEquipo);
        jugadorFutbol = new JugadorFutbol[24];
        this.golesTotal = 0;
        totalEquipos++;
    }


    /**
     * Funcion de tipo JugadorBaloncesto que crear el objeto y lo rellena aleatoriamente o por teclado segun lo que se pase por el parametro.
     * Despues de rellenar toda la informacion del objeto, este se devolvera.
     *
     * @param aleatorio Si el valor es true se creara un JugadorBaloncesto aleatorio usando la clase Faker sino se creara a partir de teclado
     * @return Objeto de tipo JugadorBaloncesto con todos los datos necesarios
     */
    public JugadorFutbol crearJugador(boolean aleatorio) {
        Random num = new Random();
        int dorsal;
        String puesto;
        Fecha fecha = new Fecha();
        JugadorFutbol jugadorFutbol = new JugadorFutbol();
        if (!aleatorio) {
            jugadorFutbol.setNombre(PeticionDatos.pedirCadena("Nombre del jugador: "));
            jugadorFutbol.setApellido1(PeticionDatos.pedirCadena("1ª apellido del jugador: "));
            jugadorFutbol.setApellido2(PeticionDatos.pedirCadena("2º apellido del jugador: "));
            do {
                dorsal = PeticionDatos.pedirEnteroRango(1, 24, 3, "Dorsal del jugador: ");
            } while (!comprobarDorsal(dorsal, getJugadorFutbol()));
            jugadorFutbol.setDorsal(dorsal);
            do {
                puesto = PeticionDatos.pedirCadena("Puesto Jugador: ");
            } while (!jugadorFutbol.validarPuesto(puesto));
            jugadorFutbol.setPuesto(puesto);

            //TODO generar fecha aleatoria en Faker
            do {
            } while (!fecha.setFechaCompleta(PeticionDatos.pedirEntero("Dia: "), PeticionDatos.pedirEntero("Mes: "), PeticionDatos.pedirEntero("Año: ")));
            jugadorFutbol.setFechaNacimiento(fecha); //TODO Revisar fecha de nacimiento, primero se comprueba que con Fecha se valido y despues que la edad este en el rango
            /*
            jugadorBaloncesto.setPartidosJugados(PeticionDatos.pedirEntero("Partidos jugados: "));
            jugadorBaloncesto.setMinutosJugados(PeticionDatos.pedirEntero("Minutos jugados: "));
            jugadorBaloncesto.setPartidosGanados(PeticionDatos.pedirEntero("Partidos ganados: "));
            jugadorBaloncesto.setPartidosPerdidos(PeticionDatos.pedirEntero("Partidos perdidos: "));
            jugadorBaloncesto.setAnotacion(PeticionDatos.pedirEntero("Puntos anotados: "));
             */
        } else {
            //TODO Cambiar a aleatorio
            jugadorFutbol.setNombre(Faker.nombres());
            jugadorFutbol.setApellido1(Faker.apellidos());
            jugadorFutbol.setApellido2(Faker.apellidos());
            do {
                dorsal = num.nextInt(4, 24);
            } while (!comprobarDorsal(dorsal, getJugadorFutbol()));
            jugadorFutbol.setFechaNacimiento(Faker.fechaAleatoria(year - 65, year - 8));
            jugadorFutbol.setPuesto(Faker.puestoBaloncesto());
            jugadorFutbol.setDorsal(dorsal);
            /*
            jugadorBaloncesto.setPartidosJugados(num.nextInt(0,40));
            jugadorBaloncesto.setMinutosJugados(num.nextInt(0,1600));
            jugadorBaloncesto.setPartidosGanados(num.nextInt(0,jugadorBaloncesto.partidosJugados));
            jugadorBaloncesto.setPartidosPerdidos(jugadorBaloncesto.partidosJugados-jugadorBaloncesto.partidosGanados);
            jugadorBaloncesto.setAnotacion(num.nextInt(0,jugadorBaloncesto.partidosJugados*20));

            */

        }
        System.out.println(JugadorBaloncesto.totalJugadores);
        return jugadorFutbol;
    }

    public void setJugadorFutbol(JugadorFutbol[] jugadorFutbol) {
        this.jugadorFutbol = jugadorFutbol;
    }

    public JugadorFutbol[] getJugadorFutbol() {
        return jugadorFutbol;
    }

    private static void nuevoJugadorArray(JugadorFutbol jugador, JugadorFutbol[] jugador1) {
        int cont = 0;
        while (jugador1[cont] != null) {
            cont++;
        }
        jugador1[cont] = jugador;
    }

    //TODO JugadorBaloncesto con todos lo parametros necesarios para crear el objeto
    //TODO Necesario crear constructor con parametros
    public JugadorFutbol crearJugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal) {
        return new JugadorFutbol(nombre, apellido1, apellido2, puesto, fechaNacimiento, dorsal);
    }


    private static boolean comprobarDorsal(int dorsal, JugadorFutbol[] jugador) {
        if (JugadorFutbol.totalJugadores == 1) {
            return true;
        } else {
            for (int array = 0; array < JugadorFutbol.totalJugadores - 1; array++) {
                if (jugador[array].getDorsal() == dorsal) {
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
        return (partidosGanados / partidosJugados) * 100;
    }


    //TODO Comprobar valoracion
    @Override
    public double valoracion() {
        for (int i = 0; i < jugadorFutbol.length; i++) {
            golesTotal += jugadorFutbol[i].golesMarcados;
        }
        //TODO añadir punto extra por cada 20 puntos
        if (getGolesTotal() > 20) {
            int cociente = golesTotal / 20;
            golesTotal += cociente;
        }
        return golesTotal;
    }


    public int getGolesTotal() {
        return golesTotal;
    }

    public void setGolesTotal(int golesTotal) {
        this.golesTotal = golesTotal;
    }

    public void mostrarJugadores() {
        for (int i = 1; i < JugadorBaloncesto.totalJugadores; i++) {
            System.out.println(jugadorFutbol[i - 1]);
        }
    }

    //Todo revisar toString
    @Override
    public String toString() {
        System.out.println("------Equipo " + nombreEquipo + "------");
        mostrarJugadores();
        System.out.println();
        return "";
    }

}
