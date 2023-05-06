package logic;

public interface Comsumible {
	public String getNombre();
	public String getTipoPago();
	public int getPrecio();
	public String mostrarResumen();
	public String generarTextoFactura();
	public boolean getEstadoPago();
	public void setEstadoPago(boolean pago);
	public String getFechaServicio();
	public void setFechaServico(String fecha);
}
