package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Habitacion {
	private String idHabitacion;
	private String tipo;
	private String ubicacion;
	private boolean balcon;
	private boolean vista;
	private boolean cocina;
	private ArrayList<Cama> camas = new ArrayList<>();
	private HashMap<String, Disponibilidad> disponibilidad = new HashMap<>();
	
	public Habitacion(String idHabitacion, String tipo, String ubicacion, boolean balcon, boolean vista, boolean cocina){
		this.idHabitacion = idHabitacion;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.balcon = balcon;
		this.vista = vista;
		this.balcon = balcon;
		this.cocina = cocina;
	}

	public String getIdHabitación() {
		return idHabitacion;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}

	public boolean isBalcon() {
		return balcon;
	}


	public boolean isVista() {
		return vista;
	}


	public boolean isCocina() {
		return cocina;
	}

	public ArrayList<Cama> getCamas() {
		return camas;
	}

	public int getCantidadCamas () {
		return camas.size();
	}
	
	public int getCapacidadNiños() {
		int capacidad = 0;
		for(Cama cama : camas) {
			if(cama.getTipo().equals("Niños")) {
				capacidad += cama.getCapacidad();
			}
		}
		return capacidad;
	}
	
	public int getCapacidadNormal() {
		int capacidad = 0;
		for(Cama cama : camas) {
			if(cama.getTipo().equals("Normal")) {
				capacidad += cama.getCapacidad();
			}
		}
		return capacidad;
	}

	public int getCapacidad () {
		return getCapacidadNiños() + getCapacidadNormal();
	}

	public int getPrecio(String fecha) {
		return disponibilidad.get(fecha).getPrecio();
	}
	
	public void agregarCama(Cama cama) {
		camas.add(cama);
	}

	public HashMap<String, Disponibilidad> getDisponibilidad() {
		return disponibilidad;
	}
	
	public void setDisponibilidad(HashMap<String, Disponibilidad> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	public int getPrecioBase() {
		int precioBase = 0;
		if(getTipo().equals("Estandar")) {
			precioBase = 40500;
		}else if(getTipo().equals("Suite")) {
			precioBase = 80000;
		}else if(getTipo().equals("Suite_Doble")) {
			precioBase = 150000;
		}
		if(isBalcon()) {
			precioBase += 30000;
		}
		if(isVista()) {
			precioBase += 20000;
		}
		if(isCocina()) {
			precioBase += 10000;
		}
		return precioBase;
	}
}