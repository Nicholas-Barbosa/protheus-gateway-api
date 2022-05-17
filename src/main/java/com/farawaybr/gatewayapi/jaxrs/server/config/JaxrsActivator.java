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

import com.farawaybr.gatewayapi.jaxrs.server.StockResourceImpl;
import com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper.ConstraintViolationExceptionMapper;
import com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper.JsonbExceptionMapper;
import com.farawaybr.gatewayapi.jaxrs.server.exceptionmapper.ProcessingExceptionMapper;
import com.farawaybr.gatewayapi.jaxrs.server.oauthserver.TokenResource;
import com.farawaybr.gatewayapi.jaxrs.server.provider.CorsFilter;
import com.farawaybr.gatewayapi.jaxrs.server.provider.EnvironmentContainerRequestFilter;
import com.farawaybr.gatewayapi.jaxrs.server.provider.GatewayResponseContainerResponseFilter;
import com.farawaybr.gatewayapi.jaxrs.server.provider.TokenContainerRequestFilter;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class JaxrsActivator extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return Set.of(ConstraintViolationExceptionMapper.class, EnvironmentContainerRequestFilter.class,
				GatewayResponseContainerResponseFilter.class, TokenContainerRequestFilter.class,
				StockResourceImpl.class, JsonbExceptionMapper.class, ProcessingExceptionMapper.class,
				TokenResource.class, CorsFilter.class);
	}
}
