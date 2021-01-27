package formationSpringMvc.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formationSpringJpa.dao.DaoPersonne;
import formationSpringJpa.entity.Personne;

@Controller
@RequestMapping("/personne")
public class PersonneController {

	@Autowired
	private DaoPersonne daoPersonne;
	@Autowired
	private Validator validator;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("personnes", daoPersonne.findAll());
		Personne p = new Personne();
		Set<ConstraintViolation<Personne>> violations = validator.validate(p);
		if (violations.isEmpty()) {
			System.out.println(p);
		} else {
			System.out.println("erreur de validation:\n" + violations);
		}
		return "personne/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		daoPersonne.deleteByKey(id);
		return "redirect:/personne";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("personne") Personne personne, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(personne, model);
		}
		if (personne.getId() == null) {
			daoPersonne.insert(personne);
		} else {
			daoPersonne.update(personne);
		}
		return "redirect:/personne";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(daoPersonne.findByKey(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Personne(), model);
	}

	private String goEdit(Personne personne, Model model) {
		model.addAttribute("personne", personne);
		// si on a des donnees en plus dans le model on ecrit le code 1 fois
		return "personne/editAvecSpring";
	}

}
