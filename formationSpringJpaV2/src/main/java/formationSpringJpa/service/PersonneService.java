package formationSpringJpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public void demo() {
		System.out.println(personneRepo.findAll());

		Optional<Personne> opt = personneRepo.findById(10000);
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			System.out.println(opt);
		}
		Personne p = opt.isPresent() ? opt.get() : new Personne();

		personneRepo.findAll(Sort.by("prenom").descending()).stream().forEach(personne -> {
			System.out.println(personne.getPrenom() + " " + personne.getNom());
		});

		Pageable page1avec3Element = PageRequest.of(0, 3);

		personneRepo.findAll(page1avec3Element).stream().forEach(personne -> {
			System.out.println(personne.getPrenom() + " " + personne.getNom());
		});

		personneRepo.findByPrenomContaining("a").stream().forEach(personne -> {
			System.out.println(personne.getPrenom() + " " + personne.getNom());
		});

		personneRepo.findAllOlivier("olivier").stream().forEach(personne -> {
			System.out.println(personne.getPrenom() + " " + personne.getNom());
		});
	}

}
