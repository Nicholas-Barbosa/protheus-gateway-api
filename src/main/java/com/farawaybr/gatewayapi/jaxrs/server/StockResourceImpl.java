package com.farawaybr.gatewayapi.jaxrs.server;

import java.util.List;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockProtheusWrapperResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockRequestDTO;
import com.farawaybr.gatewayapi.service.ProductService;
import com.farawaybr.gatewayapi.service.ProtheusApiUrlResolver;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("stock")
@RequestScoped
public class StockResourceImpl {

	@Inject
	private ProtheusApiUrlResolver urlResolver;

	@Inject
	private ProductService productService;

	@POST
	@Produces("application/json")
	public Response findStock(@QueryParam("environment") String environment, @HeaderParam("Authorization") String token,
			@Valid @NotEmpty(message = "Array cannot be empty") @NotNull(message = "Array cannot be null!") List<ProductStockRequestDTO> products) {
		ProductStockProtheusWrapperResponseDTO protheusResponse = productService.findStock(products,
				ProtheusEnvironment.valueOf(environment.toUpperCase()), token);
		return Response.ok().entity(protheusResponse).build();
	}
}