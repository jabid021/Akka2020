package projet.back;

import org.springframework.beans.factory.annotation.Autowired;

import projet.back.entity.Categorie;
import projet.back.entity.Client;
import projet.back.repository.ClientRepository;
import projet.back.service.CategorieService;
import projet.back.service.ClientService;

public class AppSpring {

	@Autowired
	CategorieService categorieSerive;
	@Autowired
	ClientService clientService;

	public void run(String[] args) {
		
	}
}
