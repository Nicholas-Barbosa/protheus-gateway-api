package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class ProductsWrapperDTO {

	private ProductDTO[] products;

	@JsonbCreator
	public ProductsWrapperDTO(@JsonbProperty("products") ProductDTO[] products) {
		super();
		this.products = products;
	}

	public ProductDTO[] getProducts() {
		return products;
	}
}
