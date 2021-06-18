package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private Connection conn;
	private String driver="com.mysql.jdbc.Driver";
	private String cadena="jdbc:mysql://localhost/sistema_facturacion";
	private String usuario="root";
	private String clave="";
	
	public Connection conectar() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(cadena,usuario,clave);
		}catch (Exception e) {
			
		}
		return conn;
	}

}
