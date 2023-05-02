package consola;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import modelo.PropertyManagamentSystem;


public class consolaHotel {

	private boolean continuar = true;
	private PropertyManagamentSystem PMS = new PropertyManagamentSystem();


	public void ejecutarAplicacion()
	{

		String Rol;

		while (continuar)
		{
			try
			{
				FirstOpcion();
				int Login = Integer.parseInt(input("Por favor seleccione una opción"));
				if (Login == 1)
					{
					Rol = VerifyLogin();
					if (Rol=="Administrador"){
						Admin();
						continuar = false;
						}
					else if (Rol=="Recepcionista"){
						Recep();
						continuar = false;}
					else if (Rol=="Empleado"){
						Emple();
						continuar = false;}
					



					}
				else if (Login == 2)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
public void Admin(){
opcionesAdmin();
Boolean elige = true;
while (elige){
	try
	{
		int Opcion = Integer.parseInt(input("Por favor seleccione una opción"));
		if (Opcion == 1)
		{
		PMS.crearservicio();
		System.out.println("Creado Exitosamente");
		}
		else if (Opcion == 2)
		{
		PMS.consultaservicio();
		}
		else if (Opcion == 3)
		{
			String NServicio = input("Por Favor digite el nombre del servicio ");
			PMS.consultaServicio(NServicio);

		}
		else if (Opcion == 4)
		{
		String NFile = input("Por Favor Digite el nombre del Archivo");
		PMS.crearHabi(NFile);
		}
		else if (Opcion == 5)
		{
			PMS.ModifyHabi();
			System.out.println("Modificado Exitosamente");

		}
		else if (Opcion == 6)
		{
			PMS.CreaPersonal();
			System.out.println("Personal creado");
		}
		else if (Opcion == 7)
		{
			System.out.println("Saliendo de la aplicación ...");
			elige = false;
		}
	}
	catch (NumberFormatException e)
	{
		System.out.println("Debe seleccionar uno de los números de las opciones.");
	}
}
}
public void Emple(){
	opcionesEmpleado();
	Boolean elige = true;
	while (elige){
	try
	{
		int Opcion = Integer.parseInt(input("Por favor seleccione una opción"));
		if (Opcion == 1)
		{
			PMS.crearservicio();
		}
		else if (Opcion == 2)
		{
			Date FechaS=Fecha("Inicio");
			Date FechaE=Fecha("Finalizacion");


		}
		else if (Opcion == 3)
		{
			
		}
		else if (Opcion == 4)
		{
			
		}
		else if (Opcion == 5)
		{
			
		}
		else if (Opcion == 6)
		{
			
		}
		else if (Opcion == 7)
		{
			
		}
		else if (Opcion == 8)
		{
			
		}
		else if (Opcion == 9)
		{
			System.out.println("Saliendo de la aplicación ...");
			elige = false;
		}
	}
	catch (NumberFormatException e)
	{
		System.out.println("Debe seleccionar uno de los números de las opciones.");
	}
}
}


public Date Fecha(String Cpto){
	Date fechaI=null;

	Scanner scanner = new Scanner(System.in);
	System.out.println("Ingrese la fecha de "+Cpto+": (DD/MM/YYYY)");
	String fechaString = scanner.nextLine();

	try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		fechaI = sdf.parse(fechaString);
		
	} catch (ParseException e) {
		System.out.println("Error: formato de fecha inválido.");
	}
	scanner.close();
	return fechaI;
}
public void Recep(){
	opcionesRecepcionista();
	Boolean elige = true;
	while (elige){
	try
	{
		int Opcion = Integer.parseInt(input("Por favor seleccione una opción"));
		if (Opcion == 1)
		{
			String IDHabi = input("Por Favor digite el identificador de la Habitacion");
			PMS.consultaServicio(IDHabi);
		}
		else if (Opcion == 2)
		{
			String IDHabi = input("Por Favor digite el identificador de la Habitacion");
			PMS.consultaReservas(IDHabi);
		}
		else if (Opcion == 3)
		{
			
		}
		else if (Opcion == 4)
		{
			
		}
		else if (Opcion == 5)
		{
			
		}
		else if (Opcion == 6)
		{
			
		}
		else if (Opcion == 7)
		{
			
		}
		else if (Opcion == 8)
		{
			System.out.println("Saliendo de la aplicación ...");
			elige = false;
		}
	}
	catch (NumberFormatException e)
	{
		System.out.println("Debe seleccionar uno de los números de las opciones.");
	}
}
}

public void FirstOpcion()
	{
		System.out.println("\nBienvenido al Property Managament System\n");
		System.out.println("1. Iniciar Sesion");
		System.out.println("2. Salir de la aplicacion");

	}

public void opcionesAdmin()
	{
		System.out.println("\nBienvenido Administrador(a) \n");
		System.out.println("1. Crear Servicio");
		System.out.println("2. Modificar Servicio");
		System.out.println("3. Consultar Servicio");
		System.out.println("4. Crear Habitaciones");
		System.out.println("5. Modificar Habitaciones");
		System.out.println("6. Crear Personal\n");
		System.out.println("7. Salir de la aplicación\n");
	}
public void opcionesRecepcionista()
{
	System.out.println("\nBienvenido Recepcionista\n");
	System.out.println("1. Consultar una Habitacion");
	System.out.println("2. Colsultar Las Reservas de una Habitacion");
	System.out.println("3. Realizar una Reservacion");
	System.out.println("4. Registrar Nuevos Huespeds");
	System.out.println("5. Crear Grupo de Huespeds");
	System.out.println("6. Realizar CheckOut");
	System.out.println("7. Cancelar Reserva");
	System.out.println("8. Salir de la aplicación\n");
}
public void opcionesEmpleado()
{
	System.out.println("\nBienvenido Empleado\n");
	System.out.println("1. Consultar una Habitacion");
	System.out.println("2. Habitacion");
	System.out.println("3. Restaurante");
	System.out.println("4. Registrar Nuevos Huespeds");
	System.out.println("5. Crear Grupo de Huespeds");
	System.out.println("6. Realizar CheckOut");
	System.out.println("7. Crear facturacion");
	System.out.println("8. Cancelar Reserva");
	System.out.println("9. Salir de la aplicación\n");
}
public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
public String VerifyLogin()
{
	String Login = input("Por favor digite su usuario");
	String Password = input("Por favor digite su contraseña");
	String Rol = PMS.VerifyLogin(Login, Password);
	return Rol;
}

public static void main(String[] args)
	{
		consolaHotel consola = new consolaHotel();
		
		consola.ejecutarAplicacion();
	}



}
