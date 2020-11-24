package by.grodno.pvt.site.webappsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import by.grodno.pvt.site.webappsample.service.UserRepository;
import by.grodno.pvt.site.webappsample.service.impl.HibernateUserService;
import by.grodno.pvt.site.webappsample.service.utils.SessionProvider;

@Configuration
@ComponentScan(basePackages = "by.grodno.pvt.site.webappsample")
public class ContextConfig {

	@Bean
	@Primary
	public UserRepository hiberUserService(SessionProvider provider) {
		return new HibernateUserService(provider);
	}

}
