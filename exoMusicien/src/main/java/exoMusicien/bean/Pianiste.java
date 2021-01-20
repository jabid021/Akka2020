package exoMusicien.bean;

import org.springframework.stereotype.Component;

@Component("pianiste")
public class Pianiste implements Musicien {

	@Override
	public void jouer() {
		System.out.println("le pianiste joue");
	}

}
