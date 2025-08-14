package io.stock.inventory.purchase.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseRequest {
	
    private String supplier_name;
	
	private LocalDate purchase_date;
	
	private double total_cost;

	public String getSupplier_name() {
		return supplier_name;
	}

	public PurchaseRequest setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
		return this;
	}

	public LocalDate getPurchase_date() {
		return purchase_date;
	}

	public PurchaseRequest setPurchase_date(LocalDate purchase_date) {
		this.purchase_date = purchase_date;
		return this;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public PurchaseRequest setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
		return this;
	}
	
	
	public static PurchaseRequest getInstance()
	{
		return new PurchaseRequest();
	}
	
	

}
