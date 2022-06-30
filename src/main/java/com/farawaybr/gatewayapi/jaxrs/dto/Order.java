package com.farawaybr.gatewayapi.jaxrs.dto;

import java.time.LocalDate;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ "code", "orderCreatedAt", "status", "discount", "customerCode", "customerName", "customerStore",
		"customerShortName", "invoiceNumber", "invoiceSerie", "invoiceKey", "invoiceCreatedAt" })
public class Order {

	private String code;
	private String status;
	private float discount;
	@JsonbProperty("client_code")
	private String customerCode;
	@JsonbProperty("store")
	private String customerStore;
	@JsonbProperty("cliente_name")
	private String customerName;
	@JsonbProperty("client_short_name")
	private String customerShortName;
	@JsonbProperty("creation_date")
	private LocalDate orderCreatedAt;
	@JsonbProperty("invoice_number")
	private String invoiceNumber;
	@JsonbProperty("invoice_series")
	private String invoiceSerie;
	@JsonbProperty("issuance_date")
	private LocalDate invoiceCreatedAt;
	@JsonbProperty("invoice_key")
	private String invoiceKey;

	public String getCode() {
		return code;
	}

	@JsonbProperty("order_code")
	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerStore() {
		return customerStore;
	}

	public void setCustomerStore(String customerStore) {
		this.customerStore = customerStore;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerShortName() {
		return customerShortName;
	}

	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	}

	@JsonbProperty("order_created_at")
	public LocalDate getOrderCreatedAt() {
		return orderCreatedAt;
	}

	public void setOrderCreatedAt(String orderCreatedAt) {
		this.orderCreatedAt = LocalDate.parse(orderCreatedAt.substring(0, orderCreatedAt.lastIndexOf("T")));
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceSerie() {
		return invoiceSerie;
	}

	public void setInvoiceSerie(String invoiceSerie) {
		this.invoiceSerie = invoiceSerie;
	}

	@JsonbProperty("invoice_created_at")
	public LocalDate getInvoiceCreatedAt() {
		return invoiceCreatedAt;
	}

	public void setInvoiceCreatedAt(String invoiceCreatedAt) {
		int lastIndexOf = invoiceCreatedAt.lastIndexOf("T!");
		this.invoiceCreatedAt = lastIndexOf == -1 ? null
				: LocalDate.parse(invoiceCreatedAt.substring(0, invoiceCreatedAt.lastIndexOf("T")));
	}

	public String getInvoiceKey() {
		return invoiceKey;
	}

	public void setInvoiceKey(String invoiceKey) {
		this.invoiceKey = invoiceKey;
	}

}
