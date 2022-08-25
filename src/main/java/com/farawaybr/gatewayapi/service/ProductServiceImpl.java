package com.farawaybr.gatewayapi.service;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import com.farawaybr.gatewayapi.jaxrs.client.RestClient;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockPage;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockRequestDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductsWrapperDTO;

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
	public ProductStockPage findStock(int page, int pageSize, String... products) {
		// TODO Auto-generated method stub
		switch (products.length) {
		case 0:
			return client.get("/stocksg", ProductStockPage.class, Map.of("pageSize", pageSize, "page", page), null,
					MediaType.APPLICATION_JSON, authHeaderAssember.assemble());

		default:
			ProductStockPage post = client.post("/stocksg", ProductStockPage.class, null, null,
					Arrays.stream(products).map(ProductStockRequestDTO::toDto).collect(Collectors.toSet()),
					MediaType.APPLICATION_JSON, authHeaderAssember.assemble());
			return post;
		}

	}

	@Override
	public ProductStockPage findSimplifiedStock(ProductStockRequestDTO... products) {
		// TODO Auto-generated method stub
		switch (products.length) {
		case 0:
			return client.get("/stock", ProductStockPage.class, null, null, MediaType.APPLICATION_JSON,
					authHeaderAssember.assemble());

		default:
			return client.post("/stock", ProductStockPage.class, null, null, products, MediaType.APPLICATION_JSON,
					authHeaderAssember.assemble());
		}

	}

	@Override
	public ProductDTO[] findByCode(String commercialCode) {
		return client.get("/products/{code}", ProductsWrapperDTO.class, null, Map.of("code", commercialCode),
				"application/json", authHeaderAssember.assemble()).getProducts();
	}

}
