<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modelo.ProveedorBean"%>
<jsp:useBean id="l_proveedores" class="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>Código</th><th>Nombre de Empresa</th><th>Teléfono</th><th>Dirección</th>
	</tr>
	<%
	ProveedorBean bpro=new ProveedorBean();
	for(int i=0;i<l_proveedores.size();i++){
		bpro=(ProveedorBean)l_proveedores.get(i);
	%>
		<tr>
			<td><a href='Data_Proveedor?codigo=<%=bpro.getId_proveedor()%>'><%=bpro.getId_proveedor()%></a></td>
			<td><%=bpro.getNom_empresa()%></td>
			<td><%=bpro.getTelefono()%></td>
			<td><%=bpro.getDireccion()%></td>
			<td><a href='Delete_Proveedor?codigo=<%=bpro.getId_proveedor()%>'>Eliminar</a></td>
		</tr>
		<%} %>
</table>
<a href="proveedor.jsp">volver</a>
</body>
</html>