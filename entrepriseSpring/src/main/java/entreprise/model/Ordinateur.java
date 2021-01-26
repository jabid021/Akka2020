 package entreprise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity
@SequenceGenerator(name="ordinateur")
public class Ordinateur {
	@Id
	private int id;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ordinateur")
	private Marque marque;
	private Integer RAM;
	
	@OneToOne(mappedBy = "ordinateur")
	private Employe utilisateur;
	
	public Ordinateur() {
	}

	public Ordinateur(Marque marque, Integer RAM, Employe utilisateur) {
		this.marque = marque;
		this.RAM = RAM;
		this.utilisateur = utilisateur;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Integer getRAM() {
		return RAM;
	}

	public void setRAM(Integer rAM) {
		RAM = rAM;
	}

	public Employe getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Employe utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
}
