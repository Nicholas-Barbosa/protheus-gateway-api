package com.farawaybr.gatewayapi.jaxrs.dto;

import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;

public class OrderProtheusPage extends ProtheusPage<Order> {

	@JsonbProperty("order")
	@Override
	public void setContent(List<Order> content) {
		// TODO Auto-generated method stub
		super.content = content;
	}

}
