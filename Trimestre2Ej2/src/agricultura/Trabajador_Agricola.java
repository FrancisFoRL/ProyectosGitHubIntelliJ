package agricultura;

// no cambies nada de este código, no modiques nada, ni añadas ningún método o atributo
// deja el código tal y como esta,  como mucho se permite añadir el paquete package 
// al que pertenece dentro del proyecto de Intellij IDEA, NetBeans o Eclipse.

public class Trabajador_Agricola {
	// atributos de instancia u objeto
	private String nombre;
	private int dni;
	private double sueldo_base;
	// atributo de clase
	private static int num_trabajadores = 0;
	
	// métodos

	// constructor con atributos
	public Trabajador_Agricola (String nom, int dni2, double sueldo) {
		nombre = nom;
		dni = dni2;
		sueldo_base = sueldo;
		// aumentar num_trabajadores
		num_trabajadores ++;
	}// fin constructor con atributos

	// obtener el número total de trabajadores creados
	public static int getNum_trabajadores() {
		return num_trabajadores;
	}

	// este método devuelve el sueldo del trabajador
	// en este caso coincide el salario con el sueldo base
	public double salario () {
		return sueldo_base;	
	}

	// sobreescribe el método toString que hereda de la clase Object
	@Override
	public String toString() {
		return 	"nombre='" + nombre + '\'' +
				", dni=" + dni +
				", sueldo_base=" + sueldo_base;
	}
} // fin Trabajador_Agricola

// no cambies nada de este código, no modiques nada, ni añadas ningún método o atributo
// deja el código tal y como esta,  como mucho se permite añadir el paquete package 
// al que pertenece dentro del proyecto de Intellij IDEA, NetBeans o Eclipse.
