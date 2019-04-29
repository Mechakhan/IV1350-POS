package se.kth.iv1350.pos.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.MoneyDTO;

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
		String result = contr.enterItemID("DEF456", 1);
		String expResult = "5.88";
		assertTrue(result.contains(expResult), "Incorrect sale returned to the view.");
	}
	
	@Test
	void testEnteringCustomer() {
		contr.enterItemID("ABC123", 4);
		contr.enterItemID("DEF456", 3);
		contr.enterItemID("GHI789", 2);
		String result = contr.enterCustomerID("1234");
		String expResult = String.valueOf((30 * 1.25 * 4 + 49 * 1.12 * 3 + 12 * 1.06 * 2 - 20) * .9);	
		assertTrue(result.contains(expResult), "Incorrect discounted price returned to the view.");
	}
	
	@Test
	void testEndingSale() {
		contr.enterItemID("ABC123", 4);
		String result = contr.endSale();
		String expResult = "VAT: 30";
		assertTrue(result.contains(expResult), "Incorrect vat returned to the view.");
	}
	
	@Test
	void testEnterPayment() {
		contr.enterItemID("DEF456", 3);
		double change = Double.parseDouble(contr.enterPayment(new MoneyDTO(200)));
		double expResult = 200 - 49 * 1.12 * 3;
		assertEquals(expResult, change, "Incorrect change returned to the view.");
	}

}
