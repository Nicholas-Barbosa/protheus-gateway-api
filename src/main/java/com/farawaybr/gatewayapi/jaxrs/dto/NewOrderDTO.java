package com.farawaybr.gatewayapi.jaxrs.dto;

import java.util.Arrays;

import jakarta.json.bind.annotation.JsonbProperty;

public class NewOrderDTO {

	@JsonbProperty("client_code")
	private String customerCode;
	@JsonbProperty("store")
	private String store;
	@JsonbProperty("client_order")
	private String customerOrder;
	@JsonbProperty("representative_order")
	private String representativeOrder;
	@JsonbProperty("message")
	private String message;
	@JsonbProperty("items")
	private ItemDTO[] items;

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(String customerOrder) {
		this.customerOrder = customerOrder;
	}

	public String getRepresentativeOrder() {
		return representativeOrder;
	}

	public void setRepresentativeOrder(String representativeOrder) {
		this.representativeOrder = representativeOrder;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ItemDTO[] getItems() {
		return items;
	}

	public void setItems(ItemDTO[] items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "NewOrderDTO [customerCode=" + customerCode + ", store=" + store + ", customerOrder=" + customerOrder
				+ ", representativeOrder=" + representativeOrder + ", message=" + message + ", items="
				+ Arrays.toString(items) + "]";
	}

	

}
