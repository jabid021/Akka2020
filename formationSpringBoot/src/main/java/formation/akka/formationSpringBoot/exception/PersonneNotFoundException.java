package formation.akka.formationSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "page introuvable")
public class PersonneNotFoundException extends RuntimeException {

}
