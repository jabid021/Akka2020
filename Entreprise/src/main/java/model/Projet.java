package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Projet {

	protected String libelle;
	
	
	protected  List<Employe> employes=new ArrayList<>();
	
	public Projet() {
	}

	public Projet(String libelle, List<Employe> employes) {
		this.libelle = libelle;
		this.employes = employes;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	
}
