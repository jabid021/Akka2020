package exoMusicien.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import exoMusicien.bean.Musicien;
import exoMusicien.bean.Pianiste;
import exoMusicien.bean.Trompettiste;

@Configuration
@ComponentScan({ "exoMusicien.bean" })
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean("pianistee")
	public Musicien pianiste() {
		return new Pianiste();
	}

//	@Bean
//	public Musicien trompettiste() {
//		return new Trompettiste();
//	}
}
