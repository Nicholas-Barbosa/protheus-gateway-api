package com.farawaybr.gatewayapi.jaxrs.server.resources;

import com.farawaybr.gatewayapi.service.RepresentativeService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("representatives")
@RequestScoped
public class RepresentativeResource {

	@Inject
	private RepresentativeService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getData() {
		return Response.ok(service.getData()).build();
	}
}
