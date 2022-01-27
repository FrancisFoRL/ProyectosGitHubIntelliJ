package prueba;

import libreria.GestionArray;
import paquete1.Faker;

public class Principal {
    public static void main (String[] args){
        String[] array = new String [100];
        rellenarArray(array);
        GestionArray.buscar_secuencial(array,"Fran");
    }

    private static void rellenarArray(String[] personas){
        for(int x=0; x < personas.length;x++){
            personas[x] = Faker.nombres();
        }
    }
}
