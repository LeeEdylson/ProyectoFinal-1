<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modelo.ClienteBean"%>
<jsp:useBean id="l_clientes" class="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>Código</th><th>Nombre</th><th>Apellido</th><th>Dni</th><th>Teléfono</th>
	</tr>
	<%
	ClienteBean bcli=new ClienteBean();
	for(int i=0;i<l_clientes.size();i++){
		bcli=(ClienteBean)l_clientes.get(i);
	%>
		<tr>
			<td><a href='Data_Cliente?codigo=<%=bcli.getId_cliente()%>'><%=bcli.getId_cliente() %></a></td>
			<td><%=bcli.getNombres() %></td>
			<td><%=bcli.getApellidos() %></td>
			<td><%=bcli.getDni()%></td>
			<td><%=bcli.getNro_telefono()%></td>
			<td><a href='Delete_Cliente?codigo=<%=bcli.getId_cliente()%>'>Eliminar</a></td>
		</tr>
		<%} %>
</table>
<a href="cliente.jsp">volver</a>
</body>

</html>