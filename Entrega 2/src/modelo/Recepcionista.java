package modelo;

import java.util.HashMap;

public class Recepcionista extends Empleado{
	private HashMap<String, Huesped> clientes;
	Recepcionista(String nombre, String ID, String numeroContacto, String correo, String rol, String usuario,
			String contrasenia, HashMap<String, Habitacion> habitaciones, HashMap<String, Cuenta> cuentas, HashMap<String, Huesped> clientes) {
		super(nombre, ID, numeroContacto, correo, rol, usuario, contrasenia, habitaciones, cuentas);
		this.clientes = clientes;
	}
	
	public void crearHuesped(String nombre, String documentoIdentidad, String numeroContacto, String eMail, String huespedRelacionado) {
		Huesped huesped = new Huesped(nombre, documentoIdentidad, numeroContacto, eMail, huespedRelacionado);
		clientes.put(documentoIdentidad, huesped);
		if(huespedRelacionado != null) {
			clientes.get(huespedRelacionado).getAcompañantes().add(documentoIdentidad);
		}
	}
	
	public void eliminarServicioConsumido(Cuenta cuenta, Comsumible servicio) {
		cuenta.getServiciosConsumidos().remove(servicio);
	}
	
	public void cerrarCuenta(Cuenta cuenta) {
		Huesped huesped = clientes.get(cuenta.getDocumentoIdentidadCliente());
		huesped.setCuentaActual(null);
		huesped.getCuentasAnteriores().add(cuenta.getIdCuenta());
		for(String documentoAcompañante : huesped.getAcompañantes()) {
			Huesped acompañante = clientes.get(documentoAcompañante);
			if(acompañante != null) {
				acompañante.setHuespedRelacionado(null);
			}
		}
		for(Comsumible servicio : cuenta.getServiciosConsumidos()) {
			if(habitaciones.containsKey(servicio.getNombre())) {
				Habitacion habitacion = habitaciones.get(servicio.getNombre());
				if(habitacion.getDisponibilidad().keySet().contains(servicio.getFechaServicio())) {
					habitacion.getDisponibilidad().get(servicio.getFechaServicio()).setOcupado("Disponible");
				}
			}
		}
		huesped.getAcompañantes().clear();
	}
	
	public void pagarTodosServicios(Cuenta cuenta) {
		for(Comsumible servicio : cuenta.getServiciosConsumidos()) {
			servicio.setEstadoPago(true);
		}
	}
	
	public void nuevaReserva(Huesped huesped, Comsumible servicioAlojamiento, boolean pago, String fecha, String idCuenta) {
		Cuenta cuenta = new Cuenta(idCuenta, huesped.getDocumento());
		cuenta.agregarServicio(servicioAlojamiento, pago, fecha);
		cuentas.put(idCuenta, cuenta);
		huesped.setCuentaActual(idCuenta);
	}
	
	
}
