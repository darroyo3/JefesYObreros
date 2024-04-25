package jefeyobrerosordenado;

import java.util.Comparator;

public class OrdenPorSueldo implements Comparator<Empleado>{

	@Override
	public int compare(Empleado o1, Empleado o2) {
		// TODO Auto-generated method stub
		if (o1.getSueldo()==o2.getSueldo()) {
			return o1.getCodigo().compareTo(o2.getCodigo());
		}
		return  o1.getSueldo()-o2.getSueldo()>0?1:-1;			
		
	}


}
