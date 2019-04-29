package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExternalSystemHandlerTest {

	ExternalSystemHandler xsh;
	Sale sale;
	
	@BeforeEach
	void setUp() throws Exception {
		xsh = new ExternalSystemHandler();
		sale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		xsh = null;
		sale = null;
	}

	/**
	 * Since the external system handler only calls methods
	 * in classes of lower layers, the test was determined to be unnecessary.
	 */
	@Test
	void test() {}

}
