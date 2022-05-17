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
package com.farawaybr.gatewayapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ExtendWith(ArquillianExtension.class)
public class StockResourceTest {

	private final static Logger LOGGER = Logger.getLogger(StockResourceTest.class.getName());

	private WebTarget stockTraget;

	private final String token = "BEARER test_token";

	
	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class)
				.addPackages(true, "com.farawaybr.gatewayapi.jaxrs", "com.farawaybr.gatewayapi.service")
				.addClasses(ProtheusEnvironment.class, PropertiesResolver.class)

				// Enable CDI (Optional since Java EE 7.0)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@ArquillianResource
	private URL base;

	private static Client client;

	@BeforeAll
	public static void setupClient() {
		LOGGER.info("openning client");
		client = ClientBuilder.newClient();
	}

	@AfterAll
	public static void closeClient() {
		LOGGER.info("closing client");
		if (client != null) {
			client.close();
		}
	}

	@BeforeEach
	public void setup() throws MalformedURLException {
		LOGGER.info("setting stock target");
		stockTraget = client.target(new URL(this.base, "api/stock?environment=CDG").toExternalForm());
		// removed the Jackson json provider registry, due to OpenLiberty 21.0.0.1
		// switched to use Resteasy.
	}

	@Test
	@DisplayName("Stock endpoint should return 401")
	public void shouldReturn401() throws InterruptedException {
		LOGGER.log(Level.INFO, " client: {0}, baseURL: {1}", new Object[] { client, base });
		try (final Response stockResponse = this.stockTraget.request().accept(MediaType.APPLICATION_JSON)
				.post(Entity.json(null))) {
			assertEquals(401, stockResponse.getStatus());
//            assertTrue(stockResponse.readEntity(GreetingMessage.class).getMessage().startsWith("Say Hello to JakartaEE"));
		}
	}

	@Test
	@DisplayName("Stock endpoint should return 400 bad request")
	public void shouldReturn400() throws InterruptedException {
		LOGGER.log(Level.INFO, " client: {0}, baseURL: {1}", new Object[] { client, base });
		try (final Response stockResponse = this.stockTraget.request().accept(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, token).post(Entity.json(List.of("")))) {
			assertEquals(400, stockResponse.getStatus());
			System.out.println(stockResponse.readEntity(String.class));
		}
	}
	
	@Test
	@DisplayName("Get Access-Control-Allow-Origin response header")
	public void shouldReturnCorsHeader() throws InterruptedException {
		LOGGER.log(Level.INFO, " client: {0}, baseURL: {1}", new Object[] { client, base });
		try (final Response stockResponse = this.stockTraget.request().accept(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, token).post(null)) {
			assertEquals("*", stockResponse.getHeaderString("Access-Control-Allow-Origin"));
		}
	}
}
