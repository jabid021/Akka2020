package projet.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.back.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	@Query("select distinct c from Categorie c left join fetch c.sousCategories left join fetch c.categorieMere where c.id=:id")
	public Optional<Categorie> findCustomByIdWithSousCategorie(@Param("id") Long id);

	@Query("select distinct c from Categorie c left join fetch c.categorieMere left join fetch c.produits left join fetch c.sousCategories where c.id=:id")
	public Optional<Categorie> findCustomByIdWithProduitAndCategorieMereAndSousCategorie(@Param("id") Long id);

	@Query("select distinct c from Categorie c left join fetch c.produits where c.id=:id")
	public Optional<Categorie> findCustomByIdWithProduit(@Param("id") Long id);
}
