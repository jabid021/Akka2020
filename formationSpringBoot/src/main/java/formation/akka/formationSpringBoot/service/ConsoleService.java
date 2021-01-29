package formation.akka.formationSpringBoot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(ConsoleService.class);

	@Autowired
	private PersonneService personneService;

	@Override
	public void run(String... args) throws Exception {

	}

}
