package com.farawaybr.gatewayapi.jaxrs.server;

import java.time.ZonedDateTime;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("greeting")
public class GreetingResource {

	@GET
	public Response seyHello() {
		return Response.ok("Hello " + ZonedDateTime.now()).build();
	}
}
