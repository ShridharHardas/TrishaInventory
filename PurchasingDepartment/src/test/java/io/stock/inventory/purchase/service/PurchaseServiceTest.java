package io.stock.inventory.purchase.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

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

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Any;

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
}
