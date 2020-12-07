package model;

public class Ordinateur {

	
	private Marque marque;
	private Integer RAM;
	
	
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
