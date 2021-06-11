package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.tarjeta;

@Stateless
public class tarjetaFacade extends AbstractFacade<tarjeta> {
	
	@PersistenceContext(unitName = "Jdbc/__Products")
	private EntityManager entityManager;

	public tarjetaFacade() {
		super(tarjeta.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
