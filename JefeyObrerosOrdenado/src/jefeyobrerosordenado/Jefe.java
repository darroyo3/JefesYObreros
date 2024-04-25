package jefeyobrerosordenado;

import java.util.ArrayList;
import java.util.Iterator;

public class Jefe extends Empleado implements Iterable<Obrero>{

	private ArrayList<Obrero> obreros;
	private static int contador=1;
	
	public Jefe(String nombre, int edad, double sueldo) {
		super(nombre,edad, sueldo);
		codigo="J"+contador++;
		obreros=new ArrayList<>();
	}
	
	public void annadirObrero(Obrero o) {
		obreros.add(o);
	}
	
	public boolean borrarObrero(String codigo) {
		Iterator<Obrero> it=obreros.iterator();
		while(it.hasNext()) {
			if (it.next().getCodigo().equals(codigo)) {
				it.remove();
				return true;
			}
		}
		return false;		
	}
	
	public Obrero obtenerObreroMayorSueldo() {
		if (obreros.isEmpty()) {
			return null;
		}
		Obrero maximo=obreros.get(0);
		for (Obrero o: obreros) {
			if (o.getSueldo()>maximo.getSueldo()) {
				maximo=o;
			}
		}
		return maximo;
	}

	public Obrero obtenerObreroMenorSueldo() {
		if (obreros.isEmpty()) {
			return null;
		}
		Obrero minimo=obreros.get(0);
		for (Obrero o: obreros) {
			if (o.getSueldo()<minimo.getSueldo()) {
				minimo=o;
			}
		}
		return minimo;
	}

	@Override
	public String toString() {
		return super.toString()+" Jefe [obreros=" + obreros + "]";
	}

	@Override
	public Iterator<Obrero> iterator() {
		// TODO Auto-generated method stub
		return obreros.iterator();
	}
	
	
	
}
