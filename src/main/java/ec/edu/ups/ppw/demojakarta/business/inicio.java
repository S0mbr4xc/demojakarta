package ec.edu.ups.ppw.demojakarta.business;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.clienteDAO;
import ec.edu.ups.ppw.demojakarta.modelo.cliente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class inicio {
	
	@Inject
	private clienteDAO dao;
	
	@PostConstruct
	public void init() {
		System.out.println("----------------INICIANDO----------------");
		
		cliente cliente = new cliente();
		cliente.setCedula("0106785678");
		cliente.setNombre("Esteban Cordova");
		cliente.setCorreo("s3._xc@hotmail.com");
		cliente.setTelefono("0998663179");
		
		dao.insert(cliente);
		
		List<cliente> listado = dao.getAll();
		for(cliente cli : listado) {
			System.out.println(cli.getCedula()+" "+cli.getNombre());
		}
		
	}
}
