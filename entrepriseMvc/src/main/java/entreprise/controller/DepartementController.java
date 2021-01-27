package entreprise.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entreprise.dao.IDAODepartement;
import entreprise.model.Departement;

@Controller
@RequestMapping("/departement")
public class DepartementController {
	@Autowired
	private IDAODepartement daoDepartement;

	@GetMapping({ "", "/" })
	public ModelAndView list() {
		return new ModelAndView("departement/list", "departements", daoDepartement.findAll());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Integer numero) {
		daoDepartement.delete(numero);
		return new ModelAndView("redirect:/departement");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Integer numero) {
		return goEdit(daoDepartement.findById(numero));
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new Departement());
	}

	private ModelAndView goEdit(Departement departement) {
		ModelAndView modelAndView = new ModelAndView("departement/edit", "departement", departement);
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView add(@Valid @ModelAttribute("departement") Departement departement, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(departement);
		}
		if (departement.getNumero() == null) {
			daoDepartement.insert(departement);
		} else {
			daoDepartement.update(departement);
		}
		return new ModelAndView("redirect:/departement");
	}
}
