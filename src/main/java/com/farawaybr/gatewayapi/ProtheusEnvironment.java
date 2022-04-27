package com.farawaybr.gatewayapi;

public enum ProtheusEnvironment {

	CDG(8090), NSG(8094),SPG(8096),GAUSS(8093);

	private final int port;

	private ProtheusEnvironment(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	
}
