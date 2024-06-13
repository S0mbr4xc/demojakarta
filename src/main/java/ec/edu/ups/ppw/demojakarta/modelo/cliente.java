package ec.edu.ups.ppw.demojakarta.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class cliente {
	
	@Id
	@Column(name = "cli_cedula")
	private String cedula;
	private String nombre;
	private String telefono;
	private String correo;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "cliente [cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo
				+ "]";
	}
	
	
}
