<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="b_proveedores" class="Modelo.ProveedorBean" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Update_Proveedor" method="post">
<table>
	<tr><td>Código</td>
			<td><input type='text' readonly name='Codigo'
				value='<%=b_proveedores.getId_proveedor()%>'></td></tr>
	<tr><td>Nombre de Empresa</td>
			<td><input type='text' name='Nombre'
				value='<%=b_proveedores.getNom_empresa()%>'></td></tr>
	<tr><td>Teléfono</td>
			<td><input type='text' name='Telefono'
				value='<%=b_proveedores.getTelefono()%>'></td></tr>
	<tr><td>Dirección</td>
			<td><input type='text' name='Direccion'
				value='<%=b_proveedores.getDireccion()%>'></td></tr>
	<tr>
	<td><input type="submit" value="Actualizar"></td>
	<td><input type="reset" value="Limpiar"></td>
	</tr>
</table></form>
<a href="proveedor.jsp">Volver</a>
</body>
</html>