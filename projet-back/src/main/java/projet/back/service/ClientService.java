package projet.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.back.entity.Client;
import projet.back.exception.ClientException;
import projet.back.exception.CommandeException;
import projet.back.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private LoginService loginService;
	@Autowired
	private CommandeService commandeService;
	@Autowired
	private AdresseService adresseService;

	public void creation(Client client) {
		clientRepo.save(client);
	}

	public void modification(Client client) {
		clientRepo.save(client);
	}

	public Client consultation(Long id) throws ClientException {
		Optional<Client> opt = clientRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		throw new ClientException("id client inconnu");
	}

	public List<Client> consultation() {
		return clientRepo.findAll();
	}

	public List<Client> rechercheParPrenom(String prenom) {
		return clientRepo.findByPrenomContaining(prenom);
	}

	public List<Client> rechercheParNom(String nom) {
		return clientRepo.findByNomContaining(nom);
	}

	public List<Client> rechercheParPrenomOuNom(String recherche) {
		return clientRepo.findByPrenomContainingOrNomContaining(recherche);
	}

	public void suppression(Long id) throws ClientException {
		Optional<Client> opt = clientRepo.findByIdWithLoginAndCommandeAndAdresse(id);
		if (opt.isPresent()) {
			Client client = opt.get();
			loginService.suppression(client.getLogin());
			if (!client.getCommandes().isEmpty()) {
				client.getCommandes().stream().forEach(t -> {
					try {
						commandeService.suppression(t);
					} catch (CommandeException e) {
						e.printStackTrace();
					}
				});
			}
			if (!client.getAdresses().isEmpty()) {
				client.getAdresses().stream().forEach(adresseService::suppression);
			}
			clientRepo.deleteById(id);
		} else {
			throw new ClientException("id client inconnu");
		}
	}

	public void suppression(Client client) throws ClientException {
		suppression(client.getId());
	}

}
