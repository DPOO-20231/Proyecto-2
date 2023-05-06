package logic;

import java.util.HashMap;

public class Usuario {
	protected String rol;
	protected String usuario;
	protected String contrasenia;
	protected String nombre;
	protected String ID;
	protected String numeroContacto;
	protected String correo;
	protected HashMap<String, Habitacion> habitaciones;

	Usuario(String nombre, String ID, String numeroContacto, String correo,String rol, String usuario, String contrasenia, HashMap<String, Habitacion> habitaciones) {
		this.rol = rol;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.ID = ID;
		this.numeroContacto = numeroContacto;
		this.correo = correo;
		this.habitaciones = habitaciones;
	}
	
	public String getRol() {
		return rol;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}
	

	public String getNombre() {
		return nombre;
	}

	public String getID() {
		return ID;
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	public String getCorreo() {
		return correo;
	}
	
	public void setContrasenia(String newContra) {
		contrasenia = newContra;
	}
}
