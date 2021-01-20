package formationSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import formationSpring.bean.Guitare;
import formationSpring.bean.Guitariste;
import formationSpring.bean.Instrument;
import formationSpring.bean.Musicien;

@Configuration
@ComponentScan({ "formationSpring.bean" })
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean
	public Instrument guitare() {
		return new Guitare();
	}

//	@Bean("hendrix")
//	public Musicien guitariste(Instrument instrument) {
//		Guitariste musicien = new Guitariste();
//		musicien.setInstrument(instrument);
//		return musicien;
//	}
}
