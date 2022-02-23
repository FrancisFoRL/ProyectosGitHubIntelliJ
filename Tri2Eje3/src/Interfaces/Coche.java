package Interfaces;

public class Coche implements Movimiento{
    private int velocidad;
    private int plazas;

    public Coche(){}

    public Coche(int velocidad, int plazas) {
        this.velocidad = velocidad;
        this.plazas = plazas;
    }

    public boolean setVelocidad(int velocidad) {
        if(velocidad >= 0 && velocidad <= 220){
            this.velocidad = velocidad;
            return true;
        }
        return false;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getPlazas() {
        return plazas;
    }

    @Override
    public String acelerar(int cantidad) {
        if(velocidad >= 220){
        }else{
            if((velocidad+cantidad) > 220){
                velocidad = 220;
                return "El coche va la velocidad de "+velocidad;
            }else{
                velocidad+=cantidad;
                return "El coche va la velocidad de "+velocidad;
            }
        }
        return "La velocidad no se puede aumentar";
    }

    @Override
    public String frenar(int cantidad) {
        if(velocidad <= 0){
        }else{
            if((velocidad-cantidad) < 0){
                velocidad = 0;
                return "El coche va la velocidad de "+velocidad;
            }else{
                velocidad-=cantidad;
                return "El coche va la velocidad de "+velocidad;
            }
        }
        return "La velocidad no se puede reducir";
    }

    @Override
    public String toString() {
        return "El coche va a una velocidad de "+velocidad;
    }
}
