package ec.edu.ups.ppw.demojakarta.business;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.clienteDAO;
import ec.edu.ups.ppw.demojakarta.modelo.cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class gestionClientes {
	@Inject clienteDAO DAO;
	
	public cliente getCliente(String ci)throws Exception {
		if(ci.length() != 10) {
			throw new Exception("Numero no valido");
		}
		
		cliente cli = DAO.read(ci);
		if(cli == null) 
			throw new Exception("Cliente no existe");
		
		return cli;	
	}
	
	public void setCliente(cliente cliente) {
		DAO.insert(cliente);
	}
	
	public void actualiar(cliente cliente) {
		DAO.update(cliente);
	}
	
	public void borrar(String ci) {
		cliente cli = DAO.read(ci);
		DAO.delete(cli);
	}
	
	public List<cliente> getAll(){
		return DAO.getAll();
	}
	
}
