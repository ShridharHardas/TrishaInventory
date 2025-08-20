package io.stock.inventory.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.stock.inventory.supplier.dto.SupplierRequest;
import io.stock.inventory.supplier.entity.Supplier;
import io.stock.inventory.supplier.repository.SupplierRepo;

@Service
public class SupplierService {
	
	@Autowired 
	private SupplierRepo repo;
	
	public void addSupplier(SupplierRequest request)
	{
		Supplier supplier=Supplier.getInstance()
		.setSupplier_name(request.getSupplier_name())
		.setMobileno(request.getMobileno())
		.setTime(request.getTime());
		repo.save(supplier);
	}
	
	public List<Supplier> getAllSupplier()
	{
		return repo.findAll();
	}
	
	public Optional<Supplier> getSingleSupplier(Long id)
	{
		return repo.findById(id);
	}
	public void deleteSupplier(Long id)
	{
		 repo.deleteById(id);
	}
	
	public Supplier updateSupplierDetails(Supplier request)
	{
		return repo.save(request);
	}

}
