package com.farawaybr.gatewayapi.service;

import java.util.Optional;

import com.farawaybr.gatewayapi.jaxrs.dto.ErrorDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.ProtheusPage;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;

@Interceptor
@OptionalEmpty404NotFoundJoinPointCut
public class OptionalEmpyt404NotFoundAspect {

	@Inject
	private RequestData requestData;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext joinpoint) throws Throwable {
		Object obj = joinpoint.proceed();
		if (isOptional(joinpoint)) {
			Optional<?> optionalnstance = (Optional<?>) obj;
			if (optionalnstance.isPresent() && optionalnstance.get() instanceof ProtheusPage
					&& !((ProtheusPage<?>) optionalnstance.get()).containsContent()) {
				throwNotFound();
			}
		}
		return obj;
	}

	private boolean isOptional(InvocationContext joinpoint) {
		return joinpoint.getMethod().getReturnType() == Optional.class;
	}

	private void throwNotFound() {
		throw new NotFoundException(Response.status(404)
				.entity(new ErrorDTO(requestData.getEnvironment().name(), "Object not found", 404)).build());
	}
}
