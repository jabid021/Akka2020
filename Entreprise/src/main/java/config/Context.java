package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAODepartement;
import dao.IDAOEmploye;
import dao.jdbc.DAOEmployeJDBC;
import dao.jpa.DAODepartementJPA;

public class Context {

	private static Context _instance=null;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("nom_persistence");
	
	//Factory
	private IDAODepartement daoDepartement= new DAODepartementJPA();
	private IDAOEmploye daoEmploye= new DAOEmployeJDBC();
	
	
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

	public IDAODepartement getDaoDepartement() {
		return daoDepartement;
	}

	public IDAOEmploye getDaoEmploye() {
		return daoEmploye;
	}
	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	public void closeEmf() 
	{
		emf.close();
	}
	 


	
	
	
	
}
