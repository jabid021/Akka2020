package formation.akka.entreprise.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RamValidator.class)
public @interface Ram {
	String message() default "valeur possible: 4, 8, 16, 32";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
