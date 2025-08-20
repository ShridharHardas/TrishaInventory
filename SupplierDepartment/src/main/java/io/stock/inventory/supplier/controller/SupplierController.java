package io.stock.inventory.supplier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import io.stock.inventory.supplier.dto.SupplierRequest;
import io.stock.inventory.supplier.entity.Supplier;
import io.stock.inventory.supplier.service.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	
	@GetMapping("/stock/inventory/supplier/home")
	public String welcome()
	{
		return "supplierHome";
	}
	
	@PostMapping("/addSupplierDetails")
	public String addSupplierDetails(@ModelAttribute("supplier") SupplierRequest request,Model model)
	{
		service.addSupplier(request);
		return "redirect:/stock/inventory/supplier/home";
	}
	
	@GetMapping("/stock/inventory/supplier/addSupplier")
	public String openSupplierForm(Model model)
	{
		model.addAttribute("supplier", new SupplierRequest());
		return "supplierRegister";
	}
	
	@GetMapping("/stock/inventory/supplier/list")
	public String getAllSupplierDetails(Model model)
	{
		model.addAttribute("supplierList", service.getAllSupplier());
		return "supplierList";
	}
	
	@GetMapping("/stock/inventory/supplier/delete/{id}")
	public String deleteById(@PathVariable Long id)
	{
		service.deleteSupplier(id);
		return "redirect:/stock/inventory/supplier/list";
	}
	
	@GetMapping("/stock/inventory/supplier/edit/{id}")
	public String editById(@PathVariable Long id,Model model)
	{
		model.addAttribute("supplier", service.getSingleSupplier(id));
		return "supplierEdit";
	}
	
	@PostMapping("/supplierEdit")
	public String editSupplier(@ModelAttribute Supplier supplier)
	{
		service.updateSupplierDetails(supplier);
		return "redirect:/stock/inventory/supplier/list";
	}
	
	

}
