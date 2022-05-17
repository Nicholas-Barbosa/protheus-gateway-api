package com.farawaybr.gatewayapi.jaxrs.server.oauthserver;

import java.io.IOException;
import java.net.URL;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthorizationCodeHandler {

	
	void authenticate(HttpServletRequest req, HttpServletResponse resp);

	default boolean canIHandle(HttpServletRequest req) {
		String stOrigin = req.getHeader("Origin");
		if (stOrigin != null) {
			try {
				URL server = new URL("http://" + req.getServerName());
				URL origin = new URL(stOrigin);
				if (origin.getHost().equals(server.getHost())) {
					return true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	
}
