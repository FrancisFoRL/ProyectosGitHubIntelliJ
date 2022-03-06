package federacion;

import libreria.PeticionDatos;

import java.io.Serializable;
import java.time.Year;
import java.util.Random;

/**
 * Clase de EquipoFutbol, esta es la encargada de crear un nuevo equipo y añadir posteriormente jugadores de tipo
 * Baloncesto. Esta hereda de Equipo, asi que implementa sus funciones y se editan a los requisitos del Equipo.
 * Ademas, implementa Estadistica para añadir sus funciones. Se iniciaran algunos valores a 0, como por ejemplo partidos
 * jugados, ya que se interpreta que es el inicio de la temporada. Solo se pedira lo necesario para crear un Equipo.
 * @author Francisco Castillo
 * @see Jugador
 * @version 28/02/2022
 */
public class EquipoFutbol extends Equipo implements Estadisticas, Serializable {

    //Atributos
    /**
     * Los atributos que son protected, se han elegido asi para que en las subclases sean
     * visibles y puedan usarse.
     */
    private JugadorFutbol[] jugadorFutbol;
    protected int golesTotal, partidosEmpatados;
    private int year = Year.now().getValue();

    //Atributo de clase
    protected static int totalEquipos;

    //Constructores
    public EquipoFutbol(){
        this.golesTotal = 0;
        jugadorFutbol = new JugadorFutbol[24];
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
        this.partidosEmpatados = 0;
        totalEquipos++;
    }

    public EquipoFutbol(String nombreEquipo) {
        super(nombreEquipo);
        jugadorFutbol = new JugadorFutbol[24];
        this.golesTotal = 0;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
        this.partidosEmpatados = 0;
        totalEquipos++;
    }

    //Setters y Getters
    public void setJugadorFutbol(JugadorFutbol[] jugadorFutbol) {
        this.jugadorFutbol = jugadorFutbol;
    }

    public JugadorFutbol[] getJugadorFutbol() {
        return jugadorFutbol;
    }

    public int getGolesTotal() {
        return golesTotal;
    }

    public void setGolesTotal(int golesTotal) {
        this.golesTotal = golesTotal;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    @Override
    public void setNombreEquipo(String nombreEquipo) {
        super.setNombreEquipo(nombreEquipo);
    }

    @Override
    public void setPartidosJugados(int partidosJugados) {
        super.setPartidosJugados(partidosJugados);
    }

    @Override
    public void setPartidosGanados(int partidosGanados) {
        super.setPartidosGanados(partidosGanados);
    }

    @Override
    public void setPartidosPerdidos(int partidosPerdidos) {
        super.setPartidosPerdidos(partidosPerdidos);
    }

    @Override
    public int getPartidosPerdidos() {
        return this.partidosPerdidos;
    }

    @Override
    public int getPartidosGanados() {
        return this.partidosGanados;
    }

    @Override
    public int getPartidosJugados() {
        return this.partidosJugados;
    }

    /**
     * Funcion de tipo JugadorFutbol que crear el objeto y lo rellena aleatoriamente o por teclado segun lo que se pase por el parametro.
     * Despues de rellenar toda la informacion del objeto, este se devolvera.
     * @param aleatorio Si el valor es true se creara un JugadorFutbol aleatorio usando la clase Faker si no se creara a partir de teclado
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

            do {
            } while (!fecha.setFechaCompletaRango(year - 65,year - 8,
                    PeticionDatos.pedirEntero("Dia: "), PeticionDatos.pedirEntero("Mes: "), PeticionDatos.pedirEntero("Año: ")));
            jugadorFutbol.setFechaNacimiento(fecha);

        } else {
            jugadorFutbol.setNombre(Faker.nombres());
            jugadorFutbol.setApellido1(Faker.apellidos());
            jugadorFutbol.setApellido2(Faker.apellidos());
            do {
                dorsal = num.nextInt(1, 24);
            } while (!comprobarDorsal(dorsal, getJugadorFutbol()));
            jugadorFutbol.setFechaNacimiento(Faker.fechaAleatoria(year - 65, year - 8));
            jugadorFutbol.setPuesto(Faker.puestoFutbol());
            jugadorFutbol.setDorsal(dorsal);
        }
        return jugadorFutbol;
    }

    /**
     * Funcion de tipo JugadorFutbol que crear el objeto lo rellena con los datos pasado por parametro. Si algun parametro esta mal, se devolvera
     * un null en vez del objeto.
     * @param nombre cadena de nombre
     * @param apellido1 cadena de apellido1
     * @param apellido2 cadena de apellido2
     * @param puesto cadena puesto
     * @param fechaNacimiento valor de fecha
     * @param dorsal valor entero de dorsal
     * @return Objeto de tipo JugadorFutbol y si algun dato es incorrecto un null
     */
    public JugadorFutbol crearJugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal) {
        String p= puesto.toUpperCase();
        if(!comprobarDorsal(dorsal,getJugadorFutbol())){
            return null;
        }else if(!(p.equals("DEFENSA") || p.equals("MEDIOCENTRO") || p.equals("DELANTERO"))) {
            return null;
        }
        return new JugadorFutbol(nombre, apellido1, apellido2, puesto, fechaNacimiento, dorsal);
    }

    /**
     * Funcion de tipo booleana que comprueba si el array jugadorFutbol esta lleno o tiene aun alguna posicion null.
     * @return devuelve false si hay una posicion null en el array y true si esta lleno.
     */
    public boolean arrayLleno() {
        for (JugadorFutbol futbol : jugadorFutbol) {
            if (futbol == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Funcion que le asigna una posicion null del array y lo asigna a esa posicion.
     */
    public void nuevoJugadorArray(JugadorFutbol jugador) {
        for(int i = 0; i < getJugadorFutbol().length; i++){
            if(getJugadorFutbol()[i] == null){
                getJugadorFutbol()[i] = jugador;
                break;
            }
        }
    }

    /**
     * Funcion que comprueba que el dorsal que se pasa por parametro no este repetido en el array.
     * @param dorsal valor entero de dorsal
     * @param jugador array de tipo de JugadorFutbol donde se comprueba
     * @return se devuelve false si el dorsal esta repetido, si no, se devolvera true.
     */
    private static boolean comprobarDorsal(int dorsal, JugadorFutbol[] jugador) {
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

    /**
     * Se sobreescribe la funcion que devuelve la valoracion del equipo. Se hacen los calculos necesarios
     * para que devuelva la valoracion del Equipos a partir de puntos de los jugadores.
     * @return Valor de calcular la valoracion del equipo.
     */
    @Override
    public double valoracion() {
        for (JugadorFutbol futbol : jugadorFutbol) {
            if (futbol != null) {
                this.golesTotal += futbol.getGolesMarcados();
            }
        }

        if (getGolesTotal() > 20) {
            int cociente = this.golesTotal / 20;
            this.golesTotal += cociente;
        }
        return golesTotal;
    }

    /**
     * Se sobreescribe la funcion que devuelve el porcentaje de victorias del equipo. Se hacen los calculos necesarios
     * para que devuelva el porcentaje de victorias a partir de ver los partidos jugados y ganados.
     * @return Valor de calcular el porcentaje de victorias.
     */
    @Override
    public double porcentajeVictorias() {
        return ((this.partidosGanados / 100.0) * this.partidosJugados)*100;
    }

    @Override
    public int posicion() {
        return (this.partidosGanados*3)+(this.partidosEmpatados);
    }
    /**
     * Funcion que muestra por pantalla las valoraciones de los jugadores de un equipo.
     */
    public void mostrarValoracionJug() {
        for (JugadorFutbol futbol : jugadorFutbol) {
            if (futbol != null) {
                System.out.println("- " + futbol.getNombre() + " " + futbol.getApellido1() + " " + futbol.getApellido2() + " : " + futbol.valoracion() + " goles/minutos jugados // "
                        +futbol.porcentajeVictorias()+"% Victorias " + posicion());
            } else {
                break;
            }
        }
    }

    /**
     * Funcion que muestra por pantalla los jugadores de un equipo.
     */
    public void mostrarJugadores() {
        for (JugadorFutbol futbol : jugadorFutbol) {
            if (futbol != null) {
                System.out.println(futbol);
            } else {
                break;
            }
        }
    }

    public String mostrarJugadoresString() {
        String jugador="";
        for (JugadorFutbol futbol : jugadorFutbol) {
            if (futbol != null) {
                jugador += "\n"+futbol.getNombre() + " " + futbol.getApellido1() + " " + futbol.getApellido2() +
                        " // Posicion: "+futbol.getPuesto();
            } else {
                break;
            }
        }
        return jugador;
    }

    public void iniciarJugador(){
        Random r1 = new Random();
        for(int x = 0; x < jugadorFutbol.length; x++){
            if(jugadorFutbol[x] != null){
                jugadorFutbol[x].setPartidosJugados(getPartidosJugados());
                jugadorFutbol[x].setPartidosGanados(getPartidosGanados());
                jugadorFutbol[x].setPartidosEmpatados(getPartidosEmpatados());
                jugadorFutbol[x].setPartidosPerdidos(getPartidosPerdidos());
                jugadorFutbol[x].setMinutosJugados(r1.nextInt(70,90)*this.partidosJugados);

            }else{
                break;
            }
        }
    }

    //toString
    @Override
    public String toString() {
        System.out.println("------Equipo " + nombreEquipo + "------");
        mostrarJugadores();
        return "";
    }

}
