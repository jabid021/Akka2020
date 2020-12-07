package joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id_voiture",referencedColumnName="id")
public class Voiture extends Vehicule{

	
	
	private String plaque;

	public Voiture() {
	}
	
	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}
	
}
