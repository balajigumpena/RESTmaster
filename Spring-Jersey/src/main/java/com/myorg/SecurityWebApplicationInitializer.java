package com.myorg;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.myorg.config.WebSecurityConfig;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{

	public SecurityWebApplicationInitializer() {
		//super(WebSecurityConfig.class);
	}
}
