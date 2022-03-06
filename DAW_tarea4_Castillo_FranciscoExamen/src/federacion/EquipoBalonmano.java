package federacion;

import libreria.PeticionDatos;

import java.io.Serializable;
import java.time.Year;
import java.util.Random;

/**
 * Clase de EquipoBalonmano, esta es la encargada de crear un nuevo equipo y añadir posteriormente jugadores de tipo
 * Balonmano. Esta hereda de Equipo, asi que implementa sus funciones y se editan a los requisitos del Equipo.
 * Ademas, implementa Estadistica para añadir sus funciones. Se iniciaran algunos valores a 0, como por ejemplo partidos
 * jugados, ya que se interpreta que es el inicio de la temporada. Solo se pedira lo necesario para crear un Equipo.
 * @author Francisco Castillo
 * @see Jugador
 * @version 28/02/2022
 */
public class EquipoBalonmano extends Equipo implements Estadisticas, Serializable {

    //Atributos
    /**
     * Los atributos que son protected, se han elegido asi para que en las subclases sean
     * visibles y puedan usarse.
     */
    private JugadorBalonmano[] jugadorBalonmano;
    protected int golesTotal, partidosEmpatados;
    private int year = Year.now().getValue();

    //Atributo de clase
    protected static int totalEquipos;

    public EquipoBalonmano(){
        totalEquipos++;
        jugadorBalonmano = new JugadorBalonmano[14];
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
        this.partidosEmpatados = 0;
        this.golesTotal = 0;
    }

    //Constructores
    public EquipoBalonmano(String nombreEquipo) {
        super(nombreEquipo);
        jugadorBalonmano = new JugadorBalonmano[14];
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
        this.partidosEmpatados = 0;
        this.golesTotal = 0;
        totalEquipos++;
    }

    //Setters y Getters
    public int getGolesTotal() {
        return golesTotal;
    }

    public void setGolesTotal(int golesTotal) {
        this.golesTotal = golesTotal;
    }

    @Override
    public void setNombreEquipo(String nombreEquipo) {
        super.setNombreEquipo(nombreEquipo);
    }

    public void setJugadorBalonmano(JugadorBalonmano[] jugadorBalonmano) {
        this.jugadorBalonmano = jugadorBalonmano;
    }

    public JugadorBalonmano[] getJugadorBalonmano() {
        return jugadorBalonmano;
    }

    /**
     * Funcion de tipo JugadorBalonmano que crear el objeto y lo rellena aleatoriamente o por teclado segun lo que se pase por el parametro.
     * Despues de rellenar toda la informacion del objeto, este se devolvera.
     * @param aleatorio Si el valor es true se creara un JugadorBaloncesto aleatorio usando la clase Faker sino se creara a partir de teclado
     * @return Objeto de tipo JugadorBaloncesto con todos los datos necesarios
     */
    public JugadorBalonmano crearJugador(boolean aleatorio) {
        Random num = new Random();
        int dorsal;
        String puesto;
        Fecha fecha = new Fecha();
        JugadorBalonmano jugadorBalonmano = new JugadorBalonmano();
        if (!aleatorio) {
            jugadorBalonmano.setNombre(PeticionDatos.pedirCadena("Nombre del jugador: "));
            jugadorBalonmano.setApellido1(PeticionDatos.pedirCadena("1ª apellido del jugador: "));
            jugadorBalonmano.setApellido2(PeticionDatos.pedirCadena("2º apellido del jugador: "));
            do {
                dorsal = PeticionDatos.pedirEnteroRango(1, 24, 3, "Dorsal del jugador: ");
            } while (!comprobarDorsal(dorsal, getJugadorBalonmano()));
            jugadorBalonmano.setDorsal(dorsal);
            do {
                puesto = PeticionDatos.pedirCadena("Puesto Jugador: ");
            } while (!jugadorBalonmano.validarPuesto(puesto));
            jugadorBalonmano.setPuesto(puesto);

            do {
            } while (!fecha.setFechaCompletaRango(year - 65,year - 8,
                    PeticionDatos.pedirEntero("Dia: "), PeticionDatos.pedirEntero("Mes: "), PeticionDatos.pedirEntero("Año: ")));
            jugadorBalonmano.setFechaNacimiento(fecha);

        } else {
            jugadorBalonmano.setNombre(Faker.nombres());
            jugadorBalonmano.setApellido1(Faker.apellidos());
            jugadorBalonmano.setApellido2(Faker.apellidos());
            do {
                dorsal = num.nextInt(1, 24);
            } while (!comprobarDorsal(dorsal, getJugadorBalonmano()));
            jugadorBalonmano.setFechaNacimiento(Faker.fechaAleatoria(year - 65, year - 8));
            jugadorBalonmano.setPuesto(Faker.puestoBalonmano());
            jugadorBalonmano.setDorsal(dorsal);
        }
        return jugadorBalonmano;
    }

    /**
     * Funcion de tipo JugadorBalonmano que crear el objeto lo rellena con los datos pasado por parametro. Si algun parametro esta mal, se devolvera
     * un null en vez del objeto.
     * @param nombre cadena de nombre
     * @param apellido1 cadena de apellido1
     * @param apellido2 cadena de apellido2
     * @param puesto cadena puesto
     * @param fechaNacimiento valor de fecha
     * @param dorsal valor entero de dorsal
     * @return Objeto de tipo JugadorBaloncesto y si algun dato es incorrecto un null
     */
    public JugadorBalonmano crearJugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal) {
        String p= puesto.toUpperCase();
        if(!comprobarDorsal(dorsal,getJugadorBalonmano())){
            return null;
        }else if(!(p.equals("PIVOT") || p.equals("CENTRAL") || p.equals("DEFENSA"))) {
            return null;
        }
        return new JugadorBalonmano(nombre, apellido1, apellido2, puesto, fechaNacimiento, dorsal);
    }

    /**
     * Funcion de tipo booleana que comprueba si el array jugadorBaloncesto esta lleno o tiene aun alguna posicion null.
     * @return devuelve false si hay una posicion null en el array y true si esta lleno.
     */
    public boolean arrayLleno(){
        for (JugadorBalonmano balonmano : jugadorBalonmano) {
            if (balonmano == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Funcion que le asigna una posicion null del array y lo asigna a esa posicion.
     */
    protected void nuevoJugadorArray(JugadorBalonmano jugador) {
        for(int i = 0; i < getJugadorBalonmano().length; i++){
            if(getJugadorBalonmano()[i] == null){
                getJugadorBalonmano()[i] = jugador;
                break;
            }
        }
    }

    /**
     * Funcion que comprueba que el dorsal que se pasa por parametro no este repetido en el array.
     * @param dorsal valor entero de dorsal
     * @param jugador array de tipo de JugadorBaloncesto donde se comprueba
     * @return se devuelve false si el dorsal esta repetido, si no, se devolvera true.
     */
    private static boolean comprobarDorsal(int dorsal, JugadorBalonmano[] jugador) {
        int cont=0;
        while(jugador[cont]!=null)
        {
            cont++;
        }
        for (int x = 0; x < cont ; x++) {
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
        for (JugadorBalonmano balonmano : jugadorBalonmano) {
            if (balonmano != null) {
                this.golesTotal += balonmano.getGolesMarcados();
            }
        }

        if (getGolesTotal() > 20) {
            int cociente = this.golesTotal / 20;
            this.golesTotal += cociente;
        }
        return this.golesTotal;
    }

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
    public void mostrarValoracionJug(){
        for (JugadorBalonmano balonmano : jugadorBalonmano) {
            if (balonmano != null) {
                System.out.println("- " + balonmano.getNombre() + " " + balonmano.getApellido1() + " " + balonmano.getApellido2() + " : " + balonmano.valoracion() + " goles/minutos jugados // "
                + balonmano.porcentajeVictorias()+"% Victorias"+ "Valoracion "+valoracion());
            } else {
                break;
            }
        }
    }

    /**
     * Funcion que muestra por pantalla los jugadores de un equipo.
     */
    public void mostrarJugadores() {
        for (JugadorBalonmano balonmano : jugadorBalonmano) {
            if (balonmano != null) {
                System.out.println(balonmano);
            } else {
                break;
            }
        }
    }

    public String mostrarJugadoresString() {
        String jugador="";
        for (JugadorBalonmano balonmano : jugadorBalonmano) {
            if (balonmano != null) {
                jugador += "\n"+balonmano.getNombre() + " " + balonmano.getApellido1() + " " + balonmano.getApellido2() +
                        " // Posicion: "+balonmano.getPuesto();
            } else {
                break;
            }
        }
        return jugador;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public void iniciarJugador(){
        Random r1 = new Random();
        for(int x = 0; x < jugadorBalonmano.length; x++){
            if(jugadorBalonmano[x] != null){
                jugadorBalonmano[x].setPartidosJugados(this.partidosJugados);
                jugadorBalonmano[x].setPartidosGanados(this.partidosGanados);
                jugadorBalonmano[x].setPartidosEmpatados(this.partidosEmpatados);
                jugadorBalonmano[x].setPartidosPerdidos(this.partidosPerdidos);
                jugadorBalonmano[x].setMinutosJugados(r1.nextInt(70,90)*this.partidosJugados);
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

