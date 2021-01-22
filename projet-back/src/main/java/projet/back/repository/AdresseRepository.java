package projet.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projet.back.entity.Adresse;
import projet.back.entity.Client;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
	@Query("select distinct a from Adresse a left join fetch a.client where a.client=:client")
	public List<Adresse> findAdresseByClient(Client client);

	@Query("select distinct a from Adresse a left join fetch a.client where a.client.id=:id")
	public List<Adresse> findAdresseByClientId(Long id);
}
