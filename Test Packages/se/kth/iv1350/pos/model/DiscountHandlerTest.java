package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.CustomerDTO;

class DiscountHandlerTest {

	DiscountHandler dh;
	Sale sale;
	
	@BeforeEach
	void setUp() throws Exception {
		dh = new DiscountHandler();
		sale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		dh = null;
		sale = null;
	}

	@Test
	void testNoDiscount() {
		sale.addItemGroup("ABC123", 10);
		sale.addItemGroup("DEF456", 1);
		double newPrice = dh.findDiscount(new CustomerDTO("0123"), sale.getSaleLog()).getPrice();
		double expResult = 30 * 1.25 * 10 + 49 * 1.12 * 1;
		assertEquals(expResult, newPrice, "Price changed without a discount.");
	}
	
	@Test
	void testOneDiscount() {
		sale.addItemGroup("ABC123", 5);
		sale.addItemGroup("GHI789", 3);
		double newPrice = dh.findDiscount(new CustomerDTO("1234"), sale.getSaleLog()).getPrice();
		double expResult = 30 * 1.25 * 5 + 12 * 1.06 * 3 - 20;
		assertEquals(expResult, newPrice, "Price after one discount is incorrect.");
	}
	
	@Test
	void testThreeDiscount() {
		sale.addItemGroup("DEF456", 10);
		double newPrice = dh.findDiscount(new CustomerDTO("1234"), sale.getSaleLog()).getPrice();
		double expResult = (49 * 1.12 * 10 - 20) * .9 * .8;
		assertEquals(expResult, newPrice, "Price after three discounts is incorrect.");
	}

}
