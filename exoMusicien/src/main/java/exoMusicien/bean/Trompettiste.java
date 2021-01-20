package exoMusicien.bean;

import org.springframework.stereotype.Component;

@Component
public class Trompettiste implements Musicien {

	@Override
	public void jouer() {
		System.out.println("le trompettiste joue");
	}

}
