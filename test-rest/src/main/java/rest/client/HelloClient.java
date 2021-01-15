package rest.client;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Personne;

public class HelloClient {
	private final static String URL = "http://localhost:8080/test-rest/api";

	public String sayHello() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(URL);
		WebTarget helloTarget = webTarget.path("/hello");
		Builder invocationBuilder = helloTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			return response.readEntity(String.class);
		}
		throw new IllegalArgumentException("erreur");

	}

	public Personne getPersonne() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(URL);
		WebTarget helloTarget = webTarget.path("/hello/personne");
		Builder invocationBuilder = helloTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		if (response.getStatus() == 200) {
			return response.readEntity(Personne.class);
		}
		throw new IllegalArgumentException("erreur");
	}

	public void getPersonneJson() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(URL);
		WebTarget helloTarget = webTarget.path("/hello/personne/json");
		Builder invocationBuilder = helloTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == 200) {
			Map<String, Object> map = response.readEntity(LinkedHashMap.class);
			System.out.println(map);
		}
	}

}
