package com.farawaybr.gatewayapi.service;

import java.util.Map;

import com.farawaybr.gatewayapi.jaxrs.client.RestClient;
import com.farawaybr.gatewayapi.jaxrs.dto.WrapperRepresentativeDataDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.WrapperRepresentativeDataDTO.RepresentativeDataDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.HttpHeaders;

@ApplicationScoped
public class RepresentativeServiceImpl implements RepresentativeService {

	@Inject
	private RestClient restClient;

	@Inject
	private ProtheusApiUrlResolver urlResolver;

	@Inject
	private RequestData requestData;

	@Override
	public RepresentativeDataDTO getData() {
		// TODO Auto-generated method stub
		return restClient.get("/representative", WrapperRepresentativeDataDTO.class, null, null, "application/json",
				Map.of(HttpHeaders.AUTHORIZATION, requestData.getToken())).getDataarr()[0];
	}

}
