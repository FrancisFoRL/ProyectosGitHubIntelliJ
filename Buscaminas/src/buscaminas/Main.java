package buscaminas;

public class Main {
    public static void main(String[] args) {

        for (int x = 0; x < tablero.getTablero().length; x++) {
            System.out.println();
            for (int y = 0; y < tablero.getTablero().length; y++) {
                System.out.print(tablero.getTablero()[x][y]+"  ");
            }
        }
    }
}
