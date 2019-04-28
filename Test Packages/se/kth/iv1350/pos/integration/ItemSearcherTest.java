package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.dto.ItemGroupDTO;

class ItemSearcherTest {
	
	ItemSearcher is;

	@BeforeEach
	void setUp() throws Exception {
		is = new ItemSearcher();
	}

	@AfterEach
	void tearDown() throws Exception {
		is = null;
	}

	@Test
	void testDatabaseFindItem() {
		ItemGroupDTO item = is.retrieveItemWithID("ABC123", 0);
		assertNotNull(item, "Didn't find item with identifier in database.");
	}
	
	@Test
	void testDatabaseFindNoItem() {
		ItemGroupDTO item = is.retrieveItemWithID("ABC122", 0);
		assertNull(item, "Found item not in database");
	}
	
	@Test
	void testQuantity() {
		ItemGroupDTO item = is.retrieveItemWithID("DEF456", 2);
		int expResult = 2;
		assertEquals(item.getQuantity(), expResult, "Item quantity does not match with input");
	}

}
