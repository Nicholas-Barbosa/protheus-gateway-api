package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ "code", "commercialCode", "ncm", "type", "descriptionType", "description", "application",
		"webApplication", "webReplace" })
public class ProductDTO {

	private String descriptionType, code, webApplication, commercialCode, type, webReplace, commercialBlock, ncm,
			description, application;

	@JsonbCreator
	public ProductDTO(@JsonbProperty("description_product_type") String descriptionType,
			@JsonbProperty("code") String code, @JsonbProperty("web_application") String webApplication,
			@JsonbProperty("commercial_code") String commercialCode, @JsonbProperty("product_type") String type,
			@JsonbProperty("web_replace") String webReplace, @JsonbProperty("commercial_block") String commercialBlock,
			@JsonbProperty("ncm") String ncm, @JsonbProperty("description") String description,
			@JsonbProperty("application") String application) {
		super();
		this.descriptionType = descriptionType;
		this.code = code;
		this.webApplication = webApplication;
		this.commercialCode = commercialCode;
		this.type = type;
		this.webReplace = webReplace;
		this.commercialBlock = commercialBlock;
		this.ncm = ncm;
		this.description = description;
		this.application = application;
	}

	public String getDescriptionType() {
		return descriptionType;
	}

	public String getCode() {
		return code;
	}

	public String getWebApplication() {
		return webApplication;
	}

	public String getCommercialCode() {
		return commercialCode;
	}

	public String getType() {
		return type;
	}

	public String getWebReplace() {
		return webReplace;
	}

	public String getCommercialBlock() {
		return commercialBlock;
	}

	public String getNcm() {
		return ncm;
	}

	public String getDescription() {
		return description;
	}

	public String getApplication() {
		return application;
	}

}
