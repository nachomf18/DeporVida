package model;

public class Pista {

	private String nombre;
	private String deporte;
	
	public Pista(String nombre, String deporte) {
		super();
		this.nombre = nombre;
		this.deporte = deporte;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDeporte() {
		return deporte;
	}
}
