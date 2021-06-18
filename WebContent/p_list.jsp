<%@page import="Modelo.ProductoBean"%>
<jsp:useBean id="a_prod" class="java.util.ArrayList" scope="request"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Lista de productos</h3>
	<table style='width: 30%;' >
		<tr>
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Categoria</th>
			<th>Descripcion</th>
		</tr>
<%
ProductoBean brod= new ProductoBean();
	for(int i=0;i<a_prod.size();i++){
		brod= (ProductoBean) a_prod.get(i);
	
%>
		<tr>
			<td style='text-align: center;'><%=brod.getId_producto() %></td>
			<td style='text-align: center;'><a href='P_bsq?nom=<%=brod.getNom_producto()%>'><%=brod.getNom_producto() %></a></td>
			<td style='text-align: center;'><%=brod.getPrecio() %></td>
			<td style='text-align: center;'><%=brod.getPro_categoria() %></td>
			<td style='text-align: center;'><%=brod.getPro_descripcion() %></td>
			<td style='text-align: center; padding-left: 20px'><a href='P_dlt?nom=<%=brod.getNom_producto()%>'>Eliminar</a></td>
		</tr>
		<%} %>
	 </table>
	 <a href="producto.jsp">Volver</a>
</body>
</html>