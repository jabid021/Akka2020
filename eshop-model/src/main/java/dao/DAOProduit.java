package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import model.Produit;

public class DAOProduit implements IDAOProduit{


	@Override
	public Produit findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Produit b = em.find(Produit.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Produit> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Produit",Produit.class);

		return maRequete.getResultList();
	}


	@Override
	public void insert(Produit objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Produit update(Produit objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Produit objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);

		em.remove(objet);

		em.getTransaction().commit();
		em.close();
	}

}
