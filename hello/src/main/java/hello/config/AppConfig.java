package hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import hello.bean.Francais;
import hello.bean.Langue;

@Configuration
@ComponentScan({ "hello.bean", "hello.service" })
public class AppConfig {

	@Bean
	public Langue francais() {
		return new Francais();
	}

}
