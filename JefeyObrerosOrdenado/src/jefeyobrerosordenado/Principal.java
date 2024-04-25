package jefeyobrerosordenado;

import java.util.Scanner;

public class Principal {

	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		Empresa empresa=new Empresa();
		String menu="1-Alta empleado\n"+
				"2-Subir sueldo\n"+
				"3-Listar obreros jefe\n"+
				"4-Listar empleados ordenados por codigo\n"+
				"5-Listar empleados ordenados por nombre\n"+
				"6-Listar empleados ordenados por sueldo\n"+
				"-1-Salir";
		int opcion=0;
		do {

			System.out.println(menu);
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				annadirEmpleado(empresa);
				break;
			case 2:
				subirSueldo(empresa); 
				break;
			case 3:
				listarObrerosJefe(empresa);
				break;
			case 4:
				listarEmpleadosOrdPorCodigo(empresa);
				break;
			case 5:
				listarEmpleadosOrdPorNombre(empresa);
				break;
			case 6:
				listarEmpleadosOrdPorSueldo(empresa);
				break;

			default:
				System.out.println("Opcion incorrcta");
			}
			
		}while(opcion!=-1);
		
	}
	




	private static void annadirEmpleado(Empresa empresa) {
		System.out.println("Introduce tipo empleado(0-Jefe,1-Obrero)");
		int tipo=sc.nextInt();
		System.out.println("Dame el nombre:");
		String nombre=sc.next();
		System.out.println("Dame la edad:");
		int edad=sc.nextInt();
		System.out.println("Dame la sueldo:");
		double sueldo=sc.nextDouble();
		if (tipo==0) {
			Jefe jefe=new Jefe(nombre, edad, sueldo);
			empresa.annadirEmpleado(jefe);
		}
		else {
			System.out.println("Dame el código del jefe");
			String codigo=sc.next();
			Empleado jefe=empresa.comprabarEmpleadoPorCodigo(codigo);
			if (jefe==null) {
				System.out.println("Jefe no existe");
			}
			else {
				Obrero o=new Obrero(nombre,edad, sueldo);
				empresa.annadirEmpleado(o);
				o.setJefe((Jefe)jefe);
				((Jefe)jefe).annadirObrero(o);
			}
			
		}
	}
	
	private static void subirSueldo(Empresa empresa) {
		System.out.println("Dame el porcentaje:");
		int porcentaje=sc.nextInt();
		empresa.subirSueldo(porcentaje);
		System.out.println(empresa);
	}
	
	public static void listarObrerosJefe(Empresa empresa) {
		System.out.println("Dame el codigo:");
		String codigo=sc.next();
		Empleado empleado=empresa.comprabarEmpleadoPorCodigo(codigo);
		if (empleado!=null && empleado instanceof Jefe) {
			for (Obrero o: (Jefe)empleado) {
				System.out.println(o);
			}
			System.out.println("Obrero con mayor sueldo");
			System.out.println(((Jefe)empleado).obtenerObreroMayorSueldo());
			System.out.println("Obrero con menor sueldo");
			System.out.println(((Jefe)empleado).obtenerObreroMenorSueldo());

		}
		else {
			System.out.println("Jefe no encontrado.");
		}
	}

	private static void listarEmpleadosOrdPorCodigo(Empresa empresa) {
		// TODO Auto-generated method stub
		empresa.ordenarEmpleadosPorCodigo();
		System.out.println(empresa);
	}

	private static void listarEmpleadosOrdPorSueldo(Empresa empresa) {
		// TODO Auto-generated method stub
		empresa.ordenarEmpleadosPorSueldo();
		System.out.println(empresa);	
	}


	private static void listarEmpleadosOrdPorNombre(Empresa empresa) {
		// TODO Auto-generated method stub
		empresa.ordenarEmpleadosPorNombre();
		System.out.println(empresa);	
	}
}
