package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOPC;
import model.PC;

public class DAOPC implements IDAOPC{

	@Override
	public PC save(PC t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save PC");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(PC t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete PC");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public PC findById(Integer id) {
		PC pc=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{em.find(PC.class,id);}
		catch(Exception e) {System.out.println("Error find PC");}
		em.getTransaction().commit();
		
		em.close();
		return null;
	}

	@Override
	public List<PC> findAll() {
		List<PC> parc = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from PC",PC.class);
			parc=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll PC");}
		em.close();
		return parc;
	}

	@Override
	public List<PC> findDisponibles() {
		List<PC> parc = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("Select p from PC p LEFT JOIN p.employe e where e is null ",PC.class);
			parc=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll PC");}
		em.close();
		return parc;
	}

}
