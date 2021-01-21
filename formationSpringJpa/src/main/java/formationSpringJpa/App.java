package formationSpringJpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpringJpa.dao.DaoPersonne;
import formationSpringJpa.entity.Personne;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		DaoPersonne daoPersonne = ctx.getBean(DaoPersonne.class);
		daoPersonne.insert(new Personne("aa", "zzz"));
		ctx.close();
	}
}
