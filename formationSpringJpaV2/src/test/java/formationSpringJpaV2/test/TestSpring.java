package formationSpringJpaV2.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import formationSpringJpa.config.AppConfig;
import formationSpringJpa.dao.DaoPersonne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestSpring {

	@Autowired
	private DaoPersonne daoPersonne;

	@Test
	public void test() {
		assertNotNull(daoPersonne.findAll());
	}

}
