package io.stock.inventory.purchase.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.stock.inventory.purchase.dto.PurchaseRequest;
import io.stock.inventory.purchase.model.PurchasingDept;
import io.stock.inventory.purchase.repository.PurchaseRepo;

@Service
public class PurchaseService {
	
	
	@Autowired
	PurchaseRepo repo;
	
	private String generateRandomId(int length)
	{
		return UUID.randomUUID().toString().replace("-", "").substring(0,length).toUpperCase();
	}
	public String getPurchaseId()
	{
		return "PID"+generateRandomId(8);
	}
	
	public void addPurchaseList(PurchaseRequest request)
	{
		PurchasingDept dept=PurchasingDept.getInstance()
				.setPurchase_id(getPurchaseId())
				.setSupplier_name(request.getSupplier_name())
				.setPurchase_date(request.getPurchase_date())
				.setTotal_cost(request.getTotal_cost());
		
		repo.save(dept);
	}
	
	public List<PurchasingDept> getAll()
	{
		return repo.findAll();
	}
	public Optional<PurchasingDept> getSingleProduct(Long id)
	{
		return repo.findById(id);
	}
	
	public void deletePruchase(Long id)
	{
		repo.deleteById(id);
	}
	
	public PurchasingDept updatePurchaseProduct(PurchasingDept request)
	{
		return repo.save(request);
	}

}
