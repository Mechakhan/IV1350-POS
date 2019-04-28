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
	}

	@AfterEach
	void tearDown() throws Exception {
		contr = null;
	}

	@Test
	void testEnteringItem() {
		contr.startNewSale();
		double result = contr.enterItemID("DEF456", 1).getRunningTotal().getVAT();
		double expResult = 5.88;
		assertEquals(result, expResult, "Incorrect sale dto returned to the view.");
		
	}

}
