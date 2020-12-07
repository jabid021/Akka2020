package model;

import java.util.List;

public class Developpement extends Projet{
	
	private String technologie;
	
	public Developpement() {
	}

	public Developpement(String libelle, List<Employe> employes,String technologie) {
		super(libelle, employes);
		this.technologie=technologie;
		
	}

	public String getTechnologie() {
		return technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}

	

}
