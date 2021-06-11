package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.comida;

@Stateless
public class comidaFacade extends AbstractFacade<comida> {
	
	@PersistenceContext(unitName = "Pedidos")
	private EntityManager entityManager;

	public comidaFacade() {
		super(comida.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	
}
