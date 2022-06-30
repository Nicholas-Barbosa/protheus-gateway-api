/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 */
package com.farawaybr.gatewayapi.jaxrs.server.config;

import java.util.Set;

import com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper.ConstraintViolationExceptionMapper;
import com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper.JsonbExceptionMapper;
import com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper.ProcessingExceptionMapper;
import com.farawaybr.gatewayapi.jaxrs.server.oauthserver.TokenResource;
import com.farawaybr.gatewayapi.jaxrs.server.provider.requestfilter.PreflightContainerRequestFilter;
import com.farawaybr.gatewayapi.jaxrs.server.provider.requestfilter.RequestDataBootstrapperContainerRequestFilter;
import com.farawaybr.gatewayapi.jaxrs.server.provider.requestfilter.TokenContainerRequestFilter;
import com.farawaybr.gatewayapi.jaxrs.server.provider.responsefilter.CorsResponseFilter;
import com.farawaybr.gatewayapi.jaxrs.server.provider.responsefilter.GatewayJsonWrapperResponseContainerResponseFilter;
import com.farawaybr.gatewayapi.jaxrs.server.resources.DanfeResource;
import com.farawaybr.gatewayapi.jaxrs.server.resources.OrderResource;
import com.farawaybr.gatewayapi.jaxrs.server.resources.RepresentativeResource;
import com.farawaybr.gatewayapi.jaxrs.server.resources.RequestResource;
import com.farawaybr.gatewayapi.jaxrs.server.resources.StockResource;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class JaxrsActivator extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return Set.of(ConstraintViolationExceptionMapper.class, RequestDataBootstrapperContainerRequestFilter.class,
				GatewayJsonWrapperResponseContainerResponseFilter.class, TokenContainerRequestFilter.class,
				StockResource.class, JsonbExceptionMapper.class, ProcessingExceptionMapper.class, TokenResource.class,
				PreflightContainerRequestFilter.class, CorsResponseFilter.class, RepresentativeResource.class,
				OrderResource.class, RequestResource.class, DanfeResource.class);
	}
}
