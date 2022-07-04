package com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper;

import com.farawaybr.gatewayapi.jaxrs.dto.ConstraintViolationError;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Inject
	private RequestData requestData;

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		// TODO Auto-generated method stub
		String[] invalidFields = exception.getConstraintViolations().stream().map(c ->c.getMessage())
				.toArray(s -> new String[s]);
		ConstraintViolationError error = new ConstraintViolationError(requestData.getEnvironment().name(),
				"Constraint violation exception", 400, invalidFields);
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}

}
