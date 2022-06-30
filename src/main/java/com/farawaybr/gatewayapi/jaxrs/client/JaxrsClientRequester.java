package com.farawaybr.gatewayapi.jaxrs.client;

import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class JaxrsClientRequester {

	@Inject
	private JaxrsClientSource clientSource;

	public <T> T request(JaxrsRequestData data, Class<T> responseType) {
		WebTarget target = getTarget(data.getUrl(), data.getQueryParams(), data.getPathParams());
		Builder request = target.request(data.getMediaType());
		resolveHeaders(data.getHeaders(), request);
		final Response response = request.method(data.getMethod(),
				Entity.entity(data.getRequestBody(), data.getMediaType()));
		try (response) {
			data = null;
			return response.readEntity(responseType);
		}

	}

	private WebTarget getTarget(String url, Map<String, Object> queryParams, Map<String, Object> pathParams) {
		WebTarget target = clientSource.getClient().target(url);
		url = null;
		if (queryParams != null)
			for (String key : queryParams.keySet())
				target = target.queryParam(key, queryParams.get(key));

		if (pathParams != null)
			target = target.resolveTemplates(pathParams);
		return target;
	}

	private void resolveHeaders(Map<String, Object> headers, Builder request) {
		if (headers != null)
			headers.forEach((k, v) -> request.header(k, v));
	}
}
