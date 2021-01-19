package hello.bean;

public class Francais implements Langue {

	@Override
	public String direBonjour() {
		return "bonjour";
	}

	@Override
	public String direAuRevoir() {
		return "au revoir";
	}

}
