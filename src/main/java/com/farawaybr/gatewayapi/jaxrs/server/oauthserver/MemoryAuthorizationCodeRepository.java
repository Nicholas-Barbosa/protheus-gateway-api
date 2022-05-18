package com.farawaybr.gatewayapi.jaxrs.server.oauthserver;

import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.farawaybr.gatewayapi.domain.AuthorizationCode;

import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;

@Singleton
public class MemoryAuthorizationCodeRepository implements AuthorizationCodeRepository {

	private final Map<UUID, AuthorizationCode> authorizationCodes = new ConcurrentHashMap<>();

	@Override
	public Optional<AuthorizationCode> getToken(UUID authorizationCode) {
		// TODO Auto-generated method stub
		Optional<AuthorizationCode> ofNullable = Optional.ofNullable(authorizationCodes.get(authorizationCode));
		ofNullable.ifPresent(ac -> this.authorizationCodes.remove(ac.getCode()));
		return ofNullable;
	}

	@Override
	public void save(AuthorizationCode code) {
		authorizationCodes.put(code.getCode(), code);
	}

	@Schedule(minute = "*/2", hour = "*")
	private void removeExpiredCodes() {
		if (!authorizationCodes.isEmpty()) {
			authorizationCodes.values().parallelStream()
					.filter(ac -> ac.getExpiresAt().toLocalTime().isBefore(LocalTime.now())).forEach(this::removeCode);
		}
	}

	private void removeCode(AuthorizationCode authorizationCode) {
		System.out.println("removendo codigo " + authorizationCode.getCode());
		this.authorizationCodes.remove(authorizationCode.getCode());
	}
}
