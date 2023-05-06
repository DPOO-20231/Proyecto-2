package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Administrador extends Usuario{
	private HashMap<String, Usuario> credenciales;

	Administrador(String nombre, String ID, String numeroContacto, String correo, String rol, String usuario,
		String contrasenia, HashMap<String, Habitacion> habitaciones,  HashMap<String, Usuario> credenciales){
		super(nombre, ID, numeroContacto, correo, rol, usuario, contrasenia, habitaciones);
		this.credenciales = credenciales;
	}
	
	public void crearUsuario(String nombre, String documentoIdentidad, String numeroContacto, String eMail, String tipoRol, String usuarioLogIn, String contraseña) {
		Usuario usuario = new Usuario(nombre, documentoIdentidad, numeroContacto, eMail, tipoRol, usuarioLogIn, contraseña, habitaciones);
		credenciales.put(usuarioLogIn, usuario);
	}
	
	public void eliminarUsuario(String usuarioRol) {
		credenciales.remove(usuarioRol);
	}
	
	public Habitacion crearHabitacion(String tipo, String ubicacion, boolean balcon, boolean vista, boolean cocina, ArrayList<Cama> camas) {
		String idHabitacion = tipo.toString()+ "-" + ubicacion;
		Habitacion habitacion = new Habitacion(idHabitacion, tipo, ubicacion, balcon, vista, cocina);
		for(Cama cama : camas) {
			habitacion.agregarCama(cama);
		}
		habitaciones.put(idHabitacion, habitacion);
		return habitacion;
	}
	
	public void eliminarHabitacion(String idHabitacion) {
		habitaciones.remove(idHabitacion);
	}
}
