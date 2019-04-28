package se.kth.iv1350.pos.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest {
	
	Controller contr;

	@BeforeEach
	void setUp() throws Exception {
		contr = new Controller();
		contr.startNewSale();
	}

	@AfterEach
	void tearDown() throws Exception {
		contr = null;
	}

	@Test
	void testEnteringItem() {
		double result = contr.enterItemID("DEF456", 1).getRunningTotal().getVAT();
		double expResult = 5.88;
		assertEquals(expResult, result, "Incorrect sale dto returned to the view.");	
	}
	
	@Test
	void testEnteringCustomer() {
		contr.enterItemID("ABC123", 4);
		contr.enterItemID("DEF456", 3);
		contr.enterItemID("GHI789", 2);
		double result = contr.enterCustomerID("1234").getPrice();
		double expResult = (30 * 1.25 * 4 + 49 * 1.12 * 3 + 12 * 1.06 * 2 - 20) * .9;
		assertEquals(expResult, result, "Incorrect discounted price returned to the view.");	
	}

}
