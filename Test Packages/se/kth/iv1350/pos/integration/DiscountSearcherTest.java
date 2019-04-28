package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.AmountDTO;
import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.ItemDescriptionDTO;
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
		for (int i = 0; i < 10; i++)
			itemList.add(new ItemGroupDTO("ABC123", 
						new AmountDTO(30.0, 0.25), 0, new ItemDescriptionDTO()));
		int amountOfDiscounts = ds.getEligibleDiscounts(new CustomerDTO("0123"), new SaleDTO(itemList, new PriceDTO(375, 75))).length;
		int expResult = 0;
		assertEquals(amountOfDiscounts, expResult, "Discount was returned for invalid customer ID.");
	}
	
	@Test
	void testInvalidItemCount() {
		List<ItemGroupDTO> itemList = new ArrayList<ItemGroupDTO>();
		for (int i = 0; i < 4; i++)
			itemList.add(new ItemGroupDTO("ABC123", 
						new AmountDTO(80.0, 0.25), 0, new ItemDescriptionDTO()));
		int amountOfDiscounts = ds.getEligibleDiscounts(new CustomerDTO("1234"), new SaleDTO(itemList, new PriceDTO(400, 80))).length;
		int expResult = 0;
		assertEquals(amountOfDiscounts, expResult, "Discount was returned for invalid item count.");
	}
	
	@Test
	void testInvalidSalePrice() {
		List<ItemGroupDTO> itemList = new ArrayList<ItemGroupDTO>();
		for (int i = 0; i < 10; i++)
			itemList.add(new ItemGroupDTO("ABC123", 
						new AmountDTO(5, 0.06), 0, new ItemDescriptionDTO()));
		int amountOfDiscounts = ds.getEligibleDiscounts(new CustomerDTO("1234"), new SaleDTO(itemList, new PriceDTO(53, 3))).length;
		int expResult = 0;
		assertEquals(amountOfDiscounts, expResult, "Discount was returned for invalid item count.");
	}

}
