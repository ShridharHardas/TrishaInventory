package io.stock.inventory.purchase.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Support {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public Support setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Support setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Support setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Support setMessage(String message) {
		this.message = message;
		return this;
	}

	private String name;
	
	private String email;
	
	private String message;
	
	public static Support getInstance()
	{
		return new Support();
	}

}
