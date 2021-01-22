package projet.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.back.entity.Categorie;
import projet.back.exception.CategorieException;
import projet.back.repository.CategorieRepository;
import projet.back.repository.ProduitRepository;

@Service
public class CategorieService {
	@Autowired
	private CategorieRepository categorieRepo;
	@Autowired
	private ProduitRepository produitRepo;

	public void creation(Categorie categorie) {
		categorieRepo.save(categorie);
	}

	public void modification(Categorie categorie) {
		categorieRepo.save(categorie);
	}

	public Categorie consultation(Categorie categorie) throws CategorieException {
		return consultation(categorie.getId());
	}

	public Categorie consultation(Long id) throws CategorieException {
		Optional<Categorie> opt = categorieRepo.findCustomByIdWithSousCategorie(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new CategorieException("id inconnu");
	}

	public Categorie consultationAvecProduit(Long id) throws CategorieException {
		Optional<Categorie> opt = categorieRepo.findCustomByIdWithProduit(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new CategorieException("id inconnu");
	}

	public List<Categorie> consultation() {
		return categorieRepo.findAll();
	}

	public void suppressionCategorie(Categorie categorie) throws CategorieException {
		suppressionCategorie(categorie.getId());
	}

	public void suppressionCategorie(Long id) throws CategorieException {
		Optional<Categorie> opt = categorieRepo.findCustomByIdWithProduitAndCategorieMereAndSousCategorie(id);
		if (opt.isPresent()) {
			Categorie c = opt.get();
			if (!c.getProduits().isEmpty()) {
				if (c.getCategorieMere() != null) {
					c.getProduits().stream().forEach(produit -> {
						produit.setCategorie(c.getCategorieMere());
						produitRepo.save(produit);
					});
				} else {
					throw new CategorieException(
							"il y a des produits dans cette categorie. Il faut d'accord les supprimer ou les deplacer dans une autre categorie");
				}
			}
			if (!c.getSousCategories().isEmpty()) {
				if (c.getCategorieMere() != null) {
					c.getSousCategories().stream().forEach(categorie -> {
						categorie.setCategorieMere(c.getCategorieMere());
						categorieRepo.save(categorie);
					});
				} else {
					throw new CategorieException(
							"il y a des sous categories. Il faut d'abord les supprimer ou les deplacer");
				}
			}
			categorieRepo.deleteById(id);
		} else {
			throw new CategorieException("id inconnu");
		}
	}
}
