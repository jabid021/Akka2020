package formationSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import formationSpringJpa.entity.Personne;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoPersonneJpaSpringImpl implements DaoPersonne {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Personne findByKey(Integer key) {
		return em.find(Personne.class, key);
	}

	@Override
	public List<Personne> findAll() {
		return em.createQuery("from Personne p", Personne.class).getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Personne obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Personne update(Personne obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Personne obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByKey(Integer key) {
		em.remove(em.find(Personne.class, key));
	}

}
