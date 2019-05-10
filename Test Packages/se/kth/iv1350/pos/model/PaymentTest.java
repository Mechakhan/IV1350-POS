package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.dto.PriceDTO;

class PaymentTest {

	Payment payment;
	
	@BeforeEach
	void setUp() throws Exception {
		payment = new Payment(new MoneyDTO(100));
	}

	@AfterEach
	void tearDown() throws Exception {
		payment = null;
	}

	@Test
	void testCalculateChange() {
		double change = payment.calculateChange(new PriceDTO(80, 0, false)).getAmount();
		double expResult = 20;
		assertEquals(expResult, change, "Wrong change is returned.");
	}
	
	@Test
	void testCalculateChangeInvalidPrice() {
		double change = payment.calculateChange(new PriceDTO(-10, 0, false)).getAmount();
		double expResult = 100;
		assertEquals(expResult, change, "Wrong change is returned with invalid input.");
	}
	
	@Test
	void testCalculateChangeLargerPrice() {
		try {
			payment.calculateChange(new PriceDTO(200, 0, false));
			fail("change is returned with too big input.");
		}
		catch (Exception e) {}
	}
}
