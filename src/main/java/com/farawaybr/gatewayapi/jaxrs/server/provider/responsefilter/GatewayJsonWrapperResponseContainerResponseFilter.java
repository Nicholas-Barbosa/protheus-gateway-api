package com.farawaybr.gatewayapi.jaxrs.server.provider.responsefilter;

import java.io.IOException;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.dto.ProtheusGatewayResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProtheusResponse;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.jaxrs.server.ResponseInfo;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(1)
public class GatewayJsonWrapperResponseContainerResponseFilter implements ContainerResponseFilter {

	@Inject
	private RequestData requestData;

	@Inject
	private ResponseInfo responseInfo;

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		// TODO Auto-generated method stub
		Object objectEntity = responseContext.getEntity();
		if (objectEntity != null) {
			if (objectEntity instanceof ProtheusResponse || responseInfo.isProtheusResponse()) {
				ProtheusEnvironment pEnvironment = requestData.getEnvironment();
				responseContext
						.setEntity(new ProtheusGatewayResponseDTO(pEnvironment != null ? pEnvironment.name() : null,
								requestData.getRemoteAddr(), requestData.getLatency(), objectEntity));
			}

			objectEntity = null;
		}
	}

}
