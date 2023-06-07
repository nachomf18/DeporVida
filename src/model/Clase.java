package model;

public class Clase {

	private String nombre;
	private String descripcion;
	private String deporte;
	private String dia1;
	private String dia2;
	private String horaDesde;
	private String horaHasta;
	
	public Clase(String nombre, String descripcion, String deporte, String dia1, String dia2,
			String horaDesde, String horaHasta) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.deporte = deporte;
		this.dia1 = dia1;
		this.dia2 = dia2;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getDeporte() {
		return deporte;
	}

	public String getDia1() {
		return dia1;
	}

	public String getDia2() {
		return dia2;
	}

	public String getHoraDesde() {
		return horaDesde;
	}

	public String getHoraHasta() {
		return horaHasta;
	}
}
