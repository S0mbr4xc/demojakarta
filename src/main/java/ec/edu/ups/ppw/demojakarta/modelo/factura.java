package ec.edu.ups.ppw.demojakarta.modelo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class factura {
	
	@Id
	private int numero;
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente")
	private cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "detalles")
	private List<detalleFactura> detalleFactura;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public cliente getCliente() {
		return cliente;
	}
	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}
	public List<detalleFactura> getDetalleFactura() {
		return detalleFactura;
	}
	public void setDetalleFactura(List<detalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}
	@Override
	public String toString() {
		return "factura [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente + ", detalleFactura="
				+ detalleFactura + "]";
	}
	
	

}
