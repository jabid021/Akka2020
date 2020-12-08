package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import config.Context;
import dao.IDAOMarque;
import model.Departement;
import model.Marque;

public class DAOMarque implements IDAOMarque{

	@Override
	public Marque findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Marque b = em.find(Marque.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Marque> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Marque objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Marque objet) {
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
		Marque d=em.find(Marque.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}

}
