package com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.inject.Inject;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.ProcessingException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ProcessingExceptionMapper implements ExceptionMapper<ProcessingException> {

	@Inject
	private JsonbExceptionMapper jsonbExceptionMapper;

	@Inject
	private RequestData requestData;

	@Override
	public Response toResponse(ProcessingException exception) {
		if (exception.getCause() instanceof JsonbException)
			return jsonbExceptionMapper.toResponse((JsonbException) exception.getCause());
		return Response.status(500)
				.entity(new ErrorDTO(requestData.getEnvironment().name(), "Internal error: " + exception, 500)).build();
	}

}
