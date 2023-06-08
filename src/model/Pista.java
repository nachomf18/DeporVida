package model;

public class Pista {

	private String nombre;
	private String deporte;
	private String fecha;
	private String horaDesde;
	private String horaHasta;
	
	public Pista(String nombre, String deporte) {
		super();
		this.nombre = nombre;
		this.deporte = deporte;
	}
	
	public Pista(String nombre, String deporte, String fecha, String horaDesde, String horaHasta) {
		super();
		this.nombre = nombre;
		this.deporte = deporte;
		this.fecha = fecha;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDeporte() {
		return deporte;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHoraDesde() {
		return horaDesde;
	}

	public String getHoraHasta() {
		return horaHasta;
	}
}
