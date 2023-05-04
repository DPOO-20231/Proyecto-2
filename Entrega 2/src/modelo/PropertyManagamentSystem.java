package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import modelo.Administrador;
import modelo.Consumible;
import modelo.Administrador;
import modelo.Recepcionista;
import modelo.Empleado;
import modelo.Reserva;
import modelo.Habitacion;
import modelo.Usuario;
import modelo.Loader;
import modelo.ModificadorDeArchivo;

public class PropertyManagamentSystem {
	public ArrayList<Consumible> servicios;
	public ArrayList<Habitacion> habitaciones;
	public ModificadorDeArchivo modificadorArchivo;
	public ArrayList<Reserva> ConsultaReserva;
	public ArrayList<Producto> productos;
	public ArrayList<Recepcionista> opcionesRecepcionista;
	public ArrayList<Empleado> opcionesEmpleado;
	public HashMap<String, ArrayList<String>> habitacionesOcupadas;
	public ArrayList<Usuario> usuarios;
	public HashMap<String, Empleado> Lempleado;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")

	public PropertyManagamentSystem()
	{
		try {
			Loader.cargarData(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ArrayList<Habitacion> getHabitaciones(){
		return habitaciones;
	}
	
	public ArrayList<Consumible> getServicios(){
		return servicios;
	}
	
	public void cargarHabitaciones(ArrayList<Habitacion> habitaciones, String Namefile)
	{
		
	}
	public void crearservicio()
	{
		Administrador Admin=null;
		Admin.crearservicio(productos);
	}

	public void Modificaservicio()
	{
		Administrador Admin=null;
		Admin.modificarServicio(productos);
	}
	public void consultaservicio()
	{
		Administrador Admin=null;
	}
	public void crearHabi(String NameFile)
	{
		Administrador Admin=null;
		Admin.cargarHabitaciones_mano(habitaciones);
	}
	public void ModifyHabi()
	{
		Administrador Admin=null;
		Admin.modificarHabitacion(habitaciones);
	}
	public void CreaPersonal()
	{
		Administrador Admin=null;
		Admin.cargarPersonal(Lempleado, this);
	}
	public void consultaServicio(String IDServicio){
        Producto servicioEncontrado= null;
    
		for (int i = 0; i < productos.size() && servicioEncontrado == null; i++)
		{
			if (productos.get(i).getNombre().equals(IDServicio))
				servicioEncontrado= productos.get(i);
		}
		if (servicioEncontrado != null){
			String mensaje = "el servicio" + servicioEncontrado.getNombre()+", con Descripcion: "+ servicioEncontrado.getDescripcion() +
			"tiene un valor de: $" + servicioEncontrado.getPrecio()+ " y esta Disponible para cuarto: "+ servicioEncontrado.getDisponibleHabitacion() +
			"desde el "+servicioEncontrado.getInicioDisponible() +" hasta el: " + servicioEncontrado.getFinDisponible();
			System.out.println(mensaje);}
		else
		{
			System.out.println("No se encontro el Servicio con nombre: " + IDServicio);
		}
		}
		
	public void consultaHabitacion(String IDHabitacion){
		Habitacion FindHabi= null;
	
		for (int i = 0; i < habitaciones.size() && FindHabi == null; i++)
		{
			if (habitaciones.get(i).getIdHabi().equals(IDHabitacion))
				FindHabi= habitaciones.get(i);
		}
		if (FindHabi != null){
			String mensaje = "La habitacion No. " + IDHabitacion+" se encuentra en: " +FindHabi.getUbicacion()+"es tipo: "+ FindHabi.getTipo()+
			"tiene "+FindHabi.getNumCamas() + " camas. Tiene una capacidad maxima de: " +FindHabi.getCapacidad()+" huespeds y cuenta con los elementos: "+ FindHabi.getElementosDeCobro();
			System.out.println(mensaje);}
		else
		{
			System.out.println("No se encontro La habitacion No. " + IDHabitacion);
		}
		}
		public void consultaReservas(String IDHabitacion){
			ArrayList<Habitacion> FindHabi= null;
			for (int i = 0; i < ConsultaReserva.size(); i++)
			{
			FindHabi=ConsultaReserva.get(i).getHabitaciones();
				for (int j = 0; j < FindHabi.size(); j++){
					if (FindHabi.get(i).getIdHabi().equals(IDHabitacion)){
						System.out.println("La Habitacion No. "+IDHabitacion+" esta reservada del "+ConsultaReserva.get(i).getDateInicio()+
						"hasta el "+ ConsultaReserva.get(i).getDateFin());
					}
				}
			}
			}
	public void RealizarReserva(){

		Reserva Newreserva = new Reserva(null, null, habitaciones, null, null, null, null);
	}
	


    

	public String VerifyLogin(String IDusuario, String Contraseña)
	{
		String rol="No encontrado";
		Empleado elempleado= null;
		elempleado = Lempleado.get(IDusuario);
		System.out.println(elempleado);
		if (elempleado == null)
		{
			rol = "ID erroneo";
			System.out.println("errado");
		}
		else 
		{
			System.out.println(elempleado.getPassword());
			if (elempleado.getPassword().equals(Contraseña)){
			rol=elempleado.getrol();;
			}
			else {
				rol = "contraseña erronea";
		}
		}
		return rol;
	}

}
