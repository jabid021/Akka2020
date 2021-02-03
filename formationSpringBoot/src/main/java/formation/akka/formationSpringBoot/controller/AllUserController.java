package formation.akka.formationSpringBoot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class AllUserController {

	Logger log = LoggerFactory.getLogger(AllUserController.class);

	@GetMapping("")
	public String home() {
		return "home";
	}

	@GetMapping("/page1")
	public String page1() {
		log.info("methode page1");
		return "public/page1";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "admin/home";
	}
}
