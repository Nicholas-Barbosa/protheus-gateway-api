package com.farawaybr.gatewayapi.jaxrs.server.provider.requestfilter;

import java.io.IOException;
import java.util.List;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.server.oauthserver.TokenResource;
import com.farawaybr.gatewayapi.jaxrs.server.resources.RequestResource;

import jakarta.annotation.Priority;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(1)
public class TokenContainerRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		boolean isTokenRquest = requestContext.getUriInfo().getMatchedResources().stream()
				.anyMatch(resource -> resource instanceof TokenResource || resource instanceof RequestResource);
		List<String> environments = requestContext.getUriInfo().getQueryParameters().get("environment");
		if (requestContext.getHeaderString(HttpHeaders.AUTHORIZATION) == null && !isTokenRquest)
			requestContext.abortWith(Response.status(Status.BAD_REQUEST)
					.entity(new ErrorDTO(environments !=null? environments.get(0) :"Not identified", "Authorization header not present!", 400))
					.type(MediaType.APPLICATION_JSON).build());
	}

}
