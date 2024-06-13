package ec.edu.ups.ppw.demojakarta.dao;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.modelo.factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class facturaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(factura factura) {
		em.persist(factura);
	}
	public void update(factura factura) {
		em.merge(factura);
	}
	public factura read(int codigo) {
		factura factura = em.find(factura.class, codigo);
		return factura;
	}
	public void delete(factura factura) {
		factura fac = this.read(factura.getNumero());
		em.remove(fac);
	}
	
	public List<factura> getAll(){
		String jpql = "SELECT f FROM factura f";
		Query query = em.createQuery(jpql, factura.class);
		return query.getResultList();
	}
}
