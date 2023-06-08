package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Clase;
import model.Pista;
import model.Usuario;

public class PolideportivoPersistencia {

	static final String TABLA_USUARIO = "USUARIO";
	static final String COL_DNI = "DNI";
	static final String COL_PWD = "CONTRASENIA";
	static final String COL_NOMBRE = "NOMBRE";
	static final String COL_APELLIDOS = "APELLIDOS";
	static final String COL_EMAIL = "EMAIL";
	static final String COL_TELEFONO = "TELEFONO";
	static final String COL_ANIO = "ANIO_NAC";
	static final String TABLA_CLASE = "CLASE";
	static final String COL_DESCRIPCION = "DESCRIPCION";
	static final String COL_DEPORTE = "DEPORTE";
	static final String COL_DIA1 = "DIA_1";
	static final String COL_DIA2 = "DIA_2";
	static final String COL_HORA_DESDE = "HORA_DESDE";
	static final String COL_HORA_HASTA = "HORA_HASTA";
	static final String TABLA_USUARIO_CLASE = "USUARIO_CLASE";
	static final String TABLA_PISTA = "PISTA";
	static final String TABLA_USUARIO_PISTA = "USUARIO_PISTA";
	static final String COL_FECHA = "FECHA";
	static final String COL_NOMBRE_CLASE = "NOMBRE_CLASE";
	static final String COL_NOMBRE_PISTA = "NOMBRE_PISTA";
	
	private AccesoDB acceso;

	public PolideportivoPersistencia() {
		acceso = new AccesoDB();
	}
	
	public String verificarUsuario(Usuario usuario) {
		String query = "SELECT " + COL_DNI + ", " + COL_PWD + " FROM " + TABLA_USUARIO 
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
		String query = "INSERT INTO " + TABLA_USUARIO + "(" + COL_DNI + ", " + COL_NOMBRE + ", " + COL_APELLIDOS 
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

	public ArrayList<Clase> filtrarClase(String deporte) {
		ArrayList<Clase> listaClases = new ArrayList<>();
		
		String query = "SELECT " + COL_NOMBRE + ", " + COL_DESCRIPCION + ", " 
		+ COL_DEPORTE + ", " + COL_DIA1 + ", " + COL_DIA2 + ", " + COL_HORA_DESDE + ", " + COL_HORA_HASTA 
		+ " FROM " + TABLA_CLASE;
		
		if(!deporte.equals("Todos")) {
			query += " WHERE " + COL_DEPORTE + " = ?";
		}
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			
			if(!deporte.equals("Todos")) {
				stmt.setString(1, deporte);
			}
					
			rslt = stmt.executeQuery();
			
			while(rslt.next()) {
				listaClases.add(new Clase(rslt.getString(COL_NOMBRE),  rslt.getString(COL_DESCRIPCION), 
						rslt.getString(COL_DEPORTE), rslt.getString(COL_DIA1), rslt.getString(COL_DIA2), 
						rslt.getString(COL_HORA_DESDE), rslt.getString(COL_HORA_HASTA)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
		return listaClases;
	}

	public int addUsuarioClase(String nombre, String dni) {
		String query = "INSERT INTO " + TABLA_USUARIO_CLASE + "(" + COL_DNI + ", " + COL_NOMBRE_CLASE + ") VALUES (?, ?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, dni);
			stmt.setString(2, nombre);
			
			res = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			res = -1;
		}
		
		return res;
	}

	public ArrayList<Pista> filtrarPista(String deporte) {
		ArrayList<Pista> listaPistas = new ArrayList<>();
		
		String query = "SELECT " + COL_NOMBRE + ", " + COL_DEPORTE + " FROM " + TABLA_PISTA;
		
		if(!deporte.equals("Todos")) {
			query += " WHERE " + COL_DEPORTE + " = ?";
		}
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			
			if(!deporte.equals("Todos")) {
				stmt.setString(1, deporte);
			}
					
			rslt = stmt.executeQuery();
			
			while(rslt.next()) {
				listaPistas.add(new Pista(rslt.getString(COL_NOMBRE), rslt.getString(COL_DEPORTE)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
		return listaPistas;
	}

	public int addUsuarioPista(String nombre, String dni, String fecha, String hora) {
		String query = "INSERT INTO " + TABLA_USUARIO_PISTA + "(" + COL_DNI + ", " + COL_NOMBRE_PISTA + ", " + COL_FECHA 
				+ ", " + COL_HORA_DESDE + ", " + COL_HORA_HASTA + ") VALUES (?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, dni);
			stmt.setString(2, nombre);
			stmt.setString(3, fecha);
			stmt.setString(4, hora.split(" - ")[0]);
			stmt.setString(5, hora.split(" - ")[1]);
			
			res = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			res = -1;
		}
		
		return res;
	}

	public String comprobarReserva(String nombre, String fecha, String hora) {
		String query = "SELECT " + COL_NOMBRE_PISTA + ", " + COL_FECHA + ", " + COL_HORA_DESDE + ", " + COL_HORA_HASTA 
				+ " FROM " + TABLA_USUARIO_PISTA 
				+ " WHERE " + COL_NOMBRE_PISTA + " = ? AND " + COL_FECHA  + " = ? AND " + COL_HORA_DESDE + " = ? AND " 
				+ COL_HORA_HASTA + " = ?";
		
		String resultado = "";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			stmt.setString(2, fecha);
			stmt.setString(3, hora.split(" - ")[0]);
			stmt.setString(4, hora.split(" - ")[1]);
			
			rslt = stmt.executeQuery();
			
			if (rslt.next()) {
				resultado = "Está pistada ya está reservada";
			} else {
				resultado = "Pista reservada con éxito";
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

	public int modPassword(String newPwd, String dni) {
		String query = "UPDATE " + TABLA_USUARIO + " SET " + COL_PWD + " = ? WHERE " + COL_DNI + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, newPwd);
			stmt.setString(2, dni);
			
			res = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			res = -1;
		}
		
		return res;
	}

	public ArrayList<Clase> selectUsuarioClases(String dni) {
		ArrayList<Clase> listaClasesUsuario = new ArrayList<>();
		
		String query = "SELECT C." + COL_NOMBRE + ", C." + COL_DESCRIPCION + ", C." 
		+ COL_DEPORTE + ", C." + COL_DIA1 + ", C." + COL_DIA2 + ", C." + COL_HORA_DESDE + ", C." + COL_HORA_HASTA 
		+ " FROM " + TABLA_CLASE + " C, " +  TABLA_USUARIO_CLASE + " UC WHERE UC." + COL_DNI + " = ? AND UC." 
		+ COL_NOMBRE_CLASE + " = C." + COL_NOMBRE;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, dni);
					
			rslt = stmt.executeQuery();
			
			while(rslt.next()) {
				listaClasesUsuario.add(new Clase(rslt.getString(COL_NOMBRE),  rslt.getString(COL_DESCRIPCION), 
						rslt.getString(COL_DEPORTE), rslt.getString(COL_DIA1), rslt.getString(COL_DIA2), 
						rslt.getString(COL_HORA_DESDE), rslt.getString(COL_HORA_HASTA)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
		return listaClasesUsuario;
	}

	public Usuario selectDatosUsuario(String dni) {
		Usuario datosUsuario = null;
		
		String query = "SELECT " + COL_DNI + ", " + COL_NOMBRE + ", " + COL_APELLIDOS 
				+ ", " + COL_ANIO + ", " + COL_TELEFONO + ", " + COL_EMAIL + ", " + COL_PWD + " FROM "
				+ TABLA_USUARIO + " WHERE " + COL_DNI + " = ?";
				
				Connection con = null;
				PreparedStatement stmt = null;
				ResultSet rslt = null;

				try {
					con = acceso.getConexion();
					
					stmt = con.prepareStatement(query);
					
					stmt.setString(1, dni);
							
					rslt = stmt.executeQuery();
					
					if(rslt.next()) {
						datosUsuario = new Usuario(rslt.getString(COL_DNI),  rslt.getString(COL_NOMBRE), 
								rslt.getString(COL_APELLIDOS), rslt.getInt(COL_ANIO), rslt.getString(COL_TELEFONO), 
								rslt.getString(COL_EMAIL), rslt.getString(COL_PWD));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
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
				return datosUsuario;
	}

	public ArrayList<Pista> selectUsuarioPista(String dni) {
		ArrayList<Pista> listaPistasUsuario = new ArrayList<>();
		
		String query = "SELECT P." + COL_NOMBRE + ", P." + COL_DEPORTE + ", UP." 
		+ COL_FECHA + ", UP." + COL_HORA_DESDE + ", UP." + COL_HORA_HASTA
		+ " FROM " + TABLA_PISTA + " P, " +  TABLA_USUARIO_PISTA + " UP WHERE UP." + COL_DNI + " = ? AND UP." 
		+ COL_NOMBRE_PISTA + " = P." + COL_NOMBRE;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, dni);
					
			rslt = stmt.executeQuery();
			
			while(rslt.next()) {
				listaPistasUsuario.add(new Pista(rslt.getString(COL_NOMBRE), rslt.getString(COL_DEPORTE), 
						rslt.getString(COL_FECHA), rslt.getString(COL_HORA_DESDE), rslt.getString(COL_HORA_HASTA)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
		return listaPistasUsuario;
	}

	public int eliminarClase(String nombre) {
		String query = "DELETE FROM " + TABLA_USUARIO_CLASE + " WHERE " + COL_NOMBRE_CLASE + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			
			res = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			res = -1;
		}
		
		return res;
	}

	public int eliminarReserva(String nombre) {
		String query = "DELETE FROM " + TABLA_USUARIO_PISTA + " WHERE " + COL_NOMBRE_PISTA + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
}
