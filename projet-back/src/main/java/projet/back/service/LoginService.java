package projet.back.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.back.entity.Login;
import projet.back.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepo;

	public void creation(Login login) {
		loginRepo.save(login);
	}

	public void modification(Login login) {
		loginRepo.save(login);
	}

	public Login consultation(Long id) throws LoginException {
		Optional<Login> opt = loginRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		throw new LoginException("id login inconnu");
	}

	public Login consultation(String login) throws LoginException {
		Optional<Login> opt = loginRepo.findByLogin(login);
		if (opt.isPresent())
			return opt.get();
		throw new LoginException("login inconnu");
	}

	public void suppression(Login login) {
		loginRepo.delete(login);
	}

	public void suppression(String login) {
		loginRepo.deleteByLogin(login);
	}

}
