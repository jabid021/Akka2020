package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;

import formationSpring.bean.Guitariste;

public class ApplicationSpring {

	@Autowired
	private Guitariste guitariste;

	public void run(String[] args) {
		guitariste.jouer();
	}
}
