package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.bean.Instrument;
import formationSpring.bean.Musicien;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		// spring est pret

		Instrument instrument = ctx.getBean(Instrument.class);
		System.out.println(instrument);

		Musicien musicien = ctx.getBean("guitariste", Musicien.class);
		musicien.jouer();
		System.out.println(musicien);
		System.out.println(ctx.getBean("guitariste", Musicien.class));
		// fermeture de spring
		ctx.close();
	}
}
