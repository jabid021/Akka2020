package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAODepartement;
import dao.IDAOEmploye;
import dao.jdbc.DAODepartementJDBC;
import dao.jdbc.DAOEmployeJDBC;

public class Context {

	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entreprise");
	
	//Factory
	private IDAODepartement daoDepartement= new DAODepartementJDBC();
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



	
	
	
	
}
