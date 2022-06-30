package com.farawaybr.gatewayapi.service;

import java.util.List;
import java.util.stream.Collectors;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.client.RestClient;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockProtheusWrapperResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockRequestDTO;
import com.farawaybr.gatewayapi.jaxrs.server.ResponseInfo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

	@Inject
	private RestClient client;

	@Inject
	private ProtheusApiUrlResolver urlResolver;

	@Inject
	private AuthorizationHeaderAssembler authHeaderAssember;


	@Override
	public ProductStockProtheusWrapperResponseDTO findStock(List<String> products, ProtheusEnvironment enviroment,
			String token) {
		// TODO Auto-generated method stub
		switch (products.size()) {
		case 0:
			return client.get("/stocksg",
					ProductStockProtheusWrapperResponseDTO.class, null, null, MediaType.APPLICATION_JSON,
					authHeaderAssember.assemble());

		default:
			return client.post("/stocksg",
					ProductStockProtheusWrapperResponseDTO.class, null, null,
					products.stream().map(ProductStockRequestDTO::toDto).collect(Collectors.toSet()),
					MediaType.APPLICATION_JSON, authHeaderAssember.assemble());
		}

	}

}
