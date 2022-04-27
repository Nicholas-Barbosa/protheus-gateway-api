package com.farawaybr.gatewayapi.jaxrs.dto;

import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotBlank;

public class AuthenticationRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "username cannot be null or blank!")
	private String username;
	@NotBlank(message  ="password cannot be null or blank!")
	private String password;

	public String getUsername() {
		return username;
	}

	@JsonbProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@JsonbProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	private void writeObject(ObjectOutputStream s) throws Exception {
		PutField fields = s.putFields();
		fields.put("username", username);
		s.writeFields();
	}

	@Override
	public String toString() {
		return "AuthenticationRequestDTO [username=" + username + "]";
	}

}
