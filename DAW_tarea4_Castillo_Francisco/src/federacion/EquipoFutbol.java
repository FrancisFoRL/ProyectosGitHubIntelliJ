package federacion;

import libreria.PeticionDatos;

import java.time.Year;
import java.util.Random;

public class EquipoFutbol extends Equipo implements Estadisticas{
    //TODO comprobar array ESTATICO
    protected static JugadorFutbol[] jugadorFutbol;
    protected int anotacionTotal;
    private int year = Year.now().getValue();

    public EquipoFutbol(String nombreEquipo) {
        super(nombreEquipo);
        jugadorFutbol = new JugadorFutbol[24];
        this.anotacionTotal = 0;
    }

    /**
     * Funcion de tipo JugadorBaloncesto que crear el objeto y lo rellena aleatoriamente o por teclado segun lo que se pase por el parametro.
     * Despues de rellenar toda la informacion del objeto, este se devolvera.
     * @param aleatorio Si el valor es true se creara un JugadorBaloncesto aleatorio usando la clase Faker sino se creara a partir de teclado
     * @return Objeto de tipo JugadorBaloncesto con todos los datos necesarios
     */
    public JugadorFutbol crearJugador(boolean aleatorio){
        Random num = new Random();
        int dorsal;
        JugadorFutbol jugadorFutbol = new JugadorFutbol();
        if(!aleatorio){
            jugadorFutbol.setNombre(PeticionDatos.pedirCadena("Nombre del jugador: "));
            jugadorFutbol.setApellido1(PeticionDatos.pedirCadena("1ª apellido del jugador: "));
            jugadorFutbol.setApellido2(PeticionDatos.pedirCadena("2º apellido del jugador: "));
            do {
                dorsal = PeticionDatos.pedirEnteroRango(1, 24, 3, "Dorsal del jugador: ");
            }while (!comprobarDorsal(dorsal));
            jugadorFutbol.setDorsal(dorsal);
            jugadorFutbol.setPuesto(PeticionDatos.pedirCadena("Puesto Jugador: "));
            //TODO generar fecha aleatoria en Faker
            //jugadorBaloncesto.setFechaNacimiento(); //TODO Revisar fecha de nacimiento, primero se comprueba que con Fecha se valido y despues que la edad este en el rango
            jugadorFutbol.setPartidosJugados(PeticionDatos.pedirEnteroRango(0,36,3,"Partidos jugados: "));
            jugadorFutbol.setMinutosJugados(PeticionDatos.pedirEnteroRango(0,60*partidosJugados,3,"Minutos jugados: "));
            jugadorFutbol.setPartidosGanados(PeticionDatos.pedirEnteroRango(0,partidosJugados,3,"Partidos ganados: "));
            jugadorFutbol.setPartidosEmpatados(PeticionDatos.pedirEnteroRango(0,partidosJugados-partidosGanados,3, "Partidos empatados: "));
            jugadorFutbol.setPartidosPerdidos(PeticionDatos.pedirEnteroRango(0,partidosJugados-partidosGanados-jugadorFutbol.partidosEmpatados,3,"Partidos perdidos: "));
            jugadorFutbol.setGolesMarcados(PeticionDatos.pedirEnteroRango(0,partidosJugados*4,3,"Goles anotados: "));
        }else{
            //TODO Cambiar a aleatorio
            jugadorFutbol.setNombre(Faker.nombres());
            jugadorFutbol.setApellido1(Faker.apellidos());
            jugadorFutbol.setApellido2(Faker.apellidos());
            do {
                dorsal = num.nextInt(4,24);
            }while (!comprobarDorsal(dorsal));
            jugadorFutbol.setFechaNacimiento(Faker.fechaAleatoria(year-8,year-65));
            jugadorFutbol.setPuesto(Faker.puestoFutbol());
            jugadorFutbol.setDorsal(dorsal);
            jugadorFutbol.setPartidosJugados(num.nextInt(0,36));
            jugadorFutbol.setMinutosJugados(num.nextInt(0, partidosJugados*60));
            jugadorFutbol.setPartidosGanados(num.nextInt(0,partidosJugados));
            jugadorFutbol.setPartidosPerdidos(partidosJugados-partidosGanados);
            jugadorFutbol.setPartidosEmpatados(partidosJugados-partidosGanados- partidosPerdidos);
            jugadorFutbol.setGolesMarcados(num.nextInt(0,partidosJugados*4));
        }

        return jugadorFutbol;
    }

    //TODO JugadorBaloncesto con todos lo parametros necesarios para crear el objeto
    //TODO Necesario crear constructor con parametros
    public JugadorFutbol crearJugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal, int minutosJugados, int partidosJugados, int partidosGanados, int partidosPerdidos, int golesMarcados, int partidosEmpatados){
        return new JugadorFutbol(nombre, apellido1, apellido2,puesto, fechaNacimiento, dorsal, minutosJugados, partidosJugados,  partidosGanados, partidosPerdidos, golesMarcados, partidosEmpatados);
    }

    private static boolean comprobarDorsal(int dorsal) {
        if(JugadorFutbol.totalJugadores == 1){
            return true;
        }else {
            for (int array = 0; array < JugadorFutbol.totalJugadores - 1; array++) {
                if (jugadorFutbol[array].getDorsal() == dorsal) {
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

}
