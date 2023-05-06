package modelo;
import java.util.ArrayList;

public class ServicioRestaurante implements Comsumible{
	private String nombre = "Servicio Restaurante";
	private String tipoPago = "Individual";
	private int precio = 0;
	private boolean estadoPago;
	private String fechaServicio;
	private String resumen = "";
	
	public ServicioRestaurante(ArrayList<Producto> pedido) {
		int index = 1;
		String formatPrint = "%-3.3s %-25.25s %14.14s";
		resumen += String.format(formatPrint, "#", "Producto", "Precio") + "\n";
		for(Producto producto : pedido) {
			precio += producto.getPrecio();
			resumen += String.format(formatPrint, Integer.toString(index) + "- ", producto.getNombre(), Integer.toString(producto.getPrecio())) + "\n";
			index++;
		}
	}

	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String getTipoPago() {
		return tipoPago;
	}

	@Override
	public int getPrecio() {
		return precio;
	}

	@Override
	public String mostrarResumen() {
		return resumen;
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
