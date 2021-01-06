package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOOeuvre;
import model.Oeuvre;

public class DAOOeuvre implements IDAOOeuvre {

	@Override
	public Oeuvre save(Oeuvre t) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		try{
		em.getTransaction().begin();
		
		t=em.merge(t);
		em.getTransaction().commit();
		}
		catch(Exception e) {System.out.println("Error delete oeuvre");}
		em.close();
		return t;
	}

	@Override
	public void delete(Oeuvre t) {
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		try{
			em.getTransaction().begin();
		
		t=em.merge(t);
		em.remove(t);
		em.getTransaction().commit();
		}
		catch(Exception e) {System.out.println("Error delete oeuvre");}
		em.close();

	}

	@Override
	public Oeuvre findById(Integer id) {
		Oeuvre e = null;
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		try {

			e=em.find(Oeuvre.class, id);
		}
		catch(Exception exc) {System.out.println("Error find Oeuvre");}
		
		em.close();
		return e;
	}

	@Override
	public List<Oeuvre> findAll() {
		List<Oeuvre> oeuvres = new ArrayList();
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		try {

			Query query=em.createQuery("from Oeuvre o",Oeuvre.class);
			oeuvres=query.getResultList();
			
		}
		catch(Exception exc) {System.out.println("Error findAll Oeuvre");}
		
		em.close();
		return oeuvres;
	}

}
