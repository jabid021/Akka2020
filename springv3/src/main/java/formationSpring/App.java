package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.bean.Guitariste;
import formationSpring.bean.Instrument;
import formationSpring.bean.Musicien;
import formationSpring.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// spring est pret
		ctx.getBeanFactory().createBean(ApplicationSpring.class).run(args);
		
		//ctx.getBean(Guitariste.class);
		// fermeture de spring
		ctx.close();

	}
}
