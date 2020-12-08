package singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


//@Entity
@DiscriminatorValue("chat")
public class Chat extends Animal {

	private String race2;
	
	public Chat() {
	}

	public String getRace2() {
		return race2;
	}

	public void setRace2(String race) {
		this.race2 = race;
	}
	
	
	
}
