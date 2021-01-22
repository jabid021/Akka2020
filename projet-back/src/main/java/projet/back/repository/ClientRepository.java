package projet.back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projet.back.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select distinct c from Client c left join fetch c.login left join fetch c.adresses left join fetch c.commandes com left join fetch com.lignesCommandes where c.id=:id")
	public Optional<Client> findByIdWithLoginAndCommandeAndAdresse(Long id);

	public List<Client> findByPrenomContaining(String prenom);

	public List<Client> findByNomContaining(String nom);

	@Query("select distinct c from Client c where c.prenom like %:texte% or nom like %:texte%")
	public List<Client> findByPrenomContainingOrNomContaining(String texte);
}
