package test;

import config.Context;
import dao.IDAODepartement;
import dao.jpa.DAODepartementJPA;
import model.Departement;
import model.Employe;

public class TestJPA {
	public static void main(String[] args) {
		
		
		
		DAODepartementJPA daoDept= new DAODepartementJPA();
		
		
		
		for(Departement d  : daoDept.findAll()) 
		{
			System.out.println(d.getNumero());
			System.out.println(d.getLieu());
			System.out.println(d.getNom());
			System.out.println(d.getEmployes());
	
			
		}

		Context.getInstance().closeEmf();
	}
}
