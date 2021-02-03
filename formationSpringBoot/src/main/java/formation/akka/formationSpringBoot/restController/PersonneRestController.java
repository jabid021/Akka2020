package formation.akka.formationSpringBoot.restController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import formation.akka.formationSpringBoot.entity.Adresse;
import formation.akka.formationSpringBoot.entity.Personne;
import formation.akka.formationSpringBoot.entity.Vue;
import formation.akka.formationSpringBoot.exception.PersonneInvalidException;
import formation.akka.formationSpringBoot.exception.PersonneNotFoundException;
import formation.akka.formationSpringBoot.service.PersonneService;

@RestController
@RequestMapping("/api/personne")
public class PersonneRestController {

	@Autowired
	private PersonneService personneService;

	@GetMapping({ "", "/" })
	public List<Personne> getAllPersonne() {
		return personneService.allPersonne();
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Personne> addPersonne(@Valid @RequestBody Personne p, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new PersonneInvalidException();
		}
		personneService.creationPersonne(p);
		URI uri = uCB.path("/api/personne/{id}").buildAndExpand(p.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Personne>(p, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Personne findById(@PathVariable("id") Integer id) {
		Personne p = personneService.find(id);
		if (p.getId() != null) {
			return p;
		}
		throw new PersonneNotFoundException();
	}

	@PutMapping("/{id}")
	public Personne update(@Valid @RequestBody Personne p, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new PersonneInvalidException();
		}
		Personne personneEnBase = personneService.find(id);
		if (personneEnBase.getId() == null) {
			throw new PersonneNotFoundException();
		}
		personneEnBase.setPrenom(p.getPrenom());
		personneEnBase.setNom(p.getNom());
		personneService.save(personneEnBase);
		return personneEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Personne personneEnBase = personneService.find(id);
		if (personneEnBase.getId() == null) {
			throw new PersonneNotFoundException();
		}
		personneService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/test")
	@JsonView(Vue.Common.class)
	public Personne test() {
		return testPrivate();
	}

	@GetMapping("/test/Adresse")
	@JsonView(Vue.PersonneWithAdresse.class)
	public Personne test2() {
		return testPrivate();
	}

	private Personne testPrivate() {
		Adresse a = new Adresse();
		a.setRue("rue aaa");
		Personne p = new Personne("aa", "pp");
		p.setAdresse(a);
		return p;
	}

}
