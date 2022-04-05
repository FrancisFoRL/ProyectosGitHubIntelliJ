package libreria;

import java.util.Scanner;

public class PeticionDatos {
    static boolean comprobar;

    public PeticionDatos() {
    }

    public static int pedirEntero() {
        Scanner sc = new Scanner(System.in);
        int numero = 0;

        do {
            comprobar = true;

            try {
                System.out.print("Dame un numero entero: ");
                numero = sc.nextInt();
            } catch (Exception var3) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

    public static int pedirEntero(String texto) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;

        do {
            comprobar = true;

            try {
                System.out.print(texto);
                numero = sc.nextInt();
            } catch (Exception var4) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

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
            } catch (Exception var3) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

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
                } catch (Exception var5) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
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
                } catch (Exception var4) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        }

        return numero;
    }

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
                } catch (Exception var6) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
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
                } catch (Exception var5) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        }

        return numero;
    }

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
            } catch (Exception var3) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

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
            } catch (Exception var4) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

    public static int pedirEnteroRango(int limite1, int limite2) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        if (limite1 >= limite2) {
            if (limite1 > limite2) {
                do {
                    comprobar = true;

                    try {
                        System.out.print("Dame un numero entero: ");
                        numero = sc.nextInt();
                        if (numero >= limite1 || numero <= limite2) {
                            System.out.println("Numero no valido, fuera del rango");
                            comprobar = false;
                        }
                    } catch (Exception var5) {
                        System.out.println("Valor no valido");
                        sc.nextLine();
                        comprobar = false;
                    }
                } while(!comprobar);
            } else {
                System.out.println("Rango no valido");
            }
        } else {
            do {
                comprobar = true;

                try {
                    System.out.print("Dame un numero entero: ");
                    numero = sc.nextInt();
                    if (numero <= limite1 || numero >= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception var6) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        }

        return numero;
    }

    public static int pedirEnteroRango(int limite1, int limite2, String texto) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        if (limite1 >= limite2) {
            if (limite1 > limite2) {
                do {
                    comprobar = true;

                    try {
                        System.out.print(texto);
                        numero = sc.nextInt();
                        if (numero >= limite1 || numero <= limite2) {
                            System.out.println("Numero no valido, fuera del rango");
                            comprobar = false;
                        }
                    } catch (Exception var6) {
                        System.out.println("Valor no valido");
                        sc.nextLine();
                        comprobar = false;
                    }
                } while(!comprobar);
            } else {
                System.out.println("Rango no valido");
            }
        } else {
            do {
                comprobar = true;

                try {
                    System.out.print(texto);
                    numero = sc.nextInt();
                    if (numero <= limite1 || numero >= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception var7) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        }

        return numero;
    }

    public static int pedirEnteroRango(int limite1, int limite2, int incluido) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        switch(incluido) {
            case 1:
                if (limite1 >= limite2) {
                    if (limite1 > limite2) {
                        do {
                            comprobar = true;

                            try {
                                System.out.print("Dame un numero entero: ");
                                numero = sc.nextInt();
                                if (numero > limite1 || numero <= limite2) {
                                    System.out.println("Numero no valido, fuera del rango");
                                    comprobar = false;
                                }
                            } catch (Exception var10) {
                                System.out.println("Valor no valido");
                                sc.nextLine();
                                comprobar = false;
                            }
                        } while(!comprobar);
                    }
                    break;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print("Dame un numero entero: ");
                            numero = sc.nextInt();
                            if (numero < limite1 || numero >= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var11) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            case 2:
                if (limite1 >= limite2) {
                    if (limite1 > limite2) {
                        do {
                            comprobar = true;

                            try {
                                System.out.print("Dame un numero entero: ");
                                numero = sc.nextInt();
                                if (numero >= limite1 || numero < limite2) {
                                    System.out.println("Numero no valido, fuera del rango");
                                    comprobar = false;
                                }
                            } catch (Exception var8) {
                                System.out.println("Valor no valido");
                                sc.nextLine();
                                comprobar = false;
                            }
                        } while(!comprobar);
                    }
                    break;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print("Dame un numero entero: ");
                            numero = sc.nextInt();
                            if (numero <= limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var9) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            case 3:
                if (limite1 >= limite2) {
                    if (limite1 > limite2) {
                        do {
                            comprobar = true;

                            try {
                                System.out.print("Dame un numero entero: ");
                                numero = sc.nextInt();
                                if (numero > limite1 || numero < limite2) {
                                    System.out.println("Numero no valido, fuera del rango");
                                    comprobar = false;
                                }
                            } catch (Exception var6) {
                                System.out.println("Valor no valido");
                                sc.nextLine();
                                comprobar = false;
                            }
                        } while(!comprobar);
                    }
                    break;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print("Dame un numero entero: ");
                            numero = sc.nextInt();
                            if (numero < limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var7) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            default:
                numero = pedirEnteroRango(limite1, limite2);
        }

        return numero;
    }

    public static int pedirEnteroRango(int limite1, int limite2, int incluido, String texto) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        switch(incluido) {
            case 1:
                if (limite1 >= limite2) {
                    if (limite1 <= limite2) {
                        System.out.println("Rango no valido, lo numeros no pueden ser iguales");
                        return 0;
                    }

                    do {
                        comprobar = true;

                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();
                            if (numero > limite1 || numero <= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var11) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();
                            if (numero < limite1 || numero >= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var12) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            case 2:
                if (limite1 >= limite2) {
                    if (limite1 <= limite2) {
                        System.out.println("Rango no valido, lo numeros no pueden ser iguales");
                        return 0;
                    }

                    do {
                        comprobar = true;

                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();
                            if (numero >= limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var9) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();
                            if (numero <= limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var10) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            case 3:
                if (limite1 >= limite2) {
                    if (limite1 <= limite2) {
                        System.out.println("Rango no valido, lo numeros no pueden ser iguales");
                        return 0;
                    }

                    do {
                        comprobar = true;

                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();
                            if (numero > limite1 || numero < limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var7) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print(texto);
                            numero = sc.nextInt();
                            if (numero < limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var8) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            default:
                numero = pedirEnteroRango(limite1, limite2, texto);
                return numero;
        }
    }

    public static double pedirDecimal() {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;

        do {
            comprobar = true;

            try {
                System.out.print("Dame un numero decimal: ");
                numero = sc.nextDouble();
            } catch (Exception var4) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

    public static double pedirDecimal(String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;

        do {
            comprobar = true;

            try {
                System.out.print(texto);
                numero = sc.nextDouble();
            } catch (Exception var5) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

    public static double pedirDecimalPositivo() {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;

        do {
            comprobar = true;

            try {
                System.out.print("Dame un numero decimal positivo: ");
                numero = sc.nextDouble();
                if (numero < 0.0D) {
                    System.out.println("Numero no valido");
                    comprobar = false;
                }
            } catch (Exception var4) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

    public static double pedirDecimalPositivo(boolean cero) {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;
        if (!cero) {
            do {
                comprobar = true;

                try {
                    System.out.print("Dame un numero decimal positivo: ");
                    numero = sc.nextDouble();
                    if (numero <= 0.0D) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception var6) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        } else {
            do {
                comprobar = true;

                try {
                    System.out.print("Dame un numero decimal positivo: ");
                    numero = sc.nextDouble();
                    if (numero < 0.0D) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception var5) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        }

        return numero;
    }

    public static double pedirDecimalPositivo(boolean cero, String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;
        if (!cero) {
            do {
                comprobar = true;

                try {
                    System.out.print(texto);
                    numero = sc.nextDouble();
                    if (numero <= 0.0D) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception var7) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        } else {
            do {
                comprobar = true;

                try {
                    System.out.print(texto);
                    numero = sc.nextDouble();
                    if (numero < 0.0D) {
                        System.out.println("Numero no valido");
                        comprobar = false;
                    }
                } catch (Exception var6) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        }

        return numero;
    }

    public static double pedirDecimalNegativo() {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;

        do {
            comprobar = true;

            try {
                System.out.print("Dame un decimal negativo: ");
                numero = sc.nextDouble();
                if (numero >= 0.0D) {
                    System.out.println("Numero no valido");
                    comprobar = false;
                }
            } catch (Exception var4) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

    public static double pedirDecimalNegativo(String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;

        do {
            comprobar = true;

            try {
                System.out.print(texto);
                numero = sc.nextDouble();
                if (numero >= 0.0D) {
                    System.out.println("Numero no valido");
                    comprobar = false;
                }
            } catch (Exception var5) {
                System.out.println("Valor no valido");
                sc.nextLine();
                comprobar = false;
            }
        } while(!comprobar);

        return numero;
    }

    public static double pedirDecimalRango(double limite1, double limite2) {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;
        if (!(limite1 < limite2)) {
            if (!(limite1 > limite2)) {
                System.out.println("Rango no valido, lo numeros no pueden ser iguales");
                return 0.0D;
            }

            do {
                comprobar = true;

                try {
                    System.out.print("Dame un numero entero: ");
                    numero = sc.nextDouble();
                    if (numero >= limite1 || numero <= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception var8) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        } else {
            do {
                comprobar = true;

                try {
                    System.out.print("Dame un numero decimal: ");
                    numero = sc.nextDouble();
                    if (numero <= limite1 || numero >= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception var9) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        }

        return numero;
    }

    public static double pedirDecimalRango(double limite1, double limite2, String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;
        if (!(limite1 < limite2)) {
            if (!(limite1 > limite2)) {
                System.out.println("Rango no valido, lo numeros no pueden ser iguales");
                return 0.0D;
            }

            do {
                comprobar = true;

                try {
                    System.out.print(texto);
                    numero = sc.nextDouble();
                    if (numero >= limite1 || numero <= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception var9) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        } else {
            do {
                comprobar = true;

                try {
                    System.out.print(texto);
                    numero = sc.nextDouble();
                    if (numero <= limite1 || numero >= limite2) {
                        System.out.println("Numero no valido, fuera del rango");
                        comprobar = false;
                    }
                } catch (Exception var10) {
                    System.out.println("Valor no valido");
                    sc.nextLine();
                    comprobar = false;
                }
            } while(!comprobar);
        }

        return numero;
    }

    public static double pedirDecimalRango(double limite1, double limite2, int incluido) {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;
        switch(incluido) {
            case 0:
                numero = pedirDecimalRango(limite1, limite2);
                break;
            case 1:
                if (!(limite1 < limite2)) {
                    if (limite1 > limite2) {
                        do {
                            comprobar = true;

                            try {
                                System.out.print("Dame un numero decimal: ");
                                numero = sc.nextDouble();
                                if (numero > limite1 || numero <= limite2) {
                                    System.out.println("Numero no valido, fuera del rango");
                                    comprobar = false;
                                }
                            } catch (Exception var13) {
                                System.out.println("Valor no valido");
                                sc.nextLine();
                                comprobar = false;
                            }
                        } while(!comprobar);
                    }
                    break;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();
                            if (numero < limite1 || numero >= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var14) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            case 2:
                if (!(limite1 < limite2)) {
                    if (limite1 > limite2) {
                        do {
                            comprobar = true;

                            try {
                                System.out.print("Dame un numero decimal: ");
                                numero = sc.nextDouble();
                                if (numero >= limite1 || numero < limite2) {
                                    System.out.println("Numero no valido, fuera del rango");
                                    comprobar = false;
                                }
                            } catch (Exception var11) {
                                System.out.println("Valor no valido");
                                sc.nextLine();
                                comprobar = false;
                            }
                        } while(!comprobar);
                    }
                    break;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();
                            if (numero <= limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var12) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            case 3:
                if (!(limite1 < limite2)) {
                    if (limite1 > limite2) {
                        do {
                            comprobar = true;

                            try {
                                System.out.print("Dame un numero decimal: ");
                                numero = sc.nextDouble();
                                if (numero > limite1 || numero < limite2) {
                                    System.out.println("Numero no valido, fuera del rango");
                                    comprobar = false;
                                }
                            } catch (Exception var9) {
                                System.out.println("Valor no valido");
                                sc.nextLine();
                                comprobar = false;
                            }
                        } while(!comprobar);
                    }
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print("Dame un numero decimal: ");
                            numero = sc.nextDouble();
                            if (numero < limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var10) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);
                }
        }

        return numero;
    }

    public static double pedirDecimalRango(double limite1, double limite2, int incluido, String texto) {
        Scanner sc = new Scanner(System.in);
        double numero = 0.0D;
        switch(incluido) {
            case 0:
                numero = pedirDecimalRango(limite1, limite2);
                break;
            case 1:
                if (!(limite1 < limite2)) {
                    if (limite1 > limite2) {
                        do {
                            comprobar = true;

                            try {
                                System.out.print(texto);
                                numero = sc.nextDouble();
                                if (numero > limite1 || numero <= limite2) {
                                    System.out.println("Numero no valido, fuera del rango");
                                    comprobar = false;
                                }
                            } catch (Exception var14) {
                                System.out.println("Valor no valido");
                                sc.nextLine();
                                comprobar = false;
                            }
                        } while(!comprobar);
                    }
                    break;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print(texto);
                            numero = sc.nextDouble();
                            if (numero < limite1 || numero >= limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var15) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            case 2:
                if (!(limite1 < limite2)) {
                    if (limite1 > limite2) {
                        do {
                            comprobar = true;

                            try {
                                System.out.print(texto);
                                numero = sc.nextDouble();
                                if (numero >= limite1 || numero < limite2) {
                                    System.out.println("Numero no valido, fuera del rango");
                                    comprobar = false;
                                }
                            } catch (Exception var12) {
                                System.out.println("Valor no valido");
                                sc.nextLine();
                                comprobar = false;
                            }
                        } while(!comprobar);
                    }
                    break;
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print(texto);
                            numero = sc.nextDouble();
                            if (numero <= limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var13) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);

                    return numero;
                }
            case 3:
                if (!(limite1 < limite2)) {
                    if (limite1 > limite2) {
                        do {
                            comprobar = true;

                            try {
                                System.out.print("Dame un numero decimal: ");
                                numero = sc.nextDouble();
                                if (numero > limite1 || numero < limite2) {
                                    System.out.println("Numero no valido, fuera del rango");
                                    comprobar = false;
                                }
                            } catch (Exception var10) {
                                System.out.println("Valor no valido");
                                sc.nextLine();
                                comprobar = false;
                            }
                        } while(!comprobar);
                    }
                } else {
                    do {
                        comprobar = true;

                        try {
                            System.out.print(texto);
                            numero = sc.nextDouble();
                            if (numero < limite1 || numero > limite2) {
                                System.out.println("Numero no valido, fuera del rango");
                                comprobar = false;
                            }
                        } catch (Exception var11) {
                            System.out.println("Valor no valido");
                            sc.nextLine();
                            comprobar = false;
                        }
                    } while(!comprobar);
                }
        }

        return numero;
    }

    public static String pedirCadena() {
        Scanner sc = new Scanner(System.in);

        String cadena;
        do {
            comprobar = true;
            System.out.print("Cadena de texto: ");
            cadena = sc.nextLine();

            for(int i = 0; i < cadena.length(); ++i) {
                char caracter = cadena.toUpperCase().charAt(i);
                if (caracter != 165 && (caracter < 'A' || caracter > 'Z') && caracter != ' ') {
                    comprobar = false;
                }
            }

            if (!comprobar) {
                System.out.println("Cadena no valida, solo puede tener letras");
            }
        } while(!comprobar);

        return cadena;
    }

    public static String pedirCadena(String texto) {
        Scanner sc = new Scanner(System.in);

        String cadena;
        do {
            comprobar = true;
            System.out.print(texto);
            cadena = sc.nextLine();

            for(int i = 0; i < cadena.length(); ++i) {
                char caracter = cadena.toUpperCase().charAt(i);
                if (caracter != 165 && (caracter < 'A' || caracter > 'Z') && caracter != ' ') {
                    comprobar = false;
                }
            }

            if (!comprobar) {
                System.out.println("Cadena no valida, solo puede tener letras");
            }
        } while(!comprobar);

        return cadena;
    }

    public static String pedirCadenaLimite(boolean numero, boolean simbolo, int limite) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        int i;
        char caracter;
        if (!numero && !simbolo) {
            do {
                comprobar = true;
                System.out.print("Cadena de texto: ");
                cadena = sc.nextLine();

                for(i = 0; i < cadena.length(); ++i) {
                    caracter = cadena.charAt(i);
                    if ((caracter < 'A' || caracter > 'Z') && (caracter < 'a' || caracter > 'z') && (caracter < 160 || caracter > 165) && caracter != ' ') {
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
            } while(!comprobar);
        } else if (numero) {
            if (!simbolo) {
                do {
                    comprobar = true;
                    System.out.print("Cadena de texto: ");
                    cadena = sc.nextLine();

                    for(i = 0; i < cadena.length(); ++i) {
                        caracter = cadena.toUpperCase().charAt(i);
                        if ((caracter < 'A' || caracter > 'Z') && (caracter < 'a' || caracter > 'z') && (caracter < 160 || caracter > 165) && (caracter < '0' || caracter > '8') && caracter != ' ') {
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
                } while(!comprobar);
            } else {
                do {
                    comprobar = true;
                    System.out.print("Cadena de texto: ");
                    cadena = sc.nextLine();
                    if (cadena.length() > limite) {
                        System.out.println("Cadena no valida, supera el limite de caracteres");
                        comprobar = false;
                    }
                } while(!comprobar);
            }
        } else {
            do {
                comprobar = true;
                System.out.print("Cadena de texto: ");
                cadena = sc.nextLine();

                for(i = 0; i < cadena.length(); ++i) {
                    caracter = cadena.charAt(i);
                    if (caracter >= '0' && caracter <= '9') {
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
            } while(!comprobar);
        }

        return cadena;
    }

    public static String pedirCadenaLimite(boolean numero, boolean simbolo, int limite, String texto) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        int i;
        char caracter;
        if (!numero && !simbolo) {
            do {
                comprobar = true;
                System.out.print(texto);
                cadena = sc.nextLine();

                for(i = 0; i < cadena.length(); ++i) {
                    caracter = cadena.charAt(i);
                    if ((caracter < 'A' || caracter > 'Z') && (caracter < 'a' || caracter > 'z') && (caracter < 160 || caracter > 165) && caracter != ' ') {
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
            } while(!comprobar);
        } else if (numero) {
            if (!simbolo) {
                do {
                    comprobar = true;
                    System.out.print(texto);
                    cadena = sc.nextLine();

                    for(i = 0; i < cadena.length(); ++i) {
                        caracter = cadena.charAt(i);
                        if ((caracter < 'A' || caracter > 'Z') && (caracter < 'a' || caracter > 'z') && (caracter < 160 || caracter > 165) && (caracter < '0' || caracter > '8') && caracter != ' ') {
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
                } while(!comprobar);
            } else {
                do {
                    comprobar = true;
                    System.out.print(texto);
                    cadena = sc.nextLine();
                    if (cadena.length() > limite) {
                        System.out.println("Cadena no valida, supera el limite de caracteres");
                        comprobar = false;
                    }
                } while(!comprobar);
            }
        } else {
            do {
                comprobar = true;
                System.out.print(texto);
                cadena = sc.nextLine();

                for(i = 0; i < cadena.length(); ++i) {
                    caracter = cadena.charAt(i);
                    if (caracter >= '0' && caracter <= '9') {
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
            } while(!comprobar);
        }

        return cadena;
    }

    public static String pedirNIF_NIE() {
        Scanner sc = new Scanner(System.in);
        String dni;
        do {
            comprobar = true;
            System.out.print("Dame el NIF/NIE: ");
            dni = sc.nextLine();
            if (!validarNIF_NIE(dni)) {
                System.out.println("NIF/NIE no valido");
                comprobar = false;
            }
        } while(!comprobar);

        return dni;
    }

    public static boolean validarNIF_NIE(String cadena) {
        String numDni = "";
        char[] arrayletra = new char[]{'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        cadena = cadena.toUpperCase();
        if (cadena.length() > 9) {
            System.out.println("NIF/NIE no valido, longitud incorrecta");
            return false;
        } else {
            char numeros;
            int resto;
            int letradni;
            int x;
            if (cadena.charAt(0) != 'X' && cadena.charAt(0) != 'Y' && cadena.charAt(0) != 'Z') {
                x = 0;

                while(true) {
                    if (x > 7) {
                        letradni = Integer.parseInt(numDni);
                        resto = letradni % 23;
                        if (cadena.charAt(8) != arrayletra[resto]) {
                            System.out.println("La letra del DNI " + cadena + " no es correcta");
                            return false;
                        }
                        break;
                    }

                    numeros = cadena.charAt(x);
                    numDni = numDni + numeros;
                    if (numeros < '0' || numeros > '9') {
                        System.out.println("La letra " + numeros + " no puede estar entre los 8 primeros digitos");
                        return false;
                    }

                    ++x;
                }
            } else {
                try {
                    if (cadena.charAt(0) == 'X') {
                        cadena = cadena.replace('X', '0');
                    } else if (cadena.charAt(0) == 'Y') {
                        cadena = cadena.replace('Y', '1');
                    } else if (cadena.charAt(0) == 'Z') {
                        cadena = cadena.replace('Z', '2');
                    }

                    for(x = 0; x <= 7; ++x) {
                        numeros = cadena.charAt(x);
                        numDni = numDni + numeros;
                    }

                    letradni = Integer.parseInt(numDni);
                    resto = letradni % 23;
                    if (cadena.charAt(8) != arrayletra[resto]) {
                        System.out.println("NIF invalido, letra incorrecta");
                        return false;
                    }
                } catch (NumberFormatException var7) {
                    System.out.println("NIF invalido, formato incorrecto");
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        pedirNIF_NIE();
    }
}
