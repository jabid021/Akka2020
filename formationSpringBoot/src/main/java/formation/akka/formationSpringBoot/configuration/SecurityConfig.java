package formation.akka.formationSpringBoot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import formation.akka.formationSpringBoot.service.CustomUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@// @formatter:off		
		//activation des restcontroller
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests().antMatchers(HttpMethod.OPTIONS).anonymous()
			.and()
			.csrf().disable().authorizeRequests()
				.antMatchers("/api/inscription").permitAll()
				.antMatchers("/api/**").authenticated()
				.and().httpBasic();
			
//		http.authorizeRequests()
//				.antMatchers("/", "/images/**", "/public", "/public/**").permitAll()
//				.antMatchers("/admin/**").hasAnyRole("ADMIN")
//				.anyRequest().authenticated()
//			.and()
//			.formLogin()
//				.loginPage("/login")
//				.defaultSuccessUrl("/secure/home")
//				.failureUrl("/login?error")
//				.permitAll()
//			.and()
//			.logout()
//				.logoutUrl("/logout")
//				.logoutSuccessUrl("/")
//				.permitAll();
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// @formatter:off
//		auth.inMemoryAuthentication()
//			.withUser("olivier").password("{noop}olivier").roles("ADMIN","USER")
//			.and()
//			.withUser("user").password("{noop}user").roles("USER");
//		// @formatter:on

		// @formatter:off
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.usersByUsernameQuery("select username,password,enable from ????? where username=?")
//				.authoritiesByUsernameQuery("select username,role from ???? whee username=?");
		// @formatter:on

		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
