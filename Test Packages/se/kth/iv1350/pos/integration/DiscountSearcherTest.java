package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.model.Sale;

class DiscountSearcherTest {
	
	DiscountSearcher ds;
	Sale sale;

	@BeforeEach
	void setUp() throws Exception {
		ds = new DiscountSearcher();
		sale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		ds = null;
		sale = null;
	}

	@Test
	void testInvalidCustomerID() {
		sale.addItemGroup("ABC123", 6);
		int amountOfDiscounts = ds.getEligibleDiscounts(new CustomerDTO("0123"), sale.getSaleLog()).length;
		int expResult = 0;
		assertEquals(expResult, amountOfDiscounts, "Discount was returned for invalid customer ID.");
	}
	
	@Test
	void testInvalidItemCount() {
		sale.addItemGroup("ABC123", 3);
		int amountOfDiscounts = ds.getEligibleDiscounts(new CustomerDTO("1234"), sale.getSaleLog()).length;
		int expResult = 0;
		assertEquals(expResult, amountOfDiscounts, "Discount was returned for invalid item count.");
	}
	
	@Test
	void testInvalidSalePrice() {
		sale.addItemGroup("GHI789", 5);
		int amountOfDiscounts = ds.getEligibleDiscounts(new CustomerDTO("1234"), sale.getSaleLog()).length;
		int expResult = 0;
		assertEquals(expResult, amountOfDiscounts, "Discount was returned for invalid sale price.");
	}
	
	@Test
	void testValidForOneDiscount() {
		sale.addItemGroup("ABC123", 1);
		sale.addItemGroup("DEF456", 1);
		sale.addItemGroup("GHI789", 8);
		int amountOfDiscounts = ds.getEligibleDiscounts(new CustomerDTO("1234"), sale.getSaleLog()).length;
		int expResult = 1;
		assertEquals(expResult, amountOfDiscounts, "A wrong amount of discounts was returned.");
	}
	
	@Test
	void testValidForTwoDiscounts() {
		sale.addItemGroup("ABC123", 3);
		sale.addItemGroup("DEF456", 6);
		int amountOfDiscounts = ds.getEligibleDiscounts(new CustomerDTO("1234"), sale.getSaleLog()).length;
		int expResult = 2;
		assertEquals(expResult, amountOfDiscounts, "A wrong amount of discounts was returned.");
	}

}
