package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;
import model.Fournisseur;

public class App {

	public static void main(String[] args) {
		
		Fournisseur f = new Fournisseur("Abid","Jordan","AJC");
		Client c = new Client("D","Thierry",35,LocalDate.parse("2000-10-05"));
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopConnect");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(c);
		em.persist(f);
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		
	}
}
