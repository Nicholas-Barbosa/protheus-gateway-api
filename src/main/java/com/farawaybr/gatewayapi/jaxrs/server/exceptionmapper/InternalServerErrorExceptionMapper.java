package com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper;

import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.inject.Inject;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class InternalServerErrorExceptionMapper implements ExceptionMapper<InternalServerErrorException> {

	@Inject
	private RequestData requestData;

	@Override
	public Response toResponse(InternalServerErrorException exception) {
		// TODO Auto-generated method stub
		return Response.status(500)
				.entity(exception.getResponse())
				.build();
	}

}
