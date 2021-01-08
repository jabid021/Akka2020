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
	
	public Employe(String login, String password, String mail,PC pc) {
		super(login,password,mail);
		this.pc=pc;
	}
	
	public Employe(Integer id,String login, String password, String mail,PC pc) {
		super(id,login,password,mail);
		this.pc=pc;
	}

	public PC getPc() {
		return pc;
	}

	public void setPc(PC pc) {
		this.pc = pc;
	}
	
	
}
