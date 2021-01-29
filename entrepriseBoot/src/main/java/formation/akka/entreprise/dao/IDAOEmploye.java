package formation.akka.entreprise.dao;

import java.util.List;

import formation.akka.entreprise.model.Employe;

public interface IDAOEmploye extends IDAO<Employe, Integer> {

	public List<Employe> SelectByPoste(String poste);
	
}
