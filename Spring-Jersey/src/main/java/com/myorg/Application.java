package com.myorg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true/*,securedEnabled = true*/)
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new Application()
				.configure(new SpringApplicationBuilder(Application.class))
				.run(args);
	}
}
