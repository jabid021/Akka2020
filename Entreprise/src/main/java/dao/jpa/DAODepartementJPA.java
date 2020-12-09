package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAODepartement;
import model.Departement;

public class DAODepartementJPA implements IDAODepartement{

	@Override
	public Departement findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Departement b = em.find(Departement.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Departement> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Departement",Departement.class);
	
		return maRequete.getResultList();
	}
	
	

	
	public List<Departement> findByLieu(String lieu)
	{
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("FROM Departement d where d.lieu=:ville ",Departement.class);
		maRequete.setParameter("ville", lieu);
	
		return maRequete.getResultList();
		
	}
	
	public List<Departement> findAllWithEmployes()
	{
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("SELECT p FROM Departement d left join  d.employes",Departement.class);
	
		return maRequete.getResultList();
		
	}

	@Override
	public void insert(Departement objet) {

		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Departement objet) {
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
		Departement d=em.find(Departement.class, id);
		
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void delete(Departement d) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		d=em.merge(d);
		em.remove(d);
		
		em.getTransaction().commit();
		em.close();
	}
	
	
	

}
