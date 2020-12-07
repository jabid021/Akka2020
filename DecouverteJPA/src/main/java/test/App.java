package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import joined.Marque;
import joined.Moto;
import joined.Voiture;
import singleTable.Chat;
import singleTable.Chien;

public class App {

	public static void main(String[] args) {
		
		
		Moto m1 = new Moto();
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
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("baseDemoJPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(m1);
		em.persist(v1);
		
		em.persist(chien);
		em.persist(chat);
	
		
		
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
	}

}
