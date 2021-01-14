package model;

public class Ville {
	private String nom;
	private long population;
	private String pays;

	public Ville() {

	}

	public Ville(String nom, long population, String pays) {
		super();
		this.nom = nom;
		this.population = population;
		this.pays = pays;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}
