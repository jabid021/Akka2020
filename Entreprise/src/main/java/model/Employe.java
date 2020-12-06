package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employe implements Serializable {

	private int numero;
	private String nom;
	private String poste;
	private Employe manager;
	private LocalDate embauche;
	private int salaire;
	private Integer commission;
	private Departement departement;


	public Employe() {
	}


	public Employe(int numero, String nom, String poste, String embauche, int salaire, Integer commission,
			Departement departement) {
		this.numero = numero;
		this.nom = nom;
		this.poste = poste;
		this.embauche = LocalDate.parse(embauche);
		this.salaire = salaire;
		this.commission = commission;
		this.departement = departement;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}


	public Employe getManager() {
		return manager;
	}


	public void setManager(Employe manager) {
		this.manager = manager;
	}


	public LocalDate getEmbauche() {
		return embauche;
	}


	public void setEmbauche(String embauche) {
		this.embauche = LocalDate.parse(embauche);
	}


	public int getSalaire() {
		return salaire;
	}


	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}


	public Integer getCommission() {
		return commission;
	}


	public void setCommission(Integer commission) {
		this.commission = commission;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	@Override
	public String toString() {
		return "Employe [numero=" + numero + ", nom=" + nom + ", poste=" + poste + ", manager=" + manager
				+ ", embauche=" + embauche + ", salaire=" + salaire + ", commission=" + commission + ", departement="
				+ departement + "]";
	}


}
