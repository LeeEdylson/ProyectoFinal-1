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

@WebServlet("/Registro_Proveedor")
public class Registro_Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PreparedStatement sen;
	public ResultSet res;

    public Registro_Proveedor() {
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
		String tel=request.getParameter("txtTelefono");
		String dir=request.getParameter("txtDireccion");
		try {Conexion con=new Conexion();
			String reg= "INSERT INTO proveedor"+ "(nom_empresa,telefono,direccion)" +"VALUES  (?,?,?)";
			sen=con.conectar().prepareStatement(reg);
			sen.setString(1, nom);
			sen.setString(2, tel);
			sen.setString(3, dir);
			sen.executeUpdate();
			sen.close();
			con.conectar().close();
		}catch (Exception e) {
		}
		RequestDispatcher rd=request.getRequestDispatcher("correct_proveedor.jsp");
		rd.forward(request, response);
		}

}
