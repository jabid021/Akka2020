package formation.akka.formationSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secure/admin")
public class AdminController {

	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}
}
