package formationSpringJpa;

import org.springframework.beans.factory.annotation.Autowired;

import formationSpringJpa.service.PersonneService;

public class AppSpring {

	@Autowired
	private PersonneService personneService;

	public void run(String[] args) {
		//point d'entree
	}
}
