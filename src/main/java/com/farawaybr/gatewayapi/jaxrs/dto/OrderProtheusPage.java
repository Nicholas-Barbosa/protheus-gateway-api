package com.farawaybr.gatewayapi.jaxrs.dto;

import java.util.List;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class OrderProtheusPage extends ProtheusPage<Order> {

	@JsonbCreator
	public OrderProtheusPage(@JsonbProperty("order") List<Order> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

}
