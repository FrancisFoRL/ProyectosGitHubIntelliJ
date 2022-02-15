package Interfaces;

public class Robot implements Movimiento{
    private int pasos;

    public Robot(){}

    public Robot(int pasos) {
        this.pasos = pasos;
    }

    public boolean setPasos(int pasos) {
        if(pasos >= 0 && pasos <= 100){
            this.pasos = pasos;
            return true;
        }
        return false;
    }

    public int getPasos() {
        return pasos;
    }

    @Override
    public String acelerar(int cantidad) {
        if(pasos >= 100){
        }else{
            if((pasos+cantidad) > 100){
            }else{
                pasos+=cantidad;
                return "El robot ha dado "+pasos+" pasos";
            }
        }
        return "Los pasos no se pueden aumentar";
    }

    @Override
    public String frenar(int cantidad) {
        if(pasos <= 0){
        }else{
            if((pasos+cantidad) < 0){
            }else{
                pasos-=cantidad;
                return "El robot ha dado "+pasos+" pasos";
            }
        }
        return "Los pasos no se pueden reducir";
    }

    @Override
    public String toString() {
        return "El robot a dado "+pasos+" pasos";
    }
}
