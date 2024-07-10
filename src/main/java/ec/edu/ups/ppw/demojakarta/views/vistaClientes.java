package ec.edu.ups.ppw.demojakarta.views;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.business.gestionClientes;
import ec.edu.ups.ppw.demojakarta.modelo.cliente;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("clientes")  
@RequestScoped
public class vistaClientes {
	
	
	@Inject
	private gestionClientes gClientes;
	
	
	private cliente persona = new cliente();
	
	
	private List<cliente> listado;
	
	
	@PostConstruct
	public void init() {
		listado = gClientes.getAll();  
	}
	
	public cliente getPersona() {
		return persona;
	}
	public void setPersona(cliente persona) {
		this.persona = persona;
	}
	
	
	
	public List<cliente> getListado() {
		return listado;
	}
	public void setListado(List<cliente> listado) {
		this.listado = listado;
	}
	
	
	
	//
	public String guardar() {
		System.out.println(this.persona);
	
	try {
		gClientes.setCliente(persona);
		return "listadoClientes?faces-redirect=true";
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "error";
		}
	}
}