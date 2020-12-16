package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import config.Context;
import dao.IDAOProjet;
import model.Departement;
import model.Projet;

public class DAOProjet implements IDAOProjet{

	@Override
	public Projet findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Projet b = em.find(Projet.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Projet> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Projet objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Projet objet) {
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

		Projet d=em.find(Projet.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}

}
