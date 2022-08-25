package com.farawaybr.gatewayapi.jaxrs.server.resources;

import com.farawaybr.gatewayapi.service.DanfeService;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("danfes")
public class DanfeResource {

	@Inject
	private DanfeService service;

	@GET
	@Produces("application/json")
	@Path("{number}/serie/{serie}")
	public Response getDanfe(@NotBlank @PathParam("number") String invoiceNumber, @PathParam("serie") int serie) {
		return Response.ok(service.find(invoiceNumber, serie)).build();
	}

	@GET
	@Produces("application/json")
	@Path("st/{number}/serie/{serie}")
	public Response getDanfeST(@NotBlank @PathParam("number") String invoiceNumber, @PathParam("serie") int serie) {
		return Response.ok(service.findST(invoiceNumber, serie)).build();
	}

}
