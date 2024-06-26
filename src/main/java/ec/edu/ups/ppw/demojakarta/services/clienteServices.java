package ec.edu.ups.ppw.demojakarta.services;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.business.gestionClientes;
import ec.edu.ups.ppw.demojakarta.modelo.cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/cliente")
public class clienteServices {
	
	@Inject
	private gestionClientes gc;
	
	
	@POST
	public void create(cliente cliente) {
		
	}
	
	@PUT
	public void update(cliente cliente) {
			
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@PathParam("/{ci}")
	public cliente read(String ci) {
		cliente cli;
		try {
			cli = gc.getCliente(ci);
			return cli;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	public void delete(@QueryParam("id") String ci) {
	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<cliente> list(){
		return gc.getAll();
	}
	
}
