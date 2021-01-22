package projet.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.back.entity.Categorie;
import projet.back.entity.Produit;
import projet.back.exception.ProduitException;
import projet.back.repository.LigneCommandeRepository;
import projet.back.repository.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepo;

	public Produit consultation(Long id) throws ProduitException {
		Optional<Produit> opt = produitRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		throw new ProduitException("id produit inconnu");
	}

	public Produit consultation(Produit produit) throws ProduitException {
		return consultation(produit.getId());
	}

	public List<Produit> consultation() {
		return produitRepo.findAll();
	}

	public List<Produit> consultation(Categorie categorie) {
		return produitRepo.findProduitByCategorie(categorie.getId());
	}

	public List<Produit> consultation(String nom) {
		return produitRepo.findByNomContaining(nom);
	}

	public void creation(Produit produit) {
		produitRepo.save(produit);
	}

	public void modification(Produit produit) {
		produitRepo.save(produit);
	}

	public void suppression(Produit produit) {
		suppression(produit.getId());
	}

	public void suppression(Long id) {
		Optional<Produit> opt = produitRepo.findProduitByIdWithLigneCommande(id);
		if (opt.isPresent()) {
			Produit produit = opt.get();
			if (!produit.getLignesCommandes().isEmpty()) {
				produit.getLignesCommandes().stream().forEach(ligneCommandeRepo::delete);
			}
			produitRepo.deleteById(id);
		}
	}

}
