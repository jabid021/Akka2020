package exoString;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import exoString.bean.BeanQuiRetourneUnString;
import exoString.bean.InterfacePourAspect;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		ctx.getBean("object", InterfacePourAspect.class).methodeQuiRetourneUnString(true);
		ctx.close();
	}

}
