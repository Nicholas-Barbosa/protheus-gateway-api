package com.farawaybr.gatewayapi.jaxrs.server.provider;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.dto.InvalidEnvironmentError;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(0)
public class EnvironmentContainerRequestFilter implements ContainerRequestFilter {

	@Inject
	private RequestData requestData;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getMatchedURIs().stream().anyMatch(uri -> uri.equalsIgnoreCase("token/code")))
			return;

		List<String> environments = requestContext.getUriInfo().getQueryParameters().get("environment");
		String environment = environments == null ? null : environments.get(0);

		if (environment == null || !Arrays.stream(ProtheusEnvironment.values())
				.anyMatch(en -> en.toString().equalsIgnoreCase(environment))) {
			requestContext.abortWith(Response.status(Status.BAD_REQUEST).entity(InvalidEnvironmentError.build())
					.type(MediaType.APPLICATION_JSON).build());
			return;
		}
		requestData.setEnvironment(ProtheusEnvironment.valueOf(environment.strip().toUpperCase()));
		requestData.setInitialRequestTime(System.currentTimeMillis());
	}

}
