package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqBaguette", initialValue = 15)
public class Baguette {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqBaguette")
	private Integer id;
	private String titre;
	
	
	
	@OneToOne(mappedBy = "baguette")
	private Sorcier sorcier;
	
	public Baguette() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Baguette(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Sorcier getSorcier() {
		return sorcier;
	}

	public void setSorcier(Sorcier sorcier) {
		this.sorcier = sorcier;
	}
	
	
	
}
