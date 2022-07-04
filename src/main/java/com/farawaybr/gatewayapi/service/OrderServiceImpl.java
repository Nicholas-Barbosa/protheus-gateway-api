package com.farawaybr.gatewayapi.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.jaxrs.client.RestClient;
import com.farawaybr.gatewayapi.jaxrs.dto.NewOrderDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.OrderProtheusPage;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

	@Inject
	private RestClient restClient;


	@Inject
	private AuthorizationHeaderAssembler authHeader;


	@Override
	public String persist(NewOrderDTO dto, ProtheusEnvironment env) {
		// TODO Auto-generated method stub
		String data = restClient.post("/orders", String.class, null, null, dto,
				"application/json", authHeader.assemble());
		return data;
	}

	@Override
	@OptionalEmpty404NotFoundJoinPointCut
	public OrderProtheusPage find(int page, int pageSize, String searchKey) {
		// TODO Auto-generated method stub

		return restClient.get("/orders",
				OrderProtheusPage.class,
				Stream.of("page=" + page, "pageSize=" + pageSize, "searchKey=" + searchKey).filter(k->!k.contains("null"))
						.collect(Collectors.toMap(k -> k.substring(0, k.lastIndexOf("=")), v -> v.substring(v.lastIndexOf("=")+1))),
				null, "application/json", authHeader.assemble());
	}

}
