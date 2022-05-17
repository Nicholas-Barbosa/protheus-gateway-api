package com.farawaybr.gatewayapi.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class AuthorizationCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8338287531327501263L;
	private final UUID code;
	private final AccessToken accessToken;
	private final LocalDateTime createdAt = LocalDateTime.now();
	private final LocalDateTime expiresAt = createdAt.plusMinutes(2);

	public AuthorizationCode(UUID code, AccessToken accessToken) {
		super();
		this.code = code;
		this.accessToken = accessToken;
	}

	public UUID getCode() {
		return code;
	}

	public AccessToken getAccessToken() {
		return accessToken;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorizationCode other = (AuthorizationCode) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
