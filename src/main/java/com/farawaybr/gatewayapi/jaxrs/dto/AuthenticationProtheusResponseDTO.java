package com.farawaybr.gatewayapi.jaxrs.dto;

import com.farawaybr.gatewayapi.domain.AccessToken;

import jakarta.json.bind.annotation.JsonbProperty;

public class AuthenticationProtheusResponseDTO extends ProtheusResponse {

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

	public AuthenticationProtheusResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationProtheusResponseDTO(String accessToken, String refreshToken, String scope, String tokenType,
			int expiresIn) {
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

	public AccessToken toAccessToken() {
		// TODO Auto-generated method stub
		return new AccessToken(accessToken, refreshToken, scope, tokenType, expiresIn);
	}

	public static AuthenticationProtheusResponseDTO fromAccessTokeb(AccessToken accessToken) {
		// TODO Auto-generated method stub
		return new AuthenticationProtheusResponseDTO(accessToken.getAccessToken(), accessToken.getRefreshToken(),
				accessToken.getScope(), accessToken.getTokenType(), accessToken.getExpiresIn());
	}

}
