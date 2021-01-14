package soapclient;

import soap.HelloService;
import soap.HelloService_Service;
import soap.Personne;

public class App {

	public static void main(String[] args) {
		System.out.println("soap client");
		HelloService_Service hss = new HelloService_Service();
		HelloService helloService = hss.getHelloServicePort();
		Personne olivier = helloService.getPersonneInit("azerty", "uiop");
		System.out.println(olivier.getPrenom() + " " + olivier.getNom());
	}

}
