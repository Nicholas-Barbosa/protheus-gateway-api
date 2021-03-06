package com.farawaybr.gatewayapi.jaxrs.dto;

import java.io.Serializable;
import java.util.List;

import com.farawaybr.gatewayapi.jaxrs.dto.ProductStockPage.ProductStockResponseDTO;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class ProductStockPage extends ProtheusPage<ProductStockResponseDTO> {

	@JsonbCreator
	public ProductStockPage(@JsonbProperty("stock") List<ProductStockResponseDTO> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

	@Override
	@JsonbProperty("stock")
	public List<ProductStockResponseDTO> getContent() {
		// TODO Auto-generated method stub
		return super.getContent();
	}

	public static class ProductStockResponseDTO implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String productErp, line, product, type, description;
		private int avaliable;
		private Integer openOrder, multipleCdBar, stockBalance, boxQuantity, amountBurden;

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

		@JsonbProperty("description")
		public String getDescription() {
			return description;
		}

		@JsonbProperty("description")
		public void setDescription(String description) {
			this.description = description;
		}

		@JsonbProperty("avaliable")
		public int getAvaliable() {
			return avaliable;
		}

		@JsonbProperty("available")
		public void setAvaliable(int avaliable) {
			this.avaliable = avaliable;
		}

		@JsonbProperty("open_order")
		public Integer getOpenOrder() {
			return openOrder;
		}

		@JsonbProperty("open_order")
		public void setOpenOrder(int openOrder) {
			this.openOrder = openOrder;
		}

		@JsonbProperty("multiple_cd_bar")
		public Integer getMultipleCdBar() {
			return multipleCdBar;
		}

		@JsonbProperty("multiple_cd_bar")
		public void setMultipleCdBar(int multipleCdBar) {
			this.multipleCdBar = multipleCdBar;
		}

		@JsonbProperty("stock_balance")
		public Integer getStockBalance() {
			return stockBalance;
		}

		@JsonbProperty("stock_balance")
		public void setStockBalance(int stockBalance) {
			this.stockBalance = stockBalance;
		}

		@JsonbProperty("box_quantity")
		public Integer getBoxQuantity() {
			return boxQuantity;
		}

		@JsonbProperty("box_quantity")
		public void setBoxQuantity(int boxQuantity) {
			this.boxQuantity = boxQuantity;
		}

		@JsonbProperty("amount_burden")
		public Integer getAmountBurden() {
			return amountBurden;
		}

		@JsonbProperty("amount_burden")
		public void setAmountBurden(int amountBurden) {
			this.amountBurden = amountBurden;
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
