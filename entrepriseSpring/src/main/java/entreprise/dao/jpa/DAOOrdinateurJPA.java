package entreprise.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import entreprise.dao.IDAOOrdinateur;
import entreprise.model.Ordinateur;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DAOOrdinateurJPA implements IDAOOrdinateur {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Ordinateur findById(Integer id) {
		Ordinateur b = em.find(Ordinateur.class, id);
		return b;
	}

	@Override
	public List<Ordinateur> findAll() {
		return em.createQuery("from Ordinateur e", Ordinateur.class).getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Ordinateur objet) {
		em.persist(objet);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Ordinateur objet) {
		em.merge(objet);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Integer id) {
		Ordinateur d = em.find(Ordinateur.class, id);
		em.remove(d);
	}

	
}
