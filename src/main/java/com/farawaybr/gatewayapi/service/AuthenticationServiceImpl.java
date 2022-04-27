package com.farawaybr.gatewayapi.service;

import java.util.Map;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.client.RestClient;
import com.farawaybr.gatewayapi.jaxrs.dto.AuthenticationProtheusResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.AuthenticationRequestDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.RefreshTokenRequestDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class AuthenticationServiceImpl implements AuthenticationService {

	@Inject
	private RestClient restClient;

	@Inject
	private ProtheusApiUrlResolver urlResolver;

	@Override
	public AuthenticationProtheusResponseDTO authenticate(AuthenticationRequestDTO request,
			ProtheusEnvironment enviroment) {
		String tokenEndpoint = urlResolver.resolveUrl(enviroment) + "/api/oauth2/v1/token";
		Map<String, Object> queryParams = Map.of("grant_type", "password", "username", request.getUsername(),
				"password", request.getPassword());
		request = null;
		return restClient.post(tokenEndpoint, AuthenticationProtheusResponseDTO.class, queryParams, null, null,
				MediaType.APPLICATION_JSON, null);
	}

	@Override
	public AuthenticationProtheusResponseDTO refresh(RefreshTokenRequestDTO request, ProtheusEnvironment environment) {
		// TODO Auto-generated method stub
		String tokenEndpoint = urlResolver.resolveUrl(environment) + "/api/oauth2/v1/token";
		Map<String, Object> queryParams = Map.of("grant_type", "refresh_token","refresh_token",request.getRefreshToken());
		return restClient.post(tokenEndpoint, AuthenticationProtheusResponseDTO.class, queryParams, null, null,
				MediaType.APPLICATION_JSON, null);
	}

}
