package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.model.Sale;

@SuppressWarnings("unused")
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

	/**
	 * As there is no way to retrieve the sale log list without
	 * a get method, the test wasn't made.
	 */
	@Test
	void test() {}

}
