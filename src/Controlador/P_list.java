package Controlador;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modelo.DBconn;
import Modelo.ProductoBean;

@WebServlet("/P_list")
public class P_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PreparedStatement sen;
	public ResultSet res;
    public P_list() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList p_list=new ArrayList();
		ProductoBean prod;
		
		try {
			DBconn con=new DBconn();
			String pprod="select * from producto limit 5";
			sen=con.conectar().prepareStatement(pprod);
			res=sen.executeQuery();
			while(res.next()) {
				prod=new ProductoBean();
				prod.setId_producto(res.getInt(1));
				prod.setNom_producto(res.getString(2));
				prod.setPro_descripcion(res.getString(3));
				prod.setPro_categoria(res.getString(4));
				prod.setPrecio(res.getDouble(5));
				p_list.add(prod);
				System.out.println(res.getString(2));
				System.out.println(p_list);
			}
			res.close();
			sen.close();
			con.conectar().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("a_prod", p_list);
		RequestDispatcher rd=
				request.getRequestDispatcher("p_list.jsp");
		rd.forward(request, response);
		
		
	}


}
