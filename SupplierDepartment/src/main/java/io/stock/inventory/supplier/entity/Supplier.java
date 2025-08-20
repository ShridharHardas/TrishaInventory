package io.stock.inventory.supplier.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplier_id;
	
	private String supplier_name;
	
	private long mobileno;
	
	private LocalDate time;

	public Long getSupplier_id() {
		return supplier_id;
	}

	public Supplier setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
		return this;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public Supplier setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
		return this;
	}

	public long getMobileno() {
		return mobileno;
	}

	public Supplier setMobileno(long mobileno) {
		this.mobileno = mobileno;
		return this;
	}

	public LocalDate getTime() {
		return time;
	}

	public Supplier setTime(LocalDate time) {
		this.time = time;
		return this;
	}
	
	public static Supplier getInstance()
	{
		return new Supplier();
	}
	
}
