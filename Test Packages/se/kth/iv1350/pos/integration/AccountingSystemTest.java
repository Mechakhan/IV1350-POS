package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.model.Sale;

class AccountingSystemTest {

	AccountingSystem as;
	Sale sale;
	
	@BeforeEach
	void setUp() throws Exception {
		as = new AccountingSystem();
		sale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		as = null;
		sale = null;
	}

	@Test
	void testLoggingSale() {
		sale.addItemGroup("ABC123", 2);
		as.logSale(sale.getSaleLog());
		int amount = as.getNrOfSales();
		int expResult = 1;
		assertEquals(expResult, amount, "Wrong amount of logs in accounting system.");
	}

}
