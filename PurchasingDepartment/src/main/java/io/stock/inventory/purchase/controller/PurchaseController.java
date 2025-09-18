package io.stock.inventory.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import io.stock.inventory.purchase.dto.PurchaseRequest;
import io.stock.inventory.purchase.dto.SupportRequest;
import io.stock.inventory.purchase.model.PurchasingDept;
import io.stock.inventory.purchase.service.PurchaseService;
import io.stock.inventory.purchase.service.SupportService;

@Controller
public class PurchaseController {

	
	@Autowired
	PurchaseService service;
	
	@Autowired
	SupportService supportService;
	
	@GetMapping("stock/inventory/home")
	public String welcome()
	{
		return "homePage";
	}
	
	@GetMapping("/stock/inventory/addPurchase")
	public String openAddPurchase(Model model)
	{
		model.addAttribute("purchase", new PurchaseRequest());
		return "purchaseForm";
	}
	
	@PostMapping("/addPurchase")
	public String addPurchaseProduct(@ModelAttribute("purchase") PurchaseRequest request,Model model)
	{
		service.addPurchaseList(request);
		return "redirect:/stock/inventory/home";
	}
	
	@GetMapping("/stock/inventory/purchaseList")
	public String getAllDetails(Model model)
	{
		model.addAttribute("purchaseList", service.getAll());
		return "purchaseList";
	}
	
	@GetMapping("stock/inventory/delete/{id}")
	public String deleteById(@PathVariable Long id)
	{
		service.deletePruchase(id);
		return "redirect:/stock/inventory/purchaseList";
	}
	
	@GetMapping("stock/inventory/edit/{id}")
	public String editById(@PathVariable Long id,Model model)
	{
		model.addAttribute("purchase", service.getSingleProduct(id));
		return "updatePurchase";
	}
	
	@PostMapping("/updatePurchase")
	public String update(@ModelAttribute PurchasingDept purchase)
	{
		service.updatePurchaseProduct(purchase);
		return "redirect:/stock/inventory/purchaseList";
	}
	
	@GetMapping("/stock/inventory/support")
	public String getSupport(Model model)
	{
		model.addAttribute("support", new SupportRequest());
		return "support";
	}
	
	@PostMapping("/getSupport")
	public String getSupport(@ModelAttribute("support") SupportRequest request,Model model)
	{
		supportService.getData(request);
		return "redirect:/stock/inventory/home";
	}
}
