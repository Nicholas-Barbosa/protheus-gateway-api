package com.farawaybr.gatewayapi.service;

import java.util.Map;

import com.farawaybr.gatewayapi.jaxrs.client.RestClient;
import com.farawaybr.gatewayapi.jaxrs.dto.BillsToPayPage;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BillServiceImpl implements BillService {

	@Inject
	private RestClient restClient;

	@Inject
	private AuthorizationHeaderAssembler authHeader;

	@Override
	public BillsToPayPage findBillsToPayByCustomer(String customerName, int page, int pageSize) {
		// TODO Auto-generated method stub
		return restClient.get("/titles/{customerName}", BillsToPayPage.class,
				Map.of("page", page, "pageSize", pageSize), Map.of("customerName", customerName), "application/json",
				authHeader.assemble());
	}

	@Override
	public BillsToPayPage findBillsToPay(int page, int pageSize) {
		// TODO Auto-generated method stub
		return restClient.get("/titles", BillsToPayPage.class,
				Map.of("page", page, "pageSize", pageSize), null, "application/json", authHeader.assemble());
	}

}
