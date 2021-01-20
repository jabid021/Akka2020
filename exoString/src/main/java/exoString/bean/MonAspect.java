package exoString.bean;

public class MonAspect {

	public void interceptRetour(String valeurDeRetour) {
		System.out.println(valeurDeRetour);
	}

	public void interceptException(Exception exception) {
		System.out.println(exception);
	}
}
