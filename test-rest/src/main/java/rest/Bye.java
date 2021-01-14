package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bye")
public class Bye {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String bye() {
		return "au revoir";
	}
}
