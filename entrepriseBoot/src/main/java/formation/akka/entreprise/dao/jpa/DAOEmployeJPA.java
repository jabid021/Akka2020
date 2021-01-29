package formation.akka.entreprise.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import formation.akka.entreprise.dao.IDAOEmploye;
import formation.akka.entreprise.model.Employe;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DAOEmployeJPA implements IDAOEmploye {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Employe findById(Integer id) {
		Employe b = em.find(Employe.class, id);
		return b;
	}

	@Override
	public List<Employe> findAll() {
		return em.createQuery("from Employe e", Employe.class).getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Employe objet) {
		em.persist(objet);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Employe objet) {
		em.merge(objet);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Integer id) {
		Employe d = em.find(Employe.class, id);
		em.remove(d);
	}

	@Override
	public List<Employe> SelectByPoste(String poste) {
		// TODO Auto-generated method stub
		return null;
	}
}
