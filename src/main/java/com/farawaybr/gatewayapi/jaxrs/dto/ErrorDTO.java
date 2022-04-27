package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"status","cause"})
public class ErrorDTO {

	private String environment, cause;
	private int status;

	public ErrorDTO(String environment, String cause, int status) {
		super();
		this.environment = environment;
		this.cause = cause;
		this.status = status;
	}

	public String getEnvironment() {
		return environment;
	}

	public int getStatus() {
		return status;
	}

	public String getCause() {
		return cause;
	}
}
