package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.pedido;

@Stateless
public class pedidoFacade extends AbstractFacade<pedido> {
	
	@PersistenceContext(unitName = "Jdbc/__Products")
	private EntityManager entityManager;


	public pedidoFacade() {
		super(pedido.class);
	}


	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}


	
	
	
}
