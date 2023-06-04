package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class PolideportivoPersistencia {

	static final String NOM_TABLA = "USUARIO";
	static final String COL_DNI = "DNI";
	static final String COL_PWD = "CONTRASENIA";
	static final String COL_NOMBRE = "NOMBRE";
	static final String COL_APELLIDOS = "APELLIDOS";
	static final String COL_EMAIL = "EMAIL";
	static final String COL_TELEFONO = "TELEFONO";
	static final String COL_ANIO = "ANIO_NAC";
	
	private AccesoDB acceso;

	public PolideportivoPersistencia() {
		acceso = new AccesoDB();
	}
	
	public String verficarUsuario(Usuario usuario) {
		String query = "SELECT " + COL_DNI + ", " + COL_PWD + " FROM " + NOM_TABLA 
				+ " WHERE " + COL_DNI + " = ?";
		
		String resultado = "";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, usuario.getDni());
			
			rslt = stmt.executeQuery();
			
			if (rslt.next()) {
				String pwd = rslt.getString(2);
				
				if (pwd.equals(usuario.getContrasenia())) {
					resultado = "Acceso permitido";
				} else {
					resultado = "Contraseña incorrecta";
				}
			} else {
				resultado = "El usuario no se encuentra en la base de datos";
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Se ha producido un error, póngase en contacto con el administrador";
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				
				if(rslt != null) {
					rslt.close();
				}
				
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}

	public int addUsuario(Usuario usuario) {
		String query = "INSERT INTO " + NOM_TABLA + "(" + COL_DNI + ", " + COL_NOMBRE + ", " + COL_APELLIDOS 
				+ ", " + COL_ANIO + ", " + COL_TELEFONO + ", " + COL_EMAIL + ", " + COL_PWD + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, usuario.getDni());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellidos());
			stmt.setInt(4, usuario.getAnio_nac());
			stmt.setString(5, usuario.getTelefono());
			stmt.setString(6, usuario.getEmail());
			stmt.setString(7, usuario.getContrasenia());
			
			res = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			res = -1;
		}
		
		return res;
	}
}
