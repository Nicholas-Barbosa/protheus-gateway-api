package com.farawaybr.gatewayapi.jaxrs.client.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProtheusErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.ForbiddenException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientResponseContext;
import jakarta.ws.rs.client.ClientResponseFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(0)
public class HttpStatusHandler implements ClientResponseFilter {

	@Inject
	private RequestData requestData;

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
//		String environment = (String) requestContext.getHeaders().get("environment").get(0);
		String environment = requestData.getEnvironment() != null ? requestData.getEnvironment().name() : null;
		switch (responseContext.getStatus()) {
		case 404:
			String responseTxt = readResponse(responseContext.getEntityStream());
			Response responseNotFound = Response.status(404).entity(new ProtheusErrorDTO(environment, responseTxt, 404))
					.build();
			throw new NotFoundException(responseNotFound);
		case 500:
			throw new InternalServerErrorException(Response.status(500)
					.entity(new ProtheusErrorDTO(environment, readResponse(responseContext.getEntityStream()), 500))
					.build());
		case 403:
			throw new ForbiddenException();
		case 401:
			throw new NotAuthorizedException(Response.status(401)
					.entity(new ErrorDTO(environment, readResponse(responseContext.getEntityStream()), 401)).build());
		case 409:
			Response response = Response.status(409)
					.entity(new ProtheusErrorDTO(environment, readResponse(responseContext.getEntityStream()), 409))
					.build();
			throw new ClientErrorException(response);
		case 400:
			throw new BadRequestException(Response.status(400)
					.entity(new ProtheusErrorDTO(environment, readResponse(responseContext.getEntityStream()), 400))
					.build());
		case -1:
			throw new IllegalResponseStatusException();

		}

	}

	private String readResponse(final InputStream input) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
			StringBuilder response = new StringBuilder();
			String currentLine = null;
			while ((currentLine = reader.readLine()) != null)
				response.append(currentLine);
			return response.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
