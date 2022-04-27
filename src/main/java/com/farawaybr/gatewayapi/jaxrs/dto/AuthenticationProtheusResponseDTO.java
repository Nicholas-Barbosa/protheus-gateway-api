package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class AuthenticationProtheusResponseDTO extends SuperProtheusResponseDTO {

	@JsonbProperty("access_token")
	private String accessToken;
	@JsonbProperty("refresh_token")
	private String refreshToken;
	@JsonbProperty("scope")
	private String scope;
	@JsonbProperty("token_type")
	private String tokenType;
	@JsonbProperty("expires_in")
	private int expiresIn;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

}
