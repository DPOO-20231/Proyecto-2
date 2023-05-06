package logic;

import java.util.ArrayList;

public class Cuenta {
	private String idCuenta;
	private String documentoIdentidadCliente;
	private ArrayList<Comsumible> serviciosConsumidos = new ArrayList<>();
	
	public Cuenta(String idCuenta, String documentoIdentidadCliente){
		this.idCuenta = idCuenta;
		this.documentoIdentidadCliente = documentoIdentidadCliente;
	}
	
	public String getIdCuenta(){
		return idCuenta;
	}
	
	public String getDocumentoIdentidadCliente(){
		return documentoIdentidadCliente;
	}
	
	public void agregarServicio(Comsumible servicio, boolean pago, String fecha){
		servicio.setEstadoPago(pago);
		servicio.setFechaServico(fecha);
		serviciosConsumidos.add(servicio);
	}

	public ArrayList<Comsumible> getServiciosConsumidos() {
		return serviciosConsumidos;
	}
	
	private int getPrecioTotal() {
		int precioTotal = 0;
		for(Comsumible servicio : serviciosConsumidos) {
			precioTotal += servicio.getPrecio();
		}
		return precioTotal;
	}
	
	private int getTotalPagosParciales() {
		int pagoParcial = 0;
		for(Comsumible servicio : serviciosConsumidos) {
			if(servicio.getEstadoPago()) {
				pagoParcial += servicio.getPrecio();
			}
		}
		return pagoParcial;
	}
	
	public int getSaldoPendiente() {
		return getPrecioTotal() - getTotalPagosParciales();
	}
	
	public String generarfacturaCuenta() {
		String formatPrint = "%-15.15s %10.10s %14.14s %12.12s";
		String factura = "Hotel\n\nFactura de venta\n\n";
		factura += String.format(formatPrint, "ID Factura:", "", "", idCuenta) + "\n";
		factura += String.format(formatPrint, "Cliente:", "", "", documentoIdentidadCliente) + "\n\n";
		factura += String.format(formatPrint, "Descripcion", "Fecha", "Valor", "Pago") + "\n";
		for(Comsumible servicio : serviciosConsumidos) {
			factura += servicio.generarTextoFactura() + "\n";
		}
		factura += "\n" + String.format(formatPrint, "Pagos parciales:", "", "", Integer.toString(getTotalPagosParciales()));
		factura += "\n" + String.format(formatPrint, "Saldo pendiente:", "", "", Integer.toString(getSaldoPendiente()));
		factura += "\n\n" + String.format(formatPrint, "Valor Total:", "", "", Integer.toString(getPrecioTotal()));
		return factura;
	}

}
