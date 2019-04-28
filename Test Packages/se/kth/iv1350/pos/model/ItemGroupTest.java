package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.AmountDTO;
import se.kth.iv1350.pos.dto.ItemDescriptionDTO;
import se.kth.iv1350.pos.dto.ItemGroupDTO;

class ItemGroupTest {
	
	ItemGroup itemGroup;
	ItemGroupDTO itemDTO;

	@BeforeEach
	void setUp() throws Exception {
		itemDTO = new ItemGroupDTO("DEF456", new AmountDTO(49.0, 0.12), 3, new ItemDescriptionDTO());
		itemGroup = new ItemGroup(itemDTO);
	}

	@AfterEach
	void tearDown() throws Exception {
		itemGroup = null;
		itemDTO = null;
	}

	@Test
	void testAddingExistingItemQuantity() {
		itemGroup.addToQuantity(2);
		int qnty = itemDTO.getQuantity();
		int expResult = 5;
		assertEquals(qnty, expResult, "Adding item quantities do not match up.");
	}
	
	@Test
	void testAddingNegativeItemQuantity() {
		itemGroup.addToQuantity(-1);
		int qnty = itemDTO.getQuantity();
		int expResult = 3;
		assertEquals(qnty, expResult, "Negative item quantities are not excluded.");
	}
	
	@Test
	void testAddingItemQuantityOverflow() {
		itemGroup.addToQuantity(Integer.MAX_VALUE);
		int qnty = itemDTO.getQuantity();
		int expResult = Integer.MAX_VALUE;
		assertEquals(qnty, expResult, "Item quantity overflows to a negative value after adding.");
	}


}
