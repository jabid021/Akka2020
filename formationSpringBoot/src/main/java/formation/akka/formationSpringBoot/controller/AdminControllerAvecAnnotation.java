package formation.akka.formationSpringBoot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminv2")
@PreAuthorize("hasRole('ADMIN')")
public class AdminControllerAvecAnnotation {

	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}
}
