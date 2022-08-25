package com.farawaybr.gatewayapi.jaxrs.dto;

import java.io.Serializable;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotBlank;

public class ProductStockRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "product attribute cannot be null or blank!")
	public String product;

	public ProductStockRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductStockRequestDTO(String product2) {
		this.product = product2;
	}

	public String getProduct() {
		return product;
	}

	@JsonbProperty("product")
	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductStcokDTO [product=" + product + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductStockRequestDTO other = (ProductStockRequestDTO) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	public static ProductStockRequestDTO toDto(String product) {
		return new ProductStockRequestDTO(product);
	}
}
