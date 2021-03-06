package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.PriceDTO;

class SaleTest {
	
	Sale sale;

	@BeforeEach
	void setUp() throws Exception {
		sale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		sale = null;
	}

	@Test
	void testAddNewInvalidItem() {
		try {
			sale.addItemGroup("GHI780", 4);
			fail("Invalid item ID was treated as valid");
		} catch (InvalidItemException e) {}
	}
	
	@Test
	void testAddNewValidItem() throws InvalidItemException {
		String result = sale.addItemGroup("GHI789", 4).toString();
		String expResult = "cost: 12.0";
		assertTrue(result.contains(expResult), "Item not added correctly into List.");
	}
	
	@Test
	void testAddExistingItem() throws InvalidItemException {
		sale.addItemGroup("ABC123", 2);
		String result = sale.addItemGroup("ABC123", 4).toString();
		String expResult = "x6";
		assertTrue(result.contains(expResult), "Item not added correctly into List.");
	}

	@Test
	void testAddToRunningTotal() {
		sale.setRunningTotal(new PriceDTO(10, 0, false));
		double runningTotal = sale.getSaleLog().getRunningTotal().getPrice();
		double expResult = 10;
		assertEquals(expResult, runningTotal, "Running total not updated correctly by set method.");
	}
	
	@Test
	void testAddToRunningTotalInvalid() {
		try {
			sale.setRunningTotal(new PriceDTO(-10, 0, false));
			fail("Running total not updated correctly by negative value.");
		}
		catch (Exception e) {}
	}
	
	@Test
	void testEnd() {
		sale.setRunningTotal(new PriceDTO(42, 0, false));
		double totalPrice = sale.end().getPrice();
		double expResult = 42;
		assertEquals(expResult, totalPrice, "Running total not returned correctly by end method.");
	}
}
