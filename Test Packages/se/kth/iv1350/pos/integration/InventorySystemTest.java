package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.model.Sale;

class InventorySystemTest {
	
	InventorySystem is;
	Sale sale;

	@BeforeEach
	void setUp() throws Exception {
		is = new InventorySystem();
		sale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		is = null;
		sale = null;
	}

	@Test
	void test() {
		sale.addItemGroup("ABC123", 2);
		is.logSale(sale.getSaleLog());
		// Hur testa detta?
	}

}
