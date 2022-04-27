package com.farawaybr.gatewayapi.jaxrs.server;

import java.util.List;

import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockRequestDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

//@Path("stock")
public interface StockResource {

//	@POST
	// @Produces("application/json")
	Response findStock(@QueryParam("environment") String environment, @HeaderParam("Authorization") String token,
			@Valid @NotNull(message = "Array cannot be null!") List<ProductStockRequestDTO> products);
}
