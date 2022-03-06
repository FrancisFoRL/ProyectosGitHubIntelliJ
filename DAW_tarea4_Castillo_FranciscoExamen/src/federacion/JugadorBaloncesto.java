package federacion;

import java.io.Serializable;
import java.time.Year;

/**
 * Clase de JugadorBaloncesto, esta es la encargada de crear un Jugador de tipo Baloncesto. Esta hereda de Jugador,
 * asi que implementa sus funciones y se editan a los requisitos del jugador. Ademas, implementa Estadistica para añadir sus
 * funciones. Se iniciaran algunos valores a 0, como por ejemplo partidos jugados, ya que se interpreta que es el inicio de la
 * temporada. Solo se pedira lo necesario para crear un jugador.
 * @author Francisco Castillo
 * @see Jugador
 * @version 28/02/2022
 */
public class JugadorBaloncesto extends Jugador implements Estadisticas, Serializable {
    //Atributos
    private int anotacion;
    private int year = Year.now().getValue();//Atributo que importa Year, este nos da la fecha actual del sistema.

    //Atributo de clase
    /**
     * El atributo es protected, se ha elegido asi para que en las subclases sea
     * visible y pueda usarse.
     */
    protected static int totalJugadores;

    //Constructores
    public JugadorBaloncesto() {
        totalJugadores++;
        this.anotacion = 0;
        this.minutosJugados = 0;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
    }

    public JugadorBaloncesto(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal) {
        super(nombre, apellido1, apellido2, puesto, fechaNacimiento, dorsal);
        this.anotacion = 0;
        this.minutosJugados = 0;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
        totalJugadores++;
    }

    //Setters y Getters
    public int getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(int anotacion) {
        this.anotacion = anotacion;
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void setApellido1(String apellido1) {
        super.setApellido1(apellido1);
    }

    @Override
    public void setApellido2(String apellido2) {
        super.setApellido2(apellido2);
    }

    /**
     * Setter que aplicara un valor a puesto. Se controla que el puesto es valido llamando a la
     * funcion validarPuesto. Si el puesto no es valido, puesto tendra un valor null y si es correcto
     * se le aplicara el puesto pasado por parametro.
     * @param puesto cadena de puesto.
     */
    @Override
    public void setPuesto(String puesto) {
        if(!validarPuesto(puesto)){
            this.puesto = null;
        }else{
            super.setPuesto(puesto);
        }
    }

    /**
     * Setter que aplicara un valor a fechaNacimiento. Se controla que el puesto es valido comprobando
     * que el año esta dentro del rango especificado. Si la fecha no es valida, fechaNacimiento tendra un valor null y si es correcto
     * se le aplicara la fechaNacimiento pasado por parametro.
     * @param fechaNacimiento valor de fecha.
     */
    @Override
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        if ((fechaNacimiento.getAnio() <= year - 8) && (fechaNacimiento.getAnio() >= year - 65)) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            this.fechaNacimiento = null;
        }
    }

    /**
     * Setter que aplicara un valor a dorsal. Se controla que el dorsal es valido con la funcion
     * validaDorsal. Si el dorsal no es valida, dorsal tendra un valor de 0 y si es correcto
     * se le aplicara el dorsal pasado por parametro.
     * @param dorsal valor de dorsal.
     */
    @Override
    public void setDorsal(int dorsal) {
        if(!validarDorsal(dorsal)){
            this.dorsal= 0;
        }else {
            super.setDorsal(dorsal);
        }
    }

    @Override
    public void setMinutosJugados(int minutosJugados) {
        super.setMinutosJugados(minutosJugados);
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
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public String getApellido1() {
        return super.getApellido1();
    }

    @Override
    public String getApellido2() {
        return super.getApellido2();
    }

    @Override
    public String getPuesto() {
        return super.getPuesto();
    }

    @Override
    public Fecha getFechaNacimiento() {
        return super.getFechaNacimiento();
    }

    @Override
    public int getDorsal() {
        return super.getDorsal();
    }

    @Override
    public int getMinutosJugados() {
        return super.getMinutosJugados();
    }

    @Override
    public int getPartidosJugados() {
        return super.getPartidosJugados();
    }

    @Override
    public int getPartidosGanados() {
        return super.getPartidosGanados();
    }

    @Override
    public int getPartidosPerdidos() {
        return super.getPartidosPerdidos();
    }

    //Funciones
    /**
     * Se sobreescribe la funcion que valida el puesto pasado por parametro. Compara los puestos que son valido, si esto concuerdan,
     * devolvera que es valido, si no, devolvera que no.
     * @param puesto cadena del puesto a comprobar.
     * @return devolvera un true si el puesto es valido, si no, devolvera un false.
     */
    @Override
    boolean validarPuesto(String puesto) {
        puesto = puesto.toUpperCase();
        if (puesto.equals("BASE") || puesto.equals("ALERO") || puesto.equals("PIVOT")) {
            return true;
        }
        return false;
    }

    /**
     * Se sobreescribe la funcion que valida el dorsal pasado por parametro. Ve si el numero pasado por parametro esta dentro del
     * rango, si esto concuerdan, devolvera que es valido, si no, devolvera que no.
     * @param dorsal valor dorsal a comprobar.
     * @return devolvera un true si el dorsal es valido, si no, devolvera un false.
     */
    @Override
    boolean validarDorsal(int dorsal) {
        if (dorsal >= 4 && dorsal <= 24) {
            return true;
        }
        return false;
    }

    /**
     * Se sobreescribe la funcion que devuelve el porcentaje de victorias del jugador. Se hacen los calculos necesarios
     * para que devuelva el porcentaje de victorias a partir de ver los partidos jugados y ganados.
     * @return Valor de calcular el porcentaje de victorias.
     */
    @Override
    public double porcentajeVictorias() {
        return ((this.partidosGanados / 100.0) * this.partidosJugados)*100;
    }

    /**
     * Se sobreescribe la funcion que devuelve la valoracion del jugador. Se hacen los calculos necesarios
     * para que devuelva la valoracion del jugador a partir de puntos por minutos jugados.
     * @return Valor de calcular la valoracion del jugador.
     */
    @Override
    public double valoracion() {
        return (this.anotacion * 40.0) / this.minutosJugados;
    }

    @Override
    public int posicion() {
        return (partidosGanados*2)+((minutosJugados / 30));
    }

    /**
     * Funcion que añade nuevos puntos de anotacion a el jugador.
     * @param newPuntos valor de puntos nuevos a añadir.
     */
    private void actualizarAnotacion(int newPuntos) {
        this.anotacion += newPuntos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
