package model;

import java.time.LocalDate;
import java.util.List;

public class Audit extends Projet{
	
	private LocalDate debut;
	private LocalDate fin;
	
	
	public Audit() {
		
	}
	public Audit(String libelle, List<Employe> employes,String debut,String fin) {
		super(libelle, employes);
		this.debut=LocalDate.parse(debut);
		this.fin=LocalDate.parse(fin);
		
	}
	public LocalDate getDebut() {
		return debut;
	}
	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	
	

}
