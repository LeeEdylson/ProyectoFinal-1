<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de cliente</title>
</head>
<body>
<h1>Registro de Cliente</h1>
<form action="Registro_Cliente" method="POST">
<table>
<tr>
<th>Nombre</th>
<td><input type="text" name="txtNombre" value=""></td>
</tr>
<tr>
<th>Apellidos</th>
<td><input type="text" name="txtApellido" value=""></td>
</tr>
<tr>
<th>Dni</th>
<td><input type="text" name="txtDni" value=""></td>
</tr>
<tr>
<th>Teléfono</th>
<td><input type="text" name="txtTelefono" value=""></td>
</tr>
<tr>
<td><input type="submit" value="Registrar Cliente"> </td>
<td><input type="reset" value="Limpiar"> </td>
</tr>
</table>
</form>
<a href="cliente.jsp">Volver al menú anterior</a>

</body>
</html>