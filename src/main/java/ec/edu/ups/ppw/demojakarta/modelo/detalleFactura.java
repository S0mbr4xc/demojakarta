package ec.edu.ups.ppw.demojakarta.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class detalleFactura {
	
	@Id
	private int codigo;
	private int cantidad;
	private double precio;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto")
	private producto producto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public producto getProducto() {
		return producto;
	}

	public void setProducto(producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "detalleFactura [codigo=" + codigo + ", cantidad=" + cantidad + ", precio=" + precio + ", producto="
				+ producto + "]";
	}
	
	
}
