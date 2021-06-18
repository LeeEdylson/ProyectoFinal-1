<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de proveedor</title>
</head>
<body>
<h1>Registro de Proveedor</h1>
<form action="Registro_Proveedor" method="POST">
<table>
<tr>
<th>Nombre de empresa</th>
<td><input type="text" name="txtNombre" value=""></td>
</tr>
<tr>
<th>Teléfono</th>
<td><input type="text" name="txtTelefono" value=""></td>
</tr>
<tr>
<th>Dirección</th>
<td><input type="text" name="txtDireccion" value=""></td>
</tr>
<tr>
<td><input type="submit" value="Registrar Proveedor"> </td>
<td><input type="reset" value="Limpiar"> </td>
</tr>
</table>
</form>
<a href="proveedor.jsp">Volver al menú anterior</a>

</body>
</html>