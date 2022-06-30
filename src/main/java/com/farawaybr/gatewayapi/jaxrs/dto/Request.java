package com.farawaybr.gatewayapi.jaxrs.dto;

import java.time.LocalDateTime;
import java.util.Locale;

public class Request {

	private final String originIp;
	private final LocalDateTime requestedAt;
	private final Locale locale;

	public Request(String originIp, LocalDateTime requestedAt, Locale locale) {
		super();
		this.originIp = originIp;
		this.requestedAt = requestedAt;
		this.locale = locale;
	}

	public String getOriginIp() {
		return originIp;
	}

	public LocalDateTime getRequestedAt() {
		return requestedAt;
	}

	public Locale getLocale() {
		return locale;
	}

}
