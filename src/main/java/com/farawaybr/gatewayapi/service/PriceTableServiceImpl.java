package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.jaxrs.client.RestClient;
import com.farawaybr.gatewayapi.jaxrs.dto.PriceTable;
import com.farawaybr.gatewayapi.jaxrs.dto.PriceTableWrapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PriceTableServiceImpl implements PriceTableService {
	@Inject
	private RestClient restClient;

	@Inject
	private AuthorizationHeaderAssembler authHeader;

	@Override
	public PriceTable[] findAll() {
		// TODO Auto-generated method stub
		return  restClient.get("/tables", PriceTableWrapper.class, null, null, "application/json", authHeader.assemble()).getPriceTable();
	}

}
