package io.stock.inventory.purchase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.stock.inventory.purchase.dto.SupportRequest;
import io.stock.inventory.purchase.model.Support;
import io.stock.inventory.purchase.repository.SupportRepo;

@Service
public class SupportService {
	
	@Autowired
	SupportRepo repo;

	public void getData(SupportRequest request)
	{
		Support support=Support.getInstance()
				.setName(request.getName())
				.setEmail(request.getEmail())
				.setMessage(request.getMessage());
		repo.save(support);
	}
}
