package daw_tarea5;

import librerias.Fecha;

import java.time.Year;
import java.util.Arrays;
//todo comprobar todos los breaks en if, ya que si se despide un trabajador, este quedaria null y los siguientes no se mostrarian

public class Medico extends Persona{
    private Fecha[] diasTrabajados;
    private String especialidad;
    private final int year = Year.now().getValue();

    //Funciones
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
        return especialidad.equalsIgnoreCase("Traumatologia") || especialidad.equalsIgnoreCase("Dermatologia") || especialidad.equalsIgnoreCase("Oftalmologia") ||
                especialidad.equalsIgnoreCase("Alergologia") || especialidad.equalsIgnoreCase("Geriatria") || especialidad.equalsIgnoreCase("Psiquiatria");
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
        return fNacimiento.getAnio() > year - 70 && fNacimiento.getAnio() < year - 20;
    }

}//Fin Medico
