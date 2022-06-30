package com.farawaybr.gatewayapi.service;

import java.util.HashMap;
import java.util.Map;

import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.HttpHeaders;

@ApplicationScoped
public class AuthorizationHeaderAssembler {

	@Inject
	private RequestData requestData;

	public Map<String, Object> assemble() {
		return new HashMap<String, Object>(
				Map.of(HttpHeaders.AUTHORIZATION, requestData.getToken()));
	}
}
