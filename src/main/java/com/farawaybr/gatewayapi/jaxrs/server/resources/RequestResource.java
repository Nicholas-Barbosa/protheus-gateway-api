package com.farawaybr.gatewayapi.jaxrs.server.resources;

import com.farawaybr.gatewayapi.jaxrs.server.requesthandler.RequestsRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("requests")
public class RequestResource {

	@Inject
	private RequestsRepository respository;

	@GET
	@Produces("application/json")
	public Response get() {
		return Response.ok(respository.findAll()).build();
	}
}
