package com.farawaybr.gatewayapi.jaxrs.dto;

import java.util.List;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class BillsToPayPage extends ProtheusPage<BillToPayProtheusResponseDTO> {

	@JsonbCreator
	public BillsToPayPage(@JsonbProperty("titles") List<BillToPayProtheusResponseDTO> bills) {
		super(bills);
	}

}
