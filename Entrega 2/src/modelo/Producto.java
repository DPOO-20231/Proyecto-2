package modelo;

public class Producto {
	String nombre;
	int precio;
	String disponibilidad;
	boolean servicioCuarto;
	
	public Producto(String nombre, int precio, String disponibilidad, boolean servicioCuarto) {
		this.nombre = nombre;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
		this.servicioCuarto = servicioCuarto;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public boolean isServicioCuarto() {
		return servicioCuarto;
	}
}
