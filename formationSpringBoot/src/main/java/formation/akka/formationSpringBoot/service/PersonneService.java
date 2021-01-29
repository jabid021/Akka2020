package formation.akka.formationSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import formation.akka.formationSpringBoot.entity.Personne;
import formation.akka.formationSpringBoot.repository.RepositoryPersonne;

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

	public void delete(Personne p) {
		personneRepo.delete(p);
	}

	public void delete(Integer id) {
		personneRepo.deleteById(id);
	}

	public Personne save(Personne p) {
		return personneRepo.save(p);
	}

	public Personne find(Integer id) {
		Optional<Personne> opt = personneRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Personne();
	}

}
