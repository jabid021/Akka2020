package formation.akka.formationSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.akka.formationSpringBoot.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
