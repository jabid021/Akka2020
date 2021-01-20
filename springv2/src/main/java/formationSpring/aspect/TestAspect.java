package formationSpring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import formationSpring.bean.Guitariste;

@Component
@Aspect
public class TestAspect {

	@Pointcut("execution(* formationSpring.bean.Musicien.jouer())")
	public void pointcut() {

	}

	@Before("pointcut()")
	public void before(JoinPoint jP) {
		System.out.println("before");
		if (jP.getTarget() instanceof Guitariste) {
			System.out.println("le guitariste va jouer");
		}
	}

	@After("pointcut()")
	public void after() {
		System.out.println("after");
	}

	@AfterReturning(pointcut = "pointcut()", returning = "result")
	public void afterReturning(String result) {
		System.out.println("afterReturning " + result);
	}

	@AfterThrowing(pointcut = "pointcut()", throwing = "erreur")
	public void afterThrowing(Throwable erreur) {
		System.out.println("erreur:" + erreur);
	}

	@Around("pointcut()")
	public void around(ProceedingJoinPoint pJP) throws Throwable {
		System.out.println("je suis dans around la methode jouer n'est pas encore lancee");
		pJP.proceed();

		System.out.println("la methode jouer est fini");
	}

}
