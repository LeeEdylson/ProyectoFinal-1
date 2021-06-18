package Modelo;

public class ProductoBean {
	private int id_producto;
	private String nom_producto;
	private String pro_categoria;
	private String pro_descripcion;
	private double precio;
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNom_producto() {
		return nom_producto;
	}
	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}
	public String getPro_categoria() {
		return pro_categoria;
	}
	public void setPro_categoria(String pro_categoria) {
		this.pro_categoria = pro_categoria;
	}
	public String getPro_descripcion() {
		return pro_descripcion;
	}
	public void setPro_descripcion(String pro_descripcion) {
		this.pro_descripcion = pro_descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
