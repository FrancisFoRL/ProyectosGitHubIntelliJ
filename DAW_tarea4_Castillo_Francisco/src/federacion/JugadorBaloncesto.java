package federacion;

public class JugadorBaloncesto extends Jugador implements Estadisticas {
    protected int anotacion;
    protected static int totalJugadores;

    public JugadorBaloncesto() {
        totalJugadores++;
    }

    public JugadorBaloncesto(String nombre, String apellido1, String apellido2, String puesto, Fecha fechaNacimiento, int dorsal) {
        super(nombre, apellido1, apellido2, puesto, fechaNacimiento, dorsal);
        this.anotacion = 0;
        totalJugadores++;
    }

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

    @Override
    public void setPuesto(String puesto) {
        super.setPuesto(puesto);
    }

    //TODO Revisar fecha de nacimiento
    @Override
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        super.setFechaNacimiento(fechaNacimiento);
    }

    @Override
    public void setDorsal(int dorsal) {
        super.setDorsal(dorsal);
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


    @Override
    boolean validarPuesto(String puesto) {
        puesto = puesto.toUpperCase();
        if (puesto.equals("BASE") || puesto.equals("ALERO") || puesto.equals("PIVOT")) {
            return true;
        }
        return false;
    }

    @Override
    boolean validarDorsal(int dorsal) {
        if (dorsal >= 4 && dorsal <= 24) {
            return true;
        }
        return false;
    }

    @Override
    public double porcentajeVictorias() {
        return (partidosGanados / partidosJugados)*100;
    }

    @Override
    public double valoracion() {
        return (anotacion / minutosJugados)*100;
    }

    private void actualizarAnotacion(int newPuntos){
        anotacion+=newPuntos;
    }

    @Override
    public String toString() {
        return "JugadorBaloncesto{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", puesto='" + puesto + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", dorsal=" + dorsal +
                '}';
    }
}
