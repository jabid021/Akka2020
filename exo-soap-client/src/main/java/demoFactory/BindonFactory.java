package demoFactory;

public class BindonFactory {
	public static Bidon getInstance() {
		return new AutreClassQuiImplementBidon();
	}
}
