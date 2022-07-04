package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.jaxrs.dto.BillsToPayPage;

public interface BillService {

	BillsToPayPage findBillsToPayByCustomer(String customerName, int page, int pageSize);

	BillsToPayPage findBillsToPay(int page, int pageSize);

}
