package com.farawaybr.gatewayapi.jaxrs.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class ProtheusGatewayResponseDTO extends GatewayResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProtheusGatewayResponseDTO(String environment, String remoteAddr, Long protheusLatency,
			Object protheusResponse) {
		super(environment, remoteAddr, protheusLatency, protheusResponse);
		// TODO Auto-generated constructor stub
	}

	@JsonbProperty("protheus_data")
	@Override
	public Object getProtheusResponse() {
		// TODO Auto-generated method stub
		return super.getProtheusResponse();
	}

	public static ProtheusGatewayResponseDTO build(String environment, String remoteAddr, Long protheusLatency,
			ProtheusResponse response) {
		System.out.println("build protheus gateway");
		return new ProtheusGatewayResponseDTO(environment, remoteAddr, protheusLatency, response);
	}
}
