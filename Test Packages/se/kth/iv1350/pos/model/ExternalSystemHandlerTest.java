package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.MoneyDTO;

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

	@Test
	void test() {
		sale.addItemGroup("DEF456", 1);
		xsh.makeReciept(sale.getSaleLog(), new MoneyDTO(sale.getSaleLog().getRunningTotal().getPrice() + 1), new MoneyDTO(1));
		// Måste detta testas om den enbart anropar metoder som redan testats?
		// Isåfall, hur?
	}

}
