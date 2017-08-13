package br.com.webapp.validacampo.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.webapp.validacampo.service.Service;

@Component
@ApplicationPath("rs")
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(Service.class);
	}

}
