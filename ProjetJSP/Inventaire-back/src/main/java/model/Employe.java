package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("employe")
public class Employe extends Compte{
	
	@OneToOne
	private PC pc;

	public Employe() {
	}
	public Employe(PC pc) {
		this.pc = pc;
	}

	public PC getPc() {
		return pc;
	}

	public void setPc(PC pc) {
		this.pc = pc;
	}
	
	
}
