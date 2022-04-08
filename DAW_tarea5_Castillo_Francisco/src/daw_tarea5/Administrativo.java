package daw_tarea5;

import librerias.Fecha;

import java.time.Year;
import java.util.Arrays;
//todo comprobar todos los breaks en if, ya que si se despide un trabajador, este quedaria null(este se guardaria en un fichero) y los siguientes no se mostrarian


public class Administrativo extends Persona{
    private Fecha[] diasTrabajados;
    private String area;

    public Administrativo(String dni, String nombre, String apellido1, String apellido2, String genero, Fecha fechaNacimiento, String area) {
        super(dni, nombre, apellido1, apellido2, genero, fechaNacimiento);
        this.diasTrabajados = new Fecha[5];
        this.area = area;
    }

    //Getters y Setters
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    //Funcion
    public boolean addDiasTrabajados(Fecha trabajo){
        if (!trabajo.comprobarFechaValida(getFechaNacimiento(),18)) {
            return false;
        } else {
            for (int x = 0; x < diasTrabajados.length; x++) {
                if (diasTrabajados[x] == null) {
                    break;
                } else if (trabajo.getDia() == diasTrabajados[x].getDia() && trabajo.getMes() == diasTrabajados[x].getMes() && trabajo.getAnio() == diasTrabajados[x].getAnio()) {
                    return false;
                }
            }
        }
        aumentarArray();
        for (int x = 0; x < diasTrabajados.length; x++) {
            if (diasTrabajados[x] == null){
                diasTrabajados[x] = trabajo;
                break;
            }
        }
        return true;
    }

    private void aumentarArray() {
        if (!Arrays.asList(diasTrabajados).contains(null)){//Arrays.asList nos permite buscar en el array el valor que deseemos, en este caso un null
            Fecha[] aux = new Fecha[diasTrabajados.length];
            for(int x=0; x< aux.length;x++){
                aux[x] = diasTrabajados[x];
            }
            diasTrabajados = new Fecha[aux.length * 2];
            for(int x=0; x< aux.length;x++){
                diasTrabajados[x] = aux[x];
            }
        }
    }

    public static boolean comprobarEspecialidad(String especialidad){
        return especialidad.equalsIgnoreCase("Urgencias") || especialidad.equalsIgnoreCase("Quirofano") || especialidad.equalsIgnoreCase("Administracion");
    }

    private int contDiasTrabajados(){
        int cont=0;
        for(int x = 0; x < diasTrabajados.length;x++){
            if(diasTrabajados[x] == null)break;
            else{
                cont++;
            }
        }
        return cont;
    }

    public static boolean validarFechaNacimiento(Fecha fNacimiento) {
        return fNacimiento.getAnio() >= YEAR - 65 && fNacimiento.getAnio() <= YEAR - 18;
    }


    @Override
    public int diaporMes(int mes) {
        int cont = 0;
        for (Fecha diaTrabajado : diasTrabajados) {
            if (diaTrabajado == null) {
                break;
            } else {
                if (diaTrabajado.getMes() == mes) {
                    cont++;
                }
            }
        }
        return cont;
    }

    @Override
    public void mostrarEstado() {
        System.out.print("Dni Medico: " + getDni() + " || Nombre: " + getNombre() + " || Apellidos: " + getApellido1() + " " + getApellido2() +
                " || Dias Trabajados: "+ contDiasTrabajados());
    }
}//Fin Administrativo
