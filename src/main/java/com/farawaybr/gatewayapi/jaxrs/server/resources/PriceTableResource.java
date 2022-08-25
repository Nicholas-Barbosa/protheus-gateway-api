package com.farawaybr.gatewayapi.jaxrs.server.resources;

import com.farawaybr.gatewayapi.service.PriceTableService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("price-tables")
public class PriceTableResource {

	@Inject
	private PriceTableService service;

	@GET
	@Path("all")
	public Response findAll() {
		return Response.status(200).entity(service.findAll()).build();
	}
}
