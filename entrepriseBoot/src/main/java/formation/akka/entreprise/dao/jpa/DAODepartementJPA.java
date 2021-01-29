package formation.akka.entreprise.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import formation.akka.entreprise.dao.IDAODepartement;
import formation.akka.entreprise.model.Departement;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DAODepartementJPA implements IDAODepartement {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Departement findById(Integer id) {
		Departement b = em.find(Departement.class, id);
		return b;
	}

	@Override
	public List<Departement> findAll() {

		Query maRequete = em.createQuery("from Departement", Departement.class);

		return maRequete.getResultList();
	}

	public List<Departement> findByLieu(String lieu) {

		Query maRequete = em.createQuery("FROM Departement d where d.lieu=:ville ", Departement.class);
		maRequete.setParameter("ville", lieu);
		return maRequete.getResultList();

	}

	public List<Departement> findAllWithEmployes() {
		Query maRequete = em.createQuery("SELECT p FROM Departement d left join  d.employes", Departement.class);
		return maRequete.getResultList();

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Departement objet) {
		em.persist(objet);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Departement objet) {
		em.merge(objet);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Integer id) {
		Departement d = em.find(Departement.class, id);
		em.remove(d);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Departement d) {
		d = em.merge(d);
		em.remove(d);
	}

	

}
