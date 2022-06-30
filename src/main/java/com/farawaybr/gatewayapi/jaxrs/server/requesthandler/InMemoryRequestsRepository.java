package com.farawaybr.gatewayapi.jaxrs.server.requesthandler;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

import com.farawaybr.gatewayapi.jaxrs.dto.Request;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;

@ApplicationScoped
public class InMemoryRequestsRepository implements RequestsRepository, InMemoryCleanerRequestsObserver {

	private final Deque<Request> requests = new ConcurrentLinkedDeque<>();

	@Override
	public void onRequest(@ObservesAsync RequestEvent event) {
		// TODO Auto-generated method stub
		requests.offerFirst(new Request(event.getOriginIp(), event.getRequestAt(), event.getLocale()));
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		requests.clear();
	}

	@Override
	public List<Request> findAll() {
		// TODO Auto-generated method stub
		return requests.parallelStream().collect(CopyOnWriteArrayList::new, List::add, List::addAll);
	}
}
