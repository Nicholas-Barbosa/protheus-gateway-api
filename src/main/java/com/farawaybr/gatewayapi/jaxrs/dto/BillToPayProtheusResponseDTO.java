package com.farawaybr.gatewayapi.jaxrs.dto;

import java.time.LocalDate;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class BillToPayProtheusResponseDTO extends ProtheusResponse {

	private String customerCode, customerName, situation, docNumber;
	private float sale;
	@JsonbProperty("due_date")
	private LocalDate dueDate;

	@JsonbCreator
	public BillToPayProtheusResponseDTO(@JsonbProperty("client_code") String customerCode,
			@JsonbProperty("client_name") String customerName, @JsonbProperty("situation") String situation,
			@JsonbProperty("doc_number") String docNumber, @JsonbProperty("sale") float sale,
			@JsonbProperty("due_date") String dueDate) {
		super();
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.situation = situation;
		this.sale = sale;
		this.docNumber = docNumber;
		this.dueDate = LocalDate.parse(dueDate.substring(0, dueDate.lastIndexOf("T")));
	}

	@JsonbProperty("customer_code")
	public String getCustomerCode() {
		return customerCode;
	}

	@JsonbProperty("customer_name")
	public String getCustomerName() {
		return customerName;
	}

	@JsonbProperty("situation")
	public String getSituation() {
		return situation;
	}

	@JsonbProperty("doc_number")
	public String getDocNumber() {
		return docNumber;
	}

	@JsonbProperty("sale")
	public float getSale() {
		return sale;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
}
