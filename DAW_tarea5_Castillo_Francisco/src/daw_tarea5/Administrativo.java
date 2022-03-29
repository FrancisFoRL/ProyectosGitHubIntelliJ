package daw_tarea5;

import librerias.Fecha;

import java.time.Year;
import java.util.Arrays;
//todo comprobar todos los breaks en if, ya que si se despide un trabajador, este quedaria null y los siguientes no se mostrarian


public class Administrativo extends Persona{
    private Fecha[] diasTrabajados;
    private String area;
    private final int year = Year.now().getValue();

    public boolean addDiasTrabajados(Fecha trabajo){
        if (!trabajo.comprobarFechaValida(year - 50)) {
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
            if (diasTrabajados[x] == null) diasTrabajados[x] = trabajo;
        }
        return true;
    }

    private void aumentarArray() {
        if (Arrays.asList(diasTrabajados).contains(null));//Arrays.asList nos permite buscar en el array el valor que deseemos, en este caso un null
        else {
            Fecha[] aux = diasTrabajados;
            diasTrabajados = new Fecha[aux.length * 2];
            diasTrabajados = aux;
        }
    }

    private boolean comprobarEspecialidad(String especialidad){
        return especialidad.equalsIgnoreCase("Urgencias") || especialidad.equalsIgnoreCase("Quirofano") || especialidad.equalsIgnoreCase("Administracion");
    }

    private int contDiasTrabajados(){
        //TODO mostrar dias trabajados o numero de dias trabajados?
        int cont=0;
        for(int x = 0; x < diasTrabajados.length;x++){
            if(diasTrabajados[x] == null)break;
            else{
                cont++;
            }
        }
        return cont;
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

    @Override
    public boolean validarFechaNacimiento(Fecha fNacimiento) {
        return fNacimiento.getAnio() > year - 65 && fNacimiento.getAnio() < year - 18;
    }
}//Fin Administrativo
