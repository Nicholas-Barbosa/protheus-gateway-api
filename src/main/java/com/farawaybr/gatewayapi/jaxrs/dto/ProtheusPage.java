package com.farawaybr.gatewayapi.jaxrs.dto;

import java.util.List;
import java.util.OptionalInt;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;

public abstract class ProtheusPage<T> extends ProtheusResponse {

	@JsonbProperty("page")
	private Short page;
	@JsonbProperty("page_size")
	private Short pageSize;
	@JsonbProperty("total_page")
	private Short totalPages;
	@JsonbProperty("total_items")
	private Short totalItems;
	private List<T> content;

	public ProtheusPage(List<T> content) {
		super();
		this.content = content;
	}

	public List<T> getContent() {
		return content;
	}

	public OptionalInt getPage() {
		return OptionalInt.empty();
	}

	public void setPage(Short page) {
		this.page = page;
	}

	public Short getPageSize() {
		return pageSize;
	}

	public void setPageSize(Short pageSize) {
		this.pageSize = pageSize;
	}

	@JsonbProperty("total_pages")
	public Short getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Short totalPages) {
		this.totalPages = totalPages;
	}

	public Short getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Short totalItems) {
		this.totalItems = totalItems;
	}

	@JsonbTransient
	public boolean containsContent() {
		return content != null && content.size() > 0;
	}
}
