package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class ProtheusErrorDTO {

	private String environment, protheusRawMessage;
	private int status;

	public ProtheusErrorDTO(String environment, String protheusRawMessage, int status) {
		super();
		this.environment = environment;
		this.protheusRawMessage = protheusRawMessage;
		this.status = status;
	}

	public String getEnvironment() {
		return environment;
	}

	@JsonbProperty("protheus_root_cause")
	public String getProtheusRawMessage() {
		return protheusRawMessage;
	}

	public int getStatus() {
		return status;
	}

}
