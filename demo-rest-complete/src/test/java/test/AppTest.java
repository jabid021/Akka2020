package test;

import entity.Personne;
import rest.PersonneRestClient;

public class AppTest {
	public static void main(String[] args) {

		PersonneRestClient pRC = new PersonneRestClient();
		System.out.println(pRC.getAllPersonne());
		System.out.println("-----------");
		System.out.println(pRC.getPersonne(111));
		System.out.println("-----------");
		System.out.println(pRC.getPersonne(10));
		System.out.println("-----------");
		Personne p = new Personne("aaaa", "aa");
		String resultat = pRC.addPersonne(p);
		System.out.println(resultat);
		System.out.println("-----------");
		p = pRC.getPersonne(resultat);
		System.out.println(p);
		pRC.deletePersonne(p);

	}
}
