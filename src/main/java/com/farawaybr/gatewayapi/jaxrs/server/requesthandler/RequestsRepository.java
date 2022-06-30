package com.farawaybr.gatewayapi.jaxrs.server.requesthandler;

import java.util.List;

import com.farawaybr.gatewayapi.jaxrs.dto.Request;

import jakarta.enterprise.event.ObservesAsync;

public interface RequestsRepository {

	void onRequest(@ObservesAsync RequestEvent event);
	
	List<Request>findAll();
}
