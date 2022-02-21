package federacion;

import libreria.PeticionDatos;

public class EquipoBaloncesto extends Equipo implements Estadisticas{

    //TODO comprobar array ESTATICO
    private static JugadorBaloncesto[] jugadorBaloncesto;
    private int anotacionTotal;

    public EquipoBaloncesto(JugadorBaloncesto[] jugadorBaloncesto, int anotacionTotal) {
        JugadorBaloncesto.totalJugadores++;
        EquipoBaloncesto.jugadorBaloncesto = new JugadorBaloncesto[18];
        this.anotacionTotal = 0;
    }

    /**
     * Funcion de tipo JugadorBaloncesto que crear el objeto y lo rellena aleatoriamente o por teclado segun lo que se pase por el parametro.
     * Despues de rellenar toda la informacio del objeto, este se devolvera.
     * @param aleatorio Si el valor es true se creara un JugadorBaloncesto aleatorio usando la clase Faker sino se creara a partir de teclado
     * @return Objeto de tipo JugadorBaloncesto con todos los datos necesarios
     */
    public JugadorBaloncesto crearJugador(boolean aleatorio){
        int dorsal;
        JugadorBaloncesto jugadorBaloncesto = new JugadorBaloncesto();
        if(!aleatorio){
            jugadorBaloncesto.setNombre(PeticionDatos.pedirCadena("Nombre del jugador: "));
            jugadorBaloncesto.setApellido1(PeticionDatos.pedirCadena("1ª apellido del jugador: "));
            jugadorBaloncesto.setApellido2(PeticionDatos.pedirCadena("2º apellido del jugador: "));
            do {
                dorsal = PeticionDatos.pedirEnteroRango(1, 24, 3, "Dorsal del jugador: ");
                if(comprobarDorsal(dorsal)){
                    break;
                }
            }while (true);
            //jugadorBaloncesto.setFechaNacimiento(); //TODO Revisar fecha de nacimiento
            jugadorBaloncesto.setPartidosJugados(PeticionDatos.pedirEntero("Partidos jugados: "));
            jugadorBaloncesto.setMinutosJugados(PeticionDatos.pedirEntero("Minutos jugados: "));
            jugadorBaloncesto.setPartidosGanados(PeticionDatos.pedirEntero("Partidos ganados: "));
            jugadorBaloncesto.setPartidosPerdidos(PeticionDatos.pedirEntero("Partidos perdidos: "));
            jugadorBaloncesto.setAnotacion(PeticionDatos.pedirEntero("Puntos anotados: "));
        }else{
            //TODO Jugador creado con datos aleatorios
        }

        return jugadorBaloncesto;
    }

    //TODO JugadorBaloncesto con todos lo parametros necesarios para crear el objeto
    public JugadorBaloncesto crearJugador(){
        JugadorBaloncesto jugadorBaloncesto = new JugadorBaloncesto();
        return jugadorBaloncesto;
    }

    private static boolean comprobarDorsal(int dorsal) {
        if(JugadorBaloncesto.totalJugadores == 1){
            return true;
        }else {
            for (int array = 0; array < JugadorBaloncesto.totalJugadores - 1; array++) {
                if (jugadorBaloncesto[array].getDorsal() == dorsal) {
                    System.out.println("Dorsal no valido, ya esta en uso");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public double porcentajeVictorias() {
        return (getPartidosGanados() / getPartidosJugados())*100;
    }


    //TODO Comprobar valoracion
    @Override
    public double valoracion() {
        anotacionTotal = getPartidosGanados() * 2;

        if (getAnotacionTotal() > 20){
            int cociente = getAnotacionTotal() / 20;
            anotacionTotal+=cociente;
        }

        return anotacionTotal;
    }


    public int getAnotacionTotal() {
        return anotacionTotal;
    }

    public void setAnotacionTotal(int anotacionTotal) {
        this.anotacionTotal = anotacionTotal;
    }
}
