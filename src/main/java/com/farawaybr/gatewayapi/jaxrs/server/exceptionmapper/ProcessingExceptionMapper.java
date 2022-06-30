package com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper;

import java.net.ConnectException;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.jaxrs.server.ResponseInfo;

import jakarta.inject.Inject;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.ProcessingException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ProcessingExceptionMapper implements ExceptionMapper<ProcessingException> {

	@Context
	private JsonbExceptionMapper jsonbExceptionMapper;

	@Inject
	private RequestData requestData;

	@Inject
	private ResponseInfo responseInfo;

	@Override
	public Response toResponse(ProcessingException exception) {
		if (exception.getCause() instanceof JsonbException)
			return jsonbExceptionMapper.toResponse((JsonbException) exception.getCause());
		if (exception.getCause() instanceof ClientErrorException) {
			responseInfo.setProtheusResponse(true);
			return ((ClientErrorException) exception.getCause()).getResponse();
		}

		if (exception.getCause() instanceof ConnectException)
			return Response.status(504).entity(new ErrorDTO(requestData.getEnvironment().name(),
					"Connection timed out: connect.  Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).",
					504)).build();

		exception.printStackTrace();
		return Response.status(500)
				.entity(new ErrorDTO(requestData.getEnvironment().name(), "Caused by: " + exception.getCause(), 500))
				.build();
	}
}
