package projet.back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.back.entity.Client;
import projet.back.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
	@Query("update Commande c set c.livraison.id=0 where c.livraison.id=:id")
	public int setCommandeLivraisonToInconnu(@Param("id") Long id);

	@Query("update Commande c set c.facturation.id=0 where c.facturation.id=:id")
	public int setCommandeFacturationToInconnu(@Param("id") Long id);

	@Query("select distinct c from Commande c left join fetch c.facturation left join fetch c.livraison left join fetch c.client where c.client.id=:id")
	public List<Commande> findByClientId(@Param("id") Long id);

	@Query("select distinct c from Commande c left join fetch c.facturation left join fetch c.livraison left join fetch c.client where c.client=:client")
	public List<Commande> findByClient(@Param("client") Client client);

	@Query("select distinct c from Commande c left join fetch c.lignesCommandes where c.id=:id")
	public Optional<Commande> findByIdWithLignesCommandes(Long id);
}
