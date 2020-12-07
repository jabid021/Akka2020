package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="bike")
public class Moto {
	
	@Id
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="M", nullable=false,columnDefinition="VARCHAR(50)")
	@NotEmpty
	@Size(max=50)
	private Marque marque;
	
	@Column(name="speed")
	private int vitesse;
	
	//columnDefinition="DATE" / "Time" / DATETIME 
	@Column(name="date_creation",columnDefinition="DATE")
	private LocalDate creation;
	
	public Moto() {
	}

	public Moto(Integer id, Marque marque, int vitesse, LocalDate creation) {
		this.id = id;
		this.marque = marque;
		this.vitesse = vitesse;
		this.creation = creation;
	}





	public Marque getMarque() {
		return marque;
	}


	public void setMarque(Marque marque) {
		this.marque = marque;
	}


	public int getVitesse() {
		return vitesse;
	}


	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
	

}
