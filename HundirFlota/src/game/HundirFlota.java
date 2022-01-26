package game;

import libreria.PeticionDatos;

/**
 * Esta clase es la clase principal del juego. Aqui es donde se lleva a cabo la ejecucion del juego.
 * @author Francisco Castillo Brull
 * @version 25/01/2022
 */
public class HundirFlota {

    private static boolean comprobar;

    /**
     * Funcion principal main que ejecuta el juego hundir la flota. Dentro de esta va llamando a funciones para gestionar
     * la posicion de los barcos, para despues empezar el juego y pedir coordenadas hasta que uno de los jugadores acabe
     * con los 2 barcos del contrario..
     */
    public static void main(String[] args) {
        int fila, columna;
        Gestion jugador1 = new Gestion();
        Gestion jugador2 = new Gestion();

        System.out.println(">>>Jugador 1<<<");
        asignaBarcos(jugador1.getTableroGestion(), jugador1.getBarcos());
        System.out.println("\n>>>Jugador 2<<<");
        asignaBarcos(jugador2.getTableroGestion(), jugador2.getBarcos());


        System.out.println("\n////Comienza el Juego////");

        do {
            System.out.println("\n>>>Jugador 1<<<\n");
            jugador2.mostrarArray(jugador1.getTableroVista());
            System.out.println("Barcos del Jugador 2: " + jugador1.getBarcos()+"\n");

            do {
                do {
                    comprobar = true;
                    fila = PeticionDatos.pedirEnteroRango(1,4,3,"Dame la fila: ");
                    columna = PeticionDatos.pedirEnteroRango(1,4,3,"Dame la columna: ");

                    if (jugador1.getTableroVista()[fila][columna].equals("A") || jugador1.getTableroVista()[fila][columna].equals("T")) {
                        System.out.println("\nCoordenada ya usada");
                        comprobar = false;
                    }
                } while (!comprobar);

                jugador1.comprobarPosicion(jugador2.getTableroGestion(), jugador1.getTableroVista(), fila, columna);
                break;
            }while(true);

            if(jugador1.getBarcos()==0){
                break;
            }else{
                System.out.println("\n>>>Jugador 2<<<\n");
                jugador2.mostrarArray(jugador2.getTableroVista());
                System.out.println("Barcos del Jugador 1: " + jugador2.getBarcos()+"\n");
                do {
                    do {
                        comprobar = true;
                        fila = PeticionDatos.pedirEnteroRango(1,4,3,"Dame la fila: ");
                        columna = PeticionDatos.pedirEnteroRango(1,4,3,"Dame la columna: ");

                        if (fila == 0 || columna == 0) {
                            System.out.println("\nCoordenada no valida");
                            comprobar = false;
                        } else if (jugador2.getTableroVista()[fila][columna].equals("A") || jugador2.getTableroVista()[fila][columna].equals("T")) {
                            System.out.println("\nCoordenada ya usada");
                            comprobar = false;
                        }
                    } while (false);

                    jugador2.comprobarPosicion(jugador1.getTableroGestion(), jugador2.getTableroVista(), fila, columna);
                    break;
                }while(true);
            }
        } while (jugador1.getBarcos() != 0 && jugador2.getBarcos() != 0);

        System.out.println("\nFin del Juego");

        if(jugador1.getBarcos() > 0){
            System.out.println("El ganador es Jugador 2");
        }else{
            System.out.println("El ganador es Jugador 1");
        }

    }

    /**
     * Funcion que gestiona la asignacion de los barcos en el mapa. Se controla que no haya ningun error y al final
     * se asigne correctamente. Cada barco tendra un numero, por ejemplo, el barco 1 en la matriz tableroGestion tendra
     * el valor 1 y el barco 2, el valor 2. Con esto conseguimos que cada barco sea independiente y asi eleminamos que no
     * se confundan los barcos.
     *
     * @param matriz El parametro matriz es la matriz que se va a usar para asignarle las cordenadas de los barcos.
     * @param barcos El parametro barcos nos indicara la cantidad de barcos que hay que asignar al tablero.
     */
    private static void asignaBarcos(int[][] matriz, int barcos) {
        int fila, columna, num = 1;
        String cad;
        do {
            try {

                System.out.println("---Barco " + num + "---");
                do {
                    comprobar=true;
                    fila = PeticionDatos.pedirEnteroRango(1,4,3,"Dame la fila: ");
                    columna = PeticionDatos.pedirEnteroRango(1,4,3,"Dame la columna: ");

                    if(num == 2 && matriz[fila][columna] == 1){
                        System.out.println("Coordenada ya usada por otro barco");
                        comprobar=false;
                    }
                } while (!comprobar);

                do {
                    comprobar=true;
                    cad = PeticionDatos.pedirCadena("¿Lo quiere horizontal(H) o vertical(V)?: ");
                    cad = cad.toUpperCase();

                    if(num == 2 && cad.equals("H") && matriz[fila][columna + 1] == 1){
                        System.out.println("Coordenada ya usada por otro barco");
                        comprobar=false;
                    }else if(num == 2 && cad.equals("V") && matriz[fila+1][columna] == 1){
                        System.out.println("Coordenada ya usada por otro barco");
                        comprobar=false;
                    }

                    if(!cad.equals("H") && !cad.equals("V")){
                        System.out.println("Valor incorrecto");
                        comprobar=false;
                    }
                }while(!comprobar);

                if (cad.equals("H")) {
                    matriz[fila][columna + 1] = num;
                } else  {
                    matriz[fila + 1][columna] = num;
                }
                matriz[fila][columna] = num;
                barcos--;
                num++;
            } catch (Exception e) {
                System.out.println("Campo incorrecto");
            }
        } while (barcos != 0);
    }
}
