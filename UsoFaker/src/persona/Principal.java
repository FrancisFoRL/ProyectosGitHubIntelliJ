package persona;
import paquete1.Faker;

public class Principal {
    public static void main(String[] args){
        Persona[] personas = new Persona[20];
        rellenarPersona(personas);
        pintarPersona(personas);
    }

    private static void pintarPersona(Persona[] personas){
        for(int x=0; x < personas.length;x++){
            System.out.println("Datos de persona "+x+": "+personas[x]);
        }
    }

    private static void rellenarPersona(Persona[] personas){
        for(int x=0; x < personas.length;x++){
            personas[x]= new Persona();
            personas[x].setNombre(Faker.nombres());
            personas[x].setApellido(Faker.apellidos());
            personas[x].setProvincia(Faker.provincias());
        }
    }
}
