package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOClient;
import dao.DAOProduit;
import dao.IDAOClient;
import dao.IDAOProduit;

public class Context {

	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop");
	
	//Factory
	private IDAOClient daoClient= new DAOClient();
	private IDAOProduit daoProduit= new DAOProduit();
	
	
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

	public IDAOClient getDaoClient() {
		return daoClient;
	}

	public IDAOProduit getDaoProduit() {
		return daoProduit;
	}



	
	
	
	
}
