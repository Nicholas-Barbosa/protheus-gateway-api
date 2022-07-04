package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.jaxrs.dto.BillsToPayPage;

public interface BillService {

	BillsToPayPage findBillsToPay(String customerName, String customerStore, int page, int pageSize);

}
