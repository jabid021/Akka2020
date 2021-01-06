package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Oeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	private String editeur;
	@Column(columnDefinition = "VARCHAR(600)")
	private String description;
	
	private String image;
	
	@Version
	private int version;
	
	
	public Oeuvre() {
	}


	public Oeuvre(String libelle, String editeur, String description) {
		this.libelle = libelle;
		this.editeur = editeur;
		this.description = description;
	}


	
	public Oeuvre(Integer id, String libelle, String editeur, String description) {
		this.id = id;
		this.libelle = libelle;
		this.editeur = editeur;
		this.description = description;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getEditeur() {
		return editeur;
	}


	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public String toString() {
		return "Oeuvre [id=" + id + ", libelle=" + libelle + ", editeur=" + editeur + ", description=" + description
				+ ", image=" + image + ", version=" + version + "]";
	}


	
	
	
}
