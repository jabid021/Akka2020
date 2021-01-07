package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")

public class Admin extends Compte {

	public Admin(String login, String password, String mail) {
		super(login,password,mail);
	}

	public Admin() {

	}
}
