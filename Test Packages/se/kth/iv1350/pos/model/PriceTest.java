package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.AmountDTO;
import se.kth.iv1350.pos.dto.ItemDescriptionDTO;
import se.kth.iv1350.pos.dto.ItemGroupDTO;
import se.kth.iv1350.pos.dto.PriceDTO;

class PriceTest {

	Price price;
	PriceDTO priceDTO;
	ItemGroupDTO item;
	
	@BeforeEach
	void setUp() throws Exception {
		priceDTO = new PriceDTO();
		price = new Price(priceDTO);
		item = new ItemGroupDTO("ABC123", new AmountDTO(30.0, 0.25), 3, new ItemDescriptionDTO());
	}

	@AfterEach
	void tearDown() throws Exception {
		price = null;
		item = null;
	}

	@Test
	void testRunningTotal() {
		price.addToRunningTotal(item);
		double runningTotal = priceDTO.getPrice();
		double expResult = 30.0 * 1.25 * 3;
		assertEquals(expResult, runningTotal, "Running total not added to correctly.");
	}
	
	@Test
	void testVAT() {
		price.addToVAT(item);
		double runningTotal = priceDTO.getVAT();
		double expResult = 30.0 * 0.25 * 3;
		assertEquals(runningTotal, expResult, "Running total not added to correctly.");
	}

}
