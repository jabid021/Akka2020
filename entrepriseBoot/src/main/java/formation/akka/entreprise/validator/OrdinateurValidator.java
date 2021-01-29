package formation.akka.entreprise.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import formation.akka.entreprise.model.Ordinateur;

public class OrdinateurValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Ordinateur.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Ordinateur o = (Ordinateur) target;
		Integer ram = o.getRAM();
		if (ram != 4 && ram != 8 && ram != 16 && ram != 32) {
			errors.rejectValue("RAM","error.ram","valeur possible 4, 8, 16, 32");
		}
	}

}
