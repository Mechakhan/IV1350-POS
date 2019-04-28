package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.DiscountDTO;
import se.kth.iv1350.pos.dto.ItemGroupDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.dto.SaleDTO;

class DiscountSearcherTest {
	
	DiscountSearcher ds;

	@BeforeEach
	void setUp() throws Exception {
		ds = new DiscountSearcher();
	}

	@AfterEach
	void tearDown() throws Exception {
		ds = null;
	}

	@Test
	void testInvalidCustomerID() {
		List<ItemGroupDTO> itemList = new ArrayList<ItemGroupDTO>();
		
		int amountOfDiscounts = ds.getEligibleDiscounts(new CustomerDTO("0123"), new SaleDTO(itemList, new PriceDTO(300, 0))).length;
		int expResult = 0;
		assertEquals(amountOfDiscounts, expResult, "Discount was returned for invalid customer ID.");
	}

}
