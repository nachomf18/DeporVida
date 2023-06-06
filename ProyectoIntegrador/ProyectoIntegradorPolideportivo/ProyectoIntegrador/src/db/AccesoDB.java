package db;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AccesoDB {

	private String driver;
	private String url;
	
	public AccesoDB() {
		Properties prop = new Properties();
		InputStream is = null;
		
		try {
			is = new FileInputStream("DB/ConfiguracionDB.properties");
			prop.load(is);
			
			driver = prop.getProperty("DRIVER");
			url = prop.getProperty("URL");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexion() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		
		return con;
	}
}
