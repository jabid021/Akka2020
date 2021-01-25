package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formationSpringMvc.model.PersonneLocal;

@Controller
public class HelloController {

	// @RequestMapping(path="/hello",method=RequestMethod.GET)
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "user", required = false, defaultValue = "world") String utilisateur,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age, Model model) {
		model.addAttribute("utilisateur", utilisateur);
		System.out.println(age);
		return "hello";
	}

	@RequestMapping("/page1")
	public String page1() {
		return "page1";
	}

	@GetMapping({ "", "/index", "/home" })
	public String index() {
		return "index";
	}
//
//	@GetMapping("/personne")
//	public String helloPersonne(@ModelAttribute PersonneLocal p, Model model) {
//		model.addAttribute("personne", p);
//		return "personne";
//	}
}
