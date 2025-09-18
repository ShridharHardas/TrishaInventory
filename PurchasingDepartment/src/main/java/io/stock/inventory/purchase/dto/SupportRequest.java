package io.stock.inventory.purchase.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupportRequest {
	
	private String name;
	
	private String email;
	
	private String message;

	public String getName() {
		return name;
	}

	public SupportRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public SupportRequest setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public SupportRequest setMessage(String message) {
		this.message = message;
		return this;
	}
	public static SupportRequest getInstance()
	{
		return new SupportRequest();
	}
	
	

}
