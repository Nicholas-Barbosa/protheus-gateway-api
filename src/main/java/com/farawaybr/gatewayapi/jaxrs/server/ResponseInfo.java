package com.farawaybr.gatewayapi.jaxrs.server;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ResponseInfo {

	private boolean isProtheusResponse;

	public boolean isProtheusResponse() {
		return isProtheusResponse;
	}

	public void setProtheusResponse(boolean isProtheusResponse) {
		this.isProtheusResponse = isProtheusResponse;
	}
}
