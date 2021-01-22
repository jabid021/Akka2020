package projet.back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.back.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Query("select distinct p from Produit p left join fetch p.lignesCommandes where p.id=:id")
	public Optional<Produit> findProduitByIdWithLigneCommande(@Param("id") Long id);

	@Query("select distinct p from Produit p left join fetch p.categorie where p.categorie.id=:id")
	public List<Produit> findProduitByCategorie(Long id);

	public List<Produit> findByNomContaining(String nom);
}
