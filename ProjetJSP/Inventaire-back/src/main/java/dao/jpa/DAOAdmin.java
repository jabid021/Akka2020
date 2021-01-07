package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOAdmin;
import model.Admin;

public class DAOAdmin implements IDAOAdmin{

	@Override
	public Admin save(Admin t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Admin");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(Admin t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Admin");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Admin findById(Integer id) {
		Admin pc=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{em.find(Admin.class,id);}
		catch(Exception e) {System.out.println("Error find Admin");}
		em.getTransaction().commit();
		
		em.close();
		return null;
	}

	@Override
	public List<Admin> findAll() {
		List<Admin> employes = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Admin",Admin.class);
			employes=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Admin");}
		em.close();
		return employes;
	}

}
