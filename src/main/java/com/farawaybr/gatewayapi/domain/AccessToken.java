package com.farawaybr.gatewayapi.domain;

public class AccessToken {

	private final String accessToken;
	private final String refreshToken;
	private final String scope;
	private final String tokenType;
	private final int expiresIn;


	public AccessToken(String accessToken, String refreshToken, String scope, String tokenType, int expiresIn) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.scope = scope;
		this.tokenType = tokenType;
		this.expiresIn = expiresIn;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public String getScope() {
		return scope;
	}

	public String getTokenType() {
		return tokenType;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

}
