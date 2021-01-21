package entreprise;

import org.springframework.beans.factory.annotation.Autowired;

import entreprise.dao.IDAODepartement;

public class AppSpring {

	@Autowired
	private IDAODepartement daoDepartement;

	public void run(String[] args) {
		System.out.println(daoDepartement.findAll());
	}
}
