package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ProveedorBean;

@WebServlet("/Data_Proveedor")
public class Data_Proveedor extends HttpServlet {
	private Connection conn;
	private String driver="com.mysql.jdbc.Driver";
	private String cadena="jdbc:mysql://localhost/sistema_facturacion";
	private String usuario="root";
	private String clave="";
	private Statement sen;
	private ResultSet res;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		ProveedorBean bprov=new ProveedorBean();
		this.init_mysql();
		try {
			sen=conn.createStatement();
			res=sen.executeQuery("select * from proveedor where id_proveedor = "+codigo);
			while(res.next()) {
				bprov.setId_proveedor(res.getString(1));
				bprov.setNom_empresa(res.getString(2));
				bprov.setTelefono(res.getString(3));
				bprov.setDireccion(res.getString(4));
			}
			res.close();
			sen.close();
			conn.close();
		}catch(Exception e) {
		}
		request.setAttribute("b_proveedores", bprov);
		RequestDispatcher rd=request.getRequestDispatcher("data_Proveedor.jsp");
		rd.forward(request, response);
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
