package formation.akka.formationSpringBoot.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.akka.formationSpringBoot.entity.Role;
import formation.akka.formationSpringBoot.entity.User;
import formation.akka.formationSpringBoot.entity.UserRole;
import formation.akka.formationSpringBoot.exception.UserInvalidException;
import formation.akka.formationSpringBoot.repository.UserRepository;
import formation.akka.formationSpringBoot.repository.UserRoleRepository;

@RestController
@RequestMapping("/api/inscription")
@CrossOrigin(origins="*")
public class InscriptionController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping({ "", "/" })
	public ResponseEntity<Void> ajoutUser(@Valid @RequestBody User user, BindingResult br) {
		if (br.hasErrors()) {
			throw new UserInvalidException();
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		userRoleRepository.save(new UserRole(user, Role.ROLE_USER));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
