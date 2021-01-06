package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOOeuvre;
import dao.jpa.DAOOeuvre;


public class Context {

	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manga");
	
	private IDAOOeuvre daoOeuvre= new DAOOeuvre();
	
	
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

	public IDAOOeuvre getDaoOeuvre() {
		return daoOeuvre;
	}

	

	



	
	
	
	
}
