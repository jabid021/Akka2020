package rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entity.Personne;

public class PersonneRestClient {
	private static final String REST_URI = "http://localhost:8080/demo-rest-complete/api/personne";

	public List<Personne> getAllPersonne() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(REST_URI);
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
//		Personne[] t = invocationBuilder.get(Personne[].class);
//		List<Personne> list = new ArrayList<>();
//		for (Personne p : t) {
//			list.add(p);
//		}
		return Arrays.asList(invocationBuilder.get(Personne[].class));
	}

	public Personne getPersonne(String uri) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(uri);
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == 404) {
			return null;
		}
		return response.readEntity(Personne.class);
	}

	public Personne getPersonne(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(REST_URI);
		WebTarget personneTarget = webTarget.path(Integer.toString(id));
		Builder invocationBuilder = personneTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == 404) {
			return null;
		}
		return response.readEntity(Personne.class);
	}

	public String addPersonne(Personne p) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(REST_URI);
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(p, MediaType.APPLICATION_JSON));
		return response.getLocation().toString();
	}

	public Personne updatePersonne(Personne p) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(REST_URI);
		WebTarget personneTarget = webTarget.path(Integer.toString(p.getId()));
		Builder invocationBuilder = personneTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(p, MediaType.APPLICATION_JSON));
		if (response.getStatus() == 404) {
			return null;
		}
		return response.readEntity(Personne.class);
	}

	public void deletePersonne(Personne p) {
		deletePersonne(p.getId());
	}

	public void deletePersonne(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(REST_URI);
		WebTarget personneTarget = webTarget.path(Integer.toString(id));
		Builder invocationBuilder = personneTarget.request();
		Response response = invocationBuilder.delete();
		System.out.println(response.getStatus());
	}
}
