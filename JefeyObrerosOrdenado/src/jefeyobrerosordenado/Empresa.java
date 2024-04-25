package jefeyobrerosordenado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Empresa {
	private ArrayList<Empleado> empleados;
	
	public Empresa() {
		empleados=new ArrayList<Empleado>();
	}
	
	public void annadirEmpleado(Empleado e) {
		empleados.add(e);
	}
	
	public boolean borrarEmpleado(String codigo) {
		Iterator<Empleado> it=empleados.iterator();
		while(it.hasNext()) {
			if (it.next().getCodigo().equals(codigo)) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	public boolean comprobarEmpleadoPorNombre(String nombre) {
		for (Empleado e: empleados) {
			if (e.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}
	
	public Empleado comprabarEmpleadoPorCodigo(String codigo) {
		//Empleado empleado=null;
		for (Empleado e: empleados) {
			if (e.getCodigo().equals(codigo)) {
			//	empleado=e;
				//break;
				return e;
			}
		}
		//return empleado;
		return null;
	}
	
	public double calcularMediaSueldos() {
		double suma=0;
		for (Empleado e: empleados) {
			suma+=e.getSueldo();
		}
		return suma/empleados.size();
		
	}
	
	public void subirSueldo(int porcentaje) {
		for (Empleado e: empleados) {
			e.setSueldo(e.getSueldo()+(e.getSueldo()*porcentaje)/100);
			if (e instanceof Jefe) {
				e.setSueldo(e.getSueldo()+120);
			}
		}
	}
	
	public void ordenarEmpleadosPorCodigo() {
		Collections.sort(empleados);
	}
	
	public void ordenarEmpleadosPorNombre() {
		Collections.sort(empleados, new OrdenPorNombre());
	}
	
	public void ordenarEmpleadosPorSueldo() {
		Collections.sort(empleados, new OrdenPorSueldo());
	}

	@Override
	public String toString() {
		String resultado="";
		for (Empleado e: empleados) {
			System.out.println(e);
		}		
		return resultado;
	}
}
