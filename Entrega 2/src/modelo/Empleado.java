package modelo;

import java.util.HashMap;

public class Empleado extends Usuario{
	protected HashMap<String, Cuenta> cuentas;
	Empleado(String nombre, String ID, String numeroContacto, String correo, String rol, String usuario,
			String contrasenia, HashMap<String, Habitacion> habitaciones, HashMap<String, Cuenta> cuentas) {
		super(nombre, ID, numeroContacto, correo, rol, usuario, contrasenia, habitaciones);
		this.cuentas = cuentas;
	}
	
	public void agregarServicio(Huesped huesped, Comsumible servicio, boolean pago, String fecha) {
		Cuenta cuenta = cuentas.get(huesped.getCuentaActual());
		cuenta.agregarServicio(servicio, pago, fecha);
		cuentas.put(huesped.getCuentaActual(), cuenta);
	}

}
