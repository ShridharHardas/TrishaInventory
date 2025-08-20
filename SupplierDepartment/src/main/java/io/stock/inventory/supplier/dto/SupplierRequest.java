package io.stock.inventory.supplier.dto;



import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class SupplierRequest {

	private String supplier_name;
	
	private long mobileno;
	
	private LocalDate time;

	public String getSupplier_name() {
		return supplier_name;
	}

	public SupplierRequest setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
		return this;
	}

	public long getMobileno() {
		return mobileno;
	}

	public SupplierRequest setMobileno(long mobileno) {
		this.mobileno = mobileno;
		return this;
	}

	public LocalDate getTime() {
		return time;
	}

	public SupplierRequest setTime(LocalDate time) {
		this.time = time;
		return this;
	}
	public static SupplierRequest getInstance()
	{
		return new SupplierRequest();
	}
	
}
