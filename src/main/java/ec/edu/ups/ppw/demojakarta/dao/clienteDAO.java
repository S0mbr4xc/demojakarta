package ec.edu.ups.ppw.demojakarta.dao;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.modelo.cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class clienteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(cliente cliente) {
		em.merge(cliente);
	}
	
	public void delete(cliente cliente) {
		cliente cli = this.read(cliente.getCedula());
		em.remove(cli);
	}
	
	public cliente read(String cedula) {
		cliente cliente = em.find(cliente.class, cedula);
		return cliente;
	}
	
	public List<cliente> getAll(){
		String jpql = "SELECT c FROM cliente c";//Nombre de la entidad asi se haya cambiado el nombre
		Query query = em.createQuery(jpql, cliente.class);
		
		return query.getResultList();
	}
}
