package formationSpringJpaV2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationSpringJpa.config.AppConfig;
import formationSpringJpa.dao.DaoPersonne;
import formationSpringJpa.entity.Personne;

public class DaoPersonneTest {

	private static AnnotationConfigApplicationContext ctx;

	private DaoPersonne daoPersonne;

	@BeforeClass
	public static void initSpringContext() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);

	}

	@AfterClass
	public static void closeSpringContext() {
		ctx.close();
	}

	@Before
	public void initTest() {
		daoPersonne = ctx.getBean(DaoPersonne.class);
	}

	@After
	public void afterTest() {
		daoPersonne = null;
	}

	@Test
	public void test() {
		assertNotNull(daoPersonne.findAll());
	}

	@Test
	public void insert() {
		Personne p = new Personne("aa", "ll");
		daoPersonne.insert(p);
		assertNotNull(daoPersonne.findByKey(p.getId()));
		daoPersonne.delete(p);
		assertNull(daoPersonne.findByKey(p.getId()));
	}
}
