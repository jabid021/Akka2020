package soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import model.Personne;

@WebService(name = "HelloService")
public class Hello {

	@WebMethod
	public String sayHello() {
		return "hello world de soap";
	}

	@WebMethod
	public @WebResult(name = "personne") Personne getPersonne() {
		return new Personne("olivier", "gozlan");
	}

	@WebMethod
	public @WebResult(name = "personne") Personne getPersonneInit(@WebParam(name = "prenom") String prenom,
			@WebParam(name = "nom") String nom) {
		return new Personne(prenom, nom);
	}
}
