package com.farawaybr.gatewayapi.jaxrs.client;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import com.farawaybr.gatewayapi.jaxrs.client.provider.HttpStatusHandler;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

@Stateless(description = "Jaxrs Client source")
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class JaxrsClientSource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -41223482409279482L;

	private Client client;

	@PostConstruct
	public void init() {
		client = ClientBuilder.newBuilder().register(HttpStatusHandler.class).connectTimeout(10, TimeUnit.SECONDS)
				.readTimeout(50, TimeUnit.SECONDS).build();

	}

	@PreDestroy
	public void destroy() {
		client.close();
	}

	public Client getClient() {
		return client;
	}

}
