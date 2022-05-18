package com.farawaybr.gatewayapi.jaxrs.server.provider;

import java.io.IOException;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.jaxrs.server.oauthserver.TokenResource;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(2)
public class TokenContainerRequestFilter implements ContainerRequestFilter {

	@Inject
	private RequestData requestData;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		boolean isTokenRquest = requestContext.getUriInfo().getMatchedResources().stream()
				.anyMatch(resource -> resource instanceof TokenResource);

		if (requestContext.getHeaderString(HttpHeaders.AUTHORIZATION) == null && !isTokenRquest)
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED)
					.entity(new ErrorDTO(requestData.getEnvironment().name(), "Authorization header not present!", 401))
					.type(MediaType.APPLICATION_JSON).build());
	}

}
