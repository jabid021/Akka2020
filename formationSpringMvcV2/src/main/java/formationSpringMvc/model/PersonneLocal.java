package formationSpringMvc.model;

public class PersonneLocal {
	private String prenom;
	private String nom;

	public PersonneLocal() {

	}

	public PersonneLocal(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
