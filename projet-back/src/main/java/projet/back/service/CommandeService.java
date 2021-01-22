package projet.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.back.entity.Client;
import projet.back.entity.Commande;
import projet.back.exception.CommandeException;
import projet.back.repository.CommandeRepository;
import projet.back.repository.LigneCommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepo;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepo;

	public void creation(Commande commande) {
		commandeRepo.save(commande);
		commande.getLignesCommandes().stream().forEach(ligneCommandeRepo::save);
	}

	public void modification(Commande commande) {
		commandeRepo.save(commande);
	}

	public List<Commande> consultation() {
		return commandeRepo.findAll();
	}

	public Commande consultation(Long id) throws CommandeException {
		Optional<Commande> opt = commandeRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new CommandeException("id commande inconnu");
	}

	public Commande consultation(Commande commande) throws CommandeException {
		return consultation(commande.getId());
	}

	public List<Commande> consultation(Client client) {
		return commandeRepo.findByClientId(client.getId());
	}

	public void suppression(Commande commande) throws CommandeException {
		suppression(commande.getId());
	}

	public void suppression(Long id) throws CommandeException {
		Optional<Commande> opt = commandeRepo.findByIdWithLignesCommandes(id);
		if (opt.isPresent()) {
			Commande commande = opt.get();
			if (!commande.getLignesCommandes().isEmpty()) {
				commande.getLignesCommandes().stream().forEach(ligneCommandeRepo::delete);
			}
			commandeRepo.deleteById(id);
		} else {
			throw new CommandeException("id commande inconnu");
		}
	}
}
