package io.stock.inventory.purchase.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.stock.inventory.purchase.model.PurchasingDept;
import io.stock.inventory.purchase.service.PurchaseService;

@WebMvcTest(PurchaseController.class)
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class PurchaseControllerTest {

	@MockBean
	private PurchaseService purchaseService;
	@Autowired
	private MockMvc mockMvc;
	
	
	
	@Test
	@Disabled
	void createUserData()
	{
		PurchasingDept dept1=PurchasingDept.getInstance()
				.setPurchase_id("PID1234")
				.setSupplier_name("Kishor Borude")
				.setPurchase_date(LocalDate.now())
				.setTotal_cost(10000);
		
		//when(purchaseService.addPurchaseList(null)).thenReturn(dept1);
	}
	
	@Test
	void getAllMovies() throws Exception
	{
		PurchasingDept dept1=PurchasingDept.getInstance()
				.setPurchase_id("PID1234")
				.setSupplier_name("Kishor Borude")
				.setPurchase_date(LocalDate.now())
				.setTotal_cost(10000);
		PurchasingDept dept2=PurchasingDept.getInstance()
				.setPurchase_id("PID4567")
				.setSupplier_name("Shridhar Hardas")
				.setPurchase_date(LocalDate.now())
				.setTotal_cost(4562);
		List<PurchasingDept> list=new ArrayList<>();
		list.add(dept1);
		list.add(dept2);
		when(purchaseService.getAll()).thenReturn(list);
		mockMvc.perform(get("/stock/inventory/purchaseList"))
        .andExpect(status().isOk());
	}
}
