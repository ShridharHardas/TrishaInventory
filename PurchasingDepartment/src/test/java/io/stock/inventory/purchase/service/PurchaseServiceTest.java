package io.stock.inventory.purchase.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;


import io.stock.inventory.purchase.dto.PurchaseRequest;
import io.stock.inventory.purchase.model.PurchasingDept;
import io.stock.inventory.purchase.repository.PurchaseRepo;


@ExtendWith(MockitoExtension.class)
@AutoConfigureTestDatabase(replace = Replace.AUTO_CONFIGURED.ANY)
public class PurchaseServiceTest {
	
	@InjectMocks
	private PurchaseService purchaseService;

	@Mock
	private PurchaseRepo purchaseRepo;
	
	
	
	
	@Test
	@Disabled
	void save()
	{
		ModelMapper mapper=new ModelMapper();
		PurchasingDept dept=PurchasingDept.getInstance()
				.setPurchase_id("PID1234")
				.setSupplier_name("Kishor Borude")
				.setPurchase_date(LocalDate.now())
				.setTotal_cost(10000);
		 ArgumentCaptor<PurchasingDept> captor = ArgumentCaptor.forClass(PurchasingDept.class);
		when(purchaseRepo.save(any(PurchasingDept.class))).thenReturn(dept);
		purchaseService.addPurchaseList(mapper.map(dept, PurchaseRequest.class));
		verify(purchaseRepo).save(captor.capture());
		PurchasingDept dept2=captor.getValue();
		assertEquals("Kishor1 Borude", dept2.getSupplier_name());
			
	}
	
	@Test
	@Disabled
	@DisplayName("To Find The All Movies")
	void getAllMovies()
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
		when(purchaseRepo.findAll()).thenReturn(list);
		List<PurchasingDept> depts=purchaseService.getAll();
		assertEquals(2, depts.size());
		assertNotNull(depts);
	}
	
	@Test
	@Disabled
	void getPurchaseById()
	{
		PurchasingDept dept1=PurchasingDept.getInstance()
				.setPurchase_id("PID1234")
				.setSupplier_name("Kishor Borude")
				.setPurchase_date(LocalDate.now())
				.setTotal_cost(10000);
		when(purchaseRepo.findById(anyLong())).thenReturn(Optional.of(dept1));
		Optional<PurchasingDept> data=purchaseService.getSingleProduct(1L);
		assertThat(data);
		assertNotNull(data);
	}
	
	@Test
	@DisplayName("This Purchase Id Thrown Exception")
	@Disabled
	void getPurchaseByIdException()
	{
		PurchasingDept dept1=PurchasingDept.getInstance()
				.setPurchase_id("PID1234")
				.setSupplier_name("Kishor Borude")
				.setPurchase_date(LocalDate.now())
				.setTotal_cost(10000);
		when(purchaseRepo.findById(1l)).thenReturn(Optional.of(dept1));
		
		Assertions.assertThrows(RuntimeException.class,()->{
			purchaseService.getSingleProduct(2l);
		});
	}
	
	
	@Test
	@DisplayName("update Purchase Information")
	@Disabled
	void updatePurchaseProduct()
	{
		
		PurchasingDept dept1=PurchasingDept.getInstance()
				.setPurchase_id("PID1234")
				.setSupplier_name("Kishor Borude")
				.setPurchase_date(LocalDate.now())
				.setTotal_cost(10000);
		when(purchaseRepo.save(any(PurchasingDept.class))).thenReturn(dept1);
		dept1.setSupplier_name("Rutik Borude");
		PurchasingDept data=purchaseService.updatePurchaseProduct(dept1);
		//You can stubbing Method in single time other wise showing a Error
		//when(purchaseRepo.save(any(PurchasingDept.class))).thenReturn(data);
		assertEquals("Rutik Borude", data.getSupplier_name());
	}
	
	
	@Test
	@DisplayName("Delete the Movies by Id")
	void deletePurchaseDeleteById()
	{
		PurchasingDept dept1=PurchasingDept.getInstance()
				.setPurchase_id("PID1234")
				.setSupplier_name("Kishor Borude")
				.setPurchase_date(LocalDate.now())
				.setTotal_cost(10000);
		when(purchaseRepo.findById(anyLong())).thenReturn(Optional.of(dept1));
		//doNothing().when(purchaseRepo).delete(any(PurchasingDept.class));
		purchaseService.deletePruchase(1l);
		verify(purchaseRepo,times(1)).delete(dept1);
	}
}
