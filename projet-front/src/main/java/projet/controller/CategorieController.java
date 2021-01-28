package projet.controller;

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

import projet.back.entity.Categorie;
import projet.back.exception.CategorieException;
import projet.back.service.CategorieService;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
	@Autowired
	private CategorieService categorieService;

	@GetMapping({ "", "/" })
	public ModelAndView list() {
		return new ModelAndView("categorie/list", "categories", categorieService.consultation());
	}

	@GetMapping("/detail")
	public ModelAndView show(@RequestParam(name = "id", required = false, defaultValue = "0") Long id) {
		try {
			return new ModelAndView("categorie/detail", "categorie", categorieService.consultationAvecDetails(id));
		} catch (CategorieException e) {
			return new ModelAndView("redirect:/categorie?error=id");
		}
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Long id) {
		try {
			categorieService.suppressionCategorie(id);
		} catch (CategorieException e) {
			return new ModelAndView("redirect:/categorie?error=id");
		}
		return new ModelAndView("redirect:/categorie");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Long id) {
		try {
			return goEdit(categorieService.consultation(id));
		} catch (CategorieException e) {
			return new ModelAndView("redirect:/categorie?error=id");
		}
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new Categorie());
	}

	private ModelAndView goEdit(Categorie categorie) {
		ModelAndView modelAndView = new ModelAndView("categorie/edit", "categorie", categorie);
		modelAndView.addObject("categories", categorieService.consultation());
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView add(@Valid @ModelAttribute("categorie") Categorie categorie, BindingResult br) {
		if (categorie.getCategorieMere().getId() == null) {
			categorie.setCategorieMere(null);
		}
		if (br.hasErrors()) {
			return goEdit(categorie);
		}
		if (categorie.getId() == null) {
			categorieService.creation(categorie);
		} else {
			categorieService.modification(categorie);
		}
		return new ModelAndView("redirect:/categorie?info=save");
	}
}
