package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"tableCode"})
public class PriceTable {

	private String application, tableCode, descriptionType, ncm, description;
	private float originPrice, unitPrice, stValue, unitGrossValue;

	@JsonbCreator
	public PriceTable(@JsonbProperty("application") String application, @JsonbProperty("table_cod") String tableCode,
			@JsonbProperty("description_product_type") String descriptionType, @JsonbProperty("ncm") String ncm,
			@JsonbProperty("description") String description, @JsonbProperty("origin_price") float originPrice,
			@JsonbProperty("unit_price") float unitPrice, @JsonbProperty("st_value") float stValue,
			@JsonbProperty("unit_gross_value") float unitGrossValue) {
		super();
		this.application = application;
		this.tableCode = tableCode;
		this.descriptionType = descriptionType;
		this.ncm = ncm;
		this.description = description;
		this.originPrice = originPrice;
		this.unitPrice = unitPrice;
		this.stValue = stValue;
		this.unitGrossValue = unitGrossValue;
	}

	public String getApplication() {
		return application;
	}

	@JsonbProperty("table_code")
	public String getTableCode() {
		return tableCode;
	}

	@JsonbProperty("description_type")
	public String getDescriptionType() {
		return descriptionType;
	}

	public String getNcm() {
		return ncm;
	}

	public String getDescription() {
		return description;
	}

	@JsonbProperty("origin_price")
	public float getOriginPrice() {
		return originPrice;
	}

	@JsonbProperty("unit_price")
	public float getUnitPrice() {
		return unitPrice;
	}

	@JsonbProperty("st_value")
	public float getStValue() {
		return stValue;
	}

	@JsonbProperty("unit_gross_value")
	public float getUnitGrossValue() {
		return unitGrossValue;
	}
}
