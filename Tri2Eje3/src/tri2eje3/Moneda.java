
package tri2eje3;

import java.util.Random;

public class Moneda extends Sorteo {
    @Override
    public int lanzar() {
        Random ram = new Random();
        return ram.nextInt(2);
    }
}
