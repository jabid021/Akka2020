package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOEmploye;
import dao.IDAOPC;
import dao.jpa.DAOCompte;
import dao.jpa.DAOEmploye;
import dao.jpa.DAOPC;

public class Context {

	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("inventaire");
	
	//Factory
	private IDAOCompte daoCompte=new DAOCompte();
	private IDAOEmploye daoEmploye=new DAOEmploye();
	private IDAOPC daoPC=new DAOPC();
	
	private Context() {}
	
	public static Context getInstance()
	{
		if(_instance==null) 
		{
			_instance=new Context();
		}
		return _instance;
	}
	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	public void closeEmf() 
	{
		emf.close();
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public IDAOEmploye getDaoEmploye() {
		return daoEmploye;
	}

	public IDAOPC getDaoPC() {
		return daoPC;
	}

	



	
	
	
	
}
