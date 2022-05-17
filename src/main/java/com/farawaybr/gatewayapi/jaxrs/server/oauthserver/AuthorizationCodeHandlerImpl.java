package com.farawaybr.gatewayapi.jaxrs.server.oauthserver;

import java.io.IOException;
import java.util.UUID;

import com.farawaybr.gatewayapi.ProtheusEnvironment;
import com.farawaybr.gatewayapi.domain.AuthorizationCode;
import com.farawaybr.gatewayapi.jaxrs.dto.AuthenticationProtheusResponseDTO;
import com.farawaybr.gatewayapi.jaxrs.dto.AuthenticationRequestDTO;
import com.farawaybr.gatewayapi.jaxrs.server.RequestData;
import com.farawaybr.gatewayapi.service.AuthenticationService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ApplicationScoped
public class AuthorizationCodeHandlerImpl implements AuthorizationCodeHandler {

	@Inject
	private AuthenticationService authService;

	@Inject
	private RequestData requestData;

	@Inject
	private AuthorizationCodeRepository repository;

	@Override
	public void authenticate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		if (canIHandle(req)) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String env = req.getParameter("envs");
			requestData.setEnvironment(ProtheusEnvironment.valueOf(env));
			AuthenticationProtheusResponseDTO response = authService
					.authenticate(new AuthenticationRequestDTO(username, password), ProtheusEnvironment.valueOf(env));
			AuthorizationCode code = new AuthorizationCode(UUID.randomUUID(), response.toAccessToken());
			repository.save(code);
			System.out.println("codigo gerado " + code.getCode());
			try {
				StringBuilder redirectUri = new StringBuilder(req.getParameter("redirectUri"));
				redirectUri.append("?code=").append(code.getCode());
				resp.sendRedirect("//" + redirectUri);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		resp.setStatus(412);
	}

}
