package com.farawaybr.gatewayapi.jaxrs.server.resources;

import com.farawaybr.gatewayapi.jaxrs.dto.NewOrderDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.service.OrderService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("order")
public class OrderResource {

	@Inject
	private OrderService service;

	@Inject
	private RequestData requestData;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response newOrder(NewOrderDTO data) {
		return Response.status(201).entity(service.persist(data, requestData.getEnvironment())).build();
	}

	@GET
	@Produces("application/json")
	public Response findAll(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize,
			@QueryParam("searchKey") String searchKey) {
		return Response.status(200).entity(service.find(page, pageSize,searchKey)).build();
	}
}
