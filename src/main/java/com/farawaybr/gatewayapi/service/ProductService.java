package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockPage;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockRequestDTO;

public interface ProductService {

	ProductStockPage findStock(int page, int pageSize, String... products);

	ProductStockPage findSimplifiedStock(ProductStockRequestDTO... products);
}
