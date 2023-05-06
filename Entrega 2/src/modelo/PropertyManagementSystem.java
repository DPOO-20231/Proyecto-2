package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class PropertyManagementSystem {
	private ArrayList<Comsumible> servicios = new ArrayList<>();
	private ArrayList<Producto> menu = new ArrayList<>();
	private HashMap<String, Usuario> credenciales = new HashMap<>();
	private HashMap<String, Huesped> clientes = new HashMap<>();
	private HashMap<String, Habitacion> habitaciones = new HashMap<>();
	private HashMap<String, Cuenta> cuentas = new HashMap<>();
	private HashMap<String, String> registroConsumos = new HashMap<>();
	private LectorEscritorArchivos modificadorArchivos;
	private Administrador adminActivo;
	private Empleado empleadoActivo;
	private Recepcionista recepcionistaActivo;
	
	
	
	public PropertyManagementSystem(){
		modificadorArchivos = new LectorEscritorArchivos(servicios, menu, credenciales, clientes, habitaciones, cuentas, registroConsumos);
		modificadorArchivos.cargarDatos();
	}
	
	//--------------------------------
	//OPCIONES DE INICIO
	//--------------------------------
	public String login(String User, String Password){
		String rol=null;
		Usuario usuariofind=credenciales.get(User);
		if (usuariofind != null){
			if (usuariofind.getContrasenia().equals(Password)){rol=usuariofind.getRol();}
			else { rol="La Contraseña ingresada es erronera";}
		}
		else {rol="El usuario ingresado no esta registrado";}
		return rol;
	}

	public void newPassword(String newPasword) {
		if (adminActivo != null) {
			adminActivo.setContrasenia(newPasword);
			credenciales.put(adminActivo.getUsuario(), adminActivo);
		} else {
			empleadoActivo.setContrasenia(newPasword);
			credenciales.put(empleadoActivo.getUsuario(), empleadoActivo);
		}
		
		modificadorArchivos.actualizarInformacion();
	}
	
	
	//--------------------------------
	//OPCIONES DEL ADMINISTRADOR
	//--------------------------------
	
	public void crearUsuario(String nombre, String documentoIdentidad, String numeroContacto, String eMail, String tipoRol, String usuarioLogIn, String contraseña) {
		adminActivo.crearUsuario(nombre, documentoIdentidad, numeroContacto, eMail, tipoRol, usuarioLogIn, contraseña);
		modificadorArchivos.actualizarInformacion();
	}
	
	public void eliminarUsuario(String usuarioRol) {
		adminActivo.eliminarUsuario(usuarioRol);
		modificadorArchivos.actualizarInformacion();
	}
	
	public Habitacion crearHabitacion(String tipo, String ubicacion, boolean balcon, boolean vista, boolean cocina, ArrayList<Cama> camas) {
		Habitacion habitacion = adminActivo.crearHabitacion(tipo, ubicacion, balcon, vista, cocina, camas);
		modificadorArchivos.actualizarInformacion();
		return habitacion;
	}
	
	public void eliminarHabitacion(String idHabitacion) {
		adminActivo.eliminarHabitacion(idHabitacion);
		modificadorArchivos.actualizarInformacion();
	}
	
	
	public void asignarTarifa(Habitacion habitacion, HashMap<String, Disponibilidad> disponibilidad) {
		habitacion.setDisponibilidad(disponibilidad);
		modificadorArchivos.actualizarInformacion();
	}
	
	public void crearServicioExterno(String nombre, String tipoPago, int precio) {
		ServicioExterno servicioExterno = new ServicioExterno(nombre, tipoPago, precio);
		servicios.add(servicioExterno);
		modificadorArchivos.actualizarInformacion();
	}
	
	
	public void eliminarServicioExterno(String nombre) {
		int indexEliminar = obtenerIndexServicioExterno(nombre);
		servicios.remove(indexEliminar);
		modificadorArchivos.actualizarInformacion();
	}
	
	public void crearProducto(String nombre, int precio, String disponibilidad, boolean servicioCuarto) {
		Producto producto = new Producto(nombre, precio, disponibilidad, servicioCuarto);
		menu.add(producto);
		modificadorArchivos.actualizarInformacion();
	}
	

	
	public void eliminarProducto(String nombre) {
		int indexEliminar = obtenerIndexProducto(nombre);
		menu.remove(indexEliminar);
	}
	
	//OPCIONES EMPLEADO
	
	
	public void nuevaReserva(Huesped huesped, Comsumible servicioAlojamiento, boolean pago, String fecha) {
		String idCuenta = generarIdCuenta();
		recepcionistaActivo.nuevaReserva(huesped, servicioAlojamiento, pago, fecha, idCuenta);
		modificadorArchivos.actualizarInformacion();
	}
	
	public void agregarServicio(Huesped huesped, Comsumible servicio, boolean pago, String fecha) {
		empleadoActivo.agregarServicio(huesped, servicio, pago, fecha);
		modificadorArchivos.actualizarInformacion();
	}
	
	public void pagarTodosServicios(Cuenta cuenta) {
		recepcionistaActivo.pagarTodosServicios(cuenta);
		modificadorArchivos.actualizarInformacion();
	}
	
	public void cerrarCuenta(Cuenta cuenta) {
		recepcionistaActivo.cerrarCuenta(cuenta);
		modificadorArchivos.actualizarInformacion();
	}
	
	public void eliminarServicioConsumido(Cuenta cuenta, Comsumible servicio) {
		recepcionistaActivo.eliminarServicioConsumido(cuenta, servicio);
		modificadorArchivos.actualizarInformacion();
	}
	
	public Huesped encontrarHuespedPrincipal(Huesped huesped) {
		Huesped huespedPrincipal = huesped;
		if(!huesped.getHuespedRelacionado().equals("null")) {
			huespedPrincipal = encontrarHuespedPrincipal(clientes.get(huesped.getHuespedRelacionado()));
		}
		return huespedPrincipal;
	}
	
	public void crearHuesped(String nombre, String documentoIdentidad, String numeroContacto, String eMail, String huespedRelacionado) {
		modificadorArchivos.actualizarInformacion();
	}
	
	
	
	//MÉTODOS AUXILIARES
	
	public String obtenerDiaSemana(String fecha) {
        LocalDate localDate = LocalDate.parse(fecha, DateTimeFormatter.BASIC_ISO_DATE);
        String diaDeLaSemana = localDate.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, new Locale.Builder().setLanguage("es").setRegion("ES").build());
        diaDeLaSemana = diaDeLaSemana.substring(0, 1).toUpperCase() + diaDeLaSemana.substring(1).toLowerCase();
        return diaDeLaSemana;
    }
	
	public int obtenerIndexServicioExterno(String nombre) {
		int index = 0; int i = 0;
		for (Comsumible servicio : servicios) {
			if (servicio.getNombre().equals(nombre)) {
				index = i;
			}
			i++;
		}
		return index;
	}
	
	public ArrayList<Habitacion> buscarHabitaciones(String tipoHabitacion, int capacidad, ArrayList<String> listaFechas){
		ArrayList<Habitacion> habitacionesEncontradas = new ArrayList<>();
		for(Habitacion habitacion : habitaciones.values()) {
			if((habitacion.getTipo().equals(tipoHabitacion)) && (habitacion.getCapacidad() == capacidad)) {
				boolean disponible = true;
				for(String fechaLista : listaFechas) {
					if(habitacion.getDisponibilidad().keySet().contains(fechaLista)) {
						if(!habitacion.getDisponibilidad().get(fechaLista).getOcupado().equals("Disponible")) {
							disponible = false;
						}
					}else {
						disponible = false;
					}
				}
				if(disponible) {
					habitacionesEncontradas.add(habitacion);
				}
			}
		}
		return habitacionesEncontradas;
	}
	
	public int obtenerIndexProducto(String nombre) {
		int index = 0; int i = 0;
		for (Producto producto : menu) {
			if (producto.getNombre().equals(nombre)) {
				index = i;
			}
			i++;
		}
		return index;
	}
	
	public ArrayList<Habitacion> buscarHabitacionesRelacionadas(String tipoHabitacion, int capacidad, ArrayList<String> listaFechas){
		ArrayList<Habitacion> habitacionesRelacionadas = new ArrayList<>();
		for(Habitacion habitacion : habitaciones.values()) {
			if((habitacion.getTipo().equals(tipoHabitacion)) && (habitacion.getCapacidad() >= capacidad)) {
				boolean disponible = false;
				for(String fechaLista : listaFechas) {
					if(habitacion.getDisponibilidad().keySet().contains(fechaLista)) {
						if(habitacion.getDisponibilidad().get(fechaLista).getOcupado().equals("Disponible")) {
							disponible = true;
						}
					}
				}
				if(disponible) {
					habitacionesRelacionadas.add(habitacion);
				}
			}
		}
		return habitacionesRelacionadas;
	}
	
	public void actualizarInfo() {
		modificadorArchivos.actualizarInformacion();
	}
	
	private String generarIdCuenta() {
		String fechaActual = DateTimeFormatter.BASIC_ISO_DATE.format(LocalDateTime.now());
		int numeroPedidos = Integer.parseInt(registroConsumos.get(fechaActual))+1;
		registroConsumos.put(fechaActual, Integer.toString(numeroPedidos));
		return fechaActual + String.format("%03d", numeroPedidos);
	}
	
	public ArrayList<String> obtenerFechas(LocalDate fechaInicial, int cantidadDias) {
	    ArrayList<String> fechas = new ArrayList<>();
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd");
	    for (int i = 0; i < cantidadDias; i++) {
	      fechas.add(fechaInicial.plusDays(i).format(formato));
	    }
	    return fechas;
	  }
	
	public void setUsuarioActivo(Usuario usuario) {
		if (usuario.getRol().equals("Administrador")){
			adminActivo = (Administrador) usuario;
		} else if (usuario.getRol().equals("Empleado")){
			empleadoActivo = (Empleado) usuario;
		} else if (usuario.getRol().equals("Recepcionista")) {
			recepcionistaActivo = (Recepcionista) usuario;
			empleadoActivo = (Empleado) usuario;
		}
	} 

	public ArrayList<Comsumible> getServicios(){
		return servicios;
	}
	
	public ArrayList<Producto> getMenu() {
		return menu;
	}
	
	public HashMap<String, Usuario> getCredenciales() {
		return credenciales;
	}
	
	public HashMap<String, Huesped> getClientes(){
		return clientes;
	}
	
	public HashMap<String, Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	public HashMap<String, Cuenta> getCuentas(){
		return cuentas;
	}

}
