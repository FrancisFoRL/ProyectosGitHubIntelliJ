package federacion;

public class Fecha {
    private int dia, mes, anio;

    public Fecha(){
        anio = 1;
        mes = 1;
        dia = 1;
    }

    public Fecha(int mes, int dia, int anio) {
        if (comprobarAnio(anio)) {
            this.anio = anio;
        } else {
            this.anio = 1;
        }

        if (comprobarMes(mes)) {
            this.mes = mes;
        } else {
            this.mes = 1;
        }

        if (comprobarDia(dia, mes, anio)) {
            this.dia = dia;
        } else {
            this.dia = 1;
        }
    }
//Todo Comprobar funcion fecha completa
    public boolean setFechaCompleta(int dia, int mes, int anio){
        if (comprobarAnio(anio)) {
            this.anio = anio;
        } else {
            return false;
        }

        if (comprobarMes(mes)) {
            this.mes = mes;
        } else {
            return false;
        }

        if (comprobarDia(dia, mes, anio)) {
            this.dia = dia;
        } else {
            return false;
        }
        return true;
    }

    public boolean setFechaCompletaRango(int rangoMayor, int rangoMenor, int dia, int mes, int anio){
        if (comprobarAnio(anio) || anio <= rangoMayor || anio >= rangoMenor) {
            this.anio = anio;
        } else {
            return false;
        }

        if (comprobarMes(mes)) {
            this.mes = mes;
        } else {
            return false;
        }

        if (comprobarDia(dia, mes, anio)) {
            this.dia = dia;
        } else {
            return false;
        }
        return true;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    private static boolean comprobarAnio(int anio) {
        if (anio < 1950 || anio > 2018) {
            return false;
        }
        return true;
    }

    private boolean comprobarMes(int mes) {
        if (mes < 1 || mes > 12) {
            return false;
        }
        return true;
    }

    public boolean comprobarDia(int dia, int mes, int anio) {
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            if (dia < 1 || dia > 31) {
                return false;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia < 1 || dia > 30) {
                return false;
            }
        } else if (mes == 2 && anioBisiesto(anio)) {
            if (dia < 1 || dia > 29) {
                return false;
            }
        } else if (mes == 2) {
            if (dia < 1 || dia > 28) {
                return false;
            }
        }
        return true;
    }

    private boolean anioBisiesto(int anio){
        if(anio % 4 == 0){
            return anio % 100 != 0;
        }else if(anio % 100 == 0){
            return anio % 400 == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }


}
