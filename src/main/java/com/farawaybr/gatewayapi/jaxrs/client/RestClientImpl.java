package com.farawaybr.gatewayapi.jaxrs.client;

import java.util.Map;

import com.farawaybr.gatewayapi.jaxrs.client.JaxrsRequestData.JaxrsRequestDataBuilder;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RestClientImpl implements RestClient {

	@Inject
	private JaxrsClientRequester requester;

	@Override
	public <T> T get(String url, Class<T> responseType, Map<String, Object> queryParams, Map<String, Object> pathParams,
			String mediaType, Map<String, Object> headers) {
		// TODO Auto-generated method stub
		return requester.request(JaxrsRequestDataBuilder.getInstance().url(url).queryParams(queryParams)
				.pathParams(pathParams).method("GET").mediaType(mediaType).headers(headers).build(), responseType);

	}

	@Override
	public <T, E> T post(String url, Class<T> responseType, Map<String, Object> queryParams,
			Map<String, Object> pathParams, E requestBody, String mediaType, Map<String, Object> headers) {
		return requester.request(
				JaxrsRequestDataBuilder.getInstance().url(url).requestBody(requestBody).queryParams(queryParams)
						.pathParams(pathParams).method("POST").mediaType(mediaType).headers(headers).build(),
				responseType);
	}

}
