package com.farawaybr.gatewayapi.jaxrs.client;

import java.util.Map;

public interface RestClient {

	<T> T get(String url, Class<T> responseType, Map<String, Object> queryParams, Map<String, Object> pathParams,
			String media,Map<String, Object> headers);

	<T, E> T post(String url, Class<T> responseType, Map<String, Object> queryParams, Map<String, Object> pathParams,
			E requestBody, String mediaType,Map<String, Object> headers);
}
