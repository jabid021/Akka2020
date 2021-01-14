package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {
	@GET
	//@Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return "hello du service rest";
	}
}
