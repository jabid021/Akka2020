package formationSpring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonAspect {

	@Pointcut("@annotation(formationSpring.aspect.MonPointCutAvecAnnotation)")
	public void pointcut() {

	}

	@Before("pointcut()")
	public void before() {
		System.out.println("before");
	}
}
