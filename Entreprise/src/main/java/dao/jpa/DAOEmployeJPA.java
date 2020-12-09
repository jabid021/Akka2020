package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import config.Context;
import dao.IDAODepartement;
import dao.IDAOEmploye;
import model.Departement;
import model.Employe;

public class DAOEmployeJPA implements IDAOEmploye{

	@Override
	public Employe findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Employe e = em.find(Employe.class, id);
		em.close();
		return e;
	}

	@Override
	public List<Employe> findAll() {
		// TODO Auto-generated method stub
				return null;
			}
	@Override
	public void insert(Employe e) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}// TODO Auto-generated method stub
		

	@Override
	public void update(Employe e) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Employe e) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		e=em.merge(e);
		
		em.remove(e);
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Employe> SelectByPoste(String poste) {
		// TODO Auto-generated method stub
		return null;
	}

}
