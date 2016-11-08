package com.myorg.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.myorg.Utils;
import com.myorg.filter.RequestFilter;
import com.myorg.filter.ResponseFilter;


@Component
@ApplicationPath("rest")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(RequestFilter.class);
		packages(Utils.SERVICE_PACKAGE);
		register(ResponseFilter.class);
	}

}
