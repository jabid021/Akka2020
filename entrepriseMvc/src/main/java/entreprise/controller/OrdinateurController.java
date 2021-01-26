package entreprise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entreprise.dao.IDAOOrdinateur;
import entreprise.model.Ordinateur;

@Controller
@RequestMapping("/ordinateur")
public class OrdinateurController {

	@Autowired
	private IDAOOrdinateur daoOrdinateur;

	@GetMapping({ "", "/" })
	public String list(Model model) {
		model.addAttribute("ordinateurs", daoOrdinateur.findAll());
		return "ordinateur/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		daoOrdinateur.delete(id);
		return "redirect:/ordinateur";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return formulaire(daoOrdinateur.findById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return formulaire(new Ordinateur(), model);
	}

	private String formulaire(Ordinateur ordinateur, Model model) {
		model.addAttribute("ordinateur", ordinateur);
		return "ordinateur/edit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Ordinateur ordinateur) {
		if (ordinateur.getId() == null) {
			daoOrdinateur.insert(ordinateur);
		} else {
			daoOrdinateur.update(ordinateur);
		}
		return "redirect:/ordinateur";
	}
}
