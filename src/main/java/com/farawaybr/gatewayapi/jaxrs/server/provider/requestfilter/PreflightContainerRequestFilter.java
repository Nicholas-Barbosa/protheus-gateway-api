package com.farawaybr.gatewayapi.jaxrs.server.provider.requestfilter;

import java.io.IOException;
import java.util.List;

import jakarta.annotation.Priority;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(0)
public class PreflightContainerRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		if (isPreflightRequest(requestContext))
			requestContext.abortWith(getPreflightResponse());
	}

	private boolean isPreflightRequest(ContainerRequestContext requestContext) {
		/*
		 * É uma requisição OPTIONS, que usa três cabeçalhos de solicitação HTTP:
		 * Access-Control-Request-Method, Access-Control-Request-Headers, e o cabeçalho
		 * Origin.
		 */
		return requestContext.getHeaders().keySet()
				.containsAll(List.of("Access-Control-Request-Method", "Access-Control-Request-Headers", "Origin"))
				&& requestContext.getMethod().equals("OPTIONS");

	}

	private Response getPreflightResponse() {
		return Response.status(200).build();
	}
}
