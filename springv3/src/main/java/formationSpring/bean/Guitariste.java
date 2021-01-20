package formationSpring.bean;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import formationSpring.aspect.MonPointCutAvecAnnotation;

@Component("hendrix")
public class Guitariste implements Musicien {

	private String nom = "une valeur fixe";
	@Autowired
	private Instrument instrument;

	public Guitariste() {
		System.out.println("instrument dans le constructeur " + instrument);
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("instrument dans postconstruct " + instrument);

	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@MonPointCutAvecAnnotation
	public void jouer() {
		System.out.println("le guitariste joue " + instrument);
	}

}
