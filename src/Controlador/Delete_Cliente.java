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

@WebServlet("/Delete_Cliente")
public class Delete_Cliente extends HttpServlet {
	private Connection conn;
	private String driver="com.mysql.jdbc.Driver";
	private String cadena="jdbc:mysql://localhost/sistema_facturacion";
	private String usuario="root";
	private String clave="";
	private Statement sen;
	private static final long serialVersionUID = 1L;
    public Delete_Cliente() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo=request.getParameter("codigo");
		String de;
		this.init_mysql();
		try {
			sen=conn.createStatement();
			de="DELETE FROM cliente WHERE id_cliente= "+codigo;
			sen.executeUpdate(de);
			sen.close();
			conn.close();
		}catch(Exception e) {
			
		}
		response.sendRedirect("Lista_Cliente");
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
