package formation.akka.entreprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.akka.entreprise.model.Utilisateur;
import formation.akka.entreprise.repository.UtilisateurRepository;

@Service
public class InitUserInDataBase implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncorder;
	@Autowired
	private UtilisateurRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
//		Utilisateur u = new Utilisateur();
//		u.setLogin("toto");
//		u.setRole("ROLE_ADMINISTRATEUR");
//		u.setPassword(passwordEncorder.encode("toto"));
//		userRepo.save(u);
	}
}
