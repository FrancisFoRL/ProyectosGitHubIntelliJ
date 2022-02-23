package Serialzar;

import java.io.*;

public class SerializatorCoche {

    public static void escribirCoche(String ruta, Coche[] c) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            for (Coche coche : c) {
                oss.writeObject(coche);
            }

            oss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Coche[] leerCoche(String ruta) {
        Coche coche = null;
        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0; i < coche.)
            coche = (Coche) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return coche;
    }

    public static void main(String[] args) {
        Coche c = null;
        for (int i = 0; i < 10; i++) {
            c = new Coche(4, "Coche_" + (i + 1), "NEGRO", "BMW");
        }
        String nombre_archivo = "coche.ser";
        escribirCoche(nombre_archivo,c);

    }
}
