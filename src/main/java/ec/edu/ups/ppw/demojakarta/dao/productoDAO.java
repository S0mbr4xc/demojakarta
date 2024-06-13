package ec.edu.ups.ppw.demojakarta.dao;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.modelo.producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class productoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(producto cliente) {
		em.persist(cliente);
	}
	
	public void update(producto cliente) {
		em.merge(cliente);
	}
	
	public void delete(producto cliente) {
		producto cli = this.read(cliente.getCodigo());
		em.remove(cli);
	}
	
	public producto read(int cedula) {
		producto cliente = em.find(producto.class, cedula);
		return cliente;
	}
	
	public List<producto> getAll(){
		String jpql = "SELECT c FROM producto c";//Nombre de la entidad asi se haya cambiado el nombre
		Query query = em.createQuery(jpql, producto.class);
		
		return query.getResultList();
	}
}
