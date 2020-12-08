package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Entity

public class Sorcier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_sorcier")
	private Integer id;
	private String nom;
	private String prenom;
	
	
	
	@OneToOne
	@JoinColumn(name="id_b")
	private Baguette baguette;
	
	
	@ManyToOne
	@JoinColumn(name="id_ecole")
	private Ecole ecole;
	
	@ManyToMany
	
	@JoinTable
	(
			name="rencontre",
			joinColumns = @JoinColumn(name="sorcier"),
			inverseJoinColumns = @JoinColumn(name="play")
	)
	private List<Match> matchs;
	public Sorcier() {
	}
	

	public Sorcier(String nom, String prenom, Baguette baguette) {
		this.nom = nom;
		this.prenom = prenom;
		this.baguette = baguette;
	}


	public List<Match> getMatchs() {
		return matchs;
	}


	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Baguette getBaguette() {
		return baguette;
	}

	public void setBaguette(Baguette baguette) {
		this.baguette = baguette;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Ecole getEcole() {
		return ecole;
	}


	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
	

}
