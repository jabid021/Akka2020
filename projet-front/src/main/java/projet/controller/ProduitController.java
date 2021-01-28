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

import projet.back.entity.Produit;
import projet.back.exception.ProduitException;
import projet.back.service.CategorieService;
import projet.back.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private ProduitService produitService;
	@Autowired
	private CategorieService categorieService;

	@GetMapping({ "", "/" })
	public ModelAndView list() {
		return new ModelAndView("produit/list", "produits", produitService.consultation());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Long id) {
		produitService.suppression(id);
		return new ModelAndView("redirect:/produit");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Long id) {
		try {
			return goEdit(produitService.consultation(id));
		} catch (ProduitException e) {
			return new ModelAndView("redirect:/produit?error=id");
		}
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new Produit());
	}

	private ModelAndView goEdit(Produit produit) {
		ModelAndView modelAndView = new ModelAndView("produit/edit", "produit", produit);
		modelAndView.addObject("categories", categorieService.consultation());
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView add(@Valid @ModelAttribute("produit") Produit produit, BindingResult br) {
		if (produit.getCategorie().getId() == null) {
			produit.setCategorie(null);
		}
		if (br.hasErrors()) {
			return goEdit(produit);
		}
		if (produit.getId() == null) {
			produitService.creation(produit);
		} else {
			produitService.modification(produit);
		}
		return new ModelAndView("redirect:/produit?info=save");
	}
}
