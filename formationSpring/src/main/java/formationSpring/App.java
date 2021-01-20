package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.bean.Guitariste;
import formationSpring.bean.Instrument;
import formationSpring.bean.Musicien;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		// spring est pret

		Musicien musicien = ctx.getBean("saxophoniste", Musicien.class);
		musicien.jouer();
		// fermeture de spring
		ctx.close();
	}
}
