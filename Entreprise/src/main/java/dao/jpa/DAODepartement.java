package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import config.Context;
import dao.IDAODepartement;
import model.Departement;

public class DAODepartement implements IDAODepartement{

	@Override
	public Departement findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Departement b = em.find(Departement.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Departement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Departement objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Departement objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Departement d=em.find(Departement.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}

}
