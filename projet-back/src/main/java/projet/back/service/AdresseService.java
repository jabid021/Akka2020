package projet.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.back.entity.Adresse;
import projet.back.entity.Client;
import projet.back.exception.AdresseException;
import projet.back.repository.AdresseRepository;
import projet.back.repository.CommandeRepository;

@Service
public class AdresseService {

	@Autowired
	private AdresseRepository adresseRepo;
	@Autowired
	private CommandeRepository commandeRepo;

	public void creation(Adresse adresse) {
		adresseRepo.save(adresse);
	}

	public void modification(Adresse adresse) {
		adresseRepo.save(adresse);
	}

	public Adresse consultation(Long id) throws AdresseException {
		Optional<Adresse> opt = adresseRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		throw new AdresseException("id adresse inconnu");
	}

	public List<Adresse> consultation(Client client) {
		return adresseRepo.findAdresseByClient(client);
	}

	public void suppression(Long id) {
		getAdresseInconnu();
		commandeRepo.setCommandeFacturationToInconnu(id);
		commandeRepo.setCommandeLivraisonToInconnu(id);
		adresseRepo.deleteById(id);
	}

	public void suppression(Adresse adresse) {
		suppression(adresse.getId());
	}

	public Adresse getAdresseInconnu() {
		Optional<Adresse> opt = adresseRepo.findById(0L);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			Adresse inconnu = new Adresse("supprimé", "supprimé", "supprimé");
			adresseRepo.save(inconnu);
			return inconnu;
		}
	}
}
