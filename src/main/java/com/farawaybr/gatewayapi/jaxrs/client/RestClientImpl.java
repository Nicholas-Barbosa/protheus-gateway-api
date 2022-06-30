package com.farawaybr.gatewayapi.jaxrs.client;

import java.util.Map;

import com.farawaybr.gatewayapi.jaxrs.client.JaxrsRequestData.JaxrsRequestDataBuilder;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.service.ProtheusApiUrlResolver;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RestClientImpl implements RestClient {

	@Inject
	private JaxrsClientRequester requester;

	@Inject
	private ProtheusApiUrlResolver urlResolver;

	@Inject
	private RequestData requestData;

	@Override
	public <T> T get(String url, Class<T> responseType, Map<String, Object> queryParams, Map<String, Object> pathParams,
			String mediaType, Map<String, Object> headers) {
		// TODO Auto-generated method stub
		return requester.request(
				JaxrsRequestDataBuilder.getInstance()
						.url(urlResolver.resolveUrl(requestData.getEnvironment()).concat(url)).queryParams(queryParams)
						.pathParams(pathParams).method("GET").mediaType(mediaType).headers(headers).build(),
				responseType);

	}

	@Override
	public <T, E> T post(String url, Class<T> responseType, Map<String, Object> queryParams,
			Map<String, Object> pathParams, E requestBody, String mediaType, Map<String, Object> headers) {
		return requester.request(JaxrsRequestDataBuilder.getInstance()
				.url(urlResolver.resolveUrl(requestData.getEnvironment()).concat(url)).requestBody(requestBody)
				.queryParams(queryParams).pathParams(pathParams).method("POST").mediaType(mediaType).headers(headers)
				.build(), responseType);
	}

}
