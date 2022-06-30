package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class WrapperRepresentativeDataDTO extends ProtheusResponse{

	@JsonbProperty("representative")
	private RepresentativeDataDTO[] dataarr;

	public RepresentativeDataDTO[] getDataarr() {
		return dataarr;
	}

	public void setDataarr(RepresentativeDataDTO[] dataarr) {
		this.dataarr = dataarr;
	}

	public static class RepresentativeDataDTO  {
		private String code, type, name, email;
		private int invoice, mark;
		@JsonbProperty("open_orders")
		private int openOrders;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getInvoice() {
			return invoice;
		}

		public void setInvoice(int invoice) {
			this.invoice = invoice;
		}

		public int getMark() {
			return mark;
		}

		public void setMark(int mark) {
			this.mark = mark;
		}

		public int getOpenOrders() {
			return openOrders;
		}

		public void setOpenOrders(int openOrders) {
			this.openOrders = openOrders;
		}

	}
}