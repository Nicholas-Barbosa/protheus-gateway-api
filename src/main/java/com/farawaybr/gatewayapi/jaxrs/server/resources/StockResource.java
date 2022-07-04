package com.farawaybr.gatewayapi.jaxrs.server.resources;

import java.util.List;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.service.ProductService;
import com.farawaybr.gatewayapi.service.ProtheusApiUrlResolver;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("stock")
@RequestScoped
public class StockResource {

	@Inject
	private ProtheusApiUrlResolver urlResolver;

	@Inject
	private ProductService productService;

	@GET
	@Produces("application/json")
	public Response findStock(@QueryParam("environment") String environment, @HeaderParam("Authorization") String token,
			@QueryParam("products") List<String> products) {
		return Response.ok().entity(productService.findStock(products,
				ProtheusEnvironment.valueOf(environment.toUpperCase()), token)).build();

	}
}
