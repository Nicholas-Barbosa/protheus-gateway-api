package com.farawaybr.gatewayapi.jaxrs.server.oauthserver;

import java.util.Optional;
import java.util.UUID;

import com.farawaybr.gatewayapi.domain.AuthorizationCode;

public interface AuthorizationCodeRepository {

	Optional<AuthorizationCode> getToken(UUID authorizationCode);
	
	void save(AuthorizationCode code);
}
