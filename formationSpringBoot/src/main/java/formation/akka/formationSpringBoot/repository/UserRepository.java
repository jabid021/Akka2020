package formation.akka.formationSpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.akka.formationSpringBoot.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	@Query("select u from User u left join fetch u.roles where u.login=:login")
	public Optional<User> findByLoginWithRoles(@Param("login") String login);
}
