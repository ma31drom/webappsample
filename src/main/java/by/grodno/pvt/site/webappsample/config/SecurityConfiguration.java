package by.grodno.pvt.site.webappsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
		.authorizeRequests()
			.antMatchers("/", "/home", "/register", "/register/**","/register/**", "/test/**", "/webjars/**", "/webjars/**","/swagger-resources/**","/activate/**", "/swagger-ui.html", "/v2/api-docs")
			.permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/users")
			.and()
		.logout()
			.permitAll();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder noop() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
