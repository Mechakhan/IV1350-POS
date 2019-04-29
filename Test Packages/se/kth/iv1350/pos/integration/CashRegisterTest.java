package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.MoneyDTO;

class CashRegisterTest {
	
	CashRegister cr;

	@BeforeEach
	void setUp() throws Exception {
		cr = new CashRegister();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		cr = null;
	}

	@Test
	void testAddToBalance() {
		cr.addToBalance(new MoneyDTO(50));
		// Hur testa detta?
	}

}
