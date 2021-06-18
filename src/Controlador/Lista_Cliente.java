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

import Modelo.ClienteBean;

@WebServlet("/Lista_Cliente")
public class Lista_Cliente extends HttpServlet {
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
		ArrayList <ClienteBean> lista=new ArrayList<ClienteBean>();
		ClienteBean clien;
		this.init_mysql();
		try {
			sen=conn.createStatement();
			res=sen.executeQuery("select * from cliente");
			while(res.next()) {
				clien=new ClienteBean();
				clien.setId_cliente(res.getString(1));
				clien.setNombres(res.getString(2));
				clien.setApellidos(res.getString(3));
				clien.setDni(res.getString(4));
				clien.setNro_telefono(res.getString(5));
				lista.add(clien);
			}
			res.close();
			sen.close();
			conn.close();
		}catch(Exception e) {			
		}	
		request.setAttribute("l_clientes",lista);
		RequestDispatcher rd=
				request.getRequestDispatcher("lista_Cliente.jsp");
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
