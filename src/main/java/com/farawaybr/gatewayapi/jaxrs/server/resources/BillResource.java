package com.farawaybr.gatewayapi.jaxrs.server.resources;

import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.service.BillService;

import jakarta.inject.Inject;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("bills")
public class BillResource {

	@Inject
	private BillService service;

	@Inject
	private RequestData requestData;

	@GET
	@Produces("application/json")
	@Path("toPay")
	public Response toPay(@QueryParam("page") int page, @DefaultValue("10") @QueryParam("pageSize") int pageSize) {
		return Response.ok(service.findBillsToPay(page, pageSize)).build();
	}

	@GET
	@Produces("application/json")
	@Path("toPay/customer/{customerCode}")
	public Response toPayByCustomer(@NotBlank @PathParam("customerCode") String customerName,
			@Min(1) @DefaultValue("1") @QueryParam("page") int page,@Min(1) @DefaultValue("10") @QueryParam("pageSize") int pageSize) {
		return Response.ok(service.findBillsToPayByCustomer(customerName, page, pageSize)).build();
	}
}
