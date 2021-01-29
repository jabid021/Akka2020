package formation.akka.formationSpringBoot;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formation.akka.formationSpringBoot.service.PersonneService;

@SpringBootTest
class FormationSpringBootApplicationTests {

	@Autowired
	private PersonneService personneService;

	@Test
	void contextLoads() {
	}

	@Test
	void testAllPersonne() {
		assertNotNull(personneService.allPersonne());
	}

}
