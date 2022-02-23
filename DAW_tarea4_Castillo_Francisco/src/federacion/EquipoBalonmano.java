package federacion;

import libreria.PeticionDatos;

import java.time.Year;
import java.util.Random;

public class EquipoBalonmano extends Equipo implements Estadisticas{
    //TODO comprobar array ESTATICO
    private static JugadorBalonmano[] jugadorBalonmano;
    protected int anotacionTotal;
    private int year = Year.now().getValue();

    public EquipoBalonmano(String nombreEquipo) {
        super(nombreEquipo);
        jugadorBalonmano = new JugadorBalonmano[14];
        this.anotacionTotal = 0;
    }

    /**
     * Funcion de tipo JugadorBaloncesto que crear el objeto y lo rellena aleatoriamente o por teclado segun lo que se pase por el parametro.
     * Despues de rellenar toda la informacion del objeto, este se devolvera.
     * @param aleatorio Si el valor es true se creara un JugadorBaloncesto aleatorio usando la clase Faker sino se creara a partir de teclado
     * @return Objeto de tipo JugadorBaloncesto con todos los datos necesarios
     */
    public JugadorBalonmano crearJugador(boolean aleatorio){
        Random num = new Random();
        int dorsal;
        JugadorBalonmano jugadorBalonmano = new JugadorBalonmano();
        if(!aleatorio){
            jugadorBalonmano.setNombre(PeticionDatos.pedirCadena("Nombre del jugador: "));
            jugadorBalonmano.setApellido1(PeticionDatos.pedirCadena("1ª apellido del jugador: "));
            jugadorBalonmano.setApellido2(PeticionDatos.pedirCadena("2º apellido del jugador: "));
            do {
                dorsal = PeticionDatos.pedirEnteroRango(1, 24, 3, "Dorsal del jugador: ");
            }while (!comprobarDorsal(dorsal));
            jugadorBalonmano.setDorsal(dorsal);
            jugadorBalonmano.setPuesto(PeticionDatos.pedirCadena("Puesto Jugador: "));
            //TODO generar fecha aleatoria en Faker
            //jugadorBaloncesto.setFechaNacimiento(); //TODO Revisar fecha de nacimiento, primero se comprueba que con Fecha se valido y despues que la edad este en el rango
            jugadorBalonmano.setPartidosJugados(PeticionDatos.pedirEnteroRango(0,36,3,"Partidos jugados: "));
            jugadorBalonmano.setMinutosJugados(PeticionDatos.pedirEnteroRango(0,60*partidosJugados,3,"Minutos jugados: "));
            jugadorBalonmano.setPartidosGanados(PeticionDatos.pedirEnteroRango(0,partidosJugados,3,"Partidos ganados: "));
            jugadorBalonmano.setPartidosEmpatados(PeticionDatos.pedirEnteroRango(0,partidosJugados-partidosGanados,3, "Partidos empatados: "));
            jugadorBalonmano.setPartidosPerdidos(PeticionDatos.pedirEnteroRango(0,partidosJugados-partidosGanados-jugadorBalonmano.partidosEmpatados,3,"Partidos perdidos: "));
            jugadorBalonmano.setGolesMarcados(PeticionDatos.pedirEnteroRango(0,partidosJugados*6,3,"Goles anotados: "));
        }else{
            //TODO Cambiar a aleatorio
            jugadorBalonmano.setNombre(Faker.nombres());
            jugadorBalonmano.setApellido1(Faker.apellidos());
            jugadorBalonmano.setApellido2(Faker.apellidos());
            do {
                dorsal = num.nextInt(4,24);
            }while (!comprobarDorsal(dorsal));
            jugadorBalonmano.setFechaNacimiento(Faker.fechaAleatoria(year-8,year-65));
            jugadorBalonmano.setPuesto(Faker.puestoBalonmano());
            jugadorBalonmano.setDorsal(dorsal);
            jugadorBalonmano.setPartidosJugados(num.nextInt(0,36));
            jugadorBalonmano.setMinutosJugados(num.nextInt(0, partidosJugados*60));
            jugadorBalonmano.setPartidosGanados(num.nextInt(0,partidosJugados));
            jugadorBalonmano.setPartidosPerdidos(partidosJugados-partidosGanados);
            jugadorBalonmano.setPartidosEmpatados(partidosJugados-partidosGanados- partidosPerdidos);
            jugadorBalonmano.setGolesMarcados(num.nextInt(0,partidosJugados*6));
        }

        return jugadorBalonmano;
    }

    //TODO JugadorBaloncesto con todos lo parametros necesarios para crear el objeto
    //TODO Necesario crear constructor con parametros
    public JugadorFutbol crearJugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal, int minutosJugados, int partidosJugados, int partidosGanados, int partidosPerdidos, int golesMarcados, int partidosEmpatados){
        return new JugadorFutbol(nombre, apellido1, apellido2,puesto, fechaNacimiento, dorsal, minutosJugados, partidosJugados,  partidosGanados, partidosPerdidos, golesMarcados, partidosEmpatados);
    }

    private static boolean comprobarDorsal(int dorsal) {
        if(JugadorBalonmano.totalJugadores == 1){
            return true;
        }else {
            for (int array = 0; array < JugadorBalonmano.totalJugadores - 1; array++) {
                if (jugadorBalonmano[array].getDorsal() == dorsal) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public double porcentajeVictorias() {
        return (partidosGanados / partidosJugados)*100;
    }

    @Override
    public void setNombreEquipo(String nombreEquipo) {
        super.setNombreEquipo(nombreEquipo);
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

