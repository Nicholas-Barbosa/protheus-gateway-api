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
	public BillsToPayPage findBillsToPay(String customerName, String customerStore, int page, int pageSize) {
		// TODO Auto-generated method stub
		String endpoint = "/titles";
		Map<String, Object> pathParams = null;
		if (customerName != null && customerStore != null) {
			endpoint = "/titles/{customerName}/loja/{store}";
			pathParams = Map.of("customerName", customerName, "store", customerStore);
		}
		return restClient.get(endpoint, BillsToPayPage.class, Map.of("page", page, "pageSize", pageSize), pathParams,
				"application/json", authHeader.assemble());
	}

}
