package test;

import javax.persistence.EntityManager;

import config.Context;
import model.Departement;
import model.Employe;

public class TestJPA {
	public static void main(String[] args) {
		
		Departement dept=new Departement("Formation", "Paris");
		Employe e = new Employe(1234, "Abid", "Formateur", "2020-02-10", 1000, null, dept);
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		
		//em.persist(dept);
		//em.persist(e);
		
		
		
		
		
		em.getTransaction().commit();
		

		Context.getInstance().closeEmf();
	}
}
