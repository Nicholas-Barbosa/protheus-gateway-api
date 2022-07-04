package com.farawaybr.gatewayapi.jaxrs.server.resources;

import com.farawaybr.gatewayapi.service.BillService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("bill")
public class BillResource {

	@Inject
	private BillService service;

	@GET
	@Produces("application/json")
	@Path("toPay")
	public Response toPay(@QueryParam("customerName") String customerName,
			@QueryParam("customerStore") String customerStore, @QueryParam("page") int page,
			@DefaultValue("10") @QueryParam("pageSize") int pageSize) {
		return Response.ok(service.findBillsToPay(customerName, customerStore, page, pageSize)).build();
	}
}
