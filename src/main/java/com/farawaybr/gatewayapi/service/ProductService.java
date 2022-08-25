package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.jaxrs.dto.ProductDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockPage;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockRequestDTO;

public interface ProductService {

	ProductStockPage findStock(int page, int pageSize, String... products);

	ProductDTO[] findByCode(String commercialCode);

	ProductStockPage findSimplifiedStock(ProductStockRequestDTO... products);
}
