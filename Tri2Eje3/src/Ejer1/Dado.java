package Ejer1;

import java.util.Random;

public class Dado extends Sorteo {

    @Override
    public int lanzar() {
        Random ram = new Random();
        return ram.nextInt(1,7);
    }
}
