package Controlador;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registro_Cliente")
public class Registro_Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PreparedStatement sen;
	public ResultSet res;
    public Registro_Cliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("txtNombre");
		String ape=request.getParameter("txtApellido");
		String dni=request.getParameter("txtDni");
		String tele=request.getParameter("txtTelefono");
		try {Conexion con=new Conexion();
			String reg= "INSERT INTO cliente"+ "(nombres,apellidos,dni,nro_telefono)" +"VALUES  (?,?,?,?)";
			sen=con.conectar().prepareStatement(reg);
			sen.setString(1, nom);
			sen.setString(2, ape);
			sen.setString(3, dni);
			sen.setString(4, tele);
			sen.executeUpdate();
			sen.close();
			con.conectar().close();
		}catch (Exception e) {
		}
		RequestDispatcher rd=request.getRequestDispatcher("correct_cliente.jsp");
		rd.forward(request, response);
		}
}
