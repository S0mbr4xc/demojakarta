package ec.edu.ups.ppw.demojakarta.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class producto {
	
	@Id
	private int codigo;
	private double precio;
	private int stock;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "producto [codigo=" + codigo + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
	
}
