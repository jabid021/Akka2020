package formationSpringJpa;

import org.springframework.beans.factory.annotation.Autowired;

import formationSpringJpa.dao.DaoPersonne;

public class AppSpring {

	@Autowired
	private DaoPersonne daoPersonne;

	public void run(String[] args) {
		System.out.println(daoPersonne.findAll());
	}
}
