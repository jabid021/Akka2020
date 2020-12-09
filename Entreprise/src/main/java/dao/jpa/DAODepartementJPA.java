package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import config.Context;
import dao.IDAODepartement;
import model.Departement;

public class DAODepartementJPA implements IDAODepartement {

	@Override
	public Departement findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Departement d = em.find(Departement.class, id);
		em.close();
		return d;
	}

	@Override
	public List<Departement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Departement d) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Departement d) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(d);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Departement d) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		d=em.merge(d);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}

}
