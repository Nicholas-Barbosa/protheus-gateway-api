package com.farawaybr.gatewayapi.jaxrs.server.provider.requestfilter;

import java.io.IOException;

import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(3)
@PreMatching
public class RequestDataBootstrapperContainerRequestFilter implements ContainerRequestFilter {

	@Inject
	private RequestData requestData;

	@Context
	private HttpServletRequest request;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getMatchedURIs().stream()
				.anyMatch(uri -> uri.equalsIgnoreCase("token/code") || uri.equalsIgnoreCase("request")))
			return;
		requestData.setPath("/" + requestContext.getUriInfo().getPath());
		requestData.setInitialRequestTime(System.currentTimeMillis());
		requestData.setRemoteAddr(request.getRemoteAddr());
		requestData.setToken(requestContext.getHeaderString(HttpHeaders.AUTHORIZATION));
	}

}
