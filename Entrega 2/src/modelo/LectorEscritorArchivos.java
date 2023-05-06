package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class LectorEscritorArchivos {
	
	private ArrayList<Comsumible> servicios ;
	private ArrayList<Producto> menu;
	private HashMap<String, Usuario> credenciales;
	private HashMap<String, Huesped> clientes;
	private HashMap<String, Habitacion> habitaciones;
	private HashMap<String, Cuenta> cuentas;
	private HashMap<String, String> registroConsumos ;
	
	private File archivoServicios = new File("data/archivoServicios.txt");
	private File archivoMenu = new File("data/archivoMenu.txt");
	private File archivoCredenciales = new File("data/archivoCredenciales.txt");
	private File archivoClientes = new File("data/archivoClientes.txt");
	private File archivoHabitaciones = new File("data/archivoHabitaciones.txt");
	private File archivoCuentas = new File("data/archivoCuentas.txt");
	private File archivoRegistroConsumos = new File("data/archivoRegistroConsumos.txt");
	
	
	public LectorEscritorArchivos(ArrayList<Comsumible> servicios, ArrayList<Producto> menu,
			HashMap<String, Usuario> credenciales, HashMap<String, Huesped> clientes,
			HashMap<String, Habitacion> habitaciones, HashMap<String, Cuenta> cuentas,
			HashMap<String, String> registroConsumos) {
		this.servicios = servicios;
		this.menu = menu;
		this.credenciales = credenciales;
		this.clientes = clientes;
		this.habitaciones = habitaciones;
		this.cuentas = cuentas;
		this.registroConsumos = registroConsumos;
	}

	public void cargarDatos() {
		try {
			servicios.clear();
			menu.clear();
			cargarCredenciales();
			cargarServicios();
			cargarMenu();
			cargarClientes();
			cargarHabitaciones();
			cargarCuentas();
			cargarRegistroConsumos();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarServicios() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoServicios));
		String linea = br.readLine();
		while (linea != null) {
			String[] informacion = linea.split(",");
			String nombre = informacion[0];
			String tipoPago = informacion[1];
			int precio = Integer.parseInt(informacion[2]);
			Comsumible servicio = new ServicioExterno(nombre, tipoPago, precio);
			servicios.add(servicio);
			linea = br.readLine();
		}
		br.close();
	}
	
	public void cargarCredenciales() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoCredenciales));
		String linea = br.readLine();
		while (linea != null) {
			String[] informacion = linea.split(";");
			String nombre = informacion[0];
			String documentoIdentidad = informacion[1];
			String numeroContacto = informacion[2];
			String EMail = informacion[3];
			String tipoRol = informacion[4];
			String usuario = informacion[5];
			String contraseña = informacion[6];
			
			Usuario nuevoUsuario = null;
			if(tipoRol.equals("Administrador")){				
				nuevoUsuario = new Administrador(nombre, documentoIdentidad, numeroContacto, EMail, tipoRol, usuario, contraseña, habitaciones, credenciales);
			}else if(tipoRol.equals("Empleado")) {
				nuevoUsuario = new Empleado(nombre, documentoIdentidad, numeroContacto, EMail, tipoRol, usuario, contraseña, habitaciones, cuentas);
			}else if(tipoRol.equals("Recepcionista")) {
				nuevoUsuario = new Recepcionista(nombre, documentoIdentidad, numeroContacto, EMail, tipoRol, usuario, contraseña, habitaciones, cuentas, clientes);
			}
			
			credenciales.put(usuario, nuevoUsuario);
			linea = br.readLine();
		}
		br.close();
	}
	
	public void cargarMenu() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String linea = br.readLine();
		while (linea != null) {
			String[] informacion = linea.split(",");
			String nombre = informacion[0];
			int precio = Integer.parseInt(informacion[1]);
			String disponibilidad = informacion[2];
			boolean servicioCuarto = Boolean.parseBoolean(informacion[3]);
			Producto producto = new Producto(nombre, precio, disponibilidad, servicioCuarto);
			menu.add(producto);
			linea = br.readLine();
		}
		br.close();
	}
	
	public void cargarClientes() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoClientes));
		String linea = br.readLine();
		while (linea != null) {
			String[] informacion = linea.split(";");
			String nombre = informacion[0];
			String documentoIdentidad = informacion[1];
			String numeroContacto = informacion[2];
			String EMail = informacion[3];
			String huespedRelacionado = informacion[4];
			String cuentaActual = informacion[5];
			String acompañantes = informacion[6];
			String cuentasAnteriores = informacion[7];
			Huesped huesped = new Huesped(nombre, documentoIdentidad, numeroContacto, EMail, huespedRelacionado);
			huesped.setCuentaActual(cuentaActual);
			for(String acompañante : acompañantes.substring(1, acompañantes.length() - 1).split(", ")) {
				if(!acompañante.isEmpty()) {
			        huesped.agregarAcompañante(acompañante);
			    }
			}
			for(String cuentaAnterior : cuentasAnteriores.substring(1, cuentasAnteriores.length() - 1).split(", ")) {
				if (!cuentaAnterior.isEmpty()) {
			        huesped.agregarCuentaAnterior(cuentaAnterior);
			    }
				
			}
			clientes.put(documentoIdentidad, huesped);
			linea = br.readLine();
		}
		br.close();
	}
	
	public void cargarRegistroConsumos() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoRegistroConsumos));
		String linea = br.readLine();
		while(linea != null) {
			String[] informacion = linea.split(",");
			String fecha = informacion[0];
			String consumos = informacion[1];
			registroConsumos.put(fecha, consumos);
			linea = br.readLine();
		}
		br.close();
		String fechaActual = DateTimeFormatter.BASIC_ISO_DATE.format(LocalDateTime.now());
		if(!registroConsumos.keySet().contains(fechaActual)) {
			registroConsumos.put(fechaActual, "0");
			actualizarInformacion();
		}
	}
	
	public void cargarCuentas() throws FileNotFoundException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(archivoCuentas));
		String linea = br.readLine();
		while (linea != null) {
			String[] informacion = linea.split(";");
			String idCuenta = informacion[0];
			String documentoIdentidad = informacion[1];
			String serviciosConsumidos = informacion[2];
			Cuenta cuenta = new Cuenta(idCuenta, documentoIdentidad);
			for(String stringServicioConsumido : serviciosConsumidos.substring(1, serviciosConsumidos.length() - 1).split(", ")) {
	            String[] servicioConsumido = stringServicioConsumido.split(" - ");
	            String nombre = servicioConsumido[0];
	            String tipoPago = servicioConsumido[1];
	            int precio = Integer.parseInt(servicioConsumido[2]);
	            boolean estadoPago = Boolean.valueOf(servicioConsumido[3]);
	            String fecha = servicioConsumido[4];
	            Comsumible servicio = new ServicioExterno(nombre, tipoPago, precio);
	            cuenta.agregarServicio(servicio, estadoPago, fecha);
	        }
			cuentas.put(idCuenta, cuenta);
			linea = br.readLine();
		}
		br.close();
	}
	
	public void cargarHabitaciones() throws FileNotFoundException, IOException{
		boolean actualizar = false;
		BufferedReader br = new BufferedReader(new FileReader(archivoHabitaciones));
		String linea = br.readLine();
		while (linea != null) {
			String[] informacion = linea.split(";");
			String idHabitacion = informacion[0];
			String tipo = String.valueOf(informacion[1]);
			String ubicacion = informacion[2];
			boolean balcon = Boolean.parseBoolean(informacion[3]);
			boolean vista = Boolean.parseBoolean(informacion[4]);
			boolean cocina = Boolean.parseBoolean(informacion[5]);
			String camas = informacion[6];
			String disponibilidadArchivo = informacion[7];
			Habitacion habitacion = new Habitacion(idHabitacion, tipo, ubicacion, balcon, vista, cocina);
			for(String stringCama : camas.substring(1, camas.length() - 1).split(", ")) {
				if(!stringCama.isEmpty()) {
					String[] camaInformacion = stringCama.split(" - ");
					String tamaño = camaInformacion[0];
					int capacidad = Integer.parseInt(camaInformacion[1]);
					String tipoCama = camaInformacion[2];
					Cama cama = new Cama(tamaño, capacidad, tipoCama);
					habitacion.agregarCama(cama);
				}
	        }
			HashMap<String, Disponibilidad> mapDisponibilidad = new HashMap<>();
			int fechaActual = Integer.parseInt(DateTimeFormatter.BASIC_ISO_DATE.format(LocalDateTime.now()));
			for(String disponibilidadArchivoString : disponibilidadArchivo.substring(1, disponibilidadArchivo.length() - 1).split(", ")) {
				if(!disponibilidadArchivoString.isEmpty()) {
					String[] pareja = disponibilidadArchivoString.split("=");
					int fecha = Integer.parseInt(pareja[0]);
					if(fecha >= fechaActual) {
						String[] disponibilidadInformacion = pareja[1].split(" - ");
						String estadoDisponibilidad = disponibilidadInformacion[0];
						int precio = Integer.parseInt(disponibilidadInformacion[1]);
						Disponibilidad disponibilidad = new Disponibilidad(estadoDisponibilidad, precio);
						mapDisponibilidad.put(pareja[0], disponibilidad);
					}
				}
			}
			LocalDate fechaInicial = LocalDate.now();
			for(String fechaLista : obtenerFechas(fechaInicial, 365)) {
				if(!mapDisponibilidad.containsKey(fechaLista)) {
					Disponibilidad disponibilidad = new Disponibilidad("Disponible", habitacion.getPrecioBase());
					mapDisponibilidad.put(fechaLista, disponibilidad);
					actualizar = true;
				}
			}
			habitacion.setDisponibilidad(mapDisponibilidad);
			habitaciones.put(idHabitacion, habitacion);
			linea = br.readLine();
		}
		br.close();
		if(actualizar) {
			actualizarInformacion();
		}
	}
	
	public ArrayList<String> obtenerFechas(LocalDate fechaInicial, int cantidadDias) {
	    ArrayList<String> fechas = new ArrayList<>();
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd");
	    for (int i = 0; i < cantidadDias; i++) {
	      fechas.add(fechaInicial.plusDays(i).format(formato));
	    }
	    return fechas;
	  }
	
	public void actualizarInformacionArchivo(String infoServicios, String infoMenu, String infoCredenciales, String infoClientes, String infoCuentas, String infoRegConsumos, String infoHabit){
		try {
		    FileWriter fw = new FileWriter(archivoServicios);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(infoServicios);
			bw.close();
			
			fw = new FileWriter(archivoMenu);
		    bw = new BufferedWriter(fw);
		    bw.write(infoMenu);
			bw.close();
			
			fw = new FileWriter(archivoCredenciales);
		    bw = new BufferedWriter(fw);
		    bw.write(infoCredenciales);
			bw.close();
			
			fw = new FileWriter(archivoClientes);
		    bw = new BufferedWriter(fw);
		    bw.write(infoClientes);
			bw.close();
			
			fw = new FileWriter(archivoCuentas);
		    bw = new BufferedWriter(fw);
		    bw.write(infoCuentas);
			bw.close();
			
			fw = new FileWriter(archivoRegistroConsumos);
		    bw = new BufferedWriter(fw);
		    bw.write(infoRegConsumos);
			bw.close();
			
			fw = new FileWriter(archivoHabitaciones);
		    bw = new BufferedWriter(fw);
		    bw.write(infoHabit);
			bw.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public void actualizarInformacion() {
		String infoServicios = generarInformacionServicios();
		String infoMenu = generarInformacionMenu();
		String infoCredenciales = generarInformacionCredenciales();
		String infoClientes = generarInformacionClientes();
		String infoCuentas = generarInformacionCuentas();
		String infoRegConsumos = generarInformacionRegistroConsumos();
		String inforHabi = generarInformacionHabitaciones();
		actualizarInformacionArchivo(infoServicios, infoMenu, infoCredenciales, infoClientes, infoCuentas, infoRegConsumos, inforHabi);
	}
	
	private String generarInformacionServicios() {
		String informacion = "";
		for(Comsumible servicio : servicios) {
			informacion += servicio.getNombre() + ",";
			informacion += servicio.getTipoPago().toString() + ",";
			informacion += servicio.getPrecio() + "\n";
		}
		return informacion;
	}
	
	private String generarInformacionMenu() {
		String informacion = "";
		for(Producto producto : menu) {
			informacion += producto.getNombre() + ",";
			informacion += Integer.toString(producto.getPrecio()) + ",";
			informacion += producto.getDisponibilidad() + ",";
			informacion += Boolean.toString(producto.isServicioCuarto()) + "\n";
		}
		return informacion;
	}
	
	private String generarInformacionCredenciales() {
		String informacion = "";
		for(Usuario usuario : credenciales.values()) {
			informacion += usuario.getNombre() + ";";
			informacion += usuario.getID() + ";";
			informacion += usuario.getNumeroContacto() + ";";
			informacion += usuario.getCorreo() + ";";
			informacion += usuario.getRol().toString() + ";";
			informacion += usuario.getUsuario() + ";";
			informacion += usuario.getContrasenia() + "\n";
		}
		return informacion;
	}
	
	private String generarInformacionClientes() {
		String informacion = "";
		for(Huesped huesped : clientes.values()) {
			informacion += huesped.getNombre() + ";";
			informacion += huesped.getDocumento() + ";";
			informacion += huesped.getNumeroContacto() + ";";
			informacion += huesped.getCorreo() + ";";
			informacion += huesped.getHuespedRelacionado() + ";";
			informacion += huesped.getCuentaActual() + ";";
			informacion += huesped.getAcompañantes().toString() + ";";
			informacion += huesped.getCuentasAnteriores().toString() + "\n";
		}
		return informacion;
	}
	
	private String generarInformacionHabitaciones() {
		String informacion = "";
		for(Habitacion habitacion : habitaciones.values()) {
			informacion += habitacion.getIdHabitación() + ";";
			informacion += habitacion.getTipo() + ";";
			informacion += habitacion.getUbicacion() + ";";
			informacion += Boolean.toString(habitacion.isBalcon()) + ";";
			informacion += Boolean.toString(habitacion.isVista()) + ";";
			informacion += Boolean.toString(habitacion.isCocina()) + ";";
			informacion += habitacion.getCamas().toString() + ";";
			informacion += habitacion.getDisponibilidad().toString() + "\n";
		}
		return informacion;
	}
	
	private String generarInformacionCuentas() {
		String informacion = "";
		for(Cuenta cuenta : cuentas.values()) {
			informacion += cuenta.getIdCuenta() + ";";
			informacion += cuenta.getDocumentoIdentidadCliente() + ";";
			informacion += cuenta.getServiciosConsumidos().toString() + "\n";
		}
		return informacion;
	}
	
	private String generarInformacionRegistroConsumos() {
		String informacion = "";
		for(String key : registroConsumos.keySet()) {
			String value = registroConsumos.get(key);
			informacion += key + ",";
			informacion += value + "\n";
		}
		return informacion;
	}
	
}
