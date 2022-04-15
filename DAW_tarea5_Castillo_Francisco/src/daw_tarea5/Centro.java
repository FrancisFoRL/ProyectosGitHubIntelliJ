package daw_tarea5;

import java.io.*;
import java.util.Arrays;

public abstract class Centro implements Estadisticas, Serializable {
    private String nombreCentro, direccionCentro;
    private int identificador, contMedicos, contAdministrativos;
    protected int limiteConsultas;
    protected static int contID;
    protected static int contCentros;
    private Paciente[] consultas;
    private Persona[] trabajadores;
    protected static Persona[] delTrabajadores = new Persona[5];
    protected static Persona[] delPaciente = new Persona[5];

    public Centro(String nombreCentro, String direccionCentro, int limiteConsultas) {
        this.nombreCentro = nombreCentro;
        this.direccionCentro = direccionCentro;
        this.consultas = new Paciente[limiteConsultas];//todo limiteconsultas el numero de consultas que tendra?
        this.limiteConsultas = limiteConsultas;
        this.trabajadores = new Persona[5];
        identificador = contID++;
        contCentros++;
    }

    //Getters y Setters
    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getDireccionCentro() {
        return direccionCentro;
    }

    public void setDireccionCentro(String direccionCentro) {
        this.direccionCentro = direccionCentro;
    }

    public Paciente[] getConsultas() {
        return consultas;
    }

    public Persona[] getTrabajadores() {
        return trabajadores;
    }

    public int getIdentificador() {
        return identificador;
    }

    //Funciones
    //todo si contMedico es para el numero de medicos, hacer funcion booleana que devuelva falta si todos los puestos ya estan ocupados
    public void addTrabajador(Persona trabajador) {
        aumentarArray(trabajadores);
        for (int x = 0; x < trabajadores.length; x++) {
            if (trabajadores[x] == null) {
                trabajadores[x] = trabajador;
                if (trabajador instanceof Medico) {
                    contMedicos++;
                    trabajador.posArray = x;
                } else if (trabajador instanceof Administrativo) {
                    contAdministrativos++;
                    trabajador.posArray = x;
                }
                break;
            }
        }
    }

    //todo Crear removeEmpleado para eliminarlo de array
    public boolean removeTrabajador(Persona trabajador) throws IOException, ClassNotFoundException {
        if (trabajador.lugar == -1 && trabajador.posArray == -1) ;
        else if (trabajadores[trabajador.posArray].getDni().equals(trabajador.getDni())) {
            trabajadores[trabajador.posArray] = null;
            trabajador.lugar = -1;
            trabajador.posArray = -1;
            if (trabajador instanceof Medico) {
                contMedicos--;
            } else if (trabajador instanceof Administrativo) {
                contAdministrativos--;
            }
            aumentarArray(delTrabajadores);
            for(int x = 0; x < delTrabajadores.length; x++){
                if(delTrabajadores[x] == null){
                    delTrabajadores[x] = trabajador;
                    break;
                }else if(delTrabajadores[x].getDni().equalsIgnoreCase(trabajador.getDni())){
                    delTrabajadores[x] = null;
                    delTrabajadores[x] = trabajador;
                    break;
                }
            }
            return true;
        }
        return false;
    }

    private static void arrayRemoveTrabajador(Persona enf) throws IOException, ClassNotFoundException {
        File fichero = new File("trabajadores.dat");
        if(fichero.exists()){
            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream("trabajadores.dat"));
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("trabajadores.dat"));
            Persona[] aux = (Persona[]) leerFichero.readObject();
            for(int x = 0; x < aux.length; x++){
                if(aux[x] == null){
                    aux[x] = enf;
                    break;
                }else if(aux[x].getDni().equalsIgnoreCase(enf.getDni())){
                    aux[x] = null;
                    aux[x] = enf;
                    break;
                }
            }
            escribiendoFichero.writeObject(aux);
            escribiendoFichero.close();

        }else{
            Persona[] aux = new Persona[50];
            for(int x = 0; x < aux.length; x++){
                if(aux[x] == null){
                    aux[x] = enf;
                    break;
                }
            }
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("trabajadores.dat"));
            escribiendoFichero.writeObject(aux);
            escribiendoFichero.close();
        }
    }

    /**
     * Funcion que analiza si el array esta lleno y en el caso de que este lleno, aumenta el espacio del array.
     */
    protected void aumentarArray(Persona[] array) {
        if (!Arrays.asList(array).contains(null)){//Arrays.asList nos permite buscar en el array el valor que deseemos, en este caso un null
            Persona[] aux = new Persona[array.length];
            for(int x=0; x< aux.length;x++){
                aux[x] = array[x];
            }
            array = new Persona[aux.length * 2];
            for(int x=0; x< aux.length;x++){
                array[x] = aux[x];
            }
        }
    }

    public static Centro existeCentro(Centro[] centros, String nombre){
        for(int x = 0; x < centros.length; x++){
            if(centros[x] == null);
            else if(centros[x].getNombreCentro().equalsIgnoreCase(nombre)){
                return centros[x];
            }
        }
        return null;
    }


}//Fin de Centro
