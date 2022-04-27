package com.farawaybr.gatewayapi.jaxrs.dto;

import java.io.Serializable;
import java.util.Set;

import jakarta.json.bind.annotation.JsonbProperty;

public class ProductStockProtheusWrapperResponseDTO extends SuperProtheusResponseDTO {

	private Set<ProductStockResponseDTO> stock;

	public Set<ProductStockResponseDTO> getStock() {
		return stock;
	}

	@JsonbProperty("stock")
	public void setStock(Set<ProductStockResponseDTO> stock) {
		this.stock = stock;
	}

	public static class ProductStockResponseDTO implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String productErp, line, product, type;
		private int avaliable;

		@JsonbProperty("product_erp")
		public String getProductErp() {
			return productErp;
		}

		@JsonbProperty("product_erp")
		public void setProductErp(String productErp) {
			this.productErp = productErp;
		}

		public String getLine() {
			return line;
		}

		@JsonbProperty("line")
		public void setLine(String line) {
			this.line = line;
		}

		public String getProduct() {
			return product;
		}

		@JsonbProperty("product")
		public void setProduct(String product) {
			this.product = product;
		}

		public String getType() {
			return type;
		}

		@JsonbProperty("product_type")
		public void setType(String type) {
			this.type = type;
		}

		@JsonbProperty("avaliable")
		public int getAvaliable() {
			return avaliable;
		}

		@JsonbProperty("available")
		public void setAvaliable(int avaliable) {
			this.avaliable = avaliable;
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
			ProductStockResponseDTO other = (ProductStockResponseDTO) obj;
			if (product == null) {
				if (other.product != null)
					return false;
			} else if (!product.equals(other.product))
				return false;
			return true;
		}

	}
}
