<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="b_cliente" class="Modelo.ClienteBean" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Update_Cliente" method="post">
<table>
	<tr><td>Código</td>
			<td><input type='text' readonly name='Codigo'
				value='<%=b_cliente.getId_cliente()%>'></td></tr>
	<tr><td>Nombre</td>
			<td><input type='text' name='Nombre'
				value='<%=b_cliente.getNombres()%>'></td></tr>
	<tr><td>Apellido</td>
			<td><input type='text' name='Apellido'
				value='<%=b_cliente.getApellidos()%>'></td></tr>
	<tr><td>Dni</td>
			<td><input type='text' name='Dni'
				value='<%=b_cliente.getDni()%>'></td></tr>
	<tr><td>Teléfono</td>
			<td><input type='text' name='Telefono'
				value='<%=b_cliente.getNro_telefono()%>'></td></tr>
	<tr>
	<td><input type="submit" value="Actualizar"></td>
	<td><input type="reset" value="Limpiar"></td>
	</tr>
</table></form>
<a href="cliente.jsp">Volver</a>
</body>
</html>