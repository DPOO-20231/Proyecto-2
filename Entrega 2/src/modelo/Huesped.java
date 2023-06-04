package modelo;

import java.util.ArrayList;

import java.util.HashMap;

public class Huesped extends Usuario{
	private String huespedRelacionado;
	private String cuentaActual;
	private ArrayList<String> acompañantes = new ArrayList<>();
	private ArrayList<String> cuentasAnteriores = new ArrayList<>();
	
	protected HashMap<String, Cuenta> cuentas;
	Huesped(String nombre, String ID, String numeroContacto, String correo, String rol, String usuario,
			String contrasenia, HashMap<String, Habitacion> habitaciones, String huespedRelacionado) {
		super(nombre, ID, numeroContacto, correo, rol, usuario, contrasenia, habitaciones);
		this.huespedRelacionado = huespedRelacionado;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return ID;
	}

	public void setDocumento(String documento) {
		this.ID = documento;
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getHuespedRelacionado() {
		return huespedRelacionado;
	}
	
	public void setHuespedRelacionado(String huespedRelacionado) {
		this.huespedRelacionado = huespedRelacionado;
	}

	public ArrayList<String> getAcompañantes() {
		return acompañantes;
	}
	
	public String getCuentaActual() {
		return cuentaActual;
	}
	
	public void setCuentaActual(String cuentaActual) {
		this.cuentaActual = cuentaActual;
	}

	public ArrayList<String> getCuentasAnteriores() {
		return cuentasAnteriores;
	}
	
	public void agregarCuentaAnterior(String idCuenta) {
		cuentasAnteriores.add(idCuenta);
	}
	
	public void agregarAcompañante(String documentoAcompañante) {
		acompañantes.add(documentoAcompañante);
	}
	
	public ArrayList<Habitacion> verificarDisponibilidad(String fecha) {
		HashMap<String, Habitacion> habitacion = this.habitaciones;
		ArrayList<Habitacion> rta = new ArrayList<Habitacion>();
		for (Habitacion habi : habitacion.values()) {
			HashMap<String, Disponibilidad> disponibilidad = habi.getDisponibilidad();
			for (String dis : disponibilidad.keySet()) {
				if (dis == fecha) {
					rta.add(habi);
				}
			}
		}
		return rta;
	}
	
	public void nuevaReserva(Huesped huesped, Comsumible servicioAlojamiento, boolean pago, String fecha, String idCuenta) {
		Cuenta cuenta = new Cuenta(idCuenta, huesped.getDocumento());
		cuenta.agregarServicio(servicioAlojamiento, pago, fecha);
		cuentas.put(idCuenta, cuenta);
		huesped.setCuentaActual(idCuenta);
	}
}
