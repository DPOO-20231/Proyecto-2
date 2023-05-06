package logic;

public class ServicioAlojamiento implements Comsumible{
	private String nombre;
	private String tipoPago = "Individual";
	private int precio;
	private boolean estadoPago;
	private String fechaServicio;

	public ServicioAlojamiento(Habitacion habitacion, String fecha){
		this.nombre = habitacion.getIdHabitación();
		this.precio = habitacion.getPrecio(fecha);
		this.fechaServicio = fecha;
	}

	@Override
	public String getNombre(){
		return nombre;
	}
	
	@Override
	public String getTipoPago() {
		return tipoPago;
	}

	@Override
	public int getPrecio(){
		return precio;
	}

	@Override
	public String mostrarResumen(){
		String formatPrint = "%-15.15s %10.10s %15.15s";
		return String.format(formatPrint, nombre, fechaServicio, Integer.toString(precio));
	}

	@Override
	public String generarTextoFactura(){
		String formatPrint = "%-15.15s %10.10s %14.14s %12.12s";
		return String.format(formatPrint, nombre, fechaServicio, Integer.toString(precio), Boolean.toString(estadoPago));
	}

	@Override
	public boolean getEstadoPago() {
		return estadoPago;
	}

	@Override
	public void setEstadoPago(boolean pago) {
		estadoPago = pago;
	}

	@Override
	public String getFechaServicio() {
		return fechaServicio;
	}
	
	@Override
	public void setFechaServico(String fecha) {
		fechaServicio = fecha;
	}
	
	@Override
    public String toString() {
		return nombre + " - " + tipoPago + " - " + precio + " - " + estadoPago + " - " + fechaServicio;
    }
}
