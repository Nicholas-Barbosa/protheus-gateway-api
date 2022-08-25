package com.farawaybr.gatewayapi.jaxrs.dto;

import java.time.LocalDateTime;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ "timestamp", "status", "error", "path" })
public class ResourceNotFoundDTO {

	@JsonbProperty("timestamp")
	private LocalDateTime timestamp = LocalDateTime.now();
	@JsonbProperty("status")
	private int status = 404;
	@JsonbProperty("path")
	private String path;
	@JsonbProperty("error")
	private String error = "The requested resource does not exists!";

	public ResourceNotFoundDTO(String path) {
		super();
		this.path = path;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getPath() {
		return path;
	}

	public String getError() {
		return error;
	}
}
