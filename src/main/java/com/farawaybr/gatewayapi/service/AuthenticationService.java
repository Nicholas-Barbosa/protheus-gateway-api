package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.dto.AuthenticationProtheusResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.AuthenticationRequestDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.RefreshTokenRequestDTO;

public interface AuthenticationService {

	AuthenticationProtheusResponseDTO authenticate(AuthenticationRequestDTO request, ProtheusEnvironment environment);

	AuthenticationProtheusResponseDTO refresh(RefreshTokenRequestDTO request, ProtheusEnvironment environment);
}
