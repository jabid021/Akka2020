package formation.akka.entreprise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.akka.entreprise.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	public Optional<Utilisateur> findByLogin(String login);
}
