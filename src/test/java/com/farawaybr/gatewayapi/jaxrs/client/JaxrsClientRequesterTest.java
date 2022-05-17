package com.farawaybr.gatewayapi.jaxrs.client;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import jakarta.inject.Inject;

@ExtendWith(ArquillianExtension.class)
public class JaxrsClientRequesterTest {

	@Inject
	JaxrsClientRequester requester;

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class)
				.addClasses(JaxrsClientRequester.class, JaxrsRequestData.class, JaxrsClientSource.class)
				// Enable CDI (Optional since Java EE 7.0)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	@DisplayName("Http get request")
	void testGet() {
//		assertEquals(300,300);
//		requester.request(JaxrsRequestDataBuilder.getInstance().method("GET")
//				.url("https://api.coindesk.com/v1/bpi/currentprice.json").build(), null);
		System.out.println(requester);
	}

}
