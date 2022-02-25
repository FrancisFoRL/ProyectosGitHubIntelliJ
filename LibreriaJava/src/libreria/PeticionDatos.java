package libreria;

import java.util.Scanner;

public class PeticionDatos {
    static boolean comprobar;

    public PeticionDatos() {
    }

    /*
     Función que pide un número entero por teclado y lo devuelve. Gestiona para que no haya excepción
     de petición.
     In: No entra parámetro.
     Out: Devuelve un entero válido introducido por teclado
    */
    public static int pedirEntero() {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print("Dame un numero entero: ");
                numero = sc.nextInt();

            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número entero por teclado y lo devuelve. Gestiona para que no haya excepción
     de petición.
     In: String texto que es el texto a mostrar en la petición.
     Out: Devuelve un entero válido introducido por teclado
    */
    public static int pedirEntero(String texto) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print(texto);
                numero = sc.nextInt();

            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número entero mayor o igual a 0 por teclado y lo devuelve. Gestiona para que
     no haya excepción de petición.
     In: No entra parámetro.
     Out: Devuelve un entero mayor o igual a 0 válido introducido por teclado
    */
    public static int pedirEnteroPositivo() {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print("Dame un numero entero positivo: ");
                numero = sc.nextInt();

                if (numero < 0) {
                    System.out.println("Numero no valido");
                    comprobar = false;
                }
            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número entero mayor o igual a 0 por teclado según el parámetro de entrada y
     lo devuelve. Gestiona para que no haya excepción de petición.
     In: boolean cero: se pasará true si acepta el cero y false si no lo acepta
     Out: Devuelve un entero mayor o igual a 0 válido introducido por teclado según el parámetro de
     entrada
    */
    public static int pedirEnteroPositivo(boolean cero) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        if (!cero) {
            do {
                comprobar = true;
                try {
                    System.out.print("Dame un numero entero positivo: ");
                    numero = sc.nextInt();

                    if (numero <= 0) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else {
            do {
                comprobar = true;
                try {
                    System.out.print("Dame un numero entero positivo: ");
                    numero = sc.nextInt();

                    if (numero < 0) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        }
        return numero;
    }

    /*
     Función que pide un número entero mayor o igual a 0 por teclado según el parámetro de entrada y
     lo devuelve. Gestiona para que no haya excepción de petición.
     In: boolean cero: se pasará true si acepta el cero y false si no lo acepta; String texto que es el texto a
     mostrar en la petición.
     Out: Devuelve un entero mayor o igual a 0 válido introducido por teclado según el parámetro de
     entrada
    */
    public static int pedirEnteroPositivo(boolean cero, String texto) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        if (!cero) {
            do {
                comprobar = true;
                try {
                    System.out.print(texto);
                    numero = sc.nextInt();

                    if (numero <= 0) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else {
            do {
                comprobar = true;
                try {
                    System.out.print(texto);
                    numero = sc.nextInt();

                    if (numero < 0) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        }
        return numero;
    }

    /*
     Función que pide un número entero menor a 0 por teclado y lo devuelve. Gestiona para que no haya
     excepción de petición.
     In: No entra parámetro.
     Out: Devuelve un entero menor a 0 válido introducido por teclado
    */
    public static int pedirEnteroNegativo() {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print("Dame un numero entero negativo: ");
                numero = sc.nextInt();

                if (numero >= 0) {
                    System.out.println("Numero no valido");
                    comprobar = false;
                }
            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número entero menor a 0 por teclado y lo devuelve. Gestiona para que no haya
     excepción de petición.
     In: String texto que es el texto a mostrar en la petición.
     Out: Devuelve un entero menor a 0 válido introducido por teclado
    */
    public static int pedirEnteroNegativo(String texto) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print(texto);
                numero = sc.nextInt();

                if (numero >= 0) {
                    System.out.println("Numero no valido");
                    comprobar = false;
                }
            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número entero por teclado dentro del rango indicado por los parámetros
     incluyendo ambos límites y lo devuelve. Gestiona para que no haya excepción de petición.
     In: int limite1 que indica uno de los limites (superior/inferior). int limite2 que indica el otro limite
     (inferior/superior)
     Out: Devuelve un entero válido introducido por teclado dentro del rango de los límites indicados,
     pudiendo ser uno de los límites.
    */
    public static int pedirEnteroRango(int limite1, int limite2) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        if (limite1 < limite2) {
            do {
                comprobar = true;
                try {
                    System.out.print("Dame un numero entero: ");
                    numero = sc.nextInt();

                    if (numero <= limite1 || numero >= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else if (limite1 > limite2) {
            do {
                comprobar = true;
                try {
                    System.out.print("Dame un numero entero: ");
                    numero = sc.nextInt();

                    if (numero >= limite1 || numero <= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else {
            System.out.println("Rango no valido");
        }
        return numero;
    }

    public static int pedirEnteroRango(int limite1, int limite2, String texto) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        if (limite1 < limite2) {
            do {
                comprobar = true;
                try {
                    System.out.print(texto);
                    numero = sc.nextInt();

                    if (numero <= limite1 || numero >= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else if (limite1 > limite2) {
            do {
                comprobar = true;
                try {
                    System.out.print(texto);
                    numero = sc.nextInt();

                    if (numero >= limite1 || numero <= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else {
            System.out.println("Rango no valido");
        }
        return numero;
    }

    /*
     Función que pide un número entero por teclado dentro del rango indicado por los parámetros
     incluyendo los límites según el tercer parámetro y lo devuelve. Gestiona para que no haya
     excepción de petición.
     In: int limite1 que indica uno de los limites (superior/inferior); int limite2 que indica el otro limite
     (inferior/superior); int incluido que valdrá 0 si no está incluido ninguno de los limites, 1 si esta
     incluido limite1 pero no limite2, 2 si está incluido limite2 pero no limite1, 3 si ambos limites estan
     incluidos. Si vale cualquier otra cosa se considerará como si fuera 0.
     Out: Devuelve un entero válido introducido por teclado dentro del rango de los límites indicados,
     includios estos o no según parámetro.
    */
    public static int pedirEnteroRango(int limite1, int limite2, int incluido) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        switch (incluido) {
            default:
                numero = pedirEnteroRango(limite1, limite2);
                break;

            case 1:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero entero: ");
                            numero = sc.nextInt();

                            if (numero < limite1 || numero >= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero entero: ");
                            numero = sc.nextInt();

                            if (numero > limite1 || numero <= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                }
                break;

            case 2:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero entero: ");
                            numero = sc.nextInt();

                            if (numero <= limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero entero: ");
                            numero = sc.nextInt();

                            if (numero >= limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                }
                break;

            case 3:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero entero: ");
                            numero = sc.nextInt();

                            if (numero < limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero entero: ");
                            numero = sc.nextInt();

                            if (numero > limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                }
                break;

        }
        return numero;
    }

    /*
     Función que pide un número entero por teclado dentro del rango indicado por los parámetros
     incluyendo los límites según el tercer parámetro y lo devuelve. Gestiona para que no haya
     excepción de petición.
     In: int limite1 que indica uno de los limites (superior/inferior); int limite2 que indica el otro limite
     (inferior/superior); int incluido que valdrá 0 si no está incluido ninguno de los limites, 1 si esta
     incluido limite1 pero no limite2, 2 si está incluido limite2 pero no limite1, 3 si ambos limites estan
     incluidos. Si vale cualquier otra cosa se considerará como si fuera 0.; String texto que es el texto a
     mostrar en la petición.
     Out: Devuelve un entero válido introducido por teclado dentro del rango de los límites indicados,
     includios estos o no según parámetro.
    */
    public static int pedirEnteroRango(int limite1, int limite2, int incluido, String texto) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        switch (incluido) {
            default:
                numero = pedirEnteroRango(limite1, limite2,texto);
                break;

            case 1:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();

                            if (numero < limite1 || numero >= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();

                            if (numero > limite1 || numero <= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else {
                    System.out.println("Rango no valido, lo numeros no pueden ser iguales");
                    return 0;
                }
                break;

            case 2:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();

                            if (numero <= limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();

                            if (numero >= limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else {
                    System.out.println("Rango no valido, lo numeros no pueden ser iguales");
                    return 0;
                }
                break;

            case 3:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();

                            if (numero < limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();

                            if (numero > limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else {
                    System.out.println("Rango no valido, lo numeros no pueden ser iguales");
                    return 0;
                }
        }
        return numero;
    }

    /*
     Función que pide un número decimal por teclado y lo devuelve. Gestiona para que no haya
     excepción de petición.
     In: No entra parámetro.
     Out: Devuelve un decimal válido introducido por teclado
    */
    public static double pedirDecimal() {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print("Dame un numero decimal: ");
                numero = sc.nextDouble();

            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número decimal por teclado y lo devuelve. Gestiona para que no haya
     excepción de petición.
     In: String texto que es el texto a mostrar en la petición.
     Out: Devuelve un decimal válido introducido por teclado
    */
    public static double pedirDecimal(String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print(texto);
                numero = sc.nextDouble();

            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número decimal mayor o igual a 0 por teclado y lo devuelve. Gestiona para
     que no haya excepción de petición.,
     In: No entra parámetro.
     Out: Devuelve un decimal mayor o igual a 0 válido introducido por teclado
    */
    public static double pedirDecimalPositivo() {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print("Dame un numero decimal positivo: ");
                numero = sc.nextDouble();

                if (numero < 0) {
                    System.out.println("Numero no valido");
                    comprobar = false;
                }
            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número decimal mayor o igual a 0 por teclado según el parámetro de entrada y
     lo devuelve. Gestiona para que no haya excepción de petición.
     In: boolean cero: se pasará true si acepta el cero y false si no lo acepta
     Out: Devuelve un decimal mayor o igual a 0 válido introducido por teclado según el parámetro de
     entrada
    */
    public static double pedirDecimalPositivo(boolean cero) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        if (!cero) {
            do {
                comprobar = true;
                try {
                    System.out.print("Dame un numero decimal positivo: ");
                    numero = sc.nextDouble();

                    if (numero <= 0) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else {
            do {
                comprobar = true;
                try {
                    System.out.print("Dame un numero decimal positivo: ");
                    numero = sc.nextDouble();

                    if (numero < 0) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        }
        return numero;
    }

    /*
     Función que pide un número decimal mayor o igual a 0 por teclado según el parámetro de entrada y
     lo devuelve. Gestiona para que no haya excepción de petición.
     In: boolean cero: se pasará true si acepta el cero y false si no lo acepta; String texto que es el texto a
     mostrar en la petición.
     Out: Devuelve un decimal mayor o igual a 0 válido introducido por teclado según el parámetro de
     entrada
    */

    public static double pedirDecimalPositivo(boolean cero, String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        if (!cero) {
            do {
                comprobar = true;
                try {
                    System.out.print(texto);
                    numero = sc.nextDouble();

                    if (numero <= 0) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else {
            do {
                comprobar = true;
                try {
                    System.out.print(texto);
                    numero = sc.nextDouble();

                    if (numero < 0) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        }
        return numero;
    }

    /*
     Función que pide un número decimal menor a 0 por teclado y lo devuelve. Gestiona para que no
     haya excepción de petición.
     In: No entra parámetro.
     Out: Devuelve un decimal menor a 0 válido introducido por teclado
    */
    public static double pedirDecimalNegativo() {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print("Dame un decimal negativo: ");
                numero = sc.nextDouble();

                if (numero >= 0) {
                    System.out.println("Numero no valido");
                    comprobar = false;
                }
            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número decimal menor a 0 por teclado y lo devuelve. Gestiona para que no
     haya excepción de petición.
     In: String texto que es el texto a mostrar en la petición.
     Out: Devuelve un decimal menor a 0 válido introducido por teclado
     */
    public static double pedirDecimalNegativo(String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        do {
            comprobar = true;
            try {
                System.out.print(texto);
                numero = sc.nextDouble();

                if (numero >= 0) {
                    System.out.println("Numero no valido");
                    comprobar = false;
                }
            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while (!comprobar);
        return numero;
    }

    /*
     Función que pide un número decimal por teclado dentro del rango indicado por los parámetros
     incluyendo ambos límites y lo devuelve. Gestiona para que no haya excepción de petición.
     In: double limite1 que indica uno de los limites (superior/inferior). double limite2 que indica el otro
     limite (inferior/superior)
     Out: Devuelve un decimal válido introducido por teclado dentro del rango de los límites indicados,
     pudiendo ser uno de los límites.
    */
    public static double pedirDecimalRango(double limite1, double limite2) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        if (limite1 < limite2) {
            do {
                comprobar = true;
                try {
                    System.out.print("Dame un numero decimal: ");
                    numero = sc.nextDouble();

                    if (numero <= limite1 || numero >= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else if (limite1 > limite2) {
            do {
                comprobar = true;
                try {
                    System.out.print("Dame un numero entero: ");
                    numero = sc.nextDouble();

                    if (numero >= limite1 || numero <= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else {
            System.out.println("Rango no valido, lo numeros no pueden ser iguales");
            return 0;
        }
        return numero;
    }

    /*
     Función que pide un número decimal por teclado dentro del rango indicado por los parámetros
     incluyendo ambos límites y lo devuelve. Gestiona para que no haya excepción de petición.
     In: double limite1 que indica uno de los limites (superior/inferior). double limite2 que indica el otro
     limite (inferior/superior); String texto que es el texto a mostrar en la petición.
     Out: Devuelve un decimal válido introducido por teclado dentro del rango de los límites indicados,
     pudiendo ser uno de los límites.
    */
    public static double pedirDecimalRango(double limite1, double limite2, String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        if (limite1 < limite2) {
            do {
                comprobar = true;
                try {
                    System.out.print(texto);
                    numero = sc.nextDouble();

                    if (numero <= limite1 || numero >= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else if (limite1 > limite2) {
            do {
                comprobar = true;
                try {
                    System.out.print(texto);
                    numero = sc.nextDouble();

                    if (numero >= limite1 || numero <= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception e) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while (!comprobar);
        } else {
            System.out.println("Rango no valido, lo numeros no pueden ser iguales");
            return 0;
        }
        return numero;
    }

    /*
     Función que pide un número decimal por teclado dentro del rango indicado por los parámetros
     incluyendo los límites según el tercer parámetro y lo devuelve. Gestiona para que no haya
     excepción de petición.
     In: double limite1 que indica uno de los limites (superior/inferior); double limite2 que indica el otro
     limite (inferior/superior); int incluido que valdrá 0 si no está incluido ninguno de los limites, 1 si
     esta incluido limite1 pero no limite2, 2 si está incluido limite2 pero no limite1, 3 si ambos limites
     estan incluidos. Si vale cualquier otra cosa se considerará como si fuera 0.
     Out: Devuelve un decimal válido introducido por teclado dentro del rango de los límites indicados,
     includios estos o no según parámetro.
    */
    public static double pedirDecimalRango(double limite1, double limite2, int incluido) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        switch (incluido) {
            case 0:
                numero = pedirDecimalRango(limite1, limite2);
                break;

            case 1:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();

                            if (numero < limite1 || numero >= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();

                            if (numero > limite1 || numero <= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                }
                break;

            case 2:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();

                            if (numero <= limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();

                            if (numero >= limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                }
                break;

            case 3:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();

                            if (numero < limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();

                            if (numero > limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                }
                break;
        }
        return numero;
    }

    /*
     Función que pide un número decimal por teclado dentro del rango indicado por los parámetros
     incluyendo los límites según el tercer parámetro y lo devuelve. Gestiona para que no haya
     excepción de petición.
     In: double limite1 que indica uno de los limites (superior/inferior); double limite2 que indica el otro
     limite (inferior/superior); int incluido que valdrá 0 si no está incluido ninguno de los limites, 1 si
     esta incluido limite1 pero no limite2, 2 si está incluido limite2 pero no limite1, 3 si ambos limites
     estan incluidos. Si vale cualquier otra cosa se considerará como si fuera 0; String texto que es el
     texto a mostrar en la petición.
     Out: Devuelve un decimal válido introducido por teclado dentro del rango de los límites indicados,
     includios estos o no según parámetro.
    */
    public static double pedirDecimalRango(double limite1, double limite2, int incluido, String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        switch (incluido) {
            case 0:
                numero = pedirDecimalRango(limite1, limite2);
                break;
            case 1:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextDouble();

                            if (numero < limite1 || numero >= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextDouble();

                            if (numero > limite1 || numero <= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                }
                break;
            case 2:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextDouble();

                            if (numero <= limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextDouble();

                            if (numero >= limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                }
                break;
            case 3:
                if (limite1 < limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print(texto);
                            numero = sc.nextDouble();

                            if (numero < limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                } else if (limite1 > limite2) {
                    do {
                        comprobar = true;
                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();

                            if (numero > limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while (!comprobar);
                }
                break;
        }

        return numero;
    }

    /*
     Función que pide una cadena de caracteres por teclado en la que no haya números ni símbolos de
     puntuación y la devuelve. Gestiona para que no haya excepción de petición.
     In: No entra parámetro.
     Out: Devuelve una cadena de caracteres introducido por teclado en la que no haya números ni
     símbolos de puntuación.
    */
    public static String pedirCadena() {
        Scanner sc = new Scanner(System.in);
        String cadena;
        do {
            comprobar = true;
            System.out.print("Cadena de texto: ");
            cadena = sc.nextLine();
            for (int i = 0; i < cadena.length(); i++) {
                char caracter = cadena.toUpperCase().charAt(i);
                if ((int) caracter != 165 &&  ((int) caracter < 65 || (int) caracter > 90) && (int) caracter!=32) {
                    comprobar = false;
                }
            }
            if (!comprobar) {
                System.out.println("Cadena no valida, solo puede tener letras");
            }
        } while (!comprobar);
        return cadena;
    }

    /*
     Función que pide una cadena de caracteres por teclado en la que no haya números ni símbolos de
     puntuación y la devuelve. Gestiona para que no haya excepción de petición.
     In: String texto que es el texto a mostrar en la petición.
     Out: Devuelve una cadena de caracteres introducido por teclado en la que no haya números ni
     símbolos de puntuación.
    */
    public static String pedirCadena(String texto) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        do {
            comprobar = true;
            System.out.print(texto);
            cadena = sc.nextLine();
            for (int i = 0; i < cadena.length(); i++) {
                char caracter = cadena.toUpperCase().charAt(i);
                if ((int) caracter != 165 && ((int) caracter < 65 || (int) caracter > 90)) {
                    comprobar = false;
                }
            }
            if (!comprobar) {
                System.out.println("Cadena no valida, solo puede tener letras");
            }
        } while (!comprobar);
        return cadena;
    }

    /*
     Función que pide una cadena de caracteres por teclado que tendrá números y/o símbolos de
     puntuación y una longitud determinada según los parámetros de entrada y la devuelve. Gestiona
     para que no haya excepción de petición.
     In: boolean numero true si se aceptan números en la cadena y false si no se aceptan; boolean
     simbolo true si se aceptan símbolos en la cadena y false si no se aceptan; int limite para indicar el
     número máximo de caracteres que se quieren.
     Out: Devuelve una cadena de caracteres introducido por teclado que cumple las condiciones
     indicadas por parámetros.
    */
    public static String pedirCadenaLimite(boolean numero, boolean simbolo, int limite) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        if (!numero && !simbolo) {
            do {
                comprobar = true;
                System.out.print("Cadena de texto: ");
                cadena = sc.nextLine();
                for (int i = 0; i < cadena.length(); i++) {
                    char caracter = cadena.charAt(i);
                    if (!(((int) caracter >= 65 && caracter <= 90) || ((int) caracter >= 97 && caracter <= 122) || ((int) caracter >= 160 && (int) caracter <= 165) || ((int) caracter == 32))) {
                        comprobar = false;
                        System.out.println("Valor no valido: " + caracter);
                    }
                }
                if (cadena.length() > limite) {
                    System.out.println("Cadena no valida, supera el limite de caracteres");
                    comprobar = false;
                }
                if (!comprobar) {
                    System.out.println("Cadena no valida, solo puede tener letras");
                }
            } while (!comprobar);
        } else if (!numero) {
            do {
                comprobar = true;
                System.out.print("Cadena de texto: ");
                cadena = sc.nextLine();
                for (int i = 0; i < cadena.length(); i++) {
                    char caracter = cadena.charAt(i);
                    if ((int) caracter >= 48 && ((int) caracter <= 57)) {
                        comprobar = false;
                        System.out.println("Valor no valido: " + caracter);
                    }
                }
                if (cadena.length() > limite) {
                    System.out.println("Cadena no valida, supera el limite de caracteres");
                    comprobar = false;
                }
                if (!comprobar) {
                    System.out.println("Cadena no valida, solo puede tener letras y simbolos");
                }
            } while (!comprobar);
        } else if (!simbolo) {
            do {
                comprobar = true;
                System.out.print("Cadena de texto: ");
                cadena = sc.nextLine();
                for (int i = 0; i < cadena.length(); i++) {
                    char caracter = cadena.toUpperCase().charAt(i);
                    if (!(((int) caracter >= 65 && caracter <= 90) || ((int) caracter >= 97 && caracter <= 122) || ((int) caracter >= 160 && (int) caracter <= 165) || ((int) caracter >= 48 && (int) caracter <= 56) || ((int) caracter == 32))) {
                        comprobar = false;
                        System.out.println("Valor no valido: " + caracter);
                    }

                }
                if (cadena.length() > limite) {
                    System.out.println("Cadena no valida, supera el limite de caracteres");
                    comprobar = false;
                }
                if (!comprobar) {
                    System.out.println("Cadena no valida, solo puede tener letras y numeros");
                }
            } while (!comprobar);
        } else {
            do {
                comprobar = true;
                System.out.print("Cadena de texto: ");
                cadena = sc.nextLine();

                if (cadena.length() > limite) {
                    System.out.println("Cadena no valida, supera el limite de caracteres");
                    comprobar = false;
                }
            } while (!comprobar);
        }
        return cadena;
    }

    /*
     Función que pide una cadena de caracteres por teclado que tendrá números y/o símbolos de
     puntuación y una longitud determinada según los parámetros de entrada y la devuelve. Gestiona
     para que no haya excepción de petición.
     In: boolean numero true si se aceptan números en la cadena y false si no se aceptan; boolean
     simbolo true si se aceptan símbolos en la cadena y false si no se aceptan; int limite para indicar el
     número máximo de caracteres que se quieren; String texto que es el texto a mostrar en la petición.
     Out: Devuelve una cadena de caracteres introducido por teclado que cumple las condiciones
     indicadas por parámetros.
    */
    public static String pedirCadenaLimite(boolean numero, boolean simbolo, int limite, String texto) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        if (!numero && !simbolo) {
            do {
                comprobar = true;
                System.out.print(texto);
                cadena = sc.nextLine();
                for (int i = 0; i < cadena.length(); i++) {
                    char caracter = cadena.charAt(i);
                    if (!(((int) caracter >= 65 && caracter <= 90) || ((int) caracter >= 97 && caracter <= 122) || ((int) caracter >= 160 && (int) caracter <= 165) || ((int) caracter == 32))) {
                        comprobar = false;
                        System.out.println("Valor no valido: " + caracter);
                    }
                }
                if (cadena.length() > limite) {
                    System.out.println("Cadena no valida, supera el limite de caracteres");
                    comprobar = false;
                }
                if (!comprobar) {
                    System.out.println("Cadena no valida, solo puede tener letras");
                }
            } while (!comprobar);
        } else if (!numero) {
            do {
                comprobar = true;
                System.out.print(texto);
                cadena = sc.nextLine();
                for (int i = 0; i < cadena.length(); i++) {
                    char caracter = cadena.charAt(i);
                    if ((int) caracter >= 48 && ((int) caracter <= 57)) {
                        comprobar = false;
                        System.out.println("Valor no valido: " + caracter);
                    }
                }
                if (cadena.length() > limite) {
                    System.out.println("Cadena no valida, supera el limite de caracteres");
                    comprobar = false;
                }
                if (!comprobar) {
                    System.out.println("Cadena no valida, solo puede tener letras y simbolos");
                }
            } while (!comprobar);
        } else if (!simbolo) {
            do {
                comprobar = true;
                System.out.print(texto);
                cadena = sc.nextLine();
                for (int i = 0; i < cadena.length(); i++) {
                    char caracter = cadena.charAt(i);
                    if (!(((int) caracter >= 65 && caracter <= 90) || ((int) caracter >= 97 && caracter <= 122) || ((int) caracter >= 160 && (int) caracter <= 165) || ((int) caracter >= 48 && (int) caracter <= 56) || ((int) caracter == 32))) {
                        comprobar = false;
                        System.out.println("Valor no valido: " + caracter);
                    }

                }
                if (cadena.length() > limite) {
                    System.out.println("Cadena no valida, supera el limite de caracteres");
                    comprobar = false;
                }
                if (!comprobar) {
                    System.out.println("Cadena no valida, solo puede tener letras y numeros");
                }
            } while (!comprobar);
        } else {
            do {
                comprobar = true;
                System.out.print(texto);
                cadena = sc.nextLine();

                if (cadena.length() > limite) {
                    System.out.println("Cadena no valida, supera el limite de caracteres");
                    comprobar = false;
                }
            } while (!comprobar);
        }
        return cadena;
    }

    /*
     Función que pide una cadena de caracteres por teclado con el formato de NIF/NIE, lo chequea y la
     devuelve. Gestiona para que no haya excepción de petición.
     In: No entra parámetro.
     Out: Devuelve una cadena de caracteres introducido por teclado que sea un NIE o un NIF válido.
    */

    public static String pedirNIF_NIE() {
        Scanner sc = new Scanner(System.in);
        String dni;

        do{
            comprobar = true;
            System.out.print("Dame el NIF/NIE: ");
            dni = sc.nextLine();

            if(!validarNIF_NIE(dni)){
                System.out.println("NIF/NIE no valido");
                comprobar=false;
            }
        }while(!comprobar);
        return dni;
    }

    /*
     Función que recibe por parámetro una cadena y valida si es un NIF o NIE correcto.
     In: String cadena, será una cadena de caracteres que se quiere comprobar como NIF o NIE válido.
     Out: Devuelve un boolean que será true si la cadena es un NIF/NIE valido y false en otro caso.
    */

    public static boolean validarNIF_NIE(String cadena) {
        char numeros;
        int resto, letradni;
        String numDni = "";
        char[] arrayletra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        cadena = cadena.toUpperCase();

        if (cadena.length() != 9) {
            System.out.println("NIF/NIE no valido, longitud incorrecta");
            return false;

        } else if (cadena.charAt(0) == 'X' || cadena.charAt(0) == 'Y' || cadena.charAt(0) == 'Z') {
            try {
                if(cadena.charAt(0) == 'X'){
                    cadena = cadena.replace( 'X','0');
                }else if(cadena.charAt(0) == 'Y'){
                    cadena = cadena.replace('Y','1');
                }else if(cadena.charAt(0) == 'Z'){
                    cadena = cadena.replace('Z','2');
                }
                for (int x = 0; x <= 7; x++) {
                    numeros = cadena.charAt(x);
                    numDni += numeros;
                }
                letradni = Integer.parseInt(numDni);
                resto = letradni % 23;
                if (cadena.charAt(8) != arrayletra[resto]) {
                    System.out.println("NIF invalido, letra incorrecta");
                    return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("NIF invalido, formato incorrecto");
                return false;
            }
        } else {
            for (int x = 0; x <= 7; x++) {
                numeros = cadena.charAt(x);
                numDni += numeros;
                if (!((int) numeros >= 48 && numeros <= 57)) {
                    System.out.println("La letra " + numeros + " no puede estar entre los 8 primeros digitos");
                    return false;
                }
            }
            letradni = Integer.parseInt(numDni);
            resto = letradni % 23;

            if (cadena.charAt(8) != arrayletra[resto]) {
                System.out.println("La letra del DNI " + cadena + " no es correcta");
                return false;
            }
        }
        return true;
    }
}
