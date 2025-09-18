package io.stock.inventory.purchase.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Purchase")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchasingDept {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( updatable = true,nullable = false)
	private long id;
	
	private String purchase_id;
	
	private String supplier_name;
	
	private LocalDate purchase_date;
	
	private double total_cost;


	public long getId() {
		return id;
	}
	public PurchasingDept setId(long id) {
		this.id = id;
		return this;
	}
	
	public String getPurchase_id() {
		return purchase_id;
	}
	public PurchasingDept setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
		return this;
	}
	public String getSupplier_name() {
		return supplier_name;
	}

	public PurchasingDept setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
		return this;
	}

	public LocalDate getPurchase_date() {
		return purchase_date;
	}

	public PurchasingDept setPurchase_date(LocalDate purchase_date) {
		this.purchase_date = purchase_date;
		return this;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public PurchasingDept setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
		return this;
	}
	
	public static  PurchasingDept getInstance()
	{
		return new PurchasingDept();
	}
	
	

}
