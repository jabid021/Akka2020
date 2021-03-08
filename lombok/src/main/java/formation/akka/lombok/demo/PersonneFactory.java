package formation.akka.lombok.demo;

import lombok.Builder;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonneFactory {

	@Builder(builderClassName = "BuilderAvecId", builderMethodName = "personneAvecId")
	public static Personne personneJusteAvecUnId(Integer id) {
		return Personne.builder().id(id).prenom("inconnu").nom("inconnu").build();
	}

	@Builder(builderClassName = "BuilderComplet", builderMethodName = "personneAvecTouteLesInfos")
	public static Personne personneComplete(Integer id, String prenom, String nom) {
		return Personne.builder().id(id).prenom(prenom).nom(nom).build();
	}
}
