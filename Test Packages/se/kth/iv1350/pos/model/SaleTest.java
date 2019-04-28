package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.ItemGroupDTO;

class SaleTest {
	
	Sale sale;

	@BeforeEach
	void setUp() throws Exception {
		sale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		sale = null;
	}

	@Test
	void testAddNewInvalidItem() {
		boolean isEmpty = sale.addItemGroup("GHI780", 4).getSaleItems().isEmpty();
		assertTrue(isEmpty, "Invalid item is added to sale items.");
	}
	
	@Test
	void testAddNewValidItem() {
		List<ItemGroupDTO> saleItems = sale.addItemGroup("GHI789", 4).getSaleItems();
		double price = 0;
		for (ItemGroupDTO itemGroup : saleItems) {
			price = itemGroup.getPrice().getPrice();
		}
		double expResult = 12.0;
		assertEquals(price, expResult, "Item not added correctly into List.");
	}
	
	@Test
	void testAddExistingItem() {
		sale.addItemGroup("ABC123", 2);
		List<ItemGroupDTO> saleItems = sale.addItemGroup("ABC123", 4).getSaleItems();
		int quantity = 0;
		for (ItemGroupDTO itemGroup : saleItems) {
			quantity = itemGroup.getQuantity();
		}
		double expResult = 6;
		assertEquals(quantity, expResult, "Item not added correctly into List.");
	}

}
