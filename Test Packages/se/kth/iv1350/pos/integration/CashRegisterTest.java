package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	/**
	 * As there is no way to retrieve the balance without
	 * a get method, the test wasn't made.
	 */
	@Test
	void test() {}

}
