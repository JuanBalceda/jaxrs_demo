package com.balceda.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.balceda.demo.web.TodoResource;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		// packages("com.balceda.demo.web"); // Fails when executing the generated jar file
		register(TodoResource.class);
	}

}
