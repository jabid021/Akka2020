package entreprise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqOrdinateur")
public class Ordinateur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrdinateur")
	private Integer id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordinateur other = (Ordinateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
