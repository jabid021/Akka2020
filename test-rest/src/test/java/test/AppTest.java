package test;

import java.util.LinkedHashMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Personne;
import rest.client.HelloClient;

public class AppTest {
	public static void main(String[] args) {
//		Client client = ClientBuilder.newClient();
//		WebTarget webTarget = client.target("http://localhost:8080/test-rest/api");
//		WebTarget helloTarget = webTarget.path("/hello");
//		Builder invocationBuilder = helloTarget.request(MediaType.APPLICATION_JSON);
//		Response response = invocationBuilder.get();
//		System.out.println(response.getStatus());
//		if (response.getStatus() == 200) {
//			System.out.println(response.readEntity(String.class));
//		}
//
//		WebTarget personneTarget = webTarget.path("/hello/personne");
//		invocationBuilder = personneTarget.request(MediaType.APPLICATION_XML);
//		Personne p = invocationBuilder.get(Personne.class);
//		System.out.println(p.getPrenom() + " " + p.getNom());

		HelloClient helloClient = new HelloClient();
		System.out.println(helloClient.sayHello());
		helloClient.getPersonne();
	}
}
