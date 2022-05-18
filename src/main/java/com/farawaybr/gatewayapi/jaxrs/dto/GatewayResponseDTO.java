package com.farawaybr.gatewayapi.jaxrs.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ "environment", "date", "remoteAddr", "protheusLatency" })
public class GatewayResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2224938028164999130L;
	private String environment, remoteAddr;
	private Long protheusLatency;
	private ZonedDateTime date;
	private SuperProtheusResponseDTO protheusResponse;

	public GatewayResponseDTO(String environment, String remoteAddr, Long protheusLatency,
			SuperProtheusResponseDTO protheusResponse) {
		super();
		this.environment = environment;
		this.remoteAddr = remoteAddr;
		this.protheusLatency = protheusLatency;
		this.protheusResponse = protheusResponse;
		this.date = ZonedDateTime.now();
	}

	public String getEnvironment() {
		return environment;
	}

	@JsonbProperty("requested_by")
	public String getRemoteAddr() {
		return remoteAddr;
	}

	@JsonbProperty("protheus_latency_ms")
	public Long getProtheusLatency() {
		return protheusLatency;
	}

	@JsonbProperty("responded_at")
	public ZonedDateTime getDate() {
		return date;
	}

	@JsonbProperty("protheus_data")
	public SuperProtheusResponseDTO getProtheusResponse() {
		return protheusResponse;
	}

	public static GatewayResponseDTO build(String environment, String remoteAddr, Long protheusLatency,
			SuperProtheusResponseDTO response) {
		return new GatewayResponseDTO(environment, remoteAddr, protheusLatency, response);
	}
}
