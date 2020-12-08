package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import config.Context;
import dao.IDAOBaguette;
import model.Baguette;

public class DAOBaguette implements IDAOBaguette{

	@Override
	public Baguette findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Baguette b = em.find(Baguette.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Baguette> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Baguette b) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Baguette b) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(b);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Baguette b) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		b=em.merge(b);
		
		em.remove(b);
		
		em.getTransaction().commit();
		em.close();
	}

}
