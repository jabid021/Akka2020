package exoMusicien;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exoMusicien.config.AppConfig;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);

		ctx.close();
	}

}
