package com.farawaybr.gatewayapi.service;

import java.util.List;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockProtheusWrapperResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockRequestDTO;

public interface ProductService {

	ProductStockProtheusWrapperResponseDTO findStock(List<ProductStockRequestDTO> products,
			ProtheusEnvironment enviroment,String token);

}
