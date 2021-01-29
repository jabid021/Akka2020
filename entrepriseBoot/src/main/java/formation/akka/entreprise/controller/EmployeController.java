package formation.akka.entreprise.controller;

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

import formation.akka.entreprise.dao.IDAODepartement;
import formation.akka.entreprise.dao.IDAOEmploye;
import formation.akka.entreprise.dao.IDAOOrdinateur;
import formation.akka.entreprise.model.Employe;

@Controller
@RequestMapping("/employe")
public class EmployeController {

	@Autowired
	private IDAOEmploye daoEmploye;
	@Autowired
	private IDAOOrdinateur daoOrdinateur;
	@Autowired
	private IDAODepartement daoDepartement;

	@GetMapping({ "", "/" })
	public ModelAndView list() {
		return new ModelAndView("employe/list", "employes", daoEmploye.findAll());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Integer numero) {
		daoEmploye.delete(numero);
		return new ModelAndView("redirect:/employe");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Integer numero) {
		return goForm(daoEmploye.findById(numero));
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goForm(new Employe());
	}

	private ModelAndView goForm(Employe employe) {
		ModelAndView modelAndView = new ModelAndView("employe/edit");
		modelAndView.addObject("employe", employe);
		modelAndView.addObject("ordinateurs", daoOrdinateur.findAll());
		modelAndView.addObject("managers", daoEmploye.findAll());
		modelAndView.addObject("departements", daoDepartement.findAll());
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("employe") Employe employe, BindingResult br) {

		if (employe.getOrdinateur().getId() == null) {
			employe.setOrdinateur(null);
		}
		if (employe.getManager().getNumero() == null) {
			employe.setManager(null);
		}
		if (employe.getDepartement() != null && employe.getDepartement().getNumero() == null) {
			employe.setDepartement(null);
		}
		if (br.hasErrors()) {
			return goForm(employe);
		}
		if (employe.getNumero() == null) {
			daoEmploye.insert(employe);
		} else {
			daoEmploye.update(employe);
		}
		return new ModelAndView("redirect:/employe");
	}
}
