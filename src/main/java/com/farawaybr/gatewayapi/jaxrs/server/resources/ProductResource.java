package com.farawaybr.gatewayapi.jaxrs.server.resources;

import com.farawaybr.gatewayapi.service.ProductService;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("products")
public class ProductResource {

	@Inject
	private ProductService service;

	@GET
	@Path("{code}")
	@Produces("application/json")
	public Response findByCode(@PathParam("code") @NotBlank String code) {
		return Response.status(200).entity(service.findByCode(code)).build();
	}
}
