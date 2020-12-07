package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fournisseur")
public class Fournisseur extends Personne{
	
	
	@Column(name="company",columnDefinition = "VARCHAR(60)")
	private String societe;
	
	
	public Fournisseur() {
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(String nom, String prenom,String societe) {
		super(nom, prenom);
		this.societe=societe;
	}
	public String getSociete() {
		return societe;
	}
	public void setSociete(String societe) {
		this.societe = societe;
	}
	
	

}
