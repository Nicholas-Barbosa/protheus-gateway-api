package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.jaxrs.dto.PriceTable;

public interface PriceTableService {

	PriceTable[] findAll();
}
