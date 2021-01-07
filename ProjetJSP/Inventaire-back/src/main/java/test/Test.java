package test;

import config.Context;
import model.Admin;
import model.Employe;
import model.Marque;
import model.PC;

public class Test {

	
	public static void initBDD() 
	{
		PC o1 = new PC(Marque.Dell,16);
		PC o2 = new PC(Marque.HP,12);
		PC o3 = new PC(Marque.Asus,16);
		PC o4 = new PC(Marque.Dell,4);
		
		o1=Context.getInstance().getDaoPC().save(o1);
		o2=Context.getInstance().getDaoPC().save(o2);
		o3=Context.getInstance().getDaoPC().save(o3);
		o4=Context.getInstance().getDaoPC().save(o4);
		
		Admin admin=new Admin("Jordan","ajc","j.abid@ajc-ingenierie.fr");
		Employe e1 = new Employe("Red","123r","re@gmail.com",o1);
		Employe e2=new Employe("Raul","123ra","Raul@gmail.com",o3);
		
		Context.getInstance().getDaoAdmin().save(admin);
		Context.getInstance().getDaoEmploye().save(e1);
		Context.getInstance().getDaoEmploye().save(e2);
		
	}
	public static void main(String[] args) {
	
		
		//initBDD();
	
	}

}
