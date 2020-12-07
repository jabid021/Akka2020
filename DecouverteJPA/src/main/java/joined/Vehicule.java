package joined;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="M", nullable=false,columnDefinition="VARCHAR(50)")
	@NotEmpty
	@Size(max=50)
	protected Marque marque;
	
	@Column(name="speed")
	protected int vitesse;
	
	//columnDefinition="DATE" / "Time" / DATETIME 
	@Column(name="date_creation",columnDefinition="DATE")
	protected LocalDate creation;
	
	
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
