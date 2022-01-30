package persona;

/**
 * Clase Persona que sera un objeto en el cual se le dara un nombre, apellido y provincia
 * en la clase Principal.
 *
 * @author Francisco Castillo
 * @version 25/01/2022
 * @see Principal
 */
public class Persona {

    /**
     * Atributo privado que se usa para almacenar el nombre.
     */
    private String nombre;
    /**
     * Atributo privado que se usa para almacenar el apellido.
     */
    private String apellido;
    /**
     * Atributo privado que se usa para almacenar el apellido2.
     */
    private String apellido2;
    /**
     * Atributo privado que se usa para almacenar la provincia.
     */
    private String provincia;

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " " + apellido2 + " || Provincia: " + provincia;
    }
}
