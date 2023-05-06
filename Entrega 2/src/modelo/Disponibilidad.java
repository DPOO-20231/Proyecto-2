package logic;

public class Disponibilidad {
	private String ocupado;
	private int precio;
	
	public Disponibilidad(String ocupado, int precio) {
		this.ocupado = ocupado;
		this.precio = precio;
	}

	public String getOcupado() {
		return ocupado;
	}

	public void setOcupado(String ocupado) {
		this.ocupado = ocupado;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	@Override
    public String toString() {
		return ocupado + " - " + precio;
    }
}
