package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Departement implements Serializable {

	private int numero;
	private String nom;
	private String lieu;
	
	
	private List<Employe> employes  = new ArrayList<>();

	public Departement() {
	}

	public Departement(int numero, String nom, String lieu) {
		this.numero = numero;
		this.nom = nom;
		this.lieu = lieu;
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

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}


}
