package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update_Proveedor
 */
@WebServlet("/Update_Proveedor")
public class Update_Proveedor extends HttpServlet {
	private Connection conn;
	private String driver="com.mysql.jdbc.Driver";
	private String cadena="jdbc:mysql://localhost/sistema_facturacion";
	private String usuario="root";
	private String clave="";
	private Statement sen;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo=request.getParameter("Codigo");
		String nom=request.getParameter("Nombre");
		String tel=request.getParameter("Telefono");
		String dire=request.getParameter("Direccion");
		String up;
		this.init_mysql();
		try {
			sen=conn.createStatement();
			up="UPDATE proveedor SET nom_empresa= '"+nom+
					"' ,telefono= '"+tel+
					"' ,direccion= '"+dire+
					"' where id_proveedor= '"+codigo+"'" ;
			sen.executeUpdate(up);
			sen.close();
			conn.close();
		}catch(Exception e) {
			
		}
		response.sendRedirect("Lista_Proveedor");
	}
	public void init_mysql() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(cadena,usuario,clave);
		}catch(ClassNotFoundException e1) {
			
		}catch(SQLException e1) {
			
		}
		
	}

}
