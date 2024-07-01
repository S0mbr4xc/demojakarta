package ec.edu.ups.ppw.demojakarta.services;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.business.gestionClientes;
import ec.edu.ups.ppw.demojakarta.modelo.cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class clienteServices {
	
	@Inject
	private gestionClientes gc;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(cliente cliente) {
		try {
			gc.setCliente(cliente);
			return Response.ok(cliente).build();
		} catch (Exception e) {
			message error = new message(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(cliente cliente) {
		try {
			gc.actualiar(cliente);
			return Response.ok(cliente).build();
		} catch (Exception e) {
			message error = new message(100, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{ci}")
	public cliente read(@PathParam("ci") String ci) {
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
	public Response delete(@QueryParam("id") String ci) {
		try {
			gc.borrar(ci);
			return Response.ok().build();
		} catch (Exception e) {
			message error = new message(101, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<cliente> list(){
		return gc.getAll();
	}
	
}
