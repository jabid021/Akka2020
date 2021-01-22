package projet.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projet.back.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	public Optional<Login> findByLogin(String login);

	@Query("delete from Login l where l.login=:login")
	public int deleteByLogin(String login);
}
