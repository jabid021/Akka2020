package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOEmploye;
import model.Employe;
import model.Employe;

public class DAOEmploye implements IDAOEmploye{

	@Override
	public Employe save(Employe t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Employe");}
		em.close();
		return t;
		
	}

	@Override
	public void delete(Employe t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Employe");}
		
		em.close();
	}

	@Override
	public Employe findById(Integer id) {
		Employe pc=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{em.find(Employe.class,id);}
		catch(Exception e) {System.out.println("Error find Employe");}
		
		
		em.close();
		return null;
	}

	@Override
	public List<Employe> findAll() {
		List<Employe> parc = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Employe",Employe.class);
			parc=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Employe");}
		em.close();
		return parc;
	}

}
