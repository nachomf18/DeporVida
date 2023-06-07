package model;

public class Usuario {

	private String dni;
	private String nombre;
	private String apellidos;
	private int anio_nac;
	private String telefono;
	private String email;
	private String contrasenia;
	
	public Usuario(String dni, String nombre, String apellidos, int anio_nac, String telefono, String email,
			String contrasenia) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.anio_nac = anio_nac;
		this.telefono = telefono;
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getAnio_nac() {
		return anio_nac;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getContrasenia() {
		return contrasenia;
	}
}
