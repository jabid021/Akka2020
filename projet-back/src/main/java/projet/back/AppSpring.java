package projet.back;

import org.springframework.beans.factory.annotation.Autowired;

import projet.back.entity.Categorie;
import projet.back.service.CategorieService;

public class AppSpring {

	@Autowired
	CategorieService categorieSerive;

	public void run(String[] args) {
		categorieSerive.creation(new Categorie("hifi", "produit hifi"));
	}
}
