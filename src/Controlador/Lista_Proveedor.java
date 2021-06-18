package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ProveedorBean;

@WebServlet("/Lista_Proveedor")
public class Lista_Proveedor extends HttpServlet {
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
		ArrayList <ProveedorBean> lista=new ArrayList<ProveedorBean>();
		ProveedorBean bpro;
		this.init_mysql();
		try {
			sen=conn.createStatement();
			res=sen.executeQuery("select * from proveedor");
			while(res.next()) {
				bpro=new ProveedorBean();
				bpro.setId_proveedor(res.getString(1));
				bpro.setNom_empresa(res.getString(2));
				bpro.setTelefono(res.getString(3));
				bpro.setDireccion(res.getString(4));
				lista.add(bpro);
			}
			res.close();
			sen.close();
			conn.close();
		}catch(Exception e) {			
		}	
		request.setAttribute("l_proveedores",lista);
		RequestDispatcher rd=
				request.getRequestDispatcher("lista_Proveedor.jsp");
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
