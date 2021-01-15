package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Personne;
import util.Context;

public class DaoPersonneJpaImpl implements DaoPersonne {

	@Override
	public Personne findByKey(Integer key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Personne p = em.find(Personne.class, key);
		em.close();
		return p;
	}

	@Override
	public List<Personne> findAll() {
		List<Personne> personnes = null;
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		personnes = em.createQuery("from Personne p", Personne.class).getResultList();
		em.close();
		return personnes;
	}

	@Override
	public void insert(Personne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Personne update(Personne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Personne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();

	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Personne.class, key));
		tx.commit();
		em.close();
	}

}
