package formation.akka.formationSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.akka.formationSpringBoot.entity.Personne;
import formation.akka.formationSpringBoot.service.PersonneService;

@Controller
@RequestMapping("/personne")
public class PersonneController {

	@Autowired
	private PersonneService personneService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("personnes", personneService.allPersonne());
		Personne p = new Personne();
		return "personne/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		personneService.delete(id);
		return "redirect:/personne";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("personne") Personne personne, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(personne, model);
		}
		personneService.save(personne);
		return "redirect:/personne";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(personneService.find(id), model);
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
