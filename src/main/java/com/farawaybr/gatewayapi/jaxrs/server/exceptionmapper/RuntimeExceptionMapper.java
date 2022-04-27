package com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

	@Inject
	private RequestData requestData;

	@Override
	public Response toResponse(RuntimeException exception) {
		// TODO Auto-generated method stub
		return Response.status(500)
				.entity(new ErrorDTO(requestData.getEnvironment().name(), "Internal server error: " + exception, 500))
				.build();
	}

}
