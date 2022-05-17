package com.farawaybr.gatewayapi.jaxrs.server.oauthserver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface OAuthServer {

	void getAuthorizationCode(HttpServletRequest req, HttpServletResponse resp);
}
