package federacion;

import libreria.PeticionDatos;

import java.time.Year;
import java.util.Random;

public class EquipoBaloncesto extends Equipo implements Estadisticas {

    //TODO comprobar array ESTATICO
    private JugadorBaloncesto[] jugadorBaloncesto;
    protected int anotacionTotal;
    private int year = Year.now().getValue();
    protected static int totalEquipos;

    public EquipoBaloncesto(String nombreEquipo) {
        super(nombreEquipo);
        jugadorBaloncesto = new JugadorBaloncesto[18];
        this.anotacionTotal = 0;
        totalEquipos++;
    }


    /**
     * Funcion de tipo JugadorBaloncesto que crear el objeto y lo rellena aleatoriamente o por teclado segun lo que se pase por el parametro.
     * Despues de rellenar toda la informacion del objeto, este se devolvera.
     *
     * @param aleatorio Si el valor es true se creara un JugadorBaloncesto aleatorio usando la clase Faker sino se creara a partir de teclado
     * @return Objeto de tipo JugadorBaloncesto con todos los datos necesarios
     */
    public JugadorBaloncesto crearJugador(boolean aleatorio) {
        Random num = new Random();
        int dorsal;
        String puesto;
        Fecha fecha = new Fecha();
        JugadorBaloncesto jugadorBaloncesto = new JugadorBaloncesto();
        if (!aleatorio) {
            jugadorBaloncesto.setNombre(PeticionDatos.pedirCadena("Nombre del jugador: "));
            jugadorBaloncesto.setApellido1(PeticionDatos.pedirCadena("1ª apellido del jugador: "));
            jugadorBaloncesto.setApellido2(PeticionDatos.pedirCadena("2º apellido del jugador: "));
            do {
                dorsal = PeticionDatos.pedirEnteroRango(1, 24, 3, "Dorsal del jugador: ");
            } while (!comprobarDorsal(dorsal, getJugadorBaloncesto()));
            jugadorBaloncesto.setDorsal(dorsal);
            do {
                puesto = PeticionDatos.pedirCadena("Puesto Jugador: ");
            } while (!jugadorBaloncesto.validarPuesto(puesto));
            jugadorBaloncesto.setPuesto(puesto);

            //TODO generar fecha aleatoria en Faker
            do {
            } while (!fecha.setFechaCompleta(PeticionDatos.pedirEntero("Dia: "), PeticionDatos.pedirEntero("Mes: "), PeticionDatos.pedirEntero("Año: ")));
            jugadorBaloncesto.setFechaNacimiento(fecha); //TODO Revisar fecha de nacimiento, primero se comprueba que con Fecha se valido y despues que la edad este en el rango
            /*
            jugadorBaloncesto.setPartidosJugados(PeticionDatos.pedirEntero("Partidos jugados: "));
            jugadorBaloncesto.setMinutosJugados(PeticionDatos.pedirEntero("Minutos jugados: "));
            jugadorBaloncesto.setPartidosGanados(PeticionDatos.pedirEntero("Partidos ganados: "));
            jugadorBaloncesto.setPartidosPerdidos(PeticionDatos.pedirEntero("Partidos perdidos: "));
            jugadorBaloncesto.setAnotacion(PeticionDatos.pedirEntero("Puntos anotados: "));
             */
        } else {
            jugadorBaloncesto.setNombre(Faker.nombres());
            jugadorBaloncesto.setApellido1(Faker.apellidos());
            jugadorBaloncesto.setApellido2(Faker.apellidos());
            do {
                dorsal = num.nextInt(1, 24);
            } while (!comprobarDorsal(dorsal, getJugadorBaloncesto()));
            jugadorBaloncesto.setFechaNacimiento(Faker.fechaAleatoria(year - 65, year - 8));
            jugadorBaloncesto.setPuesto(Faker.puestoBaloncesto());
            jugadorBaloncesto.setDorsal(dorsal);
            /*
            jugadorBaloncesto.setPartidosJugados(num.nextInt(0,40));
            jugadorBaloncesto.setMinutosJugados(num.nextInt(0,1600));
            jugadorBaloncesto.setPartidosGanados(num.nextInt(0,jugadorBaloncesto.partidosJugados));
            jugadorBaloncesto.setPartidosPerdidos(jugadorBaloncesto.partidosJugados-jugadorBaloncesto.partidosGanados);
            jugadorBaloncesto.setAnotacion(num.nextInt(0,jugadorBaloncesto.partidosJugados*20));
            */
        }
        return jugadorBaloncesto;
    }

    public void setJugadorBaloncesto(JugadorBaloncesto[] jugadorBaloncesto) {
        this.jugadorBaloncesto = jugadorBaloncesto;
    }

    public JugadorBaloncesto[] getJugadorBaloncesto() {
        return jugadorBaloncesto;
    }

    public boolean arrayLleno(){
        for(int x = 0; x < jugadorBaloncesto.length; x++){
            if(jugadorBaloncesto[x] == null){
                return false;
            }
        }
        return true;
    }

    protected void nuevoJugadorArray(JugadorBaloncesto jugador) {
        int cont = 0;
        while (getJugadorBaloncesto()[cont] != null) {
            cont++;
        }
        getJugadorBaloncesto()[cont] = jugador;
    }


    //TODO JugadorBaloncesto con todos lo parametros necesarios para crear el objeto
    //TODO Necesario crear constructor con parametros
    public JugadorBaloncesto crearJugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal) {
        return new JugadorBaloncesto(nombre, apellido1, apellido2, puesto, fechaNacimiento, dorsal);
    }


    private static boolean comprobarDorsal(int dorsal, JugadorBaloncesto[] jugador) {
        int cont = 0;
        while (jugador[cont] != null) {
            cont++;
        }
        for (int x = 0; x < cont; x++) {
            if (jugador[x].getDorsal() == dorsal) {
                return false;
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
        for (int i = 0; i < jugadorBaloncesto.length; i++) {
            anotacionTotal += jugadorBaloncesto[i].anotacion;
        }
        //TODO añadir punto extra por cada 20 puntos
        if (getAnotacionTotal() > 20) {
            int cociente = anotacionTotal / 20;
            anotacionTotal += cociente;
        }
        return anotacionTotal;
    }


    public int getAnotacionTotal() {
        return anotacionTotal;
    }

    public void setAnotacionTotal(int anotacionTotal) {
        this.anotacionTotal = anotacionTotal;
    }

    public void mostrarJugadores() {
        for (int x = 0; x < jugadorBaloncesto.length; x++) {
            if (jugadorBaloncesto[x] != null) {
                System.out.println(jugadorBaloncesto[x]);
            } else {
                break;
            }
        }
    }

    //Todo revisar toString
    @Override
    public String toString() {
        System.out.println("------Equipo " + nombreEquipo + "------");
        mostrarJugadores();
        return "";
    }
}
