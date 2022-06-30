package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class ItemDTO {

	@JsonbProperty("commercial_code")
	private String commercialCode;
	@JsonbProperty("quantity")
	private int quantity;

	public String getCommercialCode() {
		return commercialCode;
	}

	public void setCommercialCode(String commercialCode) {
		this.commercialCode = commercialCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ItemDTO [commercialCode=" + commercialCode + ", quantity=" + quantity + "]";
	}

}
