package formation.akka.entreprise.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.akka.entreprise.model.UserDetailsWithUtilisateur;
import formation.akka.entreprise.model.Utilisateur;
import formation.akka.entreprise.repository.UtilisateurRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UtilisateurRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> opt = userRepo.findByLogin(username);
		if (opt.isPresent()) {
			return new UserDetailsWithUtilisateur(opt.get());
		}
		throw new UsernameNotFoundException("nom inconnu");
	}

}
