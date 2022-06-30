package com.farawaybr.gatewayapi.service;

import java.util.Map;

import com.farawaybr.gatewayapi.jaxrs.client.RestClient;
import com.farawaybr.gatewayapi.jaxrs.dto.DanfeDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DanfeServiceImpl implements DanfeService {

	@Inject
	private RestClient restClient;

	@Inject
	private ProtheusApiUrlResolver urlResolver;

	@Inject
	private AuthorizationHeaderAssembler authHeader;

	@Override
	public DanfeDTO find(String invoiceNumber, int invoiceSerie) {
		// TODO Auto-generated method stub
		return restClient.get("/danfe/{invoiceNumber}/series/{invoiceSerie}", DanfeDTO.class, null,
				Map.of("invoiceNumber", invoiceNumber, "invoiceSerie", invoiceSerie), "application/json",
				authHeader.assemble());
	}

	@Override
	public String findST(String invoiceNumber, int invoiceSerie) {
		// TODO Auto-generated method stub
		return restClient.get("/danfe/{invoiceNumber}/series/{invoiceSerie}", String.class, null,
				Map.of("invoiceNumber", invoiceNumber, "invoiceSerie", invoiceSerie), "application/json",
				authHeader.assemble());
	}
}
