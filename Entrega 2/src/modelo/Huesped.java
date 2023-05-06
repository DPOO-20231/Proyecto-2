package modelo;

import java.util.ArrayList;

public class Huesped {
	private String nombre;
	private String documento;
	private String numeroContacto;
	private String correo;	
	private String huespedRelacionado;
	private String cuentaActual;
	private ArrayList<String> acompañantes = new ArrayList<>();
	private ArrayList<String> cuentasAnteriores = new ArrayList<>();
	
	public Huesped(String nombre, String documento, String numeroContacto, String correo, String huespedRelacionado) {
		this.huespedRelacionado = huespedRelacionado;
		this.nombre = nombre;
		this.documento = documento;
		this.numeroContacto = numeroContacto;
		this.correo = correo;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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
}
