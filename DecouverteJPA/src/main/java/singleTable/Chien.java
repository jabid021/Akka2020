package singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue("chien")
public class Chien extends Animal {

	private String race;
	
	public Chien() {
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
	
	
	
}
