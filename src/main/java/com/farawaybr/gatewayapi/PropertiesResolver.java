package com.farawaybr.gatewayapi;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PropertiesResolver {

	private Properties properties;

	private String profile;

	@PostConstruct
	public void init() {
		properties = new Properties();
		loadProperties();
		this.profile = properties.getProperty("profile");
	}

	public String getProperty(String key) {
		String property = properties.getProperty(key);
		if (property != null)
			return property;
		throw new IllegalArgumentException("Key:" + key + " not found in config.properties");
	}

	public String getProperty(String key, Object... params) {
		return MessageFormat.format(this.getProperty(key), params);
	}

	private void loadProperties() {
		try (InputStream inputStream = getClass().getResourceAsStream("/config.properties")) {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProfile() {
		return profile;
	}
}
