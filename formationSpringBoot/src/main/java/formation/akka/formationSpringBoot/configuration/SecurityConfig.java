package formation.akka.formationSpringBoot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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

	@Configuration
	@Order(2)
	public class SiteJavaSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/images/**", "/public", "/public/**");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
		//@// @formatter:off		
		//activation des restcontroller
		http		
			.antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/login","/logout").permitAll()
					.antMatchers("/secure/admin","/secure/admin/**").hasAnyRole("ADMIN")
					.antMatchers("/secure/personne","/secure/personne/**").authenticated()	
			.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/secure/home")
				.failureUrl("/login?error")
			.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/public");
		// @formatter:on
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
		}

	}

	@Configuration
	@Order(1)
	public class RestControllerSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//@// @formatter:off		
				//activation des restcontroller
				http
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
					.csrf()
						.ignoringAntMatchers("/api/**")	
					.and()
					.antMatcher("/api/**")
						.authorizeRequests()
							.antMatchers(HttpMethod.OPTIONS).anonymous()
							.antMatchers("/api/**").authenticated()
					.and()
					.httpBasic();
				// @formatter:on
		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/api/inscription", "/api/inscription/**");
		}

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
