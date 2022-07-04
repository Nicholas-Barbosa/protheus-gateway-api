package com.farawaybr.gatewayapi.jaxrs.dto;

import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;

public abstract class ProtheusPage<T> extends ProtheusResponse {

	@JsonbProperty("page")
	private int page;
	@JsonbProperty("page_size")
	private int pageSize;
	@JsonbProperty("total_page")
	private int totalPages;
	@JsonbProperty("total_items")
	private int totalItems;
	private List<T> content;

	public ProtheusPage(List<T> content) {
		super();
		this.content = content;
	}

	public List<T> getContent() {
		return content;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@JsonbProperty("total_pages")
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public boolean containsContent() {
		return content != null && content.size() > 0;
	}
}
