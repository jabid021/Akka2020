package projet.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.back.entity.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

}
