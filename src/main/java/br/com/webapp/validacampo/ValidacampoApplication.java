package br.com.webapp.validacampo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.interfaces.Check;

@SpringBootApplication
public class ValidacampoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidacampoApplication.class, args);
	}
	
	@Bean
	@RequestScope
	public Check validator() {
		return new SafeguardCheck();
	}
		
	
}
