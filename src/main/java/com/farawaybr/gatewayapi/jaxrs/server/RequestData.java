package com.farawaybr.gatewayapi.jaxrs.server;

import com.farawaybr.gatewayapi.ProtheusEnvironment;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestData {

	private ProtheusEnvironment environment;
	private long initialRequestTime, latency;
	private String remoteAddr, token;

	public ProtheusEnvironment getEnvironment() {
		return environment;
	}

	public void setEnvironment(ProtheusEnvironment environment) {
		this.environment = environment;
	}

	public long getInitialRequestTime() {
		return initialRequestTime;
	}

	public void setInitialRequestTime(long initialRequestTime) {
		this.initialRequestTime = initialRequestTime;
	}

	public long getLatency() {
		latency = latency == 0 ? initialRequestTime != 0 ? System.currentTimeMillis() - initialRequestTime : 0
				: latency;
		return latency;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
