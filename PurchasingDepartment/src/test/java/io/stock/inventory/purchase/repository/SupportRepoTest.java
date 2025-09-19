package io.stock.inventory.purchase.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import io.stock.inventory.purchase.model.Support;

@SpringBootTest
//@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.AUTO_CONFIGURED.ANY)
public class SupportRepoTest {

	@Autowired
	private SupportRepo supportRepo;
	private Support support;
	
	@BeforeEach
	void setUpData()
	{
		support=Support.getInstance()
				.setName("Shridhar")
				.setEmail("shridhar@gmail.com")
				.setMessage("This is Support Class Test Data Method");
				
	}
	
	@Test
	void findById_whenPurchaseDetailFound_thenReturnPurchaseInfo()
	{
		//Act-Given
		supportRepo.save(support);
		//when
		List<Support> supportList=supportRepo.findByEmail(support.getEmail());
		//Then
		assertThat(supportList).isNotNull().isNotEmpty();
		assertThat(supportList.get(0).getEmail()).isEqualTo(support.getEmail());
		
	}
	
	@Test
	void findById_WhenPurchaseDetailsNotFound_ThenReturnEmptyInfo()
	{
		//Act
		String email="prasad@gmail.com";
		//When
		List<Support> list=supportRepo.findByEmail(email);
		//Then
		assertThat(list).isNotNull().isEmpty();
		
		
	}
}
