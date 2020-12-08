package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import config.Context;
import dao.IDAOOrdinateur;
import model.Departement;
import model.Ordinateur;

public class DAOOrdinateur implements IDAOOrdinateur{

	@Override
	public Ordinateur findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Ordinateur b = em.find(Ordinateur.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Ordinateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Ordinateur objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Ordinateur objet) {
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

		Ordinateur d=em.find(Ordinateur.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}

}

