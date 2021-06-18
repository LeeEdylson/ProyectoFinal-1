package Modelo;

public class ClienteBean {
	private String id_cliente;
	private String nombres;
	private String apellidos;
	private String dni;
	private String nro_telefono;
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNro_telefono() {
		return nro_telefono;
	}
	public void setNro_telefono(String nro_telefono) {
		this.nro_telefono = nro_telefono;
	}
}
