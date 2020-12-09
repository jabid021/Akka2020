package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import config.Context;
import dao.IDAOEmploye;
import model.Departement;
import model.Employe;

public class DAOEmployeJPA implements IDAOEmploye {

	@Override
	public Employe findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Employe b = em.find(Employe.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Employe> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Employe objet) {

		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Employe objet) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Employe d=em.find(Employe.class, id);

		em.remove(d);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Employe> SelectByPoste(String poste) {
		// TODO Auto-generated method stub
		return null;
	}
}
