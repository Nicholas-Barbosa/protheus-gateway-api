package com.farawaybr.gatewayapi.service;

import java.util.List;
import java.util.Map;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.client.RestClient;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockProtheusWrapperResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockRequestDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

	@Inject
	private RestClient client;

	@Inject
	private ProtheusApiUrlResolver urlResolver;

	@Override
	public ProductStockProtheusWrapperResponseDTO findStock(List<ProductStockRequestDTO> products,
			ProtheusEnvironment enviroment, String token) {
		// TODO Auto-generated method stub
		return client.post(urlResolver.resolveUrl(enviroment).concat("/stock/search"),
				ProductStockProtheusWrapperResponseDTO.class, null, null, products, MediaType.APPLICATION_JSON,
				Map.of(HttpHeaders.AUTHORIZATION, "Bearer " + token.substring(7)));
	}

}
