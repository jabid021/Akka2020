package exoString.bean;

public class BeanQuiRetourneUnString implements InterfacePourAspect {
	public String methodeQuiRetourneUnString(boolean param) {
		System.out.println("methode");
		if (param) {
			return "du texte";
		}
		throw new NullPointerException();
	}
}
