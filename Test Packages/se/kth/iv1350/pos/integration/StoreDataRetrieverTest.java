package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StoreDataRetrieverTest {

	StoreDataRetriever sdr;
	
	@BeforeEach
	void setUp() throws Exception {
		sdr = new StoreDataRetriever();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetStoreData() {
		String storeData = sdr.getStoreData().toString();
		String expResult = "StoreName | Some Street";
		assertEquals(expResult, storeData, "Store Data does not match expected result");
	}
}
