package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.PropertiesResolver;
import com.farawaybr.gatewayapi.ProtheusEnvironment;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProtheusApiUrlResolver {

	@Inject
	private PropertiesResolver propertiesResolver;
	private final String configProtheusUrlTestKey = "protheus_test_env_url";
	private final String configProtheusUrlProdKey = "protheus_production_env_url";

	public String resolveUrl(ProtheusEnvironment ambiente) {
		if (propertiesResolver.getProfile().equals("prod") && ambiente == ProtheusEnvironment.CDG) {
			return propertiesResolver.getProperty(configProtheusUrlProdKey, "9990");
		}
		String baseUrl = propertiesResolver.getProperty(
				propertiesResolver.getProfile().equals("test") ? configProtheusUrlTestKey : configProtheusUrlProdKey,
				ambiente.getPort() + "");
		return baseUrl;
	}
}
