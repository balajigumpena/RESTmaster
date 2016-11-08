package com.myorg.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Service {

	@Value("${message:Balaji}")
	private String msg;

	public String message() {
		return this.msg;
	}

}
