package formation.akka.entreprise.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RamValidator implements ConstraintValidator<Ram, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return value == 4 || value == 8 || value == 16 || value == 32;
	}

}
