package com.farawaybr.gatewayapi.jaxrs.server.provider;

import java.io.IOException;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.dto.GatewayResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.SuperProtheusResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GatewayResponseContainerResponseFilter implements ContainerResponseFilter {

	@Inject
	private RequestData requestData;

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		// TODO Auto-generated method stub
		Object objectEntity = responseContext.getEntity();
		if (objectEntity instanceof SuperProtheusResponseDTO) {
			SuperProtheusResponseDTO protheusResponse = (SuperProtheusResponseDTO) objectEntity;
			ProtheusEnvironment pEnvironment = requestData.getEnvironment();
			responseContext.setEntity(GatewayResponseDTO.build(pEnvironment != null ? pEnvironment.name() : null,
					requestData.getLatency(), protheusResponse));
			protheusResponse = null;
			objectEntity = null;
		}
	}

}
