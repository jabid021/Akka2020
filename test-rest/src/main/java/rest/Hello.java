package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.Personne;

@Path("/hello")
public class Hello {
	@GET
	// @Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return "hello du service rest";
	}

	@Path("/bye")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayBye() {
//		String s = null;
//		s.toString();
		return "au revoir";
	}

	@Path("/jour/{numero}:{mois}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String jour(@PathParam("numero") int jourNombre, @PathParam("mois") int mois) {
		String jourTexte = "";
		switch (jourNombre) {
		case 1:
			jourTexte = "lundi";
			break;
		case 2:
			jourTexte = "mardi";
			break;
		default:
			jourTexte = "mercredi";
			break;
		}
		return jourTexte;
	}

	@Path("/bonjour")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String bonjour(@QueryParam("prenom") String prenom) {
		return "bonjour " + prenom;
	}

	@Path("/personne")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Personne getPersonne() {
		return new Personne("olivier", "gozlan");
	}

	@Path("/personne/json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Personne getPersonneJson() {
		return new Personne("olivier", "gozlan");
	}

}
