package com.farawaybr.gatewayapi.service;

import com.farawaybr.gatewayapi.jaxrs.dto.DanfeDTO;

public interface DanfeService {

	DanfeDTO find(String invoiceNumber,int invoiceSerie);
	
	String findST(String invoiceNumber,int invoiceSerie);
}
