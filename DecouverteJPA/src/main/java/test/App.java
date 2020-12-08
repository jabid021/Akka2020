package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Baguette;
import model.Sorcier;

public class App {

	public static void main(String[] args) {
		
		
	/*	Moto m1 = new Moto();
		m1.setMarque(Marque.Marque1);
		m1.setVitesse(240);
		m1.setEnPlus("en+");
		
		Voiture v1 = new Voiture();
		v1.setMarque(Marque.Marque1);
		v1.setVitesse(240);
		v1.setPlaque("ZADEES33223");
		
	
		
		Chien chien = new Chien();
		chien.setPoids(12);
		chien.setRace("Bichon");
		
		Chat chat = new Chat();
		chat.setPoids(6);
		chat.setRace2("Sphynx");
		
		*/
		
		Baguette b = new Baguette("Toto");
		Baguette b2 = new Baguette("titi");
		
		Sorcier harry = new Sorcier("Potter","Harry",b);
		
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("baseDemoJPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		em.persist(b);
		em.persist(harry);
		em.persist(b2);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
	}

}
