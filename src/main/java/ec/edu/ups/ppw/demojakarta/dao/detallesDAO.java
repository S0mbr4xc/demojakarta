package ec.edu.ups.ppw.demojakarta.dao;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.modelo.detalleFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class detallesDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(detalleFactura cliente) {
		em.persist(cliente);
	}
	
	public void update(detalleFactura cliente) {
		em.merge(cliente);
	}
	
	public void delete(detalleFactura cliente) {
		detalleFactura cli = this.read(cliente.getCodigo());
		em.remove(cli);
	}
	
	public detalleFactura read(int cedula) {
		detalleFactura cliente = em.find(detalleFactura.class, cedula);
		return cliente;
	}
	
	public List<detalleFactura> getAll(){
		String jpql = "SELECT c FROM detalleFactura c";//Nombre de la entidad asi se haya cambiado el nombre
		Query query = em.createQuery(jpql, detalleFactura.class);
		
		return query.getResultList();
	}
	
}
