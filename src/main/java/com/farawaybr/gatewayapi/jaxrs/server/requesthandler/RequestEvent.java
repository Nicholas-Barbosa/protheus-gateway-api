package com.farawaybr.gatewayapi.jaxrs.server.requesthandler;

import java.time.LocalDateTime;
import java.util.Locale;

public final class RequestEvent {

	private final LocalDateTime requestAt;
	private final String originIp;
	private final Locale locale;

	public RequestEvent(LocalDateTime requestAt, String originIp, Locale locale) {
		super();
		this.requestAt = requestAt;
		this.originIp = originIp;
		this.locale = locale;
	}

	public LocalDateTime getRequestAt() {
		return requestAt;
	}

	public String getOriginIp() {
		return originIp;
	}

	public Locale getLocale() {
		return locale;
	}

	public static RequestEvent of(String originIp, Locale locale) {
		return new RequestEvent(LocalDateTime.now(), originIp, locale);
	}
}
