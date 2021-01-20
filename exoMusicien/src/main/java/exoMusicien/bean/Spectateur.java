package exoMusicien.bean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Spectateur {

	@Autowired
	Musicien trompettiste;

	@Pointcut("execution(* exoMusicien.bean.Pianiste.jouer())")
	public void jouerPianiste() {

	}

	@Pointcut("execution(* exoMusicien.bean.Musicien.jouer())")
	public void jouerMusicien() {

	}

	@Pointcut("execution(* exoMusicien.bean.Trompettiste.jouer())")
	public void jouerTrompettiste() {

	}

	@Before("jouerPianiste()")
	public void prendrePlace() {
		System.out.println("le public s'installe");
	}

	@AfterReturning(pointcut = "jouerMusicien()")
	public void applaudir() {
		System.out.println("le public applaudit");
	}

	@AfterThrowing(pointcut = "jouerMusicien()")
	public void siffler() {
		System.out.println("le public siffle");
	}

	@After("jouerPianiste()")
	public void suivant() {
		trompettiste.jouer();
	}

	@After("jouerTrompettiste()")
	public void partir() {
		System.out.println("le public part");
	}

}
