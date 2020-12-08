package joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

//@Entity
@PrimaryKeyJoinColumn(name="id_moto",referencedColumnName="id")

public class Moto extends Vehicule {
	
	private String enPlus;
	
	public Moto() 
	{
		
	}

	public String getEnPlus() {
		return enPlus;
	}

	public void setEnPlus(String enPlus) {
		this.enPlus = enPlus;
	}







	
	

}
