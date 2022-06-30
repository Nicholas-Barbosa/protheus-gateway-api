package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.dto.NewOrderDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.OrderProtheusPage;

public interface OrderService {

	String persist(NewOrderDTO dto,ProtheusEnvironment environment);
	
	OrderProtheusPage find(int page,int pageSize,String searchKey);
}
