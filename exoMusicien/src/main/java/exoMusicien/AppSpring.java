package exoMusicien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import exoMusicien.bean.Musicien;

public class AppSpring {

	@Autowired
	@Qualifier("pianiste")
	Musicien pianiste;
	

	public void run(String[] args) {
		// debut du programme spring
		pianiste.jouer();
		
	}
}
