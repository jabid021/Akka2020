package formationSpring.bean;

public class Saxophoniste implements Musicien {

	private Instrument instrument;

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public String jouer() {
		System.out.println("je suis un saxophiniste " + instrument);
		return "merci du saxophiniste";
	}

}
