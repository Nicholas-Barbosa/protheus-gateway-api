package com.farawaybr.gatewayapi.jaxrs.dto;

import java.time.ZonedDateTime;

import jakarta.json.bind.annotation.JsonbProperty;

public class InvalidEnvironmentError {

	private String cause = "Invalid environment!";
	private ZonedDateTime responsedAt = ZonedDateTime.now();

	public String getCause() {
		return cause;
	}

	@JsonbProperty("responsed_at")
	public ZonedDateTime getResponsedAt() {
		return responsedAt;
	}

	public static InvalidEnvironmentError build() {
		// TODO Auto-generated method stub
		return new InvalidEnvironmentError();
	}
}
