package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import config.Context;
import dao.DAOClient;
import model.Client;
import model.Fournisseur;
import model.Produit;

public class App {

	public static void main(String[] args) {
		
		Fournisseur f = new Fournisseur("Abid","Jordan","AJC");
		Client c = new Client("D","Thierry",35,LocalDate.parse("2000-10-05"));
		Produit p1 = new Produit("chocolat", 3, f);
		
		
		
		Context.getInstance().getDaoClient().insert(c);
		Context.getInstance().getDaoProduit().insert(p1);
		
		
		for(Produit p : Context.getInstance().getDaoProduit().findAll()) 
		{
			System.out.println(p.getLibelle()+" "+p.getPrix()+"€");
		}
		
		
		
		
		Context.getInstance().closeEmf();

		
	}
}
