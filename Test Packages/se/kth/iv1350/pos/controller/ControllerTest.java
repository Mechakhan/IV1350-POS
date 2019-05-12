package se.kth.iv1350.pos.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.integration.CashRegister;
import se.kth.iv1350.pos.model.InvalidItemException;

class ControllerTest {
	
	Controller contr;

	@BeforeEach
	void setUp() throws Exception {
		contr = new Controller(CashRegister.getRegister());
		contr.startNewSale();
	}

	@AfterEach
	void tearDown() throws Exception {
		contr = null;
	}

	@Test
	void testEnteringItem() throws InvalidItemException {
		String result = contr.enterItemID("DEF456", 1).toString();
		String expResult = "5.88";
		assertTrue(result.contains(expResult), "Incorrect sale returned to the view.");
	}
	
	@Test
	void testEnteringCustomer() throws InvalidItemException {
		contr.enterItemID("ABC123", 4);
		contr.enterItemID("DEF456", 3);
		contr.enterItemID("GHI789", 2);
		String result = contr.enterCustomerID("1234").toString();
		String expResult = String.valueOf((30 * 1.25 * 4 + 49 * 1.12 * 3 + 12 * 1.06 * 2 - 20) * .9);	
		assertTrue(result.contains(expResult), "Incorrect discounted price returned to the view.");
	}
	
	@Test
	void testEndingSale() throws InvalidItemException {
		contr.enterItemID("ABC123", 4);
		String result = contr.endSale().toString();
		String expResult = "VAT: 30";
		assertTrue(result.contains(expResult), "Incorrect vat returned to the view.");
	}
	
	@Test
	void testEnterPayment() throws InvalidItemException {
		contr.enterItemID("DEF456", 3);
		double change = contr.enterPayment(new MoneyDTO(200)).getAmount();
		double expResult = 200 - 49 * 1.12 * 3;
		assertEquals(expResult, change, "Incorrect change returned to the view.");
	}
	
	@Test
	void testEnterInvalidQuantity() throws InvalidItemException {
		try {
			contr.enterItemID("DEF456", 0);
			fail("Exception was not thrown with invalid item quantity.");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	void testEnterInvalidPayment() throws InvalidItemException {
		contr.enterItemID("DEF456", 1);
		try {
			contr.enterPayment(new MoneyDTO(0));
			fail("Exception was not thrown with too small payment.");
		} catch (IllegalArgumentException e) {}
	}

}
