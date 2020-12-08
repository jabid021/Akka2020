package dao.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import dao.IDAOEmploye;
import model.Employe;

public class DAOEmployeSerial implements IDAOEmploye{
	static File f = new File("employes.txt");
	
	@Override
	public void insert(Employe e) {
		List<Employe> sauvegarde=findAll();
		try (
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				){
			
			sauvegarde.add(e);
			oos.writeObject(sauvegarde);

		}
		catch(Exception exception ) 
		{
			exception.printStackTrace();
		}
	}

	@Override
	public void update(Employe e) {
		List<Employe> sauvegarde=findAll();
		try (
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				)
		{
			
			for(int i=0;i<sauvegarde.size();i++)
			{
				if (sauvegarde.get(i).getNumero()==e.getNumero())
				{
					sauvegarde.remove(i);
				}
			}
			sauvegarde.add(e);
			oos.writeObject(sauvegarde);

		}
		catch(Exception exception ) 
		{
			exception.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		List<Employe> sauvegarde=findAll();
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
	public Employe findById(Integer id) {
		List<Employe> sauvegarde = findAll();
		try 
		{
			
			for(Employe e : sauvegarde) 
			{
				if(e.getNumero()==id) 
				{
					return e;
				}
			}
		}
		catch(Exception exception){exception.printStackTrace();}
		return null;

	}

	
	@Override
	public List<Employe> findAll() {
		List<Employe> sauvegarde = null;
		try (
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				)
		{
			sauvegarde=(List<Employe>) ois.readObject();
		}
		catch(Exception exception ) 
		{
			exception.printStackTrace();
		}

		return sauvegarde;
	}

	@Override
	public List<Employe> SelectByPoste(String poste) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
