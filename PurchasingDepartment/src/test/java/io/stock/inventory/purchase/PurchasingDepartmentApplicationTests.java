package io.stock.inventory.purchase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class PurchasingDepartmentApplicationTests {

	@Test
	@BeforeAll
	static void test2()
	{
		System.out.println("This is Test 2 Method :");
	}
	@Test
	//@Disabled
	void contextLoads() {
		System.out.println("This is the Context Method");
	}
	
	@Test
	//@DisplayName("sumOfTwoNumber_then")
	@BeforeEach
	void sumOfTwoNumber()
	{
		System.out.println("This is Sum of two Method");
	}
	
	
	@Test
	@AfterEach
	void test1()
	{
		System.out.println("This is Test 1 Method :");
	}
	
	@Test
	void test4()
	{
		System.out.println("This is Test 4 Method :");
	}
	
	@Test
	@AfterAll
	static void test3()
	{
		System.out.println("This is Test 3 Method :");
	}
	
	int sumOfTwo(int a,int b)
	{
		return a+b;
	}
	
	@Test
	void addition()
	{
		int a=5;
		int b=3;
		int sum=sumOfTwo(a, b);
		//Assertions.assertEquals(8, sum);
		
		assertThat(sum)
		.isEqualTo(8)
		.isCloseTo(8, Offset.offset(1));
		
		assertThat("Apple")
		.startsWith("pp")
		.endsWith("l")
		.hasSize(3);
	}
	
	
	@Test
	void getLocalized()
	{
		int a=5;
		int b=0;
		assertThatThrownBy(()->division(a, b))
		.isInstanceOf(NullPointerException.class)
		.hasMessage("is divide by zero");
	}
	
	double division(int a,int b)
	{
		try {
			return a/b;
		}
		catch(ArithmeticException e)
		{
			System.out.println("This Exception :"+e.getLocalizedMessage());
			throw new ArithmeticException();
		}
	}
	
	

}
