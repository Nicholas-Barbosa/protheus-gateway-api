package com.farawaybr.gatewayapi.jaxrs.server.oauthserver;

import java.util.Optional;
import java.util.UUID;

import com.farawaybr.gatewayapi.domain.AuthorizationCode;
import com.farawaybr.gatewayapi.jaxrs.dto.AuthenticationProtheusResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.AuthenticationRequestDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.RefreshTokenRequestDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.service.AuthenticationService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("token")
@RequestScoped
public class TokenResource {

	@Inject
	private AuthenticationService service;

	@Inject
	private RequestData requestData;

	@Inject
	private AuthorizationCodeRepository authorizationCodeRepository;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticate(
			@Valid @NotNull(message = "request body cannot be null!") AuthenticationRequestDTO request) {
		try {
			return Response.ok(service.authenticate(request, requestData.getEnvironment())).build();
		} catch (NotAuthorizedException e) {
			return Response.status(404)
					.entity(new ErrorDTO(requestData.getEnvironment().name(), "Username not found!", 404)).build();
		}

	}

	@POST
	@Path("refresh")
	public Response refresh(
			@NotNull(message = "request body object cannot be null!") @Valid RefreshTokenRequestDTO request) {
		return Response.ok(service.refresh(request, requestData.getEnvironment())).build();
	}

	@POST
	@Path("code")
	public Response exchangeCode(@QueryParam("code") UUID code) {
		Optional<AuthorizationCode> authorizationCode = authorizationCodeRepository.getToken(code);
		if (authorizationCode.isPresent()) {
			AuthorizationCode authCode = authorizationCode.get();
			AuthenticationProtheusResponseDTO protheusResponse = AuthenticationProtheusResponseDTO
					.fromAccessTokeb(authCode.getAccessToken());
			return Response.status(201).entity(protheusResponse).build();
		}
		return Response.status(404).build();
	}
}
