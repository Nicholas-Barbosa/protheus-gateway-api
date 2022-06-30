package com.farawaybr.gatewayapi.jaxrs.server.requesthandler;

import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.inject.Inject;

@Singleton
public class InMemoryRequestRepositoryCleaner {

	@Inject
	private InMemoryCleanerRequestsObserver observer;

	@Schedule(hour = "*/23", dayOfWeek = "*", persistent = false, timezone = "America/Sao_Paulo")
	public void notifyObserver() {
		System.out.println("limpando requests deque!");
		observer.clear();
	}
}
