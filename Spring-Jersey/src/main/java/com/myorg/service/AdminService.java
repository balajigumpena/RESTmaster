package com.myorg.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/admin")
public class AdminService {
	
	@GET
	@Path("")
	public String getAllAdmins(){
		return "allAdmin";
	}
}
