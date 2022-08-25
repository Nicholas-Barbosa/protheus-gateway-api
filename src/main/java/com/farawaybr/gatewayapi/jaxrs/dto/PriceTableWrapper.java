package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class PriceTableWrapper {

	private PriceTable[] priceTable;

	@JsonbCreator
	public PriceTableWrapper(@JsonbProperty("table") PriceTable[] priceTable) {
		super();
		this.priceTable = priceTable;
	}

	public PriceTable[] getPriceTable() {
		return priceTable;
	}

}
