package formationSpring.bean;

public class Guitariste implements Musicien {

	private String nom;
	private Instrument instrument;

	public Guitariste() {

	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void jouer() {
		System.out.println("le guitariste joue " + instrument);
	}

}
