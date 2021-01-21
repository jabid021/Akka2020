package formationSpringJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationSpringJpa.entity.Personne;
import formationSpringJpa.repository.RepositoryPersonne;

@Service
public class PersonneService {
	@Autowired
	private RepositoryPersonne personneRepo;

	// definir tous les traitements disponible sur l'entite personne

	public void creationPersonne(Personne p) {
		if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()) {
			personneRepo.save(p);
		} else {
			System.out.println("la personne n'a pas toute les infos obligatoires");
		}
	}

	public void creationPersonne(String prenom, String nom) {
		creationPersonne(new Personne(prenom, nom));
	}

	public List<Personne> allPersonne() {
		return personneRepo.findAll();
	}

}
