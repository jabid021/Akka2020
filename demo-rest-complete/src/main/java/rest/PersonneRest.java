package rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.DaoPersonne;
import dao.DaoPersonneFactory;
import entity.Personne;

@Path("/personne")
public class PersonneRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Personne> getPersonnes() {
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		return daoPersonne.findAll();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Personne p) throws URISyntaxException {
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		daoPersonne.insert(p);
		return Response.created(new URI("/demo-rest-complete/api/personne/" + p.getId())).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPersonne(@PathParam("id") int id) {
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		Personne p = daoPersonne.findByKey(id);
		if (p != null) {
			return Response.ok(p).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@Path("/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Personne p, @PathParam("id") int id) {
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		Personne personneEnBase = daoPersonne.findByKey(id);
		if (personneEnBase == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		personneEnBase.setPrenom(p.getPrenom());
		personneEnBase.setNom(p.getNom());
		personneEnBase = daoPersonne.update(personneEnBase);
		return Response.ok(personneEnBase).build();
	}

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		Personne personneEnBase = daoPersonne.findByKey(id);
		if (personneEnBase == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		daoPersonne.delete(personneEnBase);
		return Response.noContent().build();
	}
}
