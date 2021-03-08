package formation.akka.lombok.demo;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString(of = { "id", "prenom", "nom" })
@EqualsAndHashCode(of = { "id" })
public class Personne {
	private Integer id;
	@Setter
	private String prenom;
	@Setter
	private String nom;

	@Getter
	@Singular
	private List<Adresse> adresses = new ArrayList<Adresse>();

}
