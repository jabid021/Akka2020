package exoMusicien.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({ "exoMusicien.bean" })
@EnableAspectJAutoProxy
public class AppConfig {

}
