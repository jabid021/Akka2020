package hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// spring est pret
		ctx.getBeanFactory().createBean(ApplicationSpring.class).run(args);
		// fermeture de spring
		ctx.close();

	}
}
