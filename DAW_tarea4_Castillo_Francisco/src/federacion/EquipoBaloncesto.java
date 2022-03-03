package federacion;

import libreria.PeticionDatos;

import java.io.Serializable;
import java.time.Year;
import java.util.Random;

/**
 * Clase de EquipoBaloncesto, esta es la encargada de crear un nuevo equipo y añadir posteriormente jugadores de tipo
 * Baloncesto. Esta hereda de Equipo, asi que implementa sus funciones y se editan a los requisitos del Equipo.
 * Ademas, implementa Estadistica para añadir sus funciones. Se iniciaran algunos valores a 0, como por ejemplo partidos
 * jugados, ya que se interpreta que es el inicio de la temporada. Solo se pedira lo necesario para crear un Equipo.
 * @author Francisco Castillo
 * @see Jugador
 * @version 28/02/2022
 */
public class EquipoBaloncesto extends Equipo implements Estadisticas, Serializable {

    //Atributos
    /**
     * Los atributos que son protected, se han elegido asi para que en las subclases sean
     * visibles y puedan usarse.
     */
    private JugadorBaloncesto[] jugadorBaloncesto;
    protected int anotacionTotal;
    private int year = Year.now().getValue();

    //Atributo de clase
    protected static int totalEquipos;

    //Constructores
    public EquipoBaloncesto(){
        totalEquipos++;
        jugadorBaloncesto = new JugadorBaloncesto[18];
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.anotacionTotal = 0;
    }

    public EquipoBaloncesto(String nombreEquipo) {
        super(nombreEquipo);
        jugadorBaloncesto = new JugadorBaloncesto[18];
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.anotacionTotal = 0;
        totalEquipos++;
    }

    //Setters y Getters
    public JugadorBaloncesto[] getJugadorBaloncesto() {
        return jugadorBaloncesto;
    }

    public int getAnotacionTotal() {
        return anotacionTotal;
    }

    public void setAnotacionTotal(int anotacionTotal) {
        this.anotacionTotal = anotacionTotal;
    }

    @Override
    public void setNombreEquipo(String nombreEquipo) {
        super.setNombreEquipo(nombreEquipo);
    }

    /**
     * Funcion de tipo JugadorBaloncesto que crear el objeto y lo rellena aleatoriamente o por teclado segun lo que se pase por el parametro.
     * Despues de rellenar toda la informacion del objeto, este se devolvera.
     *
     * @param aleatorio Si el valor es true se creara un JugadorBaloncesto aleatorio usando la clase Faker si no se creara a partir de teclado
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

            do {
            } while (!fecha.setFechaCompletaRango(year - 65,year - 8,
                    PeticionDatos.pedirEntero("Dia: "), PeticionDatos.pedirEntero("Mes: "), PeticionDatos.pedirEntero("Año: ")));
            jugadorBaloncesto.setFechaNacimiento(fecha);

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
        }
        return jugadorBaloncesto;
    }

    /**
     * Funcion de tipo JugadorBaloncesto que crear el objeto lo rellena con los datos pasado por parametro. Si algun parametro esta mal, se devolvera
     * un null en vez del objeto.
     * @param nombre cadena de nombre
     * @param apellido1 cadena de apellido1
     * @param apellido2 cadena de apellido2
     * @param puesto cadena puesto
     * @param fechaNacimiento valor de fecha
     * @param dorsal valor entero de dorsal
     * @return Objeto de tipo JugadorBaloncesto y si algun dato es incorrecto un null
     */
    public JugadorBaloncesto crearJugador(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal) {
        String p= puesto.toUpperCase();
        if(!comprobarDorsal(dorsal,getJugadorBaloncesto())){
            return null;
        }else if(!(p.equals("BASE") || p.equals("ALERO") || p.equals("PIVOT"))) {
            return null;
        }
        return new JugadorBaloncesto(nombre, apellido1, apellido2, puesto, fechaNacimiento, dorsal);
    }

    /**
     * Funcion de tipo booleana que comprueba si el array jugadorBaloncesto esta lleno o tiene aun alguna posicion null.
     * @return devuelve false si hay una posicion null en el array y true si esta lleno.
     */
    public boolean arrayLleno(){
        for(int x = 0; x < jugadorBaloncesto.length; x++){
            if(jugadorBaloncesto[x] == null){
                return false;
            }
        }
        return true;
    }

    /**
     * Funcion que le asigna una posicion null del array y lo asigna a esa posicion.
     */
    protected void nuevoJugadorArray(JugadorBaloncesto jugador) {
        int cont = 0;
        while (getJugadorBaloncesto()[cont] != null) {
            cont++;
        }
        getJugadorBaloncesto()[cont] = jugador;
    }

    /**
     * Funcion que comprueba que el dorsal que se pasa por parametro no este repetido en el array.
     * @param dorsal valor entero de dorsal
     * @param jugador array de tipo de JugadorBaloncesto donde se comprueba
     * @return se devuelve false si el dorsal esta repetido, si no, se devolvera true.
     */
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

    /**
     * Se sobreescribe la funcion que devuelve la valoracion del equipo. Se hacen los calculos necesarios
     * para que devuelva la valoracion del Equipos a partir de puntos de los jugadores.
     * @return Valor de calcular la valoracion del equipo.
     */
    @Override
    public double valoracion() {
        for (JugadorBaloncesto baloncesto : jugadorBaloncesto) {
            if (baloncesto != null) {
                this.anotacionTotal += baloncesto.getAnotacion();
            }
        }
        if (getAnotacionTotal() > 20) {
            int cociente = this.anotacionTotal / 20;
            this.anotacionTotal += cociente;
        }
        return anotacionTotal;
    }

    /**
     * Se sobreescribe la funcion que devuelve el porcentaje de victorias del equipo. Se hacen los calculos necesarios
     * para que devuelva el porcentaje de victorias a partir de ver los partidos jugados y ganados.
     * @return Valor de calcular el porcentaje de victorias.
     */
    @Override
    public double porcentajeVictorias() {
        return (this.partidosGanados / 100.0) * this.partidosJugados;
    }

    /**
     * Funcion que muestra por pantalla las valoraciones de los jugadores de un equipo.
     */
    public void mostrarValoracionJug(){
        for (JugadorBaloncesto baloncesto : jugadorBaloncesto) {
            if (baloncesto != null) {
                System.out.println("- " + baloncesto.getNombre() + " " + baloncesto.getApellido1() + " " + baloncesto.getApellido2() + " : " + baloncesto.valoracion() + " anotaciones/minutos jugados // "
                        +baloncesto.porcentajeVictorias()+"% Victorias");
            } else {
                break;
            }
        }
    }

    /**
     * Funcion que muestra por pantalla los jugadores de un equipo.
     */
    public void mostrarJugadores() {
        for (JugadorBaloncesto baloncesto : jugadorBaloncesto) {
            if (baloncesto != null) {
                System.out.println(baloncesto);
            } else {
                break;
            }
        }
    }


    public String mostrarJugadoresString() {
        String jugador="";
        for (JugadorBaloncesto baloncesto : jugadorBaloncesto) {
            if (baloncesto != null) {
                jugador += "\n"+baloncesto.getNombre() + " " + baloncesto.getApellido1() + " " + baloncesto.getApellido2() +
                        " // Posicion: "+baloncesto.getPuesto();
            } else {
                break;
            }
        }
        return jugador;
    }

    //toString
    @Override
    public String toString() {
        System.out.println("------Equipo " + nombreEquipo + "------");
        mostrarJugadores();
        return "";
    }
}
