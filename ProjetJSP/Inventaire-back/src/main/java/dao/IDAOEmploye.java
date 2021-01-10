package dao;

import java.util.List;

import model.Employe;

public interface IDAOEmploye extends IDAO<Employe,Integer>{

	public List<Employe> findAllFilter(String name);
}
