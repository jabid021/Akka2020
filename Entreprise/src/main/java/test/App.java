package test;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import config.Context;
import model.Departement;
import model.Employe;

public class App {

	/*public static int saisieInt(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}


	public static String saisieString(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public static void main(String[] args) {
		
		menu();
	}


	private static void menu() {
		System.out.println("\nApplication de l'entreprise");
		System.out.println("Choisir un menu :");
		System.out.println("1 - Gestion Departements");
		System.out.println("2 - Gestion Employes");
		System.out.println("3 - Sortir de l'application");

		int choix = saisieInt("");
		switch(choix) 
		{
		case 1:menuDept();break;
		case 2:menuEmp();break;
		case 3:System.exit(0);break;
		}

		menu();
	}

	private static void menuEmp() {
		System.out.println("\nGestion Employes");
		System.out.println("Choisir un menu :");
		System.out.println("1 - Ajouter un employe");
		System.out.println("2 - Modifier un employe");
		System.out.println("3 - Supprimer un employe");
		System.out.println("4 - Lister les employes");
		System.out.println("5 - Retour");
		

		int choix = saisieInt("");
		switch(choix) 
		{
		case 1:addEmp();break;
		case 2:updateEmp();break;
		case 3:deleteEmp();break;
		case 4:showEmps();break;
		case 5 : menu();break;
		}
		menuEmp();

	}

	private static void showEmps() {
		System.out.println("\nListe des employes : \n");
		for(Employe e : Context.getInstance().getDaoEmploye().findAll()) 
		{
			System.out.println(e);
		}
	}

	private static void deleteEmp() {
		showEmps();
		int choix=saisieInt("Choisir un employe");
		Context.getInstance().getDaoEmploye().delete(choix);

	}

	private static void updateEmp() {

		showEmps();
		int choix=saisieInt("Choisir un employe");
		Employe e = Context.getInstance().getDaoEmploye().findById(choix);
		if(e==null) {System.out.println("Aucun employé avec ce numero");}
		else 
		{
			String nom=saisieString("Saisir nom");
			String job=saisieString("Saisir job");
			String embauche=saisieString("Saisir embauche (yyyy-mm-dd)");
			int sal=saisieInt("Saisir salaire");
			Integer comm = (saisieString("Avez vous une comm ? (Y/N)").equals("Y"))? saisieInt("Saisir votre commission") : null;

			showDepts();
			int id= saisieInt("Choisir un departement");
			Departement d = Context.getInstance().getDaoDepartement().findById(id);

			e.setNom(nom);
			e.setPoste(job);
			e.setEmbauche(embauche);
			e.setSalaire(sal);
			e.setCommission(comm);
			e.setDepartement(d);

			Context.getInstance().getDaoEmploye().update(e);
		}

	}

	private static void addEmp() {
		int numero=saisieInt("Saisir numero");
		String nom=saisieString("Saisir nom");
		String job=saisieString("Saisir job");
		String embauche=saisieString("Saisir embauche (yyyy-mm-dd)");
		int sal=saisieInt("Saisir salaire");
		Integer comm = (saisieString("Avez vous une comm ? (Y/N)").equals("Y"))? saisieInt("Saisir votre commission") : null;

		showDepts();
		int id= saisieInt("Choisir un departement");
		Departement d = Context.getInstance().getDaoDepartement().findById(id);

		Employe e = new Employe(numero, nom, job, embauche, sal, comm, d);
		Context.getInstance().getDaoEmploye().insert(e);

	}
	
	private static void menuDept() {
		System.out.println("\nGestion Departements");
		System.out.println("Choisir un menu :");
		System.out.println("1 - Ajouter un departement");
		System.out.println("2 - Modifier un departement");
		System.out.println("3 - Supprimer un departement");
		System.out.println("4 - Lister les departements");
		System.out.println("5 - Retour");

		int choix = saisieInt("");
		switch(choix) 
		{
		case 1:addDept();break;
		case 2:updateDept();break;
		case 3:deleteDept();break;
		case 4:showDepts();break;
		case 5 : menu();break;
		}
		menuDept();

	}

	private static void showDepts() {
		System.out.println("\nListe des départements : \n");
		for(Departement d : Context.getInstance().getDaoDepartement().findAll()) 
		{
			System.out.println(d);
		}

	}

	private static void deleteDept() {
		for(Departement d : Context.getInstance().getDaoDepartement().findAll()) 
		{
			System.out.println(d);
		}
		int choix = saisieInt("\nChoisir un département");

		Context.getInstance().getDaoDepartement().delete(choix);

	}

	private static void updateDept() {
		for(Departement d : Context.getInstance().getDaoDepartement().findAll()) 
		{
			System.out.println(d);
		}
		int choix = saisieInt("\nChoisir un département");
		Departement choixDept=Context.getInstance().getDaoDepartement().findById(choix);
		if(choixDept==null) {System.out.println("Aucun departement avec ce numero");}
		else 
		{
			choixDept.setLieu(saisieString("Saisir le lieu"));
			choixDept.setNom(saisieString("Saisir le nom"));

			Context.getInstance().getDaoDepartement().update(choixDept);
		}
	}

	private static void addDept() {
		Departement d = new Departement(saisieString("Saisir nom"),saisieString("Saisir lieu"));
		Context.getInstance().getDaoDepartement().insert(d);

	}
*/
	public static void main(String[] args) {

		//menu();
		
EntityManagerFactory emf = Persistence.createEntityManagerFactory("nom_persistence");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		//em.persist(b);
		//em.persist(harry);
		//em.persist(b2);
		
		em.getTransaction().commit();
	
		emf.close();
		
	}

}
