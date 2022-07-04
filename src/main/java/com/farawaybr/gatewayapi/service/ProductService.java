package com.farawaybr.gatewayapi.service;

import java.util.List;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockProtheusWrapperResponseDTO;

public interface ProductService {

	ProductStockProtheusWrapperResponseDTO findStock(List<String> products, ProtheusEnvironment enviroment,
			String token);

}
