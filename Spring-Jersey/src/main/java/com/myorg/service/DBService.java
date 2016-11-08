package com.myorg.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/db")
public class DBService {

	@GET
	@Path("")
	public String getAllAdmins(){
		return "all DBA";
	}
}
