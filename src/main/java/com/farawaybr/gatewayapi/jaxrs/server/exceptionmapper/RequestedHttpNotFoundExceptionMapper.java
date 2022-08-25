package com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper;

import com.farawaybr.gatewayapi.jaxrs.dto.ResourceNotFoundDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RequestedHttpNotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Inject
	private RequestData requestData;

	@Override
	public Response toResponse(NotFoundException exception) {
		return Response.status(404).entity(new ResourceNotFoundDTO(requestData.getPath()))
				.type(MediaType.APPLICATION_JSON).build();
	}

}
