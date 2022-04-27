package com.farawaybr.gatewayapi.jaxrs.dto;

import java.io.Serializable;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotBlank;

public class RefreshTokenRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "refresh token cannot be null or blank!")
	private String refreshToken;
	
	public String getRefreshToken() {
		return refreshToken;
	}
	@JsonbProperty("refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
