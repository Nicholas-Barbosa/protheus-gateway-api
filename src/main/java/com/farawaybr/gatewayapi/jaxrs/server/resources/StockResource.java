package com.farawaybr.gatewayapi.jaxrs.server.resources;

import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockRequestDTO;
import com.farawaybr.gatewayapi.service.ProductService;
import com.farawaybr.gatewayapi.service.ProtheusApiUrlResolver;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotEmpty;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
	public Response findStock(@DefaultValue("1") @QueryParam("page") int page,
			@DefaultValue("10") @QueryParam("pageSize") int pageSize, @QueryParam("products") String... products) {
		return Response.ok().entity(productService.findStock(page, pageSize, products)).build();

	}

	@GET
	@Path("/simplified")
	@Produces("application/json")
	public Response findStockSimplified() {
		return Response.ok().entity(productService.findSimplifiedStock()).build();
	}

	@POST
	@Path("/simplified")
	@Produces("application/json")
	public Response findStockSimplified(@NotEmpty ProductStockRequestDTO[] products) {
		return Response.ok().entity(productService.findSimplifiedStock(products)).build();
	}
}
