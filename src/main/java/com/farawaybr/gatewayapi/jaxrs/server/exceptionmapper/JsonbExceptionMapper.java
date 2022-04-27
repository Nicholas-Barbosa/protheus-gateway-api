package com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.inject.Inject;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JsonbExceptionMapper implements ExceptionMapper<JsonbException> {

	@Inject
	private RequestData requestData;

	@Override
	public Response toResponse(JsonbException exception) {
		// TODO Auto-generated method stub
	
		return Response.status(400).entity(new ErrorDTO(requestData.getEnvironment().name(),
				"Error deserialize JSON value into type expected type! See documentation to know about expected type.",
				400)).build();
	}

}
