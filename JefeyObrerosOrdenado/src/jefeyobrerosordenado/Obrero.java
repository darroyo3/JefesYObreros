package jefeyobrerosordenado;

public class Obrero extends Empleado{

	private Jefe jefe;
	private static int contador=1;
	
	public Obrero(String nombre, int edad, double sueldo) {
		super(nombre,edad,sueldo);
		codigo="O"+contador++;
	}
	
	public Obrero(String nombre, int edad, double sueldo, Jefe jefe) {
		super(nombre,edad,sueldo);
		this.jefe=jefe;
	}

	public Jefe getJefe() {
		return jefe;
	}

	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}

	@Override
	public String toString() {
		return super.toString()+" Obrero [jefe=" + jefe.getCodigo() + "]";
	}
	
	
	
}
