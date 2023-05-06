package logic;

public class Cama {
    private String tamaño;
    private int capacidad;
    private String tipo;

    public Cama(String tamaño, int capacidad, String tipo) {
        this.tamaño = tamaño;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getTipo() {
        return tipo;
    }
    
    @Override
    public String toString() {
		return tamaño + " - " + capacidad + " - " + tipo;
    }
}