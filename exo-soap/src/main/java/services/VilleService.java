package services;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import model.Ville;

@WebService(name = "villeservice")
public class VilleService {

	private static Map<String, Ville> map = null;

	static {
		map = new HashMap<>();
		map.put("paris", new Ville("paris", 10000000L, "france"));
		map.put("lyon", new Ville("lyon", 5000000L, "france"));
	}

	@WebMethod
	public @WebResult(name = "ville") Ville getInfo(@WebParam(name = "nom") String nom) {
		return map.get(nom);
	}
}
