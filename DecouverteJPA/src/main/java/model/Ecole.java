package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Ecole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private  String nom;
	
	
	
	@OneToMany(mappedBy="ecole")
	private List<Sorcier> eleves;
	
	public Ecole() {
		// TODO Auto-generated constructor stub
	}

	public Ecole(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Sorcier> getEleves() {
		return eleves;
	}

	public void setEleves(List<Sorcier> eleves) {
		this.eleves = eleves;
	}
	
	
	
	
	
}
