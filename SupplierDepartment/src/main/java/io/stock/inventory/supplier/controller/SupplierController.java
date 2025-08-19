package io.stock.inventory.supplier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
	
	@GetMapping("stock/inventory/supplier/home")
	public String welcome()
	{
		return "supplierHome";
	}

}
