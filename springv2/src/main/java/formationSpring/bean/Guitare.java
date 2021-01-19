package formationSpring.bean;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements Instrument {

	@Override
	public String toString() {
		return "plink plink plink";
	}
}
