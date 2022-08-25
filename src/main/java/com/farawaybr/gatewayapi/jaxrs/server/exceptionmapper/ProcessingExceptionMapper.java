package com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.jaxrs.server.ResponseInfo;

import jakarta.inject.Inject;
import jakarta.json.bind.JsonbException;
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
		System.out.println("processing exception mapper!");
		if (exception.getCause() instanceof JsonbException)
			return jsonbExceptionMapper.toResponse((JsonbException) exception.getCause());

		if (exception.getCause() instanceof ConnectException || exception.getCause() instanceof SocketTimeoutException)
			return Response.status(504)
					.entity(new ErrorDTO(requestData.getEnvironment().name(),
							"Connection failed, cause timeout when connecting or reading to Protheus terget server."
									+ exception.getCause().getMessage(),
							504))
					.build();
		exception.printStackTrace();
		return Response.status(500)
				.entity(new ErrorDTO(requestData.getEnvironment().name(), "Caused by: " + exception.getCause(), 500))
				.build();
	}
}
