package dao.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dao.IDAODepartement;
import model.Departement;

public class DAODepartementSerial implements IDAODepartement {
	static File f = new File("departements.txt");
	
	@Override
	public void insert(Departement d) {
		List<Departement> sauvegarde=findAll();
		try (
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				){
		
			sauvegarde.add(d);
			oos.writeObject(sauvegarde);

		}
		catch(Exception exception ) 
		{
			exception.printStackTrace();
		}
	}

	@Override
	public void update(Departement d) {
		List<Departement> sauvegarde=findAll();
		try (
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				)
		{
			
			for(int i=0;i<sauvegarde.size();i++)
			{
				if (sauvegarde.get(i).getNumero()==d.getNumero())
				{
					sauvegarde.remove(i);
				}
			}
			sauvegarde.add(d);
			oos.writeObject(sauvegarde);

		}
		catch(Exception exception ) 
		{
			exception.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		List<Departement> sauvegarde=findAll();
		try (
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				)
		{
			
			for(int i=0;i<sauvegarde.size();i++)
			{
				if (sauvegarde.get(i).getNumero()==id)
				{
					sauvegarde.remove(i);
				}
			}
			oos.writeObject(sauvegarde);

		}
		catch(Exception exception ) 
		{
			exception.printStackTrace();
		}
	}

	@Override
	public Departement findById(Integer id) {
		try 
		{
			List<Departement> sauvegarde = findAll();
			for(Departement d : sauvegarde) 
			{
				if(d.getNumero()==id) 
				{
					return d;
				}
			}
		}
		catch(Exception exception){exception.printStackTrace();}
		return null;
	}

	@Override
	public List<Departement> findAll() {
		List<Departement> sauvegarde=new ArrayList();

		try (
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				){


			sauvegarde=(List<Departement>) ois.readObject();

		}
		catch(Exception e ) 
		{
			e.printStackTrace();
		}
		return sauvegarde;
	}

}
