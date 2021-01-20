package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;

import formationSpring.bean.Guitariste;
import formationSpring.bean.Musicien;

public class ApplicationSpring {

	@Autowired
	private Musicien guitariste;

	public void run(String[] args) {
		guitariste.jouer();
	}
}
