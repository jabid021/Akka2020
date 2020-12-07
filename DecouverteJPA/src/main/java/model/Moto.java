package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bike")
public class Moto {
	
	@Id
	private Integer id;
	private String marque;
	private int vitesse;
	
	
	public Moto() {
	}


	public Moto(String marque, int vitesse) {
		this.setMarque(marque);
		this.setVitesse(vitesse);
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public int getVitesse() {
		return vitesse;
	}


	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
	

}
