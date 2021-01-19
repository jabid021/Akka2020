package hello.bean;

import org.springframework.stereotype.Component;

@Component("anglais")
public class Anglais implements Langue {

	@Override
	public String direBonjour() {
		return "hello";
	}

	@Override
	public String direAuRevoir() {
		return "bye";
	}

}
