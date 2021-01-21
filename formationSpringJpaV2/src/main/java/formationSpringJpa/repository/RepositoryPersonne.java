package formationSpringJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formationSpringJpa.entity.Personne;

public interface RepositoryPersonne extends JpaRepository<Personne, Integer> {

	public List<Personne> findByPrenomContaining(String prenom);

	@Query("select p from Personne p where p.prenom=:param")
	public List<Personne> findAllOlivier(@Param("param") String param);
}
