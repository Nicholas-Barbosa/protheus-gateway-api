package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class ConstraintViolationError extends ErrorDTO {
	
	private String[] fields;

	public ConstraintViolationError(String environment, String cause, int status,String[] fields) {
		super(environment, cause, status);
		// TODO Auto-generated constructor stub
		this.fields = fields;
	}

	@JsonbProperty("validation_errors")
	public String[] getFields() {
		return fields;
	}
}
