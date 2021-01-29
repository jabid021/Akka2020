package formation.akka.entreprise.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = Post20000101Validator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Post20000101 {
	String message() default "avant 01/01/2000";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
