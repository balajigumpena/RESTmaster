package com.myorg.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
public class RequestFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String path = requestContext.getUriInfo().getPath();
		System.out.println(path);
		if(path.equals("test")){
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
	                .entity("You are not authorised to access this page")
	                .build());
		}
		
		/*requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                .entity(ErrorConstants.ERR_AUTHENTICATION_FAILED)
                .build());*/
		
	}

}
