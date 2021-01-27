package entreprise.validator;

import java.time.LocalDate;
import java.time.Month;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Post20000101Validator implements ConstraintValidator<Post20000101, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		return value.isAfter(LocalDate.of(2000, Month.JANUARY, 1));
	}

}
