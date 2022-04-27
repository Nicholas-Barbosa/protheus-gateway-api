package com.farawaybr.gatewayapi.jaxrs.client;

import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.client.Invocation.Builder;

@ApplicationScoped
public class RestClientImpl implements RestClient {

	@Inject
	private JaxrsClientSource client;

	@Override
	public <T> T get(String url, Class<T> responseType, Map<String, Object> queryParams, Map<String, Object> pathParams,
			String media, Map<String, Object> headers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, E> T post(String url, Class<T> responseType, Map<String, Object> queryParams,
			Map<String, Object> pathParams, E requestBody, String mediaType, Map<String, Object> headers) {
		WebTarget target = client.getClient().target(url);

		if (queryParams != null)
			for (String key : queryParams.keySet())
				target = target.queryParam(key, queryParams.get(key));

		if (pathParams != null)
			target = target.resolveTemplates(pathParams);
		Builder request = target.request(mediaType);
		if (headers != null)
			headers.forEach((k, v) -> request.header(k, v));
		return request.post(Entity.json(requestBody), responseType);
	}

}
