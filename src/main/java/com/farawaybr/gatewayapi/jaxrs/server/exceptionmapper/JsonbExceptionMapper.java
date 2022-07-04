package com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProtheusErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.jaxrs.server.ResponseInfo;

import jakarta.inject.Inject;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JsonbExceptionMapper implements ExceptionMapper<JsonbException> {

	@Inject
	private RequestData requestData;

	@Inject
	private ResponseInfo responseInfo;

	@Override
	public Response toResponse(JsonbException exception) {
		// TODO Auto-generated method stub
		if (responseInfo.isProtheusResponse()) {
			exception.printStackTrace();
			return Response.status(500).entity(new ProtheusErrorDTO(requestData.getEnvironment().name(),
					"Error in protheus server to deserialize JSON value into type expected type!", 500)).build();
		}

		return Response.status(400).entity(new ErrorDTO(requestData.getEnvironment().name(),
				"Error deserialize JSON value into type expected type! ", 400)).build();
	}

}
