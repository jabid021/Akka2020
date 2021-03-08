package formation.akka.lombok.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import formation.akka.lombok.demo.Adresse;
import formation.akka.lombok.demo.Personne;
import formation.akka.lombok.demo.PersonneFactory;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsoleService implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		Personne personne = null;
		Personne.PersonneBuilder builder = Personne.builder();
		personne = builder.prenom("olivier").nom("nom").adress(new Adresse("rue xxx", "paris"))
				.adress(Adresse.builder().rue("rue aaaa").ville("lens").build()).build();
		System.out.println(personne);
		personne.getAdresses().stream().forEach(System.out::println);
		personne = PersonneFactory.personneAvecId().id(1).build();
		System.out.println(personne);
		personne = PersonneFactory.personneAvecTouteLesInfos().id(2).prenom("ooo").nom("pooo").build();
		log.info(personne.toString());
	}

}
