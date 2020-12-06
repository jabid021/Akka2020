package config;

import dao.IDAODepartement;
import dao.IDAOEmploye;
import dao.jdbc.DAODepartementJDBC;
import dao.jdbc.DAOEmployeJDBC;

public class Context {

	private static Context _instance;
	
	/*
	private DAODepartementSerial daoDepartementSerial= new DAODepartementSerial();
	private DAODepartementJDBC daoDepartementJDBC= new DAODepartementJDBC();
	
	private DAOEmployeSerial daoEmployeSerial= new DAOEmployeSerial();
	private DAOEmployeJDBC daoEmployeJDBC= new DAOEmployeJDBC();*/
	
	
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

	public IDAODepartement getDaoDepartement() {
		return daoDepartement;
	}

	public IDAOEmploye getDaoEmploye() {
		return daoEmploye;
	}



	
	
	
	
}
